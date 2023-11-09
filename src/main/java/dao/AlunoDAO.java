package dao;

import javax.persistence.EntityManager;

import entities.Aluno;
import util.HibernateUtil;

public class AlunoDAO {

	public void salvar(Aluno aluno) {
    	EntityManager entityManager = HibernateUtil.getEntityManager();

    	entityManager.getTransaction().begin();
    	entityManager.persist(aluno);
    	entityManager.getTransaction().commit();

    	entityManager.close();
	}
	
	public Aluno buscarPorId(long id) {
    	EntityManager entityManager = HibernateUtil.getEntityManager();
    	Aluno aluno = entityManager.find(Aluno.class, id);
    	entityManager.close();
    	return aluno;
	}
	
}
