package br.com.application.infra;

import java.util.HashMap;

import br.com.application.domain.Almoco;
import br.com.application.domain.Chegada;
import br.com.application.domain.Horario;
import br.com.application.domain.Saida;


public class HorariosDePonto {

	private static HashMap<String,Horario> horarios;


	static{
			horarios = new HashMap<String, Horario>(); 
			horarios.put("almoco", new Almoco());
			horarios.put("saida", new Saida());
			horarios.put("chegada", new Chegada());
			
	}
	
public static synchronized Horario pegaHorario(String keyHorario){
	
	if(horarios == null || horarios.isEmpty()){
		 horarios = new HashMap<String, Horario>();
	}
	
	return horarios.get(keyHorario);
}

public static synchronized void desabilitaHorario(String keyHorario){
	
	Horario temporario = horarios.get(keyHorario);
	temporario.setHabilitado(false);
	 
}

public static synchronized void habilitaHorario(String keyHorario){
	
	Horario temporario = horarios.get(keyHorario);
	temporario.setHabilitado(true);
	 
}


}
