package es.alvaro.annotations;

import org.springframework.beans.factory.annotation.Value;

public class SagaDune implements Libros {
	
	private TomoLibro tomoLibro;
	
	// Values de archivo externo
	@Value("${autor}")
	private String autor;
	@Value("${libros}")
	private int libros;

	public SagaDune(TomoLibro tomoLibro) {
		this.tomoLibro = tomoLibro;
	}

	@Override
	public String getTitulo() {
		return "Dune";
	}

	@Override
	public int getPaginas() {
		return 6;
	}

	@Override
	public String getPaginasString() {
		return getPaginas() + " tomos.";
	}
	
	public String getTomo() {
		return tomoLibro.getTomo();
	}

	public String getAutor() {
		return autor;
	}

	public int getLibros() {
		return libros;
	}

}
