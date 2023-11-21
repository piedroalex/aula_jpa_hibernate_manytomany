package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Pessoa;
import entities.Receita;
import util.HibernateUtil;

/**
 * @author Pedro Alex
 */
public class ReceitaDAO {

	public void salvar(Receita receita) {    	
    	EntityManager entityManager = HibernateUtil.getEntityManager();
    	try {
	    	entityManager.getTransaction().begin();
	    	entityManager.persist(receita);
	    	entityManager.getTransaction().commit();
	    	System.out.println("Receita salva com sucesso!");
    	} catch (Exception e) {
        	entityManager.getTransaction().rollback();
	    	System.out.println("Erro ao salvar a receita!");
            e.printStackTrace();
        } finally {
        	entityManager.close();			
		}
	}	

	public List<Receita> listarPorPessoa(Pessoa pessoa) {
    	EntityManager entityManager = HibernateUtil.getEntityManager();
    	try {
	        TypedQuery<Receita> query = entityManager.createQuery("SELECT r FROM Receita r WHERE r.pessoa.id = :idPessoa", Receita.class);
	        query.setParameter("idPessoa", pessoa.getId());
	        return query.getResultList();
    	} catch (Exception e) {
			System.out.println("Nenhuma receita encontrada para essa pessoa!");
			e.printStackTrace();
			return null;
		}
    }
	
	public List<Receita> listarTodos(){
		TypedQuery<Receita> query = HibernateUtil.getEntityManager().createQuery("SELECT r FROM Receita r", Receita.class);
		List<Receita> despesas = query.getResultList();
		return despesas;
	}
}
