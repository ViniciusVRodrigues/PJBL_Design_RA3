package negocio;

import dados.ClienteRepository;
import model.Cliente;
import model.Pedido;

import java.util.List;

public class ClienteService {
    private ClienteRepository clienteRepo = ClienteRepository.getInstance();

    public boolean registrarCliente(String nome, String email, String endereco, String telefone) {
        Cliente cliente = new Cliente(nome, email, endereco, telefone);
        return clienteRepo.adicionarCliente(cliente);
    }

    public List<Pedido> visualizarHistoricoPedidos(int clienteId) {
        Cliente cliente = clienteRepo.buscarCliente(clienteId);
        if(cliente==null) return null;
        return cliente.getHistoricoPedidos();
    }

    public Cliente buscarCliente(int id) {
        return clienteRepo.buscarCliente(id);
    }

    public List<Cliente> listarClientes() {
        return clienteRepo.listarClientes();
    }

    public boolean atualizarCliente(int id, String nome, String email, String endereco, String telefone) {
        Cliente cliente = clienteRepo.buscarCliente(id);
        if(cliente==null) return false;
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setEndereco(endereco);
        cliente.setTelefone(telefone);
        return clienteRepo.atualizarCliente(cliente);
    }

    public boolean removerCliente(int id) {
        return clienteRepo.removerCliente(id);
    }
}
