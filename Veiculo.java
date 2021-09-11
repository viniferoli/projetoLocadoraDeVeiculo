package projetoFinal;

import java.io.Serializable;

public class Veiculo implements Serializable{
	
	public static int seq = 0;
	
	private int idVeiculo;
	private String fabricante;
	private String placa;
	private int ano;
	private Modelo modelo;
	
	public Veiculo() {
		
	}
	
	public Veiculo(String fabricante, String placa, int ano, Modelo modelo) throws NumeroInvalidoException{
		Veiculo.seq = Veiculo.seq +1;
		this.idVeiculo = Veiculo.seq;
		this.fabricante = fabricante;
		this.placa = placa;
		this.setAno(ano);
		this.modelo = modelo;
	}


	public int getIdVeiculo() {
		return idVeiculo;
	}

	public String getFabricante() {
		return fabricante;
	}


	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) throws NumeroInvalidoException {		
		if (ano <= 0)
			throw new NumeroInvalidoException("ERRO: O ano do veículo não pode ser zero ou negativo!");
		else
			this.ano = ano;
	}


	public Modelo getModelo() {
		return modelo;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nVeiculos");
		sb.append("\nID Veículo: " + idVeiculo);
		sb.append("\nFabricante: " + fabricante);
		sb.append("\nPlaca: " + placa);
		sb.append("\nAno: " + ano);
		sb.append("\n" + modelo);
		return sb.toString();
	}

}
