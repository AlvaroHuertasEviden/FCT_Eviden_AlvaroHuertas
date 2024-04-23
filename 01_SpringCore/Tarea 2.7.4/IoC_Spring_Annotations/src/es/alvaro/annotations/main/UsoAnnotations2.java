package es.alvaro.annotations.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.alvaro.annotations.Config;
import es.alvaro.annotations.LibroEnciclopedia;

public class UsoAnnotations2 {

	public static void main(String[] args) {
		// Leer la clase de Configuración y no el XML
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class); 
		
		LibroEnciclopedia libroEnciclopedia = context.getBean("libroEnciclopedia", LibroEnciclopedia.class);
		
		System.out.println(libroEnciclopedia.getTitulo());
		System.out.println(libroEnciclopedia.getTomo1());
		
		context.close();

	}

}
