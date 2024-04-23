package es.alvaro.IoC.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.alvaro.IoC.Libro;
import es.alvaro.IoC.LibroCienciaFiccion;
import es.alvaro.IoC.LibroPoliciaco;

public class UsoLibros {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Inyección de dependencias con un constructor
		System.out.println("Inyección de dependencias por constructor:");
		Libro libroAventura = context.getBean("libroAventura", Libro.class);
		
		System.out.println(libroAventura.getTitulo());
		
		// Utilizar la inyección de dependencia
		System.out.println(libroAventura.getPaginasString());
		
		
		// Inyección de dependencias con un setter
		System.out.println("\n" + "\n" + "Inyección de dependencias por setter:");
		LibroCienciaFiccion libroCiencia = context.getBean("libroCienciaFiccion", LibroCienciaFiccion.class);
		
		System.out.println(libroCiencia.getTitulo());
		
		// Utilizar la inyección de dependencia
		System.out.println(libroCiencia.getPaginasString());
		
		// Utilizar la inyección de campos
		System.out.println("Autor: " + libroCiencia.getAutor());
		System.out.println("Editorial: " + libroCiencia.getEditorial());
		
		
		// Injección de campos de un archivo externo
		System.out.println("\n" + "\n" + "Inyección de dependencias por setter y campos por un archivo externo:");
		LibroPoliciaco libroPoliciaco = context.getBean("libroPoliciaco", LibroPoliciaco.class);
		
		// Utilizar la inyección de dependencia
		System.out.println(libroPoliciaco.getPaginasString());
				
		// Utilizar la inyección de campos de archivo externo
		System.out.println("Autor: " + libroPoliciaco.getAutor());
		System.out.println("Editorial: " + libroPoliciaco.getEditorial());
		
		
		context.close();
		
	}

}
