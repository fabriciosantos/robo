package br.com.application.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.application.domain.Usuario;
import br.com.application.service.IServicoDeConfiguracao;
import br.com.application.service.ServicoDeConfiguracao;

public class ConfigurationViewApplication extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2301882926354610991L;
	private JButton cancelar;
	private JButton salvar;
	private JTextField login;
	private JTextField funcao;
	private JPasswordField senha;
	private JLabel lbSenha;
	private JLabel lbFuncao;
	private JLabel lbLogin;
	private IServicoDeConfiguracao configurationService;

	
	public ConfigurationViewApplication(){
		
		configurationService = new ServicoDeConfiguracao();
		load();
	}

	private void load() {
		
		setTitle("WALL.E - 1.0");
		cancelar = new JButton("Cancelar");  
	    salvar = new JButton("Salvar");  
	    login = new JTextField();  
	    funcao = new JTextField();
	    senha = new JPasswordField();  

	    
	    lbSenha = new JLabel("Senha : ");
	    lbFuncao = new JLabel("Função : ");
	    lbLogin = new JLabel("Login : ");
	    
	    lbSenha.setForeground(Color.red);
	    lbFuncao.setForeground(Color.red);
	    lbLogin.setForeground(Color.red);
	    
	    
		Container contente = getContentPane();
		contente.setBackground(Color.black);
		
		
		contente.setLayout(new GridLayout(4,2));
		
		contente.add(lbFuncao);
		contente.add(funcao);
		
		contente.add(lbLogin);
		contente.add(login);
		
		contente.add(lbSenha);
		contente.add(senha);
		
		contente.add(salvar);
		contente.add(cancelar);
		
		addActionToButton(salvar);
		addActionToButton(cancelar);
		
		setLocationByPlatform(true);
		setSize(300,200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
	    Object source = event.getSource();
	    if (source instanceof JButton) 
	    	System.out.println("você clicou no button!");
	}
	
	
	private void salvar() {
			Usuario usuario = new Usuario(funcao.getText().toString(),login.getText().toString(), 
					 senha.getText().toString());
			 configurationService.criaUsuarioXML(usuario);
	}
	

	
	private void addActionToButton(final JButton button){
		
		button.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				
				
				if(button.getText().equals(salvar.getText())){
					salvar();
					ConfigurationViewApplication.this.dispose();
				}
				
				if(button.getText().equals(cancelar.getText())){
					ConfigurationViewApplication.this.dispose();
				}
			}

		});
		
	}
	
	

}
