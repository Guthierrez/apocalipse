package br.projects.apocalipse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projects.apocalipse.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long> {

}
