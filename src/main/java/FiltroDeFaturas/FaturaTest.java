package FiltroDeFaturas;

import java.util.Date;

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
}