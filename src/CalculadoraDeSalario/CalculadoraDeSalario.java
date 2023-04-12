package CalculadoraDeSalario;

public class CalculadoraDeSalario {

    public static void main(String[] args) {
        System.out.println("Hello world2!");
    }

    public int test(){
        return 2;
    }

    public Double calculaSalario(Funcionario func) {
        if (func.getCargo() == Cargo.DESENVOLVEDOR) {
            if (func.getSalario() > 3000.0) {
                return func.getSalario() * 0.8;
            } else {
                return func.getSalario() * 0.9;
            }
        }

    }
}
