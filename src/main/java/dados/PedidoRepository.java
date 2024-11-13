package dados;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Pedido;

import java.util.List;

public class PedidoRepository {
    private static PedidoRepository instance;
    private EntityManagerFactory emf;

    private PedidoRepository() {
        emf = Persistence.createEntityManagerFactory("mercadoPU");
    }

    public static PedidoRepository getInstance() {
        if (instance == null) {
            instance = new PedidoRepository();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean adicionarPedido(Pedido pedido) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pedido);
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

    public Pedido buscarPedido(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedido.class, id);
        } finally {
            em.close();
        }
    }

    public List<Pedido> listarPedidos() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("from Pedido", Pedido.class).getResultList();
        } finally {
            em.close();
        }
    }

    public boolean atualizarPedido(Pedido pedido) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(pedido);
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

    public boolean removerPedido(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Pedido pedido = em.find(Pedido.class, id);
            em.remove(pedido);
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
}
