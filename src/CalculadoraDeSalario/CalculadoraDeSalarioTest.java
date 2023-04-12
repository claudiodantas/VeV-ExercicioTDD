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

    @Test
    void test2() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 3000.00, Cargo.DESENVOLVEDOR);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(2400.00, calc.calculaSalario(func));

    }

    @Test
    void test3() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 1000.00, Cargo.DBA);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(850.00, calc.calculaSalario(func));

    }

    @Test
    void test4() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 2000.00, Cargo.DBA);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(1500.00, calc.calculaSalario(func));

    }


    @Test
    void test5() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 1000.00, Cargo.TESTADOR);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(850.00, calc.calculaSalario(func));

    }

    @Test
    void test6() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 2000.00, Cargo.TESTADOR);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(1500.00, calc.calculaSalario(func));

    }   

    @Test
    void test7() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 1000.00, Cargo.GERENTE);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(800.00, calc.calculaSalario(func));

    }

    @Test
    void test8() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 5000.00, Cargo.GERENTE);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(3500.00, calc.calculaSalario(func));

    }

    @Test
    void test9() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 5000.00, Cargo.TESTE);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(0.00, calc.calculaSalario(func));

    }

}