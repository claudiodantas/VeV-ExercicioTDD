package CalculadoraDeSalario;

public class Funcionario {
    private String nome;
    private String email;
    private double salario;
    private Cargo cargo;


    public Funcionario(String nome, String email, double salario, Cargo cargo) {
        
        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.cargo = cargo;

    }


    public String getNome() {
        return nome;
    }


    public String getEmail() {
        return email;
    }


    public double getSalario() {
        return salario;
    }


    public Cargo getCargo() {
        return cargo;
    }
}
