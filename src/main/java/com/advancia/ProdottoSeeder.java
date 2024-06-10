package com.advancia;

import java.util.ArrayList;
import java.util.List;

public class ProdottoSeeder {
	
	private ProdottoSeeder() {}

	public static final List<Prodotto> getProdottoList() {
		List<Prodotto> list = new ArrayList<>();
		list.add(new Prodotto("001", "Latte", 1, 2));
		list.add(new Prodotto("002", "Miele", 4, 3));
		list.add(new Prodotto("003", "Pane", 5, 10));
		list.add(new Prodotto("004", "Pasta", 6, 4));
		list.add(new Prodotto("005", "Carne", 2, 3));
		return list;
	}
}
