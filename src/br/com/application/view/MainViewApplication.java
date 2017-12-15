package br.com.application.view;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.com.application.controller.MainController;
import br.com.application.infra.ClockRunnable;



	  
public class MainViewApplication extends JFrame {  

	private static final long serialVersionUID = 5717066326489308235L;
	
		// Local onde atualizaremos a hora  
	    private JLabel lblHora;
	    private JMenuBar menuBar;
	    private JMenu menu;
	    private JMenuItem configuracao;
	    private Image icone;
	    private String caminhoImagem;
	    private JCheckBox almocoInicio;
		private JCheckBox almocoFim;
		private JCheckBox chegada;
		private JCheckBox saida;
	  
	    // Formatador da hora  
	    private static final DateFormat FORMATO = new SimpleDateFormat("HH:mm:ss");  
	    private static final String PATH_ICONE =  "/src/br/com/img/favicon.jpg";
	  
	    public MainViewApplication() throws IOException { 
	    	
	        super("WALL.E - 1.0");  
	        caminhoImagem = getPathImage(PATH_ICONE) ;
	        icone = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
	        setIconImage(icone);
	        setJMenuBar(getBarraMenu());
	        
	        getContentPane().add(getCheckChegada());
	  	    getContentPane().add(getCheckAlmocoInicio());
	  	    getContentPane().add(getCheckAlmocoFim());
	  	    getContentPane().add(getCheckFim());
	  	    
	  	    addListener(chegada);
	  	    addListener(almocoInicio);
	  	    addListener(almocoFim);
	  	    addListener(saida);
	  	    addJMenuItemListener(configuracao);
	  	    
	  	    
	  	    setLayout(new FlowLayout());  
	        getContentPane().add(getLblHora());  
	        
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        setSize(500, 90);  
	        setVisible(true);  
	  
	        initThread();  
	    }

		private void initThread() {
			Thread clockThread = new Thread(new ClockRunnable(this), "Clock thread");  
	        clockThread.setDaemon(true);  
	        clockThread.start();
		}  
	    
	    private String getPathImage(String nome) throws IOException{
	    	 String pathDiretorioAtual = new File(".").getCanonicalPath();
	    	 return  pathDiretorioAtual+nome;  
		     
	    }
	    
	    private JCheckBox getCheckAlmocoInicio(){
	    	
	    	if(almocoInicio==null){
	    		almocoInicio = new JCheckBox("Almoco Inicio");
	    		almocoInicio.setMnemonic(KeyEvent.VK_C);
	    		almocoInicio.setSelected(true);
	    		
	    	}
	    	
	    	return almocoInicio;
	    	
	    }
	    
	    private JCheckBox getCheckAlmocoFim(){
	    	
	    	if(almocoFim==null){
	    		almocoFim = new JCheckBox("Almoco Fim");
	    		almocoFim.setMnemonic(KeyEvent.VK_C);
	    		almocoFim.setSelected(true);
	    		
	    	}
	    	
	    	return almocoFim;
	    	
	    }
	    private JCheckBox getCheckChegada(){
	    	
	    	if(chegada==null){
	    		chegada = new JCheckBox("Chegada");
	    		chegada.setMnemonic(KeyEvent.VK_C);
	    		chegada.setSelected(true);
	    		
	    	}
	    	
	    	return chegada;
	    	
	    }
	    
	    private JCheckBox getCheckFim(){
	    	
	    	if(saida==null){
	    		saida = new JCheckBox("Saida");
	    		saida.setMnemonic(KeyEvent.VK_C);
	    		saida.setSelected(true);
	    		
	    	}
	    	
	    	return saida;
	    	
	    }
	    private JMenuBar getBarraMenu() {  
	            if (menuBar == null){  
	            	menuBar = new JMenuBar();  
	            	menuBar.add(getItemDoMenu());  
	            }  
	            return menuBar;  
	    }
	    
	    private JMenu getItemDoMenu() {  
	        if (menu == null){  
	        	menu = new JMenu();  
	        	menu.setText("opções");  
	            menu.add(getMenuConfiguracao());  
	        }  
	        return menu;  
	    }
	    
	    private JMenuItem getMenuConfiguracao() {  
	        if (configuracao == null){  
	        	configuracao = new JMenuItem();  
	        	configuracao.setText("Configurações");  
	        }  
	        return configuracao;  
	    } 
	    
	    public JLabel getLblHora() {  
	        if (lblHora == null) {  
	            lblHora = new JLabel();  
	        }  
	        return lblHora;  
	    }  
	  
	  
	    public void setHora(Date date) {  
	        getLblHora().setText(FORMATO.format(date));  
	    }  

	    public void addListener(final JCheckBox check){
	    	check.addItemListener(new ItemListener() {
	    		public void itemStateChanged(ItemEvent e) {
	    			new MainController().executeChangeJChecked(check);
	    		}
	    	});
	    	
	    }

		private void openConfiguration() {
			new ConfigurationViewApplication();
			
		}	    
	    public void addJMenuItemListener(final JMenuItem itemMenu){
	    	itemMenu.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
				  openConfiguration();
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
			
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					
				}

	    	});
	    	
	    }

}  

