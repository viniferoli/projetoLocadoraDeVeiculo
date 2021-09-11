package projetoFinal;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Main {
	
	private static LerArquivo leitor = new LerArquivo();
	private static GravarArquivo gravador = new GravarArquivo();
	private static String arquivo_veiculos = "veiculos.txt";
	private static String arquivo_clientes = "clientes.txt";

	public static void main(String[] args) {
		
		// Lê o arquivo de Veiculos e Clientes
				ArrayList<Veiculo> veiculos = null;
				ArrayList<Cliente> clientes = null;
				try {
					veiculos = leitor.veiculos(arquivo_veiculos);
					clientes = leitor.clientes(arquivo_clientes);
				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Existe um erro nos arquivos do programa. Saindo.");
					System.exit(0);
				} catch (IOException e) {

					JOptionPane.showMessageDialog(null, "Os arquivos de dados n�o foram encontrados, uma nova base ser� criada.");
					veiculos = new ArrayList<Veiculo>();
					clientes = new ArrayList<Cliente>();
				}
				// Coloca o sequ�ncial do c�digo sincronizado com os conte�dos j� salvos
				if(veiculos.size() > 0) {
					// Coloca na sequ�ncia o maior c�digo cadastrado
					int seq = 0;
					for(int i = 0; i < veiculos.size(); i++) {
						if(veiculos.get(i).getIdVeiculo() > seq) {
							seq = veiculos.get(i).getIdVeiculo();
						}
					}
					Veiculo.seq = seq;
				}else {
					Veiculo.seq = 0;
				}
				if(clientes.size() > 0) {
					// Define a sequ�ncia das Clientes
					int seq = 0;
					for(int i = 0; i < clientes.size(); i++) {
						if(clientes.get(i).getIdCliente() > seq) {
							seq = clientes.get(i).getIdCliente();
						}
					}
					Cliente.seq = seq;
				}else {
					Cliente.seq = 0;
				}
				
				inicial(veiculos, clientes);
	}
	
	
	public static void salvarVeiculos(ArrayList<Veiculo> veiculos) {
		// Salva as listas nos arquivos
		try {
			gravador.veiculos(veiculos, arquivo_veiculos);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao salvar os veiculos.");
		}
		
		
	}
	public static void salvarClientes(ArrayList<Cliente> clientes) {
		// Salva as listas nos arquivos
		try {
			gravador.clientes(clientes, arquivo_clientes);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao salvar os clientes.");
		}
		
	}
	
		public static void inicial(ArrayList<Veiculo> veiculos, ArrayList<Cliente> clientes) {
		Locadora loc = Locadora.getInstancia();
		int op=0;
		
		JOptionPane.showMessageDialog(null,"\n\nLoCar | Loca��o de Ve�culos\n\n\n\n\nPressione OK para continuar...\n\n");
		
		while(op!=5){
			op = Integer.parseInt(JOptionPane.showInputDialog(null," 1| Cliente\n 2| Ve�culo\n 3| Gerenciamento de Loca��o\n"
					+ " 4| Empresa\n 5| Sair"));
			
			if (op==1){
            	int opc=0;
            	
            	while(opc!=8) {
	            	
	            	opc = Integer.parseInt(JOptionPane.showInputDialog(null," 1| Cadastrar Cliente\n 2| Alterar Cliente\n"
		    					+ " 3| Buscar Cliente Por Nome\n 4| Buscar Cliente Por CPF\n 5| Buscar Cliente por Id\n 6| Listar Todos Clientes\n"
		    					+ " 7| Excluir Cadastro de Cliente\n 8| Voltar ao Menu Principal"));
	            	
	            	if(opc==1) {
	            		String nomeCliente = JOptionPane.showInputDialog(null,"Entre com o nome do Cliente");
	            		int idade = Integer.parseInt(JOptionPane.showInputDialog(null,"Entre com a idade"));
	    				String cpf = JOptionPane.showInputDialog(null,"Entre com o cpf");
	    				String telefone = JOptionPane.showInputDialog(null,"Entre com o telefone: (xx) xxxxx-xxxx");
	    				String  sexo = JOptionPane.showInputDialog(null,"Entre com o sexo");
	    				String endereco = JOptionPane.showInputDialog(null,"Entre com o endere�o");
	    				Boolean app = Boolean.valueOf( JOptionPane.showInputDialog(null,"� motorista de App?\nDigite True para Sim ou False para N�o") );
	    				
	    				loc.registrarCliente(clientes, new Cliente(nomeCliente, idade, cpf, telefone, sexo, endereco, app));
	    				salvarClientes(clientes);
	            	}
	            	else if(opc==2) {
	            		
	            		String cp = JOptionPane.showInputDialog(null,"Entre com o cpf");
	            		loc.buscarClientePorCpf(clientes, cp);
	            		
	            		String opt = JOptionPane.showInputDialog(null,"Deseja alterar este cadastro? (S/N)");
	            		
	            		while(opt.equalsIgnoreCase("s")) {
	            			String nomeCliente = JOptionPane.showInputDialog(null,"Entre com o nome do Cliente");
		            		int idade = Integer.parseInt(JOptionPane.showInputDialog(null,"Entre com a idade"));
		    				String cpf = JOptionPane.showInputDialog(null,"Entre com o cpf");
		    				String telefone = JOptionPane.showInputDialog(null,"Entre com o telefone: (xx) xxxxx-xxxx");
		    				String  sexo = JOptionPane.showInputDialog(null,"Entre com o sexo");
		    				String endereco = JOptionPane.showInputDialog(null,"Entre com o endere�o");
		    				Boolean app = Boolean.valueOf( JOptionPane.showInputDialog(null, "� motorista de App?\nDigite True para Sim ou False para N�o"));
		    				
		    				Cliente x = new Cliente(nomeCliente, idade, cpf, telefone, sexo, endereco, app);
		    				
		            		loc.alterarCliente(clientes, cp, x);
		            		JOptionPane.showMessageDialog(null, "Cadastro Alterado Com Sucesso");
		            		salvarClientes(clientes);
	            			break;
	            		}
	            			
	            	}
	            	else if(opc==3) {
	            		String nome = JOptionPane.showInputDialog(null,"Entre com o nome que deseja consultar");
	            		loc.buscarClientePorNome(clientes, nome);
	            		
	            	}
	            	else if(opc==4) {
	            		String cpf = JOptionPane.showInputDialog(null,"Entre com o cpf que deseja consultar");
	            		loc.buscarClientePorCpf(clientes, cpf);
	            		
	            	}
	            	else if(opc==5) {
	            		int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Entre com o id que deseja consultar"));
	            		loc.buscarClientePorId(clientes, id);	
	            		
	            	}
	            	else if(opc==6) {
	            		loc.listarClientes(clientes);
	            	}
	            	else if(opc==7) {
	            		String cp = JOptionPane.showInputDialog(null,"Entre com o cpf");
	            		loc.buscarClientePorCpf(clientes, cp);
	            		
	            		String opt = JOptionPane.showInputDialog(null,"Deseja excluir este cadastro? (S/N)");
	            		
	            		while(opt.equalsIgnoreCase("s")) {
	            			loc.deletarClientePorCpf(veiculos, clientes, cp);
	            			JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso");
	            			salvarClientes(clientes);
	            			salvarVeiculos(veiculos);
	            			break;
	            		}
	            		
	            	}
	            	else if(opc==8){
	            		
	            	}
	            	else {
	            		JOptionPane.showMessageDialog(null, "Op��o incorreta! Digite Novamente");
	            	}
	            	
            	}
			}
            else if (op==2){
            	int opc=0;
            	
            	while(opc!=8) {
	            	
	            	opc = Integer.parseInt(JOptionPane.showInputDialog(null," 1| Cadastrar Ve�culo\n 2| Alterar Ve�culo\n"
		    					+ " 3| Buscar Ve�culo Por Modelo\n 4| Buscar Ve�culo Por Placa\n 5| Buscar por Ve�culo Id\n 6| Listar Todos Ve�culos\n"
		    					+ " 7| Excluir Cadastro do Ve�culo\n 8| Voltar ao Menu Principal"));
	            	
	            	if(opc==1) {
	            		String fabricante = JOptionPane.showInputDialog(null,"Entre com o nome do fabricante");
	            		String placa = JOptionPane.showInputDialog(null,"Entre com a placa");
	            		int ano = Integer.parseInt(JOptionPane.showInputDialog(null,"Entre com o ano"));
	    				String nomeModelo = JOptionPane.showInputDialog(null,"Entre com o Modelo");
	    				String tipo = JOptionPane.showInputDialog(null,"Entre com o tipo \n(Hatch | Sedan | Pick Up)");
	    				String  cor = JOptionPane.showInputDialog(null,"Entre com a cor");
	    				String combustivel = JOptionPane.showInputDialog(null,"Entre com o combustivel \n(Etanol | Gasolina | Flex | Diesel)");
	    				int totalModelo = Integer.parseInt(JOptionPane.showInputDialog(null,"Entre com a quantidade de ve�culos deste modelo adquiridos"));
	    				Double valorAluguel = Double.parseDouble(JOptionPane.showInputDialog(null,"Entre com o valor do aluguel\n(R$/Dia)"));
	    				
	    				
	    				
	    				try {
							loc.cadastrarVeiculo(veiculos, new Veiculo(fabricante, placa, ano, new Modelo(nomeModelo, tipo, cor, combustivel, totalModelo, valorAluguel)));
						} catch (NumeroInvalidoException e) {
							e.printStackTrace();
						}
	    				
	    				JOptionPane.showMessageDialog(null, "Ve�culo Cadastrado Com Sucesso");
	    				salvarVeiculos(veiculos);
	            	}
	            	else if(opc==2) {
	            		
	            		String plak = JOptionPane.showInputDialog(null,"Entre com a placa");
	            		loc.buscarVeiculoPorPlaca(veiculos, plak);
	            		
	            		String opt = JOptionPane.showInputDialog(null,"Deseja alterar este cadastro? (S/N)");
	            		
	            		while(opt.equalsIgnoreCase("s")) {
	            			String fabricante = JOptionPane.showInputDialog(null,"Entre com o nome do fabricante");
		            		String placa = JOptionPane.showInputDialog(null,"Entre com a placa");
		            		int ano = Integer.parseInt(JOptionPane.showInputDialog(null,"Entre com o ano"));
		    				String nomeModelo = JOptionPane.showInputDialog(null,"Entre com o Modelo");
		    				String tipo = JOptionPane.showInputDialog(null,"Entre com o tipo");
		    				String  cor = JOptionPane.showInputDialog(null,"Entre com a cor");
		    				String combustivel = JOptionPane.showInputDialog(null,"Entre com o combustivel");
		    				int totalModelo = Integer.parseInt(JOptionPane.showInputDialog(null,"Entre com a quantidade de ve�culos deste modelo adquiridos"));
		    				Double valorAluguel = Double.parseDouble(JOptionPane.showInputDialog(null,"Entre com o valor do aluguel"));
		    	
		    				
		    				Veiculo v;
							try {
								v = new Veiculo(fabricante, placa, ano, new Modelo(nomeModelo, tipo, cor, combustivel, totalModelo, valorAluguel));
								loc.alterarCadastroVeiculo(veiculos, plak, v);
							} catch (NumeroInvalidoException e) {
								e.printStackTrace();
							}
		    				
		    				
		            		JOptionPane.showMessageDialog(null, "Cadastro Alterado Com Sucesso");
		            		salvarVeiculos(veiculos);
	            			break;
	            		}
	            			
	            	}
	            	else if(opc==3) {
	            		String modelo = JOptionPane.showInputDialog(null,"Entre com o nome do modelo que deseja consultar");
	            		loc.buscarVeiculoPorModelo(veiculos, modelo);
	            	}
	            	else if(opc==4) {
	            		String placa = JOptionPane.showInputDialog(null,"Entre com a placa que deseja consultar");
	            		loc.buscarVeiculoPorPlaca(veiculos, placa);
	            	}
	            	else if(opc==5) {
	            		int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Entre com o id que deseja consultar"));
	            		loc.buscarVeiculoPorID(veiculos, id);
	            	}
	            	else if(opc==6) {
	            		loc.listarVeiculos(veiculos);	
	            	}
	            	else if(opc==7) {
	            		String plak = JOptionPane.showInputDialog(null,"Entre com a placa");
	            		loc.buscarVeiculoPorPlaca(veiculos, plak);
	            		
	            		String opt = JOptionPane.showInputDialog(null,"Deseja alterar este cadastro? (S/N)");
	            		
	            		while(opt.equalsIgnoreCase("s")) {
	            			loc.deletarCadastroVeiculoPorPlaca(veiculos, clientes, plak);
	            			salvarClientes(clientes);
	            			salvarVeiculos(veiculos);
	            			JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso");
	            			break;
	            		}
	            		
	            	}
	            	else if(opc==8){
	            		
	            	}
	            	else {
	            		JOptionPane.showMessageDialog(null, "Op��o incorreta! Digite Novamente");
	            	}
	            	salvarClientes(clientes);
        			salvarVeiculos(veiculos);
            	}
			}
            else if(op==3) {
            	int opc=0;
            	
            	while(opc!=4) {
	            	
	            	opc = Integer.parseInt(JOptionPane.showInputDialog(null," 1| Alugar Ve�culo\n 2| Calcular Aluguel\n 3| Devolver Ve�culo\n 4| Voltar ao Menu Principal"));
	            	
	            	if(opc==1) {
	            		String cp = JOptionPane.showInputDialog(null,"Entre com o cpf");
	            		loc.buscarClientePorCpf(clientes, cp);
	            		
	            		String opt = JOptionPane.showInputDialog(null,"Cliente correto? (S/N)");
	            		
	            		while(opt.equalsIgnoreCase("s")) {
	            			String plak = JOptionPane.showInputDialog(null,"Entre com a placa");
		            		loc.buscarVeiculoPorPlaca(veiculos, plak);
		            		
		            		String opcion = JOptionPane.showInputDialog(null,"Ve�culo encontrado est� correto? (S/N)");
		            		
		            		while(opcion.equalsIgnoreCase("s")) {
		            			loc.alugarVeiculo(veiculos, clientes, cp, plak);
		            			salvarClientes(clientes);
		            			salvarVeiculos(veiculos);
		            			break;
		            		}
		            		opt = JOptionPane.showInputDialog(null,"Deseja alugar outro ve�culo para esse mesmo cpf? (S/N)");
		            		
	            		}
	            		
	            	}
	            	else if(opc==2) {
	            		String cp = JOptionPane.showInputDialog(null,"Entre com o cpf");
	            		loc.buscarClientePorCpf(clientes, cp);
	            		
	            		String opt = JOptionPane.showInputDialog(null,"Cliente correto? (S/N)");
	            		
	            		while(opt.equalsIgnoreCase("s")) {
	            			String plak = JOptionPane.showInputDialog(null,"Entre com a placa");
		            		loc.buscarVeiculoPorPlaca(veiculos, plak);
		            		
		            		String opcion = JOptionPane.showInputDialog(null,"Ve�culo encontrado est� correto? (S/N)");
		            		
		            		while(opcion.equalsIgnoreCase("s")) {
		            			int dias = Integer.parseInt(JOptionPane.showInputDialog(null,"Entre com a quantidade de dias que deseja alugar o ve�culo"));
		            			loc.calcularAluguel(veiculos, clientes, cp, plak, dias);
		            			salvarClientes(clientes);
		            			salvarVeiculos(veiculos);
		            			break;
		            		}
		            		opt = "n";
		            		
	            		}
	            	}
	            	else if(opc==3) {
	            		String cp = JOptionPane.showInputDialog("Entre com o cpf");
	            		loc.buscarClientePorCpf(clientes, cp);
	            		
	            		String opt = JOptionPane.showInputDialog("Cliente correto? (S/N)");
	            		
	            		while(opt.equalsIgnoreCase("s")) {
	            			String plak = JOptionPane.showInputDialog(null,"Entre com a placa");
		            		loc.buscarVeiculoPorPlaca(veiculos, plak);
		            		
		            		String opcion = JOptionPane.showInputDialog(null,"Ve�culo encontrado est� correto? (S/N)");
		            		
		            		while(opcion.equalsIgnoreCase("s")) {
		            			loc.devolverVeiculo(veiculos, clientes, cp, plak);
		            			salvarClientes(clientes);
		            			salvarVeiculos(veiculos);
		            			break;
		            		}
		            		opt = JOptionPane.showInputDialog(null,"Deseja devolver outro ve�culo desse mesmo cpf? (S/N)");
		            		
	            		}
	            	}
	            	else if(opc==4) {
	            		
	            	}
	            	else	
	                	JOptionPane.showMessageDialog(null, "Op��o incorreta! Digite Novamente");
            	}
            	
            }
            else if(op==4) {
            	loc.mostrarDadosEmpresa();
            	
            }
            else if(op==5) {
            	salvarClientes(clientes);
    			salvarVeiculos(veiculos);
            	JOptionPane.showMessageDialog(null, "\n\n                Saindo... \n\n\n\nPressione OK para finalizar!");
            }
            		
            else	
            	JOptionPane.showMessageDialog(null, "Op��o incorreta! Digite Novamente");
 
                
			
        }
					
		
	}
}
