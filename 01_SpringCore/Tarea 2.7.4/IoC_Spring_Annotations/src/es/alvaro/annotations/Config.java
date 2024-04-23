package es.alvaro.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


// Archivo de configuración java para no necesitar configruar Spring desde un XML
@Configuration
@ComponentScan("es.alvaro.annotations")
@PropertySource("classpath:datosLibro.propiedades") // Propiedades de un archivo externo
public class Config {
	// Definir el bean para TomoFinal
	@Bean
	public TomoLibro tomoFinal() {
		return new TomoFinal();
	}
	
	
	// Definir el bean para SagaDune e inyectar dependencias
	@Bean
	public Libros sagaDune() {
		return new SagaDune(tomoFinal());
	}
}
