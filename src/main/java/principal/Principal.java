package principal;

import java.util.ArrayList;
import java.util.List;

import dao.AlunoDAO;
import dao.CursoDAO;
import entities.Aluno;
import entities.Curso;

public class Principal {
	
	public static void main(String[] args) {
		CursoDAO cursoDAO = new CursoDAO();
		
		Curso curso1 = new Curso();
		curso1.setTitulo("Curso 1");
		
		Curso curso2 = new Curso();
		curso2.setTitulo("Curso 2");
		
		cursoDAO.salvar(curso1);
		cursoDAO.salvar(curso2);
		
		List<Curso> cursos = new ArrayList<Curso>();
		curso1 = cursoDAO.buscarPorId(1);
		curso2 = cursoDAO.buscarPorId(2);
		cursos.add(curso1);
		cursos.add(curso2);

		AlunoDAO alunoDAO = new AlunoDAO();
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("João");
		aluno1.setCursos(cursos);
		alunoDAO.salvar(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Maria");
		aluno2.setCursos(cursos);
		
		alunoDAO.salvar(aluno2);
		
	}
}
