package dao;

import javax.persistence.EntityManager;

import entities.Curso;
import util.HibernateUtil;

public class CursoDAO {

	public void salvar(Curso curso) {
    	EntityManager entityManager = HibernateUtil.getEntityManager();
    	entityManager.getTransaction().begin();
    	entityManager.persist(curso);
    	entityManager.getTransaction().commit();
    	entityManager.close();
	}	
	
	public Curso buscarPorId(long id) {
    	EntityManager entityManager = HibernateUtil.getEntityManager();
    	Curso curso = entityManager.find(Curso.class, id);
    	entityManager.close();
    	return curso;
	}
	
}
