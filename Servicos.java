package projetoFinal;

import java.util.ArrayList;

public interface Servicos {
	
	//serviços relacionados a clientes
	public abstract void registrarCliente(ArrayList<Cliente> clientes, Cliente c);
	public abstract void listarClientes(ArrayList<Cliente> clientes);
	public abstract void buscarClientePorId(ArrayList<Cliente> clientes, int id);
	public abstract void buscarClientePorCpf(ArrayList<Cliente> clientes, String cpf);
	public abstract void buscarClientePorNome(ArrayList<Cliente> clientes, String nome);
	public abstract void alterarCliente(ArrayList<Cliente> clientes, String cpf, Cliente x);
	public abstract void deletarClientePorCpf(ArrayList<Veiculo> veiculos, ArrayList<Cliente> clientes, String cpf);
	
	//serviços relacionados a veiculos
	public abstract void cadastrarVeiculo(ArrayList<Veiculo> veiculos, Veiculo v);
	public abstract void listarVeiculos(ArrayList<Veiculo> veiculos);
	public abstract void buscarVeiculoPorID(ArrayList<Veiculo> veiculos, int id);
	public abstract void buscarVeiculoPorPlaca(ArrayList<Veiculo> veiculos, String placa);
	public abstract void buscarVeiculoPorModelo(ArrayList<Veiculo> veiculos, String modelo);
	public abstract void alterarCadastroVeiculo(ArrayList<Veiculo> veiculos, String modelo, Veiculo x);
	public abstract void deletarCadastroVeiculoPorPlaca(ArrayList<Veiculo> veiculos, ArrayList<Cliente> clientes, String placa);
	
	

}
