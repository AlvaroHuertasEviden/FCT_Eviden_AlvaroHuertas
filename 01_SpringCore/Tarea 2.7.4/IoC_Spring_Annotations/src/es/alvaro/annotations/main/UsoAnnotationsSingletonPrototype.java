package es.alvaro.annotations.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.alvaro.annotations.LibroEnciclopedia;

public class UsoAnnotationsSingletonPrototype {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		LibroEnciclopedia libroEnciclopedia = context.getBean("libroEnciclopedia", LibroEnciclopedia.class);
		LibroEnciclopedia libroEnciclopedia2 = context.getBean("libroEnciclopedia", LibroEnciclopedia.class);
		
		System.out.println(libroEnciclopedia);
		
		System.out.println(libroEnciclopedia2);
		
		// Apuntan al mismo objeto en memoria
		
		System.out.println((libroEnciclopedia == libroEnciclopedia2)
				? "Apuntan al mismo objeto en memoria." 		// Usa Singleton
				: "No apuntan al mismo objeto en memoria.");	// Usa Prototype
		
		
		context.close();

	}

}
