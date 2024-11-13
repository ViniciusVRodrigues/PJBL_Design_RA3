package dados;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import model.Pagamento;

import java.util.List;

public class PagamentoRepository {
    private static PagamentoRepository instance;
    private EntityManagerFactory emf;

    private PagamentoRepository() {
        emf = Persistence.createEntityManagerFactory("mercadoPU");
    }

    public static PagamentoRepository getInstance() {
        if (instance == null) {
            instance = new PagamentoRepository();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean atualizarPagamento(Pagamento pagamento) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(pagamento);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return false;
    }

    public Pagamento buscarPagamento(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pagamento.class, id);
        } finally {
            em.close();
        }
    }

    public List<Pagamento> listarPagamentos() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("from Pagamento", Pagamento.class).getResultList();
        } finally {
            em.close();
        }
    }
}
