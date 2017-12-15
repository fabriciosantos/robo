package br.com.application.domain;

public class Usuario {

	private String funcao;
	private String login;
	private String senha;
	
	public Usuario(String funcao , String login , String senha){
		this.funcao = funcao;
		this.login = login;
		this.senha = senha;
		
	}
	
	public Usuario(){
		
	}
	
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String nome) {
		this.funcao = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
