package com.alvaro.ioc;

public class App {

	public static void main(String[] args) {
		/* 
		 * Esto es un simple ejemplo de Inyección de Dependencias (IoC) de java puro.
		 * La lógica de negocio no se ve afectada debido a que usamos el factory como punto
		 * intermedio entre la generación de la dependencia y su uso en el App. De esta forma
		 * si nuestra aplicación fuese más grande nos evitariamos la duplicación de código,
		 * por lo que hacemos nuestra aplicación más escalable empleando principios de flexibilidad
		 * y de reutilización.
		*/
		
		
		// Aquí se implementa la Inyección de dependencia
		// NovelaFactory obj = new NovelaFactory(new NovelaAventura());
		NovelaFactory obj = new NovelaFactory(new NovelaCienciaFiccion());
		obj.getTitulo();
		obj.getAutor();
		obj.getPaginas(608);
	}

}
