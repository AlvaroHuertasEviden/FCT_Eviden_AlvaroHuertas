package es.alvaro.annotations;

import org.springframework.stereotype.Component;

@Component
public class Tomo1 implements TomoLibro {

	@Override
	public String getTomo() {
		return "Tomo I: A-Azyme";
	}

}
