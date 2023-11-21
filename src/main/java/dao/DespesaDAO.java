package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Despesa;
import entities.Pessoa;
import util.HibernateUtil;

/**
 * @author Pedro Alex
 */
public class DespesaDAO {

	public void salvar(Despesa despesa) {    	
    	EntityManager entityManager = HibernateUtil.getEntityManager();
    	try {
	    	entityManager.getTransaction().begin();
	    	entityManager.persist(despesa);
	    	entityManager.getTransaction().commit();
	    	System.out.println("Despesa salva com sucesso!");
    	} catch (Exception e) {
        	entityManager.getTransaction().rollback();
	    	System.out.println("Erro ao salvar a despesa!");
            e.printStackTrace();
        } finally {
        	entityManager.close();			
		}
	}
	
	public List<Despesa> listarPorPessoa(Pessoa pessoa) {
    	EntityManager entityManager = HibernateUtil.getEntityManager();
    	try {
	        TypedQuery<Despesa> query = entityManager.createQuery("SELECT d FROM Despesa d WHERE d.pessoa.id = :idPessoa", Despesa.class);
	        query.setParameter("idPessoa", pessoa.getId());
	        return query.getResultList();
    	} catch (Exception e) {
			System.out.println("Nenhuma despesa encontrada para essa pessoa!");
			e.printStackTrace();
			return null;
		}
    }
	
	public List<Despesa> listarTodos(){
		TypedQuery<Despesa> query = HibernateUtil.getEntityManager().createQuery("SELECT d FROM Despesa d", Despesa.class);
		List<Despesa> despesas = query.getResultList();
		return despesas;
	}
}
