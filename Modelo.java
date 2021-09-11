package projetoFinal;

import java.io.Serializable;

public class Modelo implements Serializable{

	public static int seq = 0;

	private int idModelo;
	
	private String nomeModelo;
	private String tipo;
	private String cor;
	private String combustivel;
	private int totalModelo;
	private Double valorAluguel;

	public Modelo(String nomeModelo, String tipo, String cor, String combustivel, int totalModelo,
			Double valorAluguel) throws NumeroInvalidoException{
		Modelo.seq = Modelo.seq + 1;
		this.idModelo = Modelo.seq;
		this.nomeModelo = nomeModelo;
		this.tipo = tipo;
		this.cor = cor;
		this.combustivel = combustivel;
		this.setTotalModelo(totalModelo);
		this.valorAluguel = valorAluguel;
	}

	public int getTotalModelo() {
		return totalModelo;
	}

	public void setTotalModelo(int totalModelo) throws NumeroInvalidoException{
		if (totalModelo <0) {
			throw new NumeroInvalidoException("ERRO: A quantidade do modelo de veículo não pode ser negativo!");
		} else 
			this.totalModelo = totalModelo;
	}

	public String getNomeModelo() {
		return nomeModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public Double getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(Double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	
	

	public static int getSeq() {
		return seq;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nModelo: " + nomeModelo);
		sb.append("\nTipo: " + tipo);
		sb.append("\nCor: " + cor);
		sb.append("\nComplet ");
		sb.append("\nTotal de carros desse modelo disponível= " + totalModelo);
		return sb.toString();
	}

}
