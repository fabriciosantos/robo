package br.com.application.service;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.application.domain.Usuario;


public class ServicoSelenium {
	
	private ServicoDeConfiguracao configuracao = new ServicoDeConfiguracao();

	public  void executaServicoSeleium() {
		  
		  WebDriver driver  = new FirefoxDriver();     
		  
		  driver.get("http://portalhoras.stefanini.com/");       
		 
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  WebElement inputFunction = driver.findElement(By.name("func_relogio_8002"));//funcao
		  
		  WebElement inputUsuario = driver.findElement(By.name("userName_relogio_8002"));//user
		  
		  WebElement inputSenha = driver.findElement(By.name("password_relogio_8002"));//senha
		  
		  WebElement button = driver.findElement(By.id("ext-gen59"));//button

		 
		  Usuario usuario = configuracao.getUsuarioXML();
		  
		  inputFunction.sendKeys(usuario.getFuncao());
		  inputUsuario.sendKeys(usuario.getLogin());
		  inputSenha.sendKeys(usuario.getSenha());
		  
		  
		  button.click();
		  
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  
		  driver.close();
		
		            
	}
}
