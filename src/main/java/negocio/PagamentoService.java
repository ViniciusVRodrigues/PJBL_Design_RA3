package negocio;

import dados.PagamentoRepository;
import model.Pagamento;

import java.util.List;

public class PagamentoService {
    PagamentoRepository pagamentoRepo = PagamentoRepository.getInstance();

    public boolean atualizarPagamento(int idPagamento, String status) {
        Pagamento pagamento = pagamentoRepo.buscarPagamento(idPagamento);
        if(pagamento==null) return false;
        pagamento.setStatus(status);
        return pagamentoRepo.atualizarPagamento(pagamento);
    }

    public List<Pagamento> listarPagamentos() {
        return pagamentoRepo.listarPagamentos();
    }

    public Pagamento buscarPagamento(int idPagamento) {
        return pagamentoRepo.buscarPagamento(idPagamento);
    }

    public boolean confirmarPagamento(int idPagamento) {
        Pagamento pagamento = pagamentoRepo.buscarPagamento(idPagamento);
        if(pagamento==null) return false;
        pagamento.setStatus("Confirmado");
        return pagamentoRepo.atualizarPagamento(pagamento);
    }

    public boolean cancelarPagamento(int idPagamento) {
        Pagamento pagamento = pagamentoRepo.buscarPagamento(idPagamento);
        if(pagamento==null) return false;
        pagamento.setStatus("Cancelado");
        return pagamentoRepo.atualizarPagamento(pagamento);
    }
}
