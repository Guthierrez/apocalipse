package br.projects.apocalipse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.projects.apocalipse.model.Item;
import br.projects.apocalipse.model.Localizacao;
import br.projects.apocalipse.model.Usuario;
import br.projects.apocalipse.repository.Usuarios;

/**
 * 
 * @author Guthierrez
 *
 */
@Service
public class UsuarioService {

	@Autowired
	private Usuarios usuarios;

	/**
	 * Lista os usuarios cadastrados na base de dados
	 * 
	 * @return a lista de usuários
	 */
	public List<Usuario> listarUsuarios() {
		return usuarios.findAll();
	}

	/**
	 * Cria ou atualiza um usuário na base de dados
	 * 
	 * @param usuario
	 * @return retorna usuário criado e/ou atualizado
	 */
	public Usuario salvarUsuario(Usuario usuario) {
		return this.usuarios.save(usuario);
	}

	/**
	 * Remove um usuário existe da base de dados
	 * 
	 * @param id
	 */
	public void removerUsuario(Long id) {
		if (usuarios.findOne(id) != null) {
			this.usuarios.delete(id);
		}
	}

	/**
	 * Atualiza a ultima localização de um usuário
	 * 
	 * @param id
	 * @param localizacao
	 * @return retorna usuário atualizado ou @null se o usuário não existe
	 */
	public Usuario atualizarLocalizacaoUsuario(Long id, Localizacao localizacao) {
		Usuario usuario = this.usuarios.findOne(id);
		if (usuario != null) {
			usuario.setUltima(localizacao);
			return this.usuarios.save(usuario);
		} else {
			return null;
		}

	}

	/**
	 * Adiciona um item no usuário
	 * 
	 * @param id
	 * @param item
	 * @return retorna usuário atualizado ou @null se o usuário não existe
	 */
	public Usuario adicionarItemUsuario(Long id, Item item) {
		Usuario usuario = this.usuarios.findByIdAndFetchEager(id);
		if (usuario != null) {
			usuario.getItens().add(item);
			return this.usuarios.save(usuario);
		} else {
			return null;
		}
	}

	/**
	 * Remover um item de um usuário
	 * 
	 * @param id
	 * @param item
	 * @return retorna usuário atualizado ou @null se o item não existe ou
	 *         usuário não existe
	 */
	public Usuario removerItemUsuario(Long id, Item item) {
		Usuario usuario = this.usuarios.findByIdAndFetchEager(id);
		if (usuario != null) {
			if (usuario.getItens().contains(item)) {
				usuario.getItens().remove(item);
				return this.usuarios.save(usuario);
			}
		}
		return null;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

}
