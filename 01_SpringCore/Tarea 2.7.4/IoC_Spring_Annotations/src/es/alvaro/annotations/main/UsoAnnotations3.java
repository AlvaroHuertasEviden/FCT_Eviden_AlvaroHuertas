package es.alvaro.annotations.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.alvaro.annotations.Config;
import es.alvaro.annotations.SagaDune;

public class UsoAnnotations3 {

	public static void main(String[] args) {
		// Leer la clase de Configuración y no el XML
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class); 
		
		SagaDune dune = context.getBean("sagaDune", SagaDune.class);
		
		System.out.println(dune.getTitulo());
		System.out.println(dune.getTomo());
		
		// Values de archivo externo
		System.out.println("Autor: " + dune.getAutor());
		System.out.println(dune.getLibros() + " libros");
		
		context.close();
		// No se por que en esta clase que uso el Bean de SagaDune me sale las funciones de init y destroy
		// si esas eran del LibroEnciclopedia.
		
		
		// Vale ya se pq. Pq aunq no use esos beans están siendo creados y eliminados
	}

}
