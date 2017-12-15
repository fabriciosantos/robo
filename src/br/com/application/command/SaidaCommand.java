package br.com.application.command;

import br.com.application.factory.HorariosDePontoFactory;
import br.com.application.infra.AbstractCommand;

public class SaidaCommand extends AbstractCommand {

	@Override
	public void run(boolean selected) {
		if(selected){
			HorariosDePontoFactory.habilitaHorario("Saida");
			System.out.print(HorariosDePontoFactory.pegaHorario("Saida").isHabilitado());

		}else{
			HorariosDePontoFactory.desabilitaHorario("Saida");
			System.out.print(HorariosDePontoFactory.pegaHorario("Saida").isHabilitado());
			
		}
	}

}
