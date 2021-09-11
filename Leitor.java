package projetoFinal;

import java.io.IOException;
import java.util.ArrayList;

public interface Leitor {
	
	public ArrayList<Cliente> clientes(String nome_arquivo) throws IOException, ClassNotFoundException;
	public ArrayList<Veiculo> veiculos(String nome_arquivo) throws IOException, ClassNotFoundException;
	

}
