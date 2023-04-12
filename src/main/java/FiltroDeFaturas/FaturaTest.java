package FiltroDeFaturas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
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

    @Test
    void deveriaFiltrarFaturasComValoresMenoresQue2000(){
        List<Fatura> faturas = new ArrayList<>();
        Fatura faturaMocked = Mockito.mock(Fatura.class);
        Mockito.when(faturaMocked.getValor()).thenReturn(1999.0);
        faturas.add(faturaMocked);
        List<Fatura> faturasFiltradas = Fatura.filtraFaturas(faturas);
        assertEquals(0, faturasFiltradas.size());
    }

    @Test
    void deveriaFiltrarFaturasEntre2000e2500ComDataMenorOuIgualADeUmMesAtras() throws ParseException {
        List<Fatura> faturas = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Fatura faturaComDataMaiorQueUmMes = Mockito.mock(Fatura.class);
        Date dataMaiorQueUmMes = sdf.parse("12/02/2023");
        Mockito.when(faturaComDataMaiorQueUmMes.getValor()).thenReturn(2000.0);
        Mockito.when(faturaComDataMaiorQueUmMes.getData()).thenReturn(dataMaiorQueUmMes);

        Fatura faturaComDataMenorQueUmMes = Mockito.mock(Fatura.class);
        Date dataMenorQueUmMes = new Date();
        Mockito.when(faturaComDataMenorQueUmMes.getValor()).thenReturn(2000.0);
        Mockito.when(faturaComDataMenorQueUmMes.getData()).thenReturn(dataMenorQueUmMes);

        faturas.add(faturaComDataMaiorQueUmMes);
        faturas.add(faturaComDataMenorQueUmMes);

        List<Fatura> faturasFiltradas = Fatura.filtraFaturas(faturas);
        assertEquals(1, faturasFiltradas.size());
        assertEquals(1, faturasFiltradas.size());
        assertTrue(faturasFiltradas.contains(faturaComDataMaiorQueUmMes));
    }
}