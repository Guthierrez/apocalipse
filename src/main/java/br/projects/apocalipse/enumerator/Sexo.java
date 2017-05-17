package br.projects.apocalipse.enumerator;

/**
 * 
 * @author Guthierrez
 *
 */
public enum Sexo {
	MASCULINO("M"), FEMININO("F");
	
	private String descricao;
	
	Sexo(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
