package negocio;

import dados.ProdutoRepository;
import model.Produto;

import java.util.List;

public class ProdutoService {
    private ProdutoRepository produtoRepo = ProdutoRepository.getInstance();

    public boolean adicionarProduto(String nome, String descricao,double preco , int estoque) {
        Produto produto = new Produto(nome, descricao, preco, estoque);
        return produtoRepo.adicionarProduto(produto);
    }

    public boolean removerProduto(int id) {
        return produtoRepo.removerProduto(id);
    }

    public boolean atualizarProduto(int id, String nome, String descricao,double preco , int estoque) {
        Produto produto = produtoRepo.buscarProduto(id);
        if(produto==null) return false;
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setPreco(preco);
        produto.setEstoque(estoque);
        return produtoRepo.atualizarProduto(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepo.listarProdutos();
    }

    public Produto buscarProduto(int id) {
        return produtoRepo.buscarProduto(id);
    }
}
