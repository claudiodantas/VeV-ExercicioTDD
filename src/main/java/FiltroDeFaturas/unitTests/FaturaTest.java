package FiltroDeFaturas.unitTests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import FiltroDeFaturas.Cliente;
import FiltroDeFaturas.Fatura;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class FaturaTest {

    @Test
    void deveriaCriarUmaFatura() {
        int codigo = 1;
        double valor = 100.50;
        Date data = new Date();
        Cliente cliente = Mockito.mock(Cliente.class);

        Fatura novaFatura = new Fatura(codigo, valor, data, cliente);

        assertEquals(codigo, novaFatura.getCodigo());
        assertEquals(valor, novaFatura.getValor());
        assertEquals(data, novaFatura.getData());
        assertEquals(cliente, novaFatura.getCliente());
    }

    @Test
    void deveriaFiltrarListaDeFaturasVazia(){
        List<Fatura> faturas = new ArrayList<>();
        List<Fatura> faturasFiltradas = Fatura.filtraFaturas(faturas);
        assertEquals(faturas, faturasFiltradas);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1999.0, 1000.0, 100.0, 1.0})
    void deveriaFiltrarFaturasComValoresMenoresQue2000(double valor){
        List<Fatura> faturas = new ArrayList<>();
        Fatura faturaMocked = Mockito.mock(Fatura.class);
        Mockito.when(faturaMocked.getValor()).thenReturn(valor);
        faturas.add(faturaMocked);
        List<Fatura> faturasFiltradas = Fatura.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

    @ParameterizedTest
    @ValueSource(doubles = {2000.0, 2300.0, 2499.0})
    void deveriaFiltrarFaturasEntre2000e2500ComDataMenorOuIgualADeUmMesAtras(double valor) throws ParseException {
        List<Fatura> faturas = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Fatura faturaComDataMaiorQueUmMes = Mockito.mock(Fatura.class);
        Date dataMaiorQueUmMes = sdf.parse("12/02/2023");
        Mockito.when(faturaComDataMaiorQueUmMes.getValor()).thenReturn(valor);
        Mockito.when(faturaComDataMaiorQueUmMes.getData()).thenReturn(dataMaiorQueUmMes);

        Fatura faturaComDataMenorQueUmMes = Mockito.mock(Fatura.class);
        Date dataMenorQueUmMes = new Date();
        Mockito.when(faturaComDataMenorQueUmMes.getValor()).thenReturn(valor);
        Mockito.when(faturaComDataMenorQueUmMes.getData()).thenReturn(dataMenorQueUmMes);

        faturas.add(faturaComDataMaiorQueUmMes);
        faturas.add(faturaComDataMenorQueUmMes);

        List<Fatura> faturasFiltradas = Fatura.filtraFaturas(faturas);
        assertEquals(1, faturasFiltradas.size());
        assertTrue(faturasFiltradas.contains(faturaComDataMaiorQueUmMes));
    }

    @ParameterizedTest
    @ValueSource(doubles = {2500.0, 2750.0, 2999.0})
    void deveriaFiltrarFaturasEntre2500e3000ComDataClienteMenorOuIgualADoisMeses(double valor) throws ParseException {
        List<Fatura> faturas = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Fatura faturaComDataClienteMaiorQueDoiMeses = Mockito.mock(Fatura.class);
        Date dataMaiorQueDoisMeses = sdf.parse("01/01/2023");
        Mockito.when(faturaComDataClienteMaiorQueDoiMeses.getValor()).thenReturn(valor);
        Cliente clienteDataMaiorQueDoisMeses = Mockito.mock(Cliente.class);
        Mockito.when(clienteDataMaiorQueDoisMeses.getDataDeInclusao()).thenReturn(dataMaiorQueDoisMeses);
        Mockito.when(faturaComDataClienteMaiorQueDoiMeses.getCliente()).thenReturn(clienteDataMaiorQueDoisMeses);

        Fatura faturaComDataClienteMenorQueDoiMeses = Mockito.mock(Fatura.class);
        Date dataMenorQueDoisMeses = new Date();
        Mockito.when(faturaComDataClienteMenorQueDoiMeses.getValor()).thenReturn(valor);
        Cliente clienteDataMenorQueDoisMeses = Mockito.mock(Cliente.class);
        Mockito.when(clienteDataMenorQueDoisMeses.getDataDeInclusao()).thenReturn(dataMenorQueDoisMeses);
        Mockito.when(faturaComDataClienteMenorQueDoiMeses.getCliente()).thenReturn(clienteDataMenorQueDoisMeses);

        faturas.add(faturaComDataClienteMaiorQueDoiMeses);
        faturas.add(faturaComDataClienteMenorQueDoiMeses);

        List<Fatura> faturasFiltradas = Fatura.filtraFaturas(faturas);
        assertEquals(1, faturasFiltradas.size());
        assertTrue(faturasFiltradas.contains(faturaComDataClienteMaiorQueDoiMeses));
    }

    @ParameterizedTest
    @ValueSource(strings = {"RS", "Rio Grande do Sul", "PR", "Paraná", "SC", "Santa Catarina"})
    void deveriaFiltrarFaturasComValorMaiorQue4000eClienteSulista(String estado) throws ParseException {
        List<Fatura> faturas = new ArrayList<>();

        Fatura faturaComClienteSulista = Mockito.mock(Fatura.class);
        Mockito.when(faturaComClienteSulista.getValor()).thenReturn(4001.0);
        Cliente clienteSulista = Mockito.mock(Cliente.class);
        Mockito.when(clienteSulista.getEstado()).thenReturn(estado);
        Mockito.when(faturaComClienteSulista.getCliente()).thenReturn(clienteSulista);

        Fatura faturaComClienteNaoSulista = Mockito.mock(Fatura.class);
        Mockito.when(faturaComClienteNaoSulista.getValor()).thenReturn(4001.0);
        Cliente clienteNaoSulista = Mockito.mock(Cliente.class);
        Mockito.when(clienteNaoSulista.getEstado()).thenReturn("PB");
        Mockito.when(faturaComClienteNaoSulista.getCliente()).thenReturn(clienteNaoSulista);

        faturas.add(faturaComClienteSulista);
        faturas.add(faturaComClienteNaoSulista);

        List<Fatura> faturasFiltradas = Fatura.filtraFaturas(faturas);
        assertEquals(1, faturasFiltradas.size());
        assertTrue(faturasFiltradas.contains(faturaComClienteNaoSulista));
    }

}