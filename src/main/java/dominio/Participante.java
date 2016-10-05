package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name="tb_participante")
public class Participante implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codParticipante;
	private String nome;
	private String email;
	
	@OneToMany(mappedBy="participante")
	private List<Participacao> participacoes;
	
	public Participante() {
		participacoes = new ArrayList<>();
	}

	public Participante(Integer codParticipante, String nome, String email) {
		super();
		this.codParticipante = codParticipante;
		this.nome = nome;
		this.email = email;
		participacoes = new ArrayList<>();
	}

	public Integer getCodParticipante() {
		return codParticipante;
	}

	public void setCodParticipante(Integer codParticipante) {
		this.codParticipante = codParticipante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Participacao> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}
	
	public void addParticipacao(Participacao x) {
		participacoes.add(x);
		x.setParticipante(this);
	}
	
	public void removeParticipacao(Participacao x) {
		participacoes.remove(x);
	}

	@Override
	public String toString() {
		return "Participante [codParticipante=" + codParticipante + ", nome=" + nome + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codParticipante == null) ? 0 : codParticipante.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participante other = (Participante) obj;
		if (codParticipante == null) {
			if (other.codParticipante != null)
				return false;
		} else if (!codParticipante.equals(other.codParticipante))
			return false;
		return true;
	}
	
	public BigDecimal totalGasto() {
		BigDecimal soma = new BigDecimal("0.00");
		for(int i=0; i<participacoes.size(); i++) {
			soma = soma.add(participacoes.get(i).getAtividade().getCusto());
		}
		return soma;
	}
}
