package dao;

import dao.impl.AtividadeDaoImpl;
import dao.impl.ParticipacaoDaoImpl;
import dao.impl.ParticipanteDaoImpl;

public class DaoFactory {
	
	public static AtividadeDao criarAtividadeDao() {
		return new AtividadeDaoImpl();
	}
	
	public static ParticipacaoDao criarParticipacaoDao() {
		return new ParticipacaoDaoImpl();
	}
	
	public static ParticipanteDao criarParticipanteDao() {
		return new ParticipanteDaoImpl();
	}
}
