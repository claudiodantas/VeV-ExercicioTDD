package FiltroDeFaturas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Fatura {

    private int codigo;
    private double valor;
    private Date data;
    private Cliente cliente;

    public Fatura(int codigo, double valor, Date data, Cliente cliente){
        this.codigo = codigo;
        this.valor = valor;
        this.data = data;
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public static List<Fatura> filtraFaturas(List<Fatura> listaDefaturas){
        List<Fatura> faturasFiltradas = new ArrayList<>();
        if (listaDefaturas.size() == 0){
            faturasFiltradas = listaDefaturas;
        }
        return faturasFiltradas;
    }
}
