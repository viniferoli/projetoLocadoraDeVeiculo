package projetoFinal;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class LerArquivo implements Leitor {
	
	
	public ArrayList<Cliente> clientes(String nome_arquivo) throws IOException, ClassNotFoundException{
		
		FileInputStream fis = new FileInputStream(nome_arquivo);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		int size = ois.readInt();
		
		for (int i=0; i<size; i++) {
			Cliente cliente = (Cliente)ois.readObject();
			clientes.add(cliente);
        }
		
		ois.close();
		fis.close();
		
		return clientes;
	}
	

	public ArrayList<Veiculo> veiculos(String nome_arquivo) throws IOException, ClassNotFoundException{
		
		FileInputStream fis = new FileInputStream(nome_arquivo);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		
		int size = ois.readInt();
		
		for (int i=0; i<size; i++) {
			Veiculo veiculo = (Veiculo) ois.readObject();
			veiculos.add(veiculo);
        }
		
		ois.close();
		fis.close();
		
		return veiculos;
	}
}
