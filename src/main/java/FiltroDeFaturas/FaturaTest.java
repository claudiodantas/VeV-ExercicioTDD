package FiltroDeFaturas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        assertEquals(1, faturasFiltradas.size());
        assertTrue(faturasFiltradas.contains(faturaComDataMaiorQueUmMes));
    }

}