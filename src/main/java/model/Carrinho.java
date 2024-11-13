package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Carrinho {

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

    public Carrinho(int quantidadeTotal, double valorTotal) {
        this.quantidadeTotal = quantidadeTotal;
        this.valorTotal = valorTotal;
        produtos = new ArrayList<>();
    }

    public Carrinho() {
    }

    //Getters e Setters

    public int getId() {
        return id;
    }

    public void calcularTotal() {
        double total = 0;
        int quantidade = 0;
        for (Produto p : produtos) {
            total += p.getPreco();
            quantidade++;
        }
        this.valorTotal = total;
        this.quantidadeTotal = quantidade;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
        calcularTotal();
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
        calcularTotal();
    }

    public void removeProduto(Produto produto) {
        this.produtos.remove(produto);
        calcularTotal();
    }

    public void limparCarrinho() {
        this.produtos.clear();
        calcularTotal();
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
