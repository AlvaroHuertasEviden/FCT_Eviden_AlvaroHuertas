package es.alvaro.annotations;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Anotación para registrar un bean con su Id
// Puedes no darle un id y coge el nombre de la clase como id
@Component
@Scope("singleton") // Para cambiar el scope de Singleton a Prototype
public class LibroEnciclopedia implements Libros, InitializingBean, DisposableBean {

	// Autowired por un campo de clase
	@Autowired
	@Qualifier("tomo4")
	private TomoLibro tomos; 
	
	// Autowired por constructor
	/*
	@Autowired
	public LibroEnciclopedia(TomoLibro tomos) {
		this.tomos = tomos;
	}
	*/
	
	// Autowired por setter
	/*
	@Autowired
	public void setTomos(TomoLibro tomos) {
		this.tomos = tomos;
	}
	*/
	
	// Esto no va a funcionar pq hay 4 clases que tienen de Interface el TomoLibro.
	// Para eso debemos usar el @Qualifier

	@Override
	public String getTitulo() {
		return "L’Encyclopédie ou Dictionnaire raisonné des sciences, des arts et des métiers";
	}

	@Override
	public int getPaginas() {

		return 4191;
	}

	@Override
	public String getPaginasString() {

		return String.valueOf(getPaginas()) + " páginas.";
	}
	
	public String getTomo1() {
		return tomos.getTomo();
	}

	// ==============	
	// BEAN LIFECYCLE
	// ==============
	// No es manejado adecuadamente si trabajamos con prototype
	/*
	// Crear método INIT: Ejecutar tareas después de que el bean esté disponible
	@PostConstruct
	public void metodoInit() {
		System.out.println("Conectando con la base de datos Firestore.");
		System.out.println("Conexión Establecida!");
	}
	
	// Crear método DESTROY: Ejecutar tareas antes de que el bean haya sido utilizado
	@PreConstruct
	public void metodoDestroy() {
		System.out.println("Cerrando conexión con la base de datos externa.");
		System.out.println("Conexión cerrada!");
	}
	*/
	
	// Crear método INIT: Ejecutar tareas después de que el bean esté disponible
	@Override
	public void destroy() throws Exception {
		System.out.println("Conectando con la base de datos Firestore.");
		System.out.println("Conexión Establecida!");
	}
	
	// Crear método DESTROY: Ejecutar tareas antes de que el bean haya sido utilizado
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Conectando con la base de datos Firestore.");
		System.out.println("Conexión Establecida!");	
	}
}
