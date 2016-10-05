package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.AtividadeDao;
import dominio.Atividade;

public class AtividadeDaoImpl implements AtividadeDao {

	private EntityManager em;
	
	public AtividadeDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Atividade x) {
		if(x.getCodAtividade() != null) {
			x = em.merge(x);
		}
		em.persist(x);

	}

	@Override
	public void excluir(Atividade x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Atividade buscar(int cod) {
		return em.find(Atividade.class, cod);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Atividade> buscarTodos() {
		String jpql = "SELECT x FROM Atividade x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
