package br.projects.apocalipse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.projects.apocalipse.enumerator.Sexo;
import br.projects.apocalipse.model.Usuario;
import br.projects.apocalipse.service.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioTests {
	
	@Autowired
	private UsuarioService usuarioService;
	
	private Usuario usuario;
	
	@Before
	public void init(){
		usuario = new Usuario();
		usuario.setNome("Guthierrez");
		usuario.setSexo(Sexo.MASCULINO);
		usuario.setIdade(23);
	}

    @Test
    public void listarUsuariosTeste() {
    	Assert.assertNotNull(usuarioService.listarUsuarios());
    }
    
    @Test
    public void inserirUsuarioTeste(){
    	Assert.assertNotNull(usuarioService.salvarUsuario(usuario));
    }
    
    @Test
    public void removerUsuarioTeste(){
    	Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
    	usuarioService.removerUsuario(usuarioSalvo.getId());
    }
}