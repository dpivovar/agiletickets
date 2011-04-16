package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {


	@Test
	public void deveVender1ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
        sessao.setTotalIngressos(2);

        Assert.assertTrue(sessao.podeReservar(1));
	}

	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(2);

		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
	
	@Test
	public void deveDarDescontoParaIdosos() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(5);
		
		sessao.setPreco(new BigDecimal(100));
		Assert.assertEquals(50, sessao.getPreco(TABELA.IDOSO).intValue());
		
		
	}
	
	@Test
	public void naoDeveDarDescontoTabelaNormal() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(5);
		
		sessao.setPreco(new BigDecimal(100));
		Assert.assertEquals(100, sessao.getPreco(TABELA.NORMAL).intValue());
		
		
	}	
}
