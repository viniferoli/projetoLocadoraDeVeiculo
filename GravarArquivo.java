package projetoFinal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class GravarArquivo implements Gravador {
	
	 //Grava uma lista de clientes em um arquivo.
	 
	public void clientes(ArrayList<Cliente> clientes, String nome_arquivo) throws IOException{
		
		File f = new File(nome_arquivo);
		if(f.exists() && !f.isDirectory()) { 
		    f.delete();
		}
		
		FileOutputStream fos = new FileOutputStream(nome_arquivo, true);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//save the number of records
        oos.writeInt(clientes.size());
		
		for(int i = 0; i < clientes.size(); i++){
			oos.writeObject(clientes.get(i));
			oos.reset();
		}
		
		oos.close();
	}
	
	public void veiculos(ArrayList<Veiculo> veiculos, String nome_arquivo) throws IOException{
		
		File f = new File(nome_arquivo);
		if(f.exists() && !f.isDirectory()) { 
		    f.delete();
		}
		
		FileOutputStream fos = new FileOutputStream(nome_arquivo, true);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//save the number of records
        oos.writeInt(veiculos.size());
		
		for(int i = 0; i < veiculos.size(); i++){
			oos.writeObject(veiculos.get(i));
			oos.reset();
		}
		
		oos.close();
	}
}
