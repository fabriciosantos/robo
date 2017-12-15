package br.com.application.controller;

import java.util.HashMap;

import javax.swing.JCheckBox;

import br.com.application.command.ChegadaCommand;
import br.com.application.command.FimAlmocoCommand;
import br.com.application.command.InicioAlmocoCommand;
import br.com.application.command.SaidaCommand;
import br.com.application.infra.AbstractCommand;

public class MainController {

	
	private HashMap<String,AbstractCommand> commands = new HashMap<String, AbstractCommand>();	

	
	public MainController() {
		
		commands.put("Chegada", new ChegadaCommand() );
		commands.put("Almoco Inicio", new InicioAlmocoCommand() );
		commands.put("Almoco Fim", new FimAlmocoCommand());
		commands.put("Saida", new SaidaCommand());
		
	}
	
	
	public void executeChangeJChecked(JCheckBox check){
		
		AbstractCommand comando = commands.get(check.getText());
		if(comando!=null){
			comando.run(check.isSelected());
		}
		
		
	}

}
