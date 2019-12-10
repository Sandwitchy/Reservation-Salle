package reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping({"/", "/accueil"})
	public String accueil() {
		return "accueil";
	}
}
