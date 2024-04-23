package es.alvaro.IoC.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.alvaro.IoC.LibroCienciaFiccion;
import es.alvaro.IoC.LibroPoliciaco;

public class UsoSingletonPrototype {

	public static void main(String[] args) {
		
		// Carga de XML de configuración
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		// petición de beans al contenedor Spring
		LibroCienciaFiccion libroCiencia = context.getBean("libroCienciaFiccion", LibroCienciaFiccion.class);
		
		LibroCienciaFiccion libroCiencia2 = context.getBean("libroCienciaFiccion", LibroCienciaFiccion.class);

		/* Los dos objetos apuntan a la misma dirección de la memoria,
		 * con lo cual apuntan al mismo objeto.
		 * por eso (libroCiencia == libroCiencia2) => true
		 * SINGLETON
		 */
		System.out.println(libroCiencia);
		System.out.println(libroCiencia2);
		System.out.println((libroCiencia == libroCiencia2) ? "Apuntan al mismo objeto" : "No apuntan al mismo objeto");
		
		System.out.println("\n");
		
		
		// petición de beans al contenedor Spring
		LibroPoliciaco libroPoliciaco = context.getBean("libroPoliciaco", LibroPoliciaco.class);
		
		LibroPoliciaco libroPoliciaco2 = context.getBean("libroPoliciaco", LibroPoliciaco.class);

		/* Los dos objetos no apuntan a la misma dirección de la memoria,
		 * con lo cual apuntan a diferentes objetos.
		 * por eso (libroCiencia == libroCiencia2) => false
		 * PROTOTYPE
		 * Con prototype se sigue ahorrando memoria comparado con crear los objetos de la clase
		 * ya que copia los objetos de existentes para crear los nuevos.
		 */
		System.out.println(libroPoliciaco);
		System.out.println(libroPoliciaco2);
		System.out.println((libroPoliciaco == libroPoliciaco2) ? "Apuntan al mismo objeto" : "No apuntan al mismo objeto");		
		
		
		context.close();

	}

}
