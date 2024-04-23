package com.alvaro.ioc;

public class NovelaFactory {
	
	INovela nvl;
	
	public NovelaFactory(INovela nvl) {
		this.nvl = nvl;
	}
	
	public void getTitulo() {
		nvl.titulo();
	}
	
	public void getAutor() {
		nvl.autor();
	}
	
	public void getPaginas(int paginas) {
		nvl.paginas(paginas);
	}
}
