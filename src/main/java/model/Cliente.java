package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;
	private String email;
	private String endereco;
	private String telefone;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Pedido> historicoPedidos;

	public Cliente(String nome, String email, String endereco, String telefone) {
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Cliente() {
	}

	//Getters e Setters

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Pedido> getHistoricoPedidos() {
		return historicoPedidos;
	}

	public void adicionarPedido(Pedido pedido) {
		this.historicoPedidos.add(pedido);
	}

	public void removerPedido(Pedido pedido) {
		this.historicoPedidos.remove(pedido);
	}

	public void atualizarPedido(Pedido pedido) {
		for (Pedido p : historicoPedidos) {
			if (p.getId() == pedido.getId()) {
				p = pedido;
			}
		}
	}
}
