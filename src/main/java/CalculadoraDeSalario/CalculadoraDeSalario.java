package CalculadoraDeSalario;

public class CalculadoraDeSalario {

    public double calculaSalario(Funcionario func) {

        if (func.getCargo() == Cargo.DESENVOLVEDOR) {
            if (func.getSalario() >= 3000.0) {
                return Math.round( func.getSalario() * 0.8);
            } else {
                return Math.round(func.getSalario() * 0.9);
            }
        }
        else if (func.getCargo() == Cargo.DBA) {
            if (func.getSalario() >= 2000.0) {
                return Math.round(func.getSalario() * 0.75);
            } else {
                return Math.round(func.getSalario() * 0.85);
            }
        }
        else if (func.getCargo() == Cargo.TESTADOR) {
            if (func.getSalario() >= 2000.0) {
                return Math.round(func.getSalario() * 0.75);
            } else {
                return Math.round(func.getSalario() * 0.85);
            }
        }
        else if (func.getCargo() == Cargo.GERENTE) {
            if (func.getSalario() >= 5000.0) {
                return Math.round(func.getSalario() * 0.7);
            } else {
                return Math.round(func.getSalario() * 0.8);
            }
        }
        else{
            return 0;
        }
    }
}
