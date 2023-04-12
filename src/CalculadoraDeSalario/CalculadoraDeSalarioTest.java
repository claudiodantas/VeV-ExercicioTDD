package CalculadoraDeSalario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDeSalarioTest {

    @Test
    void test1() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 1000.00, Cargo.DESENVOLVEDOR);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(900.00, calc.calculaSalario(func));
    }


}