package br.projects.apocalipse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.projects.apocalipse.model.Item;
import br.projects.apocalipse.model.Localizacao;
import br.projects.apocalipse.model.Usuario;
import br.projects.apocalipse.repository.Usuarios;

@Service
public class UsuarioService {

	@Autowired
	private Usuarios usuarios;

	public List<Usuario> listarUsuarios() {
		return usuarios.findAll();
	}

	public Usuario salvarUsuario(Usuario usuario) {
		return this.usuarios.save(usuario);
	}

	public void removerUsuario(Long id) {
		if (usuarios.findOne(id) != null) {
			this.usuarios.delete(id);
		}
	}

	public Usuario atualizarLocalizacaoUsuario(Long id, Localizacao localizacao) {
		Usuario usuario = this.usuarios.findOne(id);
		if (usuario != null) {
			usuario.setUltima(localizacao);
			return this.usuarios.save(usuario);
		} else {
			return null;
		}

	}

	public Object adicionarItemUsuario(Long id, Item item) {
		Usuario usuario = this.usuarios.findByIdAndFetchEager(id);
		if (usuario != null) {
			usuario.getItens().add(item);
			return this.usuarios.save(usuario);
		} else {
			return null;
		}
	}

	public Object removerItemUsuario(Long id, Item item) {
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
