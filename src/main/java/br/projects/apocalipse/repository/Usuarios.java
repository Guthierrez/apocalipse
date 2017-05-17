package br.projects.apocalipse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.projects.apocalipse.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long> {
	
	@Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.itens WHERE u.id = (:id)")
    public Usuario findByIdAndFetchEager(@Param("id") Long id);

}
