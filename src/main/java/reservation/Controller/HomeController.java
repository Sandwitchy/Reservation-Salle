package reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@GetMapping({"/","/welcome"})
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		model.setViewName("accueil");
		return model;
	}
	@GetMapping("/accessdenied")
	public String denied(ModelMap model) {
		model.addAttribute("error", "Les informartions entrées sont soit fausse soit incorrect. Veuillez recommencez.");
        return "login";
	}
	@GetMapping("/admin")
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;

	}

	//Spring Security see this :
	@GetMapping("/login")
	public String login(ModelMap model) {
		return "login";

	}
}
