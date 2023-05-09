package FiltroDeFaturas.unitTests;

import static org.junit.jupiter.api.Assertions.*;

import FiltroDeFaturas.Cliente;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class ClienteTest {

    @Test
    void deveCriarUmCliente(){
        String nome = "José";
        Date dataDeInclusao = new Date();
        String estado = "PB";

        Cliente novoCliente = new Cliente(nome, dataDeInclusao, estado);

        assertEquals(nome, novoCliente.getNome());
        assertEquals(dataDeInclusao, novoCliente.getDataDeInclusao());
        assertEquals(estado, novoCliente.getEstado());
    }
}
