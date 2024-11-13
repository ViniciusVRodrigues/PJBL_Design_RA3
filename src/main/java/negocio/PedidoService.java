package negocio;

import dados.ClienteRepository;
import dados.PedidoRepository;
import model.Cliente;
import model.Pagamento;
import model.Pedido;

import java.util.Date;
import java.util.List;

public class PedidoService {
    PedidoRepository pedidoRepo = PedidoRepository.getInstance();
    ClienteRepository clienteRepo = ClienteRepository.getInstance();

    public boolean adicionarPedido(int idCliente,String metodoPagamento){
        Cliente cliente = clienteRepo.buscarCliente(idCliente);
        if(cliente==null) return false;
        Date data = new Date();
        Pagamento pagamento = new Pagamento(data,cliente.getCarrinho().getValorTotal(),metodoPagamento,"Em andamento");
        Pedido pedido = new Pedido(cliente,data,"Em andamento",pagamento);
        cliente.adicionarPedido(pedido);
        return clienteRepo.atualizarCliente(cliente);
    }

    public boolean atualizarPedido(int idPedido, String status) {
        Pedido pedido = pedidoRepo.buscarPedido(idPedido);
        if(pedido==null) return false;
        pedido.setStatus(status);
        return pedidoRepo.atualizarPedido(pedido);
    }

    public Pedido buscarPedido(int idPedido) {
        return pedidoRepo.buscarPedido(idPedido);
    }

    public boolean finalizarPedido(int idPedido) {
        Pedido pedido = pedidoRepo.buscarPedido(idPedido);
        if(pedido==null) return false;
        pedido.setStatus("Finalizado");
        return pedidoRepo.atualizarPedido(pedido);
    }

    public boolean cancelarPedido(int idPedido) {
        Pedido pedido = pedidoRepo.buscarPedido(idPedido);
        if(pedido==null) return false;
        pedido.setStatus("Cancelado");
        return pedidoRepo.atualizarPedido(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepo.listarPedidos();
    }

    public boolean removerPedido(int idPedido) {
        return pedidoRepo.removerPedido(idPedido);
    }
}
