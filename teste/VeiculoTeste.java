package projetoFinal.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import projetoFinal.Modelo;
import projetoFinal.NumeroInvalidoException;
import projetoFinal.Veiculo;

import org.junit.jupiter.api.Test;

class VeiculoTeste {

	@Test
	void anoInvalido() {
		assertThrows(NumeroInvalidoException.class, VeiculoTeste::testeAnoInvalido);
	}

	static void testeAnoInvalido() throws NumeroInvalidoException {
		new Veiculo("Ford", "ABC1234", 0, 
				new Modelo("KA+", "Hatch", "Vermelho", "Flex", 10, 62.00));
	}

	@Test
	void quantidadeDeVeiculoEmEstoque() {
		assertThrows(NumeroInvalidoException.class, VeiculoTeste::testeQuantidadeDeVeiculoEmEstoque);
	}

	static void testeQuantidadeDeVeiculoEmEstoque() throws NumeroInvalidoException {
		new Veiculo("Chevrolet", "DEDS210", 2001,
				new Modelo("GOL", "Hatch", "Preto", "Gasolina", -4, 5.0));
	}

	@Test
	void cadastro() throws NumeroInvalidoException {
		Veiculo v = new Veiculo("Hyundai", "ALI2021", 2021,
				new Modelo("HB20S", "Sedan", "Branco", "Etanol", 15, 55.00));
		assertEquals(v.getFabricante(), "Hyundai");
	}
}
