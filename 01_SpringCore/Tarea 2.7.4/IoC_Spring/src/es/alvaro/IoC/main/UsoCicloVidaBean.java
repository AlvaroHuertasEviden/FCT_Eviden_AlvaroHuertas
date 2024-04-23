package es.alvaro.IoC.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.alvaro.IoC.LibroPoliciaco;

public class UsoCicloVidaBean {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
		
		LibroPoliciaco libroPoliciaco = context.getBean("libroPoliciaco", LibroPoliciaco.class);
		
		System.out.println(libroPoliciaco.getTitulo());
		
		context.close();
	}

}
