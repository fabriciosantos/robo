package br.com.application.infra;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

public class Converter<T> {
	
	private T conteudo;
	
	public Converter(T conteudo){
		this.conteudo = conteudo;
	}
	
	public Converter(){
		
	}
	
	
	  public T convertXMLToObject(String alias , Class<T> classe) {
			
			try {
				
				XStream xStream = new XStream();
				xStream.alias(alias, classe);
				
				String pathDiretorioAtual = new File(".").getCanonicalPath();
				File arquivoDeConfiguracao = new File(pathDiretorioAtual+"/configuracao.xml");
				
				
				@SuppressWarnings("unchecked")
				T retornoConteudoEmObjeto = (T)xStream.fromXML(arquivoDeConfiguracao);
				
				return retornoConteudoEmObjeto;
				
			} catch (IOException e) {
				
				e.printStackTrace();
				return null;
			}
	
			
		}
	
		public void generateXMl(String alias) {
			
			XStream xStream = new XStream();
			xStream.alias(alias, this.conteudo.getClass());
			String usuarioXML = xStream.toXML(this.conteudo);
			
			try {
				String pathDiretorioAtual = new File(".").getCanonicalPath();
				File arquivoDeConfiguracao = new File(pathDiretorioAtual+"/configuracao.xml");
				
				FileWriter fw = new FileWriter(arquivoDeConfiguracao.getAbsolutePath());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(usuarioXML);
				bw.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			
			} catch (IOException e) {
				e.printStackTrace();
			}	
			
		}
	

	
	
	
}
