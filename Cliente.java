package projetoFinal;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {
	
	//contador sequencial que ira incrementar automaticamente toda vez que um novo cliente for instanciado
	public static int seq = 0;

	private int idCliente;
	private String nomeCliente;
	private int idade; 
	private String cpf;
	private String telefone;
	private String sexo;
	private String endereco;
	private Boolean motoristaApp; // se for motorista de App, terá desconto no aluguel
	private ArrayList<Veiculo> carros = new ArrayList<Veiculo>();
	private Double Aluguel; // valor do aluguel do veiculo que será agregado ao cadastro do cliente

	public Cliente() {
	}
	
	public Cliente(String nomeCliente, int idade, String cpf, String telefone, String sexo, String endereco, Boolean motoristaApp) {
		Cliente.seq = Cliente.seq + 1;
		this.idCliente = Cliente.seq;
		this.nomeCliente = nomeCliente;
		this.idade = idade;
		this.cpf = cpf;
		this.telefone = telefone;
		this.sexo = sexo;
		this.endereco = endereco;
		this.motoristaApp = motoristaApp;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Boolean getMotoristaApp() {
		return motoristaApp;
	}

	public void setMotoristaApp(Boolean motoristaApp) {
		this.motoristaApp = motoristaApp;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public Double getAluguel() {
		return Aluguel;
	}

	public void setAluguel(Double aluguel) {
		Aluguel = aluguel;
	}

	public ArrayList<Veiculo> getCarros() {
		return carros;
	}

	public void setCarros(ArrayList<Veiculo> carros) {
		this.carros = carros;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Cliente");
		sb.append("\nID Cliente: " + idCliente);
		sb.append("\nNome: " + nomeCliente);
		sb.append("\nIdade: " + idade);
		sb.append("\nCpf: " + cpf);
		sb.append("\nTelefone: " + telefone);
		sb.append("\nSexo: " + sexo);
		sb.append("\nEndereço: " + endereco);
		sb.append("\nMotorista de APP: " + motoristaApp);
		sb.append("\n" + carros);
		return sb.toString();
	}

}
