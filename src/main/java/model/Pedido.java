package model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date data;

    private String status;
    private double valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pagamento_id", referencedColumnName = "id")
    private Pagamento pagamento;

    @ManyToMany
    @JoinTable(
            name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;

    public Pedido(Cliente cliente, Date data, String status, Pagamento pagamento) {
        this.cliente = cliente;
        this.data = data;
        this.status = status;
        this.valorTotal = cliente.getCarrinho().getValorTotal();
        this.produtos = cliente.getCarrinho().getProdutos();
        cliente.getCarrinho().limparCarrinho();
        this.pagamento = pagamento;
    }

    public Pedido() {
    }

    //Getters e Setters

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", data=" + data +
                ", status='" + status + '\'' +
                ", valorTotal=" + valorTotal +
                ", cliente=" + cliente.getNome() +
                ", pagamento=" + pagamento.getStatus() +
                '}';
    }
}

