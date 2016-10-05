package dao;

import java.util.List;

import dominio.Atividade;

public interface AtividadeDao {
	
	public void inserirAtualizar(Atividade x);
	public void excluir(Atividade x);
	public Atividade buscar(int cod);
	public List<Atividade> buscarTodos();
}
