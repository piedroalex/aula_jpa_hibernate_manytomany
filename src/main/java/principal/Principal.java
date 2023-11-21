package principal;

import java.util.ArrayList;
import java.util.List;

import dao.DespesaDAO;
import dao.PessoaDAO;
import dao.ReceitaDAO;
import entities.Despesa;
import entities.Pessoa;
import entities.Receita;

/**
 * @author Pedro Alex
 */
public class Principal {
	
	public static void main(String[] args) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		
		Receita receita1 = new Receita();
		receita1.setDescricao("Salário Empresa 1");
		receita1.setValor(1250.0);
		
		receitaDAO.salvar(receita1);

		Receita receita2 = new Receita();
		receita2.setDescricao("Salário Empresa 2");
		receita2.setValor(1050.98);
		
		receitaDAO.salvar(receita2);

		List<Receita> receitas = new ArrayList<Receita>();
		receitas.addAll(receitaDAO.listarTodos());

		DespesaDAO despesaDAO = new DespesaDAO();
		
		Despesa despesa1 = new Despesa();
		despesa1.setDescricao("Energia");
		despesa1.setValor(272.47);
		
		Despesa despesa2 = new Despesa();
		despesa2.setDescricao("Aluguel");
		despesa2.setValor(408.76);
		
		despesaDAO.salvar(despesa1);
		despesaDAO.salvar(despesa2);
		
		List<Despesa> despesas = new ArrayList<Despesa>();
		despesas.addAll(despesaDAO.listarTodos());
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Carlos");
		pessoa.setReceitas(receitas);
		pessoa.setDespesas(despesas);
		
		pessoaDAO.salvar(pessoa);

		Receita receita3 = new Receita();
		receita3.setDescricao("Salário Empresa 3");
		receita3.setValor(2000.0);
		
		receitaDAO.salvar(receita3);
		
		receitas = new ArrayList<Receita>();
		receitas.add(receita3);
		
		pessoa = new Pessoa();
		pessoa.setNome("Maria");
		pessoa.setReceitas(receitas);
		pessoa.setDespesas(despesas);
		
		pessoaDAO.salvar(pessoa);
		
	}
}
