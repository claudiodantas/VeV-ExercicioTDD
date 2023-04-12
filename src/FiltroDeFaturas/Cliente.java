package FiltroDeFaturas;

import java.util.Date;

public class Cliente {

    private String nome;
    private Date dataDeInclusao;
    private String estado;

    public Cliente(String nome, Date dataDeInclusao, String estado){
        this.nome = nome;
        this.dataDeInclusao = dataDeInclusao;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataDeInclusao() {
        return dataDeInclusao;
    }

    public String getEstado() {
        return estado;
    }
}
