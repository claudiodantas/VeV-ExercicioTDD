package FiltroDeFaturas.functionalTests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import FiltroDeFaturas.Cliente;
import FiltroDeFaturas.Fatura;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class FunctionalTests {

    @ParameterizedTest
    @ValueSource(doubles = {1999.0, 100.0, 1.0})
    void deveriaFiltrarFaturasComValoresMenoresQue2000(double valor){
        List<Fatura> faturas = new ArrayList<>();
        Fatura faturaMocked = Mockito.mock(Fatura.class);
        Mockito.when(faturaMocked.getValor()).thenReturn(valor);
        faturas.add(faturaMocked);
        List<Fatura> faturasFiltradas = Fatura.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

    @ParameterizedTest
    @ValueSource(doubles = {2000.0, 2000.99, 2300.0, 2499.0})
    void deveriaFiltrarFaturasEntre2000e2500ComDataMenorOuIgualADeUmMesAtras(double valor) {
        List<Fatura> faturas = new ArrayList<>();

        Fatura faturaComDataMenorQueUmMes = Mockito.mock(Fatura.class);
        Date dataMenorQueUmMes = new Date();
        Mockito.when(faturaComDataMenorQueUmMes.getValor()).thenReturn(valor);
        Mockito.when(faturaComDataMenorQueUmMes.getData()).thenReturn(dataMenorQueUmMes);

        faturas.add(faturaComDataMenorQueUmMes);

        List<Fatura> faturasFiltradas = Fatura.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

    @ParameterizedTest
    @ValueSource(doubles = {2000.0, 2000.99, 2300.0, 2499.0})
    void naoDeveriaFiltrarFaturasEntre2000e2500ComDataMaiorADeUmMesAtras(double valor) throws ParseException {
        List<Fatura> faturas = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Fatura faturaComDataMaiorQueUmMes = Mockito.mock(Fatura.class);
        Date dataMaiorQueUmMes = sdf.parse("12/02/2023");
        Mockito.when(faturaComDataMaiorQueUmMes.getValor()).thenReturn(valor);
        Mockito.when(faturaComDataMaiorQueUmMes.getData()).thenReturn(dataMaiorQueUmMes);

        faturas.add(faturaComDataMaiorQueUmMes);

        List<Fatura> faturasFiltradas = Fatura.filtraFaturas(faturas);
        assertEquals(1, faturasFiltradas.size());
        assertTrue(faturasFiltradas.contains(faturaComDataMaiorQueUmMes));
    }

    @ParameterizedTest
    @ValueSource(doubles = {2500.0, 2500.01, 2750.0, 2999.0})
    void deveriaFiltrarFaturasEntre2500e3000ComDataClienteMenorOuIgualADoisMeses(double valor) {
        List<Fatura> faturas = new ArrayList<>();

        Fatura faturaComDataClienteMenorQueDoiMeses = Mockito.mock(Fatura.class);
        Date dataMenorQueDoisMeses = new Date();
        Mockito.when(faturaComDataClienteMenorQueDoiMeses.getValor()).thenReturn(valor);
        Cliente clienteDataMenorQueDoisMeses = Mockito.mock(Cliente.class);
        Mockito.when(clienteDataMenorQueDoisMeses.getDataDeInclusao()).thenReturn(dataMenorQueDoisMeses);
        Mockito.when(faturaComDataClienteMenorQueDoiMeses.getCliente()).thenReturn(clienteDataMenorQueDoisMeses);

        faturas.add(faturaComDataClienteMenorQueDoiMeses);

        List<Fatura> faturasFiltradas = Fatura.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

    @ParameterizedTest
    @ValueSource(doubles = {2500.0, 2500.01, 2750.0, 2999.0})
    void naoDeveriaFiltrarFaturasEntre2500e3000ComDataClienteMaiorQueDoisMeses(double valor) throws ParseException {
        List<Fatura> faturas = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Fatura faturaComDataClienteMaiorQueDoiMeses = Mockito.mock(Fatura.class);
        Date dataMaiorQueDoisMeses = sdf.parse("01/01/2023");
        Mockito.when(faturaComDataClienteMaiorQueDoiMeses.getValor()).thenReturn(valor);
        Cliente clienteDataMaiorQueDoisMeses = Mockito.mock(Cliente.class);
        Mockito.when(clienteDataMaiorQueDoisMeses.getDataDeInclusao()).thenReturn(dataMaiorQueDoisMeses);
        Mockito.when(faturaComDataClienteMaiorQueDoiMeses.getCliente()).thenReturn(clienteDataMaiorQueDoisMeses);

        faturas.add(faturaComDataClienteMaiorQueDoiMeses);

        List<Fatura> faturasFiltradas = Fatura.filtraFaturas(faturas);
        assertEquals(1, faturasFiltradas.size());
        assertTrue(faturasFiltradas.contains(faturaComDataClienteMaiorQueDoiMeses));
    }

    @ParameterizedTest
    @ValueSource(strings = {"RS", "Rio Grande do Sul", "PR", "Paraná", "SC", "Santa Catarina"})
    void deveriaFiltrarFaturasComValorMaiorQue4000eClienteSulista(String estado) {
        List<Fatura> faturas = new ArrayList<>();

        Fatura faturaComClienteSulista = Mockito.mock(Fatura.class);
        Mockito.when(faturaComClienteSulista.getValor()).thenReturn(4001.0);
        Cliente clienteSulista = Mockito.mock(Cliente.class);
        Mockito.when(clienteSulista.getEstado()).thenReturn(estado);
        Mockito.when(faturaComClienteSulista.getCliente()).thenReturn(clienteSulista);

        faturas.add(faturaComClienteSulista);

        List<Fatura> faturasFiltradas = Fatura.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"AC", "Acre", "DF", "Distrito Federal", "GO", "Goiás", "PB", "Paraíba", "RJ", "Rio de Janeiro"})
    void naoDeveriaFiltrarFaturasComValorMaiorQue4000eClienteNaoSulista(String estado) {
        List<Fatura> faturas = new ArrayList<>();

        Fatura faturaComClienteNaoSulista = Mockito.mock(Fatura.class);
        Mockito.when(faturaComClienteNaoSulista.getValor()).thenReturn(4001.0);
        Cliente clienteNaoSulista = Mockito.mock(Cliente.class);
        Mockito.when(clienteNaoSulista.getEstado()).thenReturn("PB");
        Mockito.when(faturaComClienteNaoSulista.getCliente()).thenReturn(clienteNaoSulista);

        faturas.add(faturaComClienteNaoSulista);

        List<Fatura> faturasFiltradas = Fatura.filtraFaturas(faturas);
        assertEquals(1, faturasFiltradas.size());
        assertTrue(faturasFiltradas.contains(faturaComClienteNaoSulista));
    }

}