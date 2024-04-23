package es.alvaro.IoC;

public class LibroAventura implements Libro {
	
	private PaginasInterface paginas;
	
	// Creación de constructor que inyecta la dependencia
	public LibroAventura(PaginasInterface paginas) {
		this.paginas = paginas;
	}

	@Override
	public String getTitulo() {
		return "Robinson Crusoe";
	}

	@Override
	public int getPaginas() {
		return 516;
	}

	@Override
	public String getPaginasString() {
		return String.valueOf(getPaginas()) + paginas.getPaginas();
	}

}
