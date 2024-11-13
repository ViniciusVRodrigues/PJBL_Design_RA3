package negocio;

import dados.ClienteRepository;
import dados.ProdutoRepository;

import model.Produto;
import model.Cliente;

public class CarrinhoService {
    private ClienteRepository clienteRepo = ClienteRepository.getInstance();
    private ProdutoRepository produtoRepo = ProdutoRepository.getInstance();

    public void adicionarProduto(int idCliente, int idProduto) {
        Produto produto = produtoRepo.buscarProduto(idProduto);
        Cliente cliente = clienteRepo.buscarCliente(idCliente);
        cliente.getCarrinho().addProduto(produto);
        clienteRepo.atualizarCliente(cliente);
    }

    public void removerProduto(int idCliente, int idProduto) {
        Produto produto = produtoRepo.buscarProduto(idProduto);
        Cliente cliente = clienteRepo.buscarCliente(idCliente);
        cliente.getCarrinho().removeProduto(produto);
        clienteRepo.atualizarCliente(cliente);
    }
}
