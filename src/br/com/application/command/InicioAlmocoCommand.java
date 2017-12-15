package br.com.application.command;

import br.com.application.factory.HorariosDePontoFactory;
import br.com.application.infra.AbstractCommand;

public class InicioAlmocoCommand extends AbstractCommand {

	@Override
	public void run(boolean selected) {
		if(selected){
			HorariosDePontoFactory.habilitaHorario("almoco");
			System.out.print(HorariosDePontoFactory.pegaHorario("almoco").isHabilitado());

		}else{
			HorariosDePontoFactory.desabilitaHorario("almoco");
			System.out.print(HorariosDePontoFactory.pegaHorario("almoco").isHabilitado());
			
		}
	}

}
