package br.projects.apocalipse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.projects.apocalipse.model.Item;
import br.projects.apocalipse.model.Localizacao;
import br.projects.apocalipse.model.Usuario;
import br.projects.apocalipse.service.UsuarioService;

/**
 * 
 * @author Guthierrez
 *
 */
@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private UsuarioService usuariosService;

	/**
	 * Lista os usuarios cadastrados na base de dados
	 * 
	 * @return JSON contendo a lista de usuários
	 */
	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> listarUsuarios() {
		List<Usuario> todosUsuarios = usuariosService.listarUsuarios();
		return ResponseEntity.ok(todosUsuarios);
	}

	/**
	 * Cria ou atualiza um usuário na base de dados
	 * 
	 * @param usuario
	 * @return retorna JSON do usuário criado e/ou atualizado
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> salvarUsuario(@RequestBody Usuario usuario) {
		usuariosService.salvarUsuario(usuario);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	/**
	 * Remove um usuário da base de dados
	 * 
	 * @param id
	 * @return status http ok se removido com sucesso
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> removerUsuario(@PathVariable("id") Long id) {
		usuariosService.removerUsuario(id);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	/**
	 * Atualiza a ultima localização de um usuário
	 * 
	 * @param id
	 * @param localizacao
	 * @return retorna JSON do usuário atualizado ou vazio se o usuário não
	 *         existe
	 */
	@RequestMapping(path = "/{id}/localizacao", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> atualizarLocalizacao(@PathVariable("id") Long id, @RequestBody Localizacao localizacao) {
		return ResponseEntity.ok(usuariosService.atualizarLocalizacaoUsuario(id, localizacao));
	}

	/**
	 * Adiciona um item no usuário
	 * 
	 * @param id
	 * @param item
	 * @return retorna JSON do usuário atualizado ou vazio se o usuário não
	 *         existe
	 */
	@RequestMapping(path = "/{id}/items", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> adicionarItem(@PathVariable("id") Long id, @RequestBody Item item) {
		return ResponseEntity.ok(usuariosService.adicionarItemUsuario(id, item));
	}

	/**
	 * Remover um item de um usuário
	 * 
	 * @param id
	 * @param item
	 * @return retorna JSON do usuário atualizado ou vazio se o item não existe
	 *         ou usuário não existe
	 */
	@RequestMapping(path = "/{id}/items", method = RequestMethod.DELETE, consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> removerItem(@PathVariable("id") Long id, @RequestBody Item item) {
		return ResponseEntity.ok(usuariosService.removerItemUsuario(id, item));
	}
}
