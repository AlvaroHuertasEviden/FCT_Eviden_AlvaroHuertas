package com.alvaro.ioc;

public class NovelaCienciaFiccion implements INovela {

	@Override
	public void titulo() {
		System.out.println("Título: Dune");
		
	}

	@Override
	public void autor() {
		System.out.println("Autor: Frank Herbert");
		
	}

	@Override
	public void paginas(int paginas) {
		System.out.println(paginas + " paginas"); 
		
	}

}
