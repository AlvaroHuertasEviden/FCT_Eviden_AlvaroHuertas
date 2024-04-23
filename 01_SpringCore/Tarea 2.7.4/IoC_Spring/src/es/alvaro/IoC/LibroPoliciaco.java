package es.alvaro.IoC;

public class LibroPoliciaco implements Libro {
	
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
		return "El caso Hartung";
	}

	@Override
	public int getPaginas() {
		return 528;
	}

	@Override
	public String getPaginasString() {
		return String.valueOf(getPaginas()) + paginas.getPaginas();
	}
	
	// Crear método INIT: Ejecutar tareas después de que el bean esté disponible
	public void metodoInit() {
		System.out.println("Conectando con la base de datos Firestore.");
		System.out.println("Conexión Establecida!");
	}
	
	// Crear método DESTROY: Ejecutar tareas antes de que el bean haya sido utilizado
	public void metodoDestroy() {
		System.out.println("Cerrando conexión con la base de datos externa.");
		System.out.println("Conexión cerrada!");
	}
	

}
