package br.projects.apocalipse.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.projects.apocalipse.enumerator.Sexo;

/**
 * 
 * @author Guthierrez
 * 
 */
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	private Integer idade;

	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "localizao_id")
	private Localizacao ultima;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_reportacoes", joinColumns = {
			@JoinColumn(name = "usuario_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "reportador_id", nullable = false, updatable = false) })
	private List<Usuario> reportacoes;

	private Boolean infectado;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id")
	private List<Item> itens;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Localizacao getUltima() {
		return ultima;
	}

	public void setUltima(Localizacao ultima) {
		this.ultima = ultima;
	}

	public List<Usuario> getReportacoes() {
		if (reportacoes == null) {
			reportacoes = new ArrayList<>(0);
		}
		return reportacoes;
	}

	public void setReportacoes(List<Usuario> reportacoes) {
		this.reportacoes = reportacoes;
	}

	public Boolean getInfectado() {
		if (infectado == null)
			infectado = false;
		return infectado;
	}

	public void setInfectado(Boolean infectado) {
		this.infectado = infectado;
	}

	public List<Item> getItens() {
		if (itens == null)
			itens = new ArrayList<>(0);
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
}
