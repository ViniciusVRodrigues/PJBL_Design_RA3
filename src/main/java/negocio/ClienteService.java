package negocio;

import dados.ClienteRepository;
import model.Cliente;
import model.Pedido;

import java.util.List;

public class ClienteService {
    private ClienteRepository clienteRepo = ClienteRepository.getInstance();

    public void registrarCliente(String nome, String email, String endereco, String telefone) {
        Cliente cliente = new Cliente(nome, email, endereco, telefone);
        clienteRepo.adicionarCliente(cliente);
    }

    public List<Pedido> visualizarHistoricoPedidos(int clienteId) {
        return clienteRepo.obterHistoricoPedidos(clienteId);
    }

    public Cliente buscarCliente(int id) {
        return clienteRepo.buscarCliente(id);
    }

    public void atualizarCliente(Cliente cliente) {
        clienteRepo.atualizarCliente(cliente);
    }

    public void removerCliente(int id) {
        clienteRepo.removerCliente(id);
    }
}
