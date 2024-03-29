package dambi.unai.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PruebaApplication {
	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		return "Gure lehen rest apia martxan dago";
	}

	@GetMapping("/kaixo")
	public String kaixo(@RequestParam(value = "izena", defaultValue = "mundua") String izena) {
		return String.format("Kaixo, %s!", izena);
	}

	@GetMapping("/zenbatu")
	public String zenbatu(@RequestParam(value = "norarte", defaultValue = "5") String norarte) {

		String strEmaitza = "";
		for (int i = 1; i <= Integer.parseInt(norarte); i++) {
			strEmaitza += (i + "\n");
		}
		return strEmaitza;
	}
}
