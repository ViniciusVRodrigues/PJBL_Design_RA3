package apresentacao;

import model.Pedido;
import negocio.ClienteService;

import java.util.List;

public class InterfaceCliente {
    private ClienteService clienteService = new ClienteService();

    public void registrarCliente(String nome, String email, String endereco, String telefone) {
        clienteService.registrarCliente(nome, email, endereco, telefone);
    }

    public void exibirHistoricoPedidos(int clienteId) {
        List<Pedido> historico = clienteService.visualizarHistoricoPedidos(clienteId);
        // Exibir histórico ao usuário
    }
}
