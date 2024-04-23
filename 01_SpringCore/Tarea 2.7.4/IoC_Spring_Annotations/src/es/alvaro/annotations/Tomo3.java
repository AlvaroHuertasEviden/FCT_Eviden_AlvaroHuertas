package es.alvaro.annotations;

import org.springframework.stereotype.Component;

@Component
public class Tomo3 implements TomoLibro {

	@Override
	public String getTomo() {
		return "Tomo III: C-Cirrhose";
	}

}
