package negocio;

import dados.ProdutoRepository;
import model.Produto;

public class ProdutoService {
    private ProdutoRepository produtoRepo = ProdutoRepository.getInstance();

    public void adicionarProduto(String nome, String descricao,double preco , int estoque) {
        Produto produto = new Produto(nome, descricao, preco, estoque);
        produtoRepo.adicionarProduto(produto);
    }

    public void removerProduto(int id) {
        produtoRepo.removerProduto(id);
    }

    public void atualizarProduto(Produto produto) {
        produtoRepo.atualizarProduto(produto);
    }

    public void listarProdutos() {
        produtoRepo.listarProdutos();
    }

    public void buscarProduto(int id) {
        produtoRepo.buscarProduto(id);
    }
}
