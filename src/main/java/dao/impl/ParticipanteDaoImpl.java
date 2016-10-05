package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ParticipanteDao;
import dominio.Participante;

public class ParticipanteDaoImpl implements ParticipanteDao {

	private EntityManager em;
	
	public ParticipanteDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Participante x) {
		if(x.getCodParticipante() != null) {
			x = em.merge(x);
		}
		em.persist(x);

	}

	@Override
	public void excluir(Participante x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Participante buscar(int cod) {
		return em.find(Participante.class, cod);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Participante> buscarTodos() {
		String jpql = "SELECT x FROM Participante x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
