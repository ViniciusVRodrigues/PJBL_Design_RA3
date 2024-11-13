package dados;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import model.Produto;

import java.util.List;

public class ProdutoRepository {
    private static ProdutoRepository instance;
    private EntityManagerFactory emf;

    private ProdutoRepository() {
        emf = Persistence.createEntityManagerFactory("mercadoPU");
    }

    public static ProdutoRepository getInstance() {
        if (instance == null) {
            instance = new ProdutoRepository();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void adicionarProduto(Produto produto) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(produto);
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

    public Produto buscarProduto(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produto.class, id);
        } finally {
            em.close();
        }
    }

    public List<Produto> listarProdutos() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("from Produto", Produto.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void atualizarProduto(Produto produto) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(produto);
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

    public void removerProduto(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Produto produto = em.find(Produto.class, id);
            em.remove(produto);
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