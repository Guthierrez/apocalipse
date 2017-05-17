package br.projects.apocalipse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.projects.apocalipse.model.Usuario;
import br.projects.apocalipse.repository.Usuarios;

@Service
public class UsuarioService {
	
	@Autowired
	private Usuarios usuarios;
	
	public List<Usuario> listarUsuarios(){
		return usuarios.findAll();
	}
	
	public Usuarios getUsuarios() {
		return usuarios;
	}
}
