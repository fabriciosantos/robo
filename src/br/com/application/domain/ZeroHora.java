package br.com.application.domain;

public class ZeroHora implements Horario {

	private String horarioInicio;
	private String horarioFim;
	private boolean habilitado;
	private static String HORARIO_ZERO = "00:00:00";
	
	public ZeroHora(){
		this.setHorarioInicio(getRandomDateInicio());
		this.setHorarioFim(getRandomDateFim());
		this.setHabilitado(true);
	}
	

	
	@Override
	public String getRandomDateInicio() {
		return HORARIO_ZERO;
	}

	@Override
	public String getRandomDateFim() {
		return horarioFim;
	}

	@Override
	public String getHorarioFim() {
		return horarioFim;
	}

	@Override
	public String getHorarioInicio() {
		return horarioInicio;
	}

	@Override
	public boolean isHabilitado() {
		return habilitado;
	}

	@Override
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
		
	}
	private void setHorarioFim(String randomDateFim) {
		
		this.horarioFim = randomDateFim;
	}
	
	private void setHorarioInicio(String randomDateInicio) {
		this.horarioInicio = randomDateInicio;
	}

}
