package es.alvaro.IoC;

public class LibroCienciaFiccion implements Libro {
	
	private PaginasInterface paginas;
	private String editorial;
	private String autor;


	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setPaginas(PaginasInterface paginas) {
		this.paginas = paginas;
	}

	@Override
	public String getTitulo() {
		return "Dune";
	}

	@Override
	public int getPaginas() {
		return 704;
	}

	@Override
	public String getPaginasString() {
		return String.valueOf(getPaginas()) + paginas.getPaginas();
	}

}
