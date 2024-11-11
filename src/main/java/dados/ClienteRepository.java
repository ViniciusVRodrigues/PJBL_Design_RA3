package dados;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Cliente;

public class ClienteRepository {

    private ClienteRepository instance;
    private EntityManager em;

    private ClienteRepository() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("locadoraPU");
        em = emf.createEntityManager();
    }

    public ClienteRepository getInstance() {
        if (instance == null) {
            instance = new ClienteRepository();
        }
        return instance;
    }

    public void salvarCliente(Cliente cliente) {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    public Cliente buscarCliente(int id) {
        return em.find(Cliente.class, id);
    }

    public void atualizarCliente(Cliente cliente) {
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
    }

    public void removerCliente(Cliente cliente) {
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
    }
}

