package br.com.application.domain;

public class Configuracao {

	private Usuario usuario;

	public Configuracao(Usuario usuario){
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
