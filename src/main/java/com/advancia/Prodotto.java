package com.advancia;

public class Prodotto {

	private String codice;
	private String nome;
	private int quantitaInMagazzino;
	private int quantitaVenduta;
	private int quantitaTotale;
	
	public Prodotto() {}
	public Prodotto(String codice, String nome, int quantitaInMagazzino, int quantitaVenduta) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.quantitaInMagazzino = quantitaInMagazzino;
		this.quantitaVenduta = quantitaVenduta;
		this.quantitaTotale = quantitaInMagazzino + quantitaVenduta;
	}
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantitaInMagazzino() {
		return quantitaInMagazzino;
	}
	public void setQuantitaInMagazzino(int quantitaInMagazzino) {
		this.quantitaInMagazzino = quantitaInMagazzino;
	}
	public int getQuantitaVenduta() {
		return quantitaVenduta;
	}
	public void setQuantitaVenduta(int quantitaVenduta) {
		this.quantitaVenduta = quantitaVenduta;
	}
	public int getQuantitaTotale() {
		return quantitaTotale;
	}
	public void setQuantitaTotale(int quantitaTotale) {
		this.quantitaTotale = quantitaTotale;
	}
}
