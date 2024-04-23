package es.alvaro.annotations;

import org.springframework.stereotype.Component;

@Component
public class Tomo4 implements TomoLibro {

	@Override
	public String getTomo() {
		return "Tomo IV: D-Déterminisme";
	}

}
