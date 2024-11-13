package dados;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Cliente;
import model.Pedido;
import model.Produto;

import java.util.List;

public class ClienteRepository {

    private static ClienteRepository instance;
    private EntityManagerFactory emf;

    private ClienteRepository() {
        emf = Persistence.createEntityManagerFactory("mercadoPU");
    }

    public static ClienteRepository getInstance() {
        if (instance == null) {
            instance = new ClienteRepository();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void adicionarCliente(Cliente cliente) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e; // Rethrow exception after transaction rollback
        } finally {
            em.close();
        }
    }

    public Cliente buscarCliente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public void atualizarCliente(Cliente cliente) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e; // Rethrow exception after transaction rollback
        } finally {
            em.close();
        }
    }

    public List<Pedido> obterHistoricoPedidos(int clienteId) {
        EntityManager em = getEntityManager();
        try {
            Cliente cliente = em.find(Cliente.class, clienteId);
            return cliente.getHistoricoPedidos();
        } finally {
            em.close();
        }
    }

    public void removerCliente(int id) {
        EntityManager em = getEntityManager();
        try {
            Cliente cliente = em.find(Cliente.class, id);
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e; // Rethrow exception after transaction rollback
        } finally {
            em.close();
        }
    }
}

