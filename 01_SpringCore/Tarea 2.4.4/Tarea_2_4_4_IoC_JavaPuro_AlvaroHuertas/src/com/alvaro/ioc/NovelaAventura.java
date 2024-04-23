package com.alvaro.ioc;

public class NovelaAventura implements INovela {

	@Override
	public void titulo() {
		System.out.println("Título: Robinson Crusoe");
		
	}

	@Override
	public void autor() {
		System.out.println("Autor: Daniel Defoe");
		
	}

	@Override
	public void paginas(int paginas) {
		System.out.println(paginas + " paginas"); 
		
	}

}
