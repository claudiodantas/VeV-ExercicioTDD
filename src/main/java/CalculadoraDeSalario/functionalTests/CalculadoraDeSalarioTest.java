package CalculadoraDeSalario.functionalTests;

import org.junit.jupiter.api.Test;

import CalculadoraDeSalario.CalculadoraDeSalario;
import CalculadoraDeSalario.Cargo;
import CalculadoraDeSalario.Funcionario;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDeSalarioTest {
//Partições de Equivalencia
    @Test
    void desenvolvedorSalarioMenor3000() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 1000.00, Cargo.DESENVOLVEDOR);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(900.00, calc.calculaSalario(func));
    }

    @Test
    void desenvolvedorSalarioMaiorIgual3000() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 3000.00, Cargo.DESENVOLVEDOR);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(2400.00, calc.calculaSalario(func));

    }

    @Test
    void DBASalarioMenor2000() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 1000.00, Cargo.DBA);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(850.00, calc.calculaSalario(func));

    }

    @Test
    void desenvolvedorSalarioMaiorIgual2000() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 2000.00, Cargo.DBA);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(1500.00, calc.calculaSalario(func));

    }


    @Test
    void testadorSalarioMenor2000() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 1000.00, Cargo.TESTADOR);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(850.00, calc.calculaSalario(func));

    }

    @Test
    void testadorSalarioMaiorIgual2000() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 2000.00, Cargo.TESTADOR);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(1500.00, calc.calculaSalario(func));

    }

    @Test
    void gerenteSalarioMenor5000() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 1000.00, Cargo.GERENTE);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(800.00, calc.calculaSalario(func));

    }

    @Test
    void gerenteSalarioMaiorIgual5000() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 5000.00, Cargo.GERENTE);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(3500.00, calc.calculaSalario(func));

    }
//Valores Limites
    @Test
    void desenvolvedorLimite1() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 2999.99, Cargo.DESENVOLVEDOR);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(2699.991, calc.calculaSalario(func));

    }

    @Test
    void desenvolvedorLimite2() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 3000, Cargo.DESENVOLVEDOR);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(2400, calc.calculaSalario(func));

    }

    @Test
    void desenvolvedorLimite3() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 3000.01, Cargo.DESENVOLVEDOR);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(2399.99, calc.calculaSalario(func));

    }

    @Test
    void dbaLimite1() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 1999.99, Cargo.DBA);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(1699.99, calc.calculaSalario(func));
    }

    @Test
    void dbaLimite2() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 2000.00, Cargo.DBA);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(1500.00, calc.calculaSalario(func));
    }

    @Test
    void dbaLimite3() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 2000.01, Cargo.DBA);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(1500.00, calc.calculaSalario(func));
    }

    @Test
    void testadorLimite1() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 1999.99, Cargo.TESTADOR);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(1699.99, calc.calculaSalario(func));
    }

    @Test
    void testadorLimite2() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 2000.00, Cargo.TESTADOR);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(1500.00, calc.calculaSalario(func));
    }

    @Test
    void testadorLimite3() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 2000.01, Cargo.TESTADOR);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(1500.00, calc.calculaSalario(func));
    }
    
    @Test
    void gerenteLimite1() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 4999.99, Cargo.GERENTE);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(3999.99, calc.calculaSalario(func));
    }

    @Test
    void gerenteLimite2() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 5000, Cargo.GERENTE);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(3500.00, calc.calculaSalario(func));
    }

    @Test
    void gerenteLimite3() {
        Funcionario func = new Funcionario("Joao", "joao@mail.com", 5000.01, Cargo.GERENTE);
        CalculadoraDeSalario calc = new CalculadoraDeSalario();
        assertEquals(3500.00, calc.calculaSalario(func));
    }


}