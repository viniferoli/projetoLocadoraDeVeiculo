package projetoFinal;

import java.io.IOException;

import java.util.ArrayList;

public interface Gravador {
	
	public void clientes(ArrayList<Cliente> clientes, String nome_arquivo) throws IOException;
	public void veiculos(ArrayList<Veiculo> veiculos, String nome_arquivo) throws IOException;
}
