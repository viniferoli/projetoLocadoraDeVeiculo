package projetoFinal;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Locadora implements Servicos{
	
	public static Locadora instancia;
	private String nomeLocadora;
	private String rSocial;
	private String cnpj;
	private String endereco;
	private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	private Locadora() {
		this.nomeLocadora = "LoCar";
		this.rSocial = "Locadora LoKar S/A";
		this.cnpj = "17.001.601/0002-34";
		this.endereco = "Av. das Tulipas, 1524, Jardins, Florianópolis - SC";
	}
	
	
	//Padrão singleton utilizado, pois o sistema foi feito sob medida para um cliente especifico
	public static Locadora getInstancia() {
		if (instancia == null) {
			instancia = new Locadora();
		}
		return instancia;
	}

	// CRUD de clientes

	public void registrarCliente(ArrayList<Cliente> clis, Cliente c) {
		clis.add(c);
	}

	public void listarClientes(ArrayList<Cliente> clis) {
		if(clis.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há clientes cadastrados");
		}
		else {
			for (Cliente c : clis) {
				JOptionPane.showMessageDialog(null, c.toString());
			}
		}
		
	}

	public void buscarClientePorId(ArrayList<Cliente> clis, int id) {
		int cont =0;
		if(clis.isEmpty()) {
			JOptionPane.showMessageDialog(null, "ID incorreto tente novamente");
		}
		else {
			for (Cliente c : clis) {
				if (c.getIdCliente() == id) {
					JOptionPane.showMessageDialog(null, c.toString());
					cont++;
					break;
				}
			}
			if(cont==0) 
				JOptionPane.showMessageDialog(null, "ID incorreto tente novamente");
		}
	}

	public void buscarClientePorCpf(ArrayList<Cliente> clis, String cpf) {
		int cont = 0;
		if(clis.isEmpty()) {
			JOptionPane.showMessageDialog(null, "CPF incorreto tente novamente");
		}
		else {
			for (Cliente c : clis) {
				if (c.getCpf().equalsIgnoreCase(cpf)) {
					JOptionPane.showMessageDialog(null, c.toString());
					cont++;
					break;
				}
			}
			if(cont==0) 
				JOptionPane.showMessageDialog(null, "CPF incorreto tente novamente");
		}
		
	}

	public void buscarClientePorNome(ArrayList<Cliente> clis, String nome) {
		int cont = 0;
		
		if(clis.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há clientes cadastrados");
		}
		else{
			for (Cliente c : clis) {
				if (c.getNomeCliente().equalsIgnoreCase(nome)) {
					JOptionPane.showMessageDialog(null, c.toString());
					cont++;
					break;
				}
				
			}
			if(cont==0) 
				JOptionPane.showMessageDialog(null, "Nome incorreto tente novamente");
			
		}
	}

	public void alterarCliente(ArrayList<Cliente> clis, String cpf, Cliente x) {
		for (Cliente c : clis) {
			if (c.getCpf().equals(cpf)) {
				c.setNomeCliente(x.getNomeCliente());
				c.setCpf(x.getCpf());
				c.setIdade(x.getIdade());
				c.setSexo(x.getSexo());
				c.setTelefone(x.getTelefone());
				c.setEndereco(x.getEndereco());
				c.setMotoristaApp(x.getMotoristaApp());
				c.setMotoristaApp(x.getMotoristaApp());
			}
		}
	}

	public void deletarClientePorCpf(ArrayList<Veiculo> veiculos, ArrayList<Cliente> clis, String cpf) {
		for (Cliente c : clis) {
			if (c.getCpf().equals(cpf)) {
				clis.remove(c);
				break;
			}
		}
	}
	
	// CRUD para veículos
	
	public void cadastrarVeiculo(ArrayList<Veiculo> vs, Veiculo v) {
		vs.add(v);
	}

	public void listarVeiculos(ArrayList<Veiculo> vs) {
		for (Veiculo v : vs) {
			JOptionPane.showMessageDialog(null, v.toString());
		}
	}

	public void buscarVeiculoPorID(ArrayList<Veiculo> vs, int id) {
		int cont = 0;
		for (Veiculo v : vs) {
			if (v.getIdVeiculo() == id) {
				JOptionPane.showMessageDialog(null, v.toString());
				cont++;
				break;
			}
		}
		if(cont==0) 
			JOptionPane.showMessageDialog(null, "ID incorreto tente novamente");
	}

	public void buscarVeiculoPorPlaca(ArrayList<Veiculo> vs, String placa) {
		int cont = 0;
		for (Veiculo v : vs) {
			if (v.getPlaca().equalsIgnoreCase(placa)) {
				JOptionPane.showMessageDialog(null, v.toString());
				cont++;
				break;
			}
		}
		if(cont==0) 
			JOptionPane.showMessageDialog(null, "Placa incorreta tente novamente");
	}

	public void buscarVeiculoPorModelo(ArrayList<Veiculo> vs, String modelo) {
		int cont = 0;
		for (Veiculo v : vs) {
			if (v.getModelo().getNomeModelo().equalsIgnoreCase(modelo)) {
				JOptionPane.showMessageDialog(null, v.toString());
				cont++;
				break;
			}
		}
		if(cont==0) 
			JOptionPane.showMessageDialog(null, "Modelo incorreto tente novamente");
	}

	public void alterarCadastroVeiculo(ArrayList<Veiculo> vs, String placa, Veiculo x) {
		for(Veiculo v : vs) {
			if(v.getPlaca().equalsIgnoreCase(placa)) {
				v.setFabricante(x.getFabricante());
				v.setPlaca(x.getPlaca());
				try {
					v.setAno(x.getAno());
				} catch (NumeroInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				v.getModelo().setNomeModelo(x.getModelo().getNomeModelo());
				v.getModelo().setCor(x.getModelo().getCor());
				v.getModelo().setTipo(x.getModelo().getTipo());
				try {
					v.getModelo().setTotalModelo(x.getModelo().getTotalModelo());
				} catch (NumeroInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				v.getModelo().setValorAluguel(x.getModelo().getValorAluguel());
			}
		}
	}

	public void deletarCadastroVeiculoPorPlaca(ArrayList<Veiculo> vs, ArrayList<Cliente> clis, String placa) {
		for (Veiculo v : vs) {
			if (v.getPlaca().equalsIgnoreCase(placa)) {
				vs.remove(v);
				clis.remove(v);
				
				break;
			}
		}
	}
	
	
	//Calcular valor do aluguel do veículo
	public void alugarVeiculo(ArrayList<Veiculo> vs, ArrayList<Cliente> clis, String cpf, String placa) {
		Veiculo w = new Veiculo();
		for (Veiculo v : vs) {
			if (v.getPlaca().equalsIgnoreCase(placa)) {
				//controle de estoque referente a quantidade de modelos disponiveis
				try {
					v.getModelo().setTotalModelo(v.getModelo().getTotalModelo()-1);
				} catch (NumeroInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				w = v;
				break;
				
			}
		}
		for (Cliente c : clis) {
			if (c.getCpf().equals(cpf)) {
				c.getCarros().add(w);
				JOptionPane.showMessageDialog(null, "Veículo vinculado ao usuário com sucesso");
				break;
				
			}	
		}
	}
	
	
	//Devolver veiculo que cliente alugou buscando o seu cadastro por cpf, e buscando cadastro do veículo por placa
	public void devolverVeiculo(ArrayList<Veiculo> vs, ArrayList<Cliente> clis, String cpf, String placa) {
		Veiculo w = new Veiculo();
		for (Veiculo v : vs) {
			if (v.getPlaca().equalsIgnoreCase(placa)) {
				try {
					v.getModelo().setTotalModelo(v.getModelo().getTotalModelo()+1);
				} catch (NumeroInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				w = v;
				break;
				
			}
		}
		for (Cliente c : clis) {
			if (c.getCpf().equals(cpf)) {
				c.getCarros().remove(w);
				JOptionPane.showMessageDialog(null, "Veículo devolvivo com sucesso");
				break;
				
			}	
		}
	}
	
	
	//calcular aluguel do veiculo, caso cliente seja motorista de app ou caso alugue por 30 dias ou mais receberá desconto de 10%
	public void calcularAluguel(ArrayList<Veiculo> vs, ArrayList<Cliente> clis, String cpf, String placa, int dias) {
		Veiculo w = new Veiculo();
		Cliente x = new Cliente();
		for (Veiculo v : vs) {
			if (v.getPlaca().equalsIgnoreCase(placa)) {
				w = v;
				break;
				
			}
		}
		for (Cliente c : clis) {
			if (c.getCpf().equals(cpf)) {
				x = c;
				break;
				
			}	
		}
		
		if(x.getMotoristaApp() || dias>=30) {
			x.setAluguel((w.getModelo().getValorAluguel() *dias) - ((w.getModelo().getValorAluguel() *dias)*0.10));
			JOptionPane.showMessageDialog(null, "Motorista de App: " + x.getMotoristaApp() + "\nDesconto: " + ((w.getModelo().getValorAluguel() *dias)*0.10) + "\nValor do aluguel R$ " + x.getAluguel());
		}
		else {
			x.setAluguel((w.getModelo().getValorAluguel() *dias));
			JOptionPane.showMessageDialog(null, "Motorista de App: " + x.getMotoristaApp() + "\nDesconto: Não possui" + "\nValor do aluguel R$ " + x.getAluguel());
	
		}
			
	}
	
	//metodo mostra apenas os dados da empresa
	public void mostrarDadosEmpresa() {
		JOptionPane.showMessageDialog(null, "Locadora " + nomeLocadora + "\nRazão Social: " + rSocial + "\nCnpj: " + cnpj + "\nEndereco: "
				+ endereco);
	}
	
	
	//Lista todos os cadastros de clientes e veiculos
	@Override
	public String toString() {
		return "Locadora " + nomeLocadora + "\nCadastros\nveiculos=" + veiculos + "\nclientes=" + clientes;
	}
	
	

}
