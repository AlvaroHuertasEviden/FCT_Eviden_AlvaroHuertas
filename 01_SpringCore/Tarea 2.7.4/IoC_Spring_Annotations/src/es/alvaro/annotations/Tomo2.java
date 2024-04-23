package es.alvaro.annotations;

import org.springframework.stereotype.Component;

@Component
public class Tomo2 implements TomoLibro {

	@Override
	public String getTomo() {
		return"Tomo II: B-Béquille";
	}

}
