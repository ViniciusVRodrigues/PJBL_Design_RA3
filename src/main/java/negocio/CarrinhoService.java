package negocio;

import dados.ClienteRepository;
import dados.ProdutoRepository;

import model.Produto;
import model.Cliente;

import java.util.List;

public class CarrinhoService {
    private ClienteRepository clienteRepo = ClienteRepository.getInstance();
    private ProdutoRepository produtoRepo = ProdutoRepository.getInstance();

    public boolean adicionarProduto(int idCliente, int idProduto) {
        Produto produto = produtoRepo.buscarProduto(idProduto);
        Cliente cliente = clienteRepo.buscarCliente(idCliente);
        cliente.getCarrinho().addProduto(produto);
        return clienteRepo.atualizarCliente(cliente);
    }

    public boolean removerProduto(int idCliente, int idProduto) {
        Produto produto = produtoRepo.buscarProduto(idProduto);
        Cliente cliente = clienteRepo.buscarCliente(idCliente);
        cliente.getCarrinho().removeProduto(produto);
        return clienteRepo.atualizarCliente(cliente);
    }

    public List<Produto> listarProdutosCarrinho(int idCliente) {
        Cliente cliente = clienteRepo.buscarCliente(idCliente);
        return cliente.getCarrinho().getProdutos();
    }
}
