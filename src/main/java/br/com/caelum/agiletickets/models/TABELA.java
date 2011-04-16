package br.com.caelum.agiletickets.models;

public enum TABELA {
	NORMAL(0),
	IDOSO(50);
	
	private int desconto;
	
	private TABELA(int desconto) {
		this.desconto = desconto;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}
}
