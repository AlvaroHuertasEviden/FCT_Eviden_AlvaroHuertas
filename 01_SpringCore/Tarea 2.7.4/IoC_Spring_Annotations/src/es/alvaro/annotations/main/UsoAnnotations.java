package es.alvaro.annotations.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.alvaro.annotations.LibroEnciclopedia;

public class UsoAnnotations {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		LibroEnciclopedia libroEnciclopedia = context.getBean("libroEnciclopedia", LibroEnciclopedia.class);
		
		System.out.println(libroEnciclopedia.getTitulo());
		System.out.println(libroEnciclopedia.getTomo1());
		
		context.close();

	}

}
