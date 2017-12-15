package br.com.application.service;

import br.com.application.domain.Alvo;
import br.com.application.domain.Usuario;
import br.com.application.infra.Converter;


public class ServicoDeConfiguracao implements IServicoDeConfiguracao {

	
public void criaUsuarioXML(Usuario usuario){
	new Converter<Usuario>(usuario).generateXMl("usuario");
}

public Usuario getUsuarioXML(){
	return 	new Converter<Usuario>().convertXMLToObject("usuario",Usuario.class);
}

public void criaAlvoXML(Alvo alvo){
	new Converter<Alvo>(alvo).generateXMl("alvo");
}


public Alvo getAlvoXML(){
	return 	new Converter<Alvo>().convertXMLToObject("alvo",Alvo.class);
}



}
