package web;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Atividade;
import dominio.Participacao;
import dominio.Participante;
import servico.AtividadeServico;
import servico.ParticipacaoServico;
import servico.ParticipanteServico;

@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			Participante p1 = new Participante(null, "Jose", "jose@gmail.com");
			Participante p2 = new Participante(null, "Maria", "Maria@gmail.com");
			Participante p3 = new Participante(null, "Joao", "joao@gmail.com");
			Participante p4 = new Participante(null, "Julia", "julia@gmail.com");

			Atividade a1 = new Atividade(null, "Palestra: Linux", new BigDecimal("100"), sdf.parse("05/09/2015"));
			Atividade a2 = new Atividade(null, "Palestra: Windows", new BigDecimal("50"), sdf.parse("07/09/2015"));
			Atividade a3 = new Atividade(null, "Palestra: Java", new BigDecimal("70"), sdf.parse("06/09/2015"));
			Atividade a4 = new Atividade(null, "Palestra: Python", new BigDecimal("80"), sdf.parse("07/09/2015"));
			Atividade a5 = new Atividade(null, "Oficina: Github", new BigDecimal("90"), sdf.parse("05/09/2015"));
			Atividade a6 = new Atividade(null, "Oficina: Unity", new BigDecimal("60"), sdf.parse("08/09/2015"));
			Atividade a7 = new Atividade(null, "Palestra: Microsoft", new BigDecimal("110"), sdf.parse("09/09/2015"));
			Atividade a8 = new Atividade(null, "Oficina: Oauth2", new BigDecimal("120"), sdf.parse("04/09/2015"));

			Participacao par1 = new Participacao(null, sdf.parse("04/09/2015"), p1, a1);
			Participacao par2 = new Participacao(null, sdf.parse("08/09/2015"), p1, a5);
			Participacao par3 = new Participacao(null, sdf.parse("09/09/2015"), p2, a3);
			Participacao par4 = new Participacao(null, sdf.parse("03/09/2015"), p2, a2);
			Participacao par5 = new Participacao(null, sdf.parse("05/09/2015"), p3, a2);
			Participacao par6 = new Participacao(null, sdf.parse("07/09/2015"), p3, a7);
			Participacao par7 = new Participacao(null, sdf.parse("07/09/2015"), p4, a4);
			Participacao par8 = new Participacao(null, sdf.parse("07/09/2015"), p4, a5);

			ParticipanteServico ps = new ParticipanteServico();
			AtividadeServico as = new AtividadeServico();
			ParticipacaoServico pas = new ParticipacaoServico();

			ps.inserirAtualizar(p1);
			ps.inserirAtualizar(p2);
			ps.inserirAtualizar(p3);
			ps.inserirAtualizar(p4);

			as.inserirAtualizar(a1);
			as.inserirAtualizar(a2);
			as.inserirAtualizar(a3);
			as.inserirAtualizar(a4);
			as.inserirAtualizar(a5);
			as.inserirAtualizar(a6);
			as.inserirAtualizar(a7);
			as.inserirAtualizar(a8);

			pas.inserirAtualizar(par1);
			pas.inserirAtualizar(par2);
			pas.inserirAtualizar(par3);
			pas.inserirAtualizar(par4);
			pas.inserirAtualizar(par5);
			pas.inserirAtualizar(par6);
			pas.inserirAtualizar(par7);
			pas.inserirAtualizar(par8);

			response.getWriter().append("Instanciação completa!");
		} catch (ParseException e) {
			response.getWriter().append(e.getMessage());
		}
	}

}
