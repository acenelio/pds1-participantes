package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name="tb_atividade")
public class Atividade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codAtividade;
	private String nome;
	private BigDecimal custo;
	private Date date;
	
	@OneToMany(mappedBy="atividade")
	private List<Participacao> participacoes;
	
	public Atividade() {
		participacoes = new ArrayList<>();
	}

	public Atividade(Integer codAtividade, String nome, BigDecimal custo, Date date) {
		super();
		this.codAtividade = codAtividade;
		this.nome = nome;
		this.custo = custo;
		this.date = date;
		participacoes = new ArrayList<>();
		
	}

	public Integer getCodAtividade() {
		return codAtividade;
	}

	public void setCodAtividade(Integer codAtividade) {
		this.codAtividade = codAtividade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Participacao> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}
	
	public void addParticipacao(Participacao x) {
		participacoes.add(x);
		x.setAtividade(this);
	}
	
	public void removeParticipacao(Participacao x) {
		participacoes.remove(x);
	}

	@Override
	public String toString() {
		return "Atividade [codAtividade=" + codAtividade + ", nome=" + nome + ", custo=" + custo + ", date=" + date
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAtividade == null) ? 0 : codAtividade.hashCode());
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
		Atividade other = (Atividade) obj;
		if (codAtividade == null) {
			if (other.codAtividade != null)
				return false;
		} else if (!codAtividade.equals(other.codAtividade))
			return false;
		return true;
	}
	
	public List<Participante> pagantesAte(Date data) {
		List<Participante> aux = new ArrayList<>();
		for(Participacao p : participacoes) {
			if(p.getDataPagamento().getTime() <= data.getTime()) {
				aux.add(p.getParticipante());
			}
		}
		return aux;
	}
}
