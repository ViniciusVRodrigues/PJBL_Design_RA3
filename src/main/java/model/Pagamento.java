package model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date dataPagamento;

    private double valor;
    private String metodoPagamento;
    private String status;

    @OneToOne(mappedBy = "pagamento")
    private Pedido pedido;

    public Pagamento(Date dataPagamento, double valor, String metodoPagamento, String status) {
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
        this.status = status;
    }

    public Pagamento() {
    }

    //Getters e Setters

    public int getId() {
        return id;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", dataPagamento=" + dataPagamento +
                ", valor=" + valor +
                ", metodoPagamento='" + metodoPagamento + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

