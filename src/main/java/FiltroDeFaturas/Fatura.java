package FiltroDeFaturas;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
        if (listaDefaturas.size() == 0){
            return listaDefaturas;
        }
        listaDefaturas.removeIf(fatura -> fatura.getValor() < 2000);
        listaDefaturas.removeIf(fatura -> (fatura.getValor() >= 2000 && fatura.getValor() < 2500)
                && (Fatura.getDuracaoDeDias(fatura.getData()) <= 30));
        listaDefaturas.removeIf(fatura -> (fatura.getValor() >= 2500 && fatura.getValor() < 3000)
                && (Fatura.getDuracaoDeDias(fatura.getCliente().getDataDeInclusao()) <= 60));
        String[] estadosDoSul = {"RS", "Rio Grande do Sul", "PR", "Paraná", "SC", "Santa Catarina"};
        listaDefaturas.removeIf(fatura -> (fatura.getValor() > 4000)
                && (Arrays.asList(estadosDoSul).contains(fatura.getCliente().getEstado())));
        return listaDefaturas;
    }

    private static int getDuracaoDeDias(Date data){
        long diffInMillies = Math.abs((new Date()).getTime() - data.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return (int) diff;
    }
}
