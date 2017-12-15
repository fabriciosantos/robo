package br.com.application.infra;

import br.com.application.domain.Usuario;

public class EntityUser {

	private static Usuario usuario;
	
	static{
		
		usuario = new Usuario();
	}

	public Usuario getUsuario(){
	
		if(usuario!=null){
			return usuario;
		}
		
		return new Usuario();
	}
}
