package br.projects.apocalipse.enumerator;

/**
 * 
 * @author Guthierrez
 *
 */
public enum TipoItem {
	AGUA("Água"), COMIDA("Comida"), MEDICAMENTO("Medicamento"), MUNICAO("Munição");
	
	private String descricao;
	
	TipoItem(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
