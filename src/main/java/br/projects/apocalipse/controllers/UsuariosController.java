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

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuarioService usuariosService;
	
	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> listarUsuarios(){
		List<Usuario> todosUsuarios = usuariosService.listarUsuarios();
		return ResponseEntity.ok(todosUsuarios);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> salvarUsuario(@RequestBody Usuario usuario){
		usuariosService.salvarUsuario(usuario);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> removerUsuario(@PathVariable("id") Long id){
		usuariosService.removerUsuario(id);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}/localizacao", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<?> atualizarLocalizacao(@PathVariable("id") Long id, @RequestBody Localizacao localizacao){
		return ResponseEntity.ok(usuariosService.atualizarLocalizacaoUsuario(id, localizacao));
	}
	
	@RequestMapping(path = "/{id}/items", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<?> adicionarItem(@PathVariable("id") Long id, @RequestBody Item item){
		return ResponseEntity.ok(usuariosService.adicionarItemUsuario(id, item));
	}
	
	@RequestMapping(path = "/{id}/items", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> removerItem(@PathVariable("id") Long id, @RequestBody Item item){
		return ResponseEntity.ok(usuariosService.removerItemUsuario(id, item));
	}
}
