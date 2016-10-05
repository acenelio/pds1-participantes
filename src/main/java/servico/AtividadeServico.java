package servico;

import java.util.List;

import dao.AtividadeDao;
import dao.DaoFactory;
import dao.Transaction;
import dominio.Atividade;

public class AtividadeServico {
	
	private AtividadeDao dao;
	
	public AtividadeServico() {
		dao = DaoFactory.criarAtividadeDao();
	}
	
	public void inserirAtualizar(Atividade x){
		try {
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void excluir(Atividade x){
		try {
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public Atividade buscar(int cod){
		return dao.buscar(cod);
	}
	
	public List<Atividade> buscarTodos(){
		return dao.buscarTodos();
	}
}
