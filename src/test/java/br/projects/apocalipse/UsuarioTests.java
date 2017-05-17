package br.projects.apocalipse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.projects.apocalipse.enumerator.Sexo;
import br.projects.apocalipse.enumerator.TipoItem;
import br.projects.apocalipse.model.Item;
import br.projects.apocalipse.model.Localizacao;
import br.projects.apocalipse.model.Usuario;
import br.projects.apocalipse.service.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioTests {
	
	@Autowired
	private UsuarioService usuarioService;
	
	private Usuario usuario;
	
	private Localizacao localizacao;
	
	private Item item;
	
	@Before
	public void init(){
		usuario = new Usuario();
		usuario.setNome("Guthierrez");
		usuario.setSexo(Sexo.MASCULINO);
		usuario.setIdade(23);
		
		localizacao = new Localizacao();
		localizacao.setLatitude("90.78");
		localizacao.setLongitude("180.79");
		
		item = new Item();
		item.setTipoItem(TipoItem.AGUA);
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
    public void removerUsuarioQueExisteTeste(){
    	Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
    	usuarioService.removerUsuario(usuarioSalvo.getId());
    }
    
    @Test
    public void removerUsuarioQueNaoExiste(){
    	usuarioService.removerUsuario(Long.MAX_VALUE);
    }
    
    @Test
    public void atualizarLocalizaoUsuarioQueExiste(){
    	Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
    	Assert.assertNotNull(usuarioService.atualizarLocalizacaoUsuario(usuarioSalvo.getId(), localizacao));
    }
    
    @Test
    public void atualizarLocalizaoUsuarioQueNaoExiste(){
    	Assert.assertEquals(usuarioService.atualizarLocalizacaoUsuario(Long.MAX_VALUE, localizacao), null);
    }
    
    @Test
    public void adicionarItemUsuarioExisteTeste(){
    	Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
    	Assert.assertNotNull(usuarioService.adicionarItemUsuario(usuarioSalvo.getId(), item));
    }
    
    @Test
    public void adicionarItemUsuarioNaoExisteTeste(){
    	Assert.assertEquals(usuarioService.adicionarItemUsuario(Long.MAX_VALUE, item), null);
    }
}