package br.com.caelum.agiletickets;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ReservaTest {
	
	private RemoteWebDriver browser;

	@Before
		public void setUp() throws Exception {
		browser = new FirefoxDriver();
	}
	
	@After
	public void tearDown() {
		browser.close();
	}
	
	@Test
	public void deveSelecionar2IngressosDeEstudante() throws Exception {
		browser.get("http://localhost:8080/sessao/60");
		browser.findElementById("idoso").click();
		browser.findElementById("quantidade").sendKeys("2");
		browser.findElementById("reservar").click();
		Assert.assertNotNull(browser.findElementById("message"));
		Assert.assertTrue(browser.findElementById("message").getText().contains("12,34"));
		
	}
}
