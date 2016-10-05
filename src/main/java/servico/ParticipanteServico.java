package servico;

import java.util.List;

import dao.DaoFactory;
import dao.ParticipanteDao;
import dao.Transaction;
import dominio.Participante;

public class ParticipanteServico {
	
	private ParticipanteDao dao;
	
	public ParticipanteServico() {
		dao = DaoFactory.criarParticipanteDao();
	}
	
	public void inserirAtualizar(Participante x){
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
	
	public void excluir(Participante x){
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
	
	public Participante buscar(int cod){
		return dao.buscar(cod);
	}
	
	public List<Participante> buscarTodos(){
		return dao.buscarTodos();
	}
}
