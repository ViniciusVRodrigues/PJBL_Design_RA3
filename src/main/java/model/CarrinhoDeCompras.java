package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CarrinhoDeCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(
            name = "carrinho_produto",
            joinColumns = @JoinColumn(name = "carrinho_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;

    private int quantidadeTotal;
    private double valorTotal;

    public CarrinhoDeCompras(int quantidadeTotal, double valorTotal) {
        this.quantidadeTotal = quantidadeTotal;
        this.valorTotal = valorTotal;
        produtos = new ArrayList<>();
    }

    public CarrinhoDeCompras() {
    }

    //Getters e Setters

    public int getId() {
        return id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void editProduto(Produto produto) {
        for (Produto p : produtos) {
            if (p.getId() == produto.getId()) {
                p.setNome(produto.getNome());
                p.setDescricao(produto.getDescricao());
                p.setPreco(produto.getPreco());
                p.setEstoque(produto.getEstoque());
            }
        }
    }

    public void removeProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    public void limparCarrinho() {
        this.produtos.clear();
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
