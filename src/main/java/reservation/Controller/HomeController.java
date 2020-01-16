package reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {
	
	@GetMapping({"/", "/accueil"})
	public String accueil() {
		return "accueil";
	}
	
	@GetMapping("/admin")
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;

	}

	@GetMapping("/accessdenied")
	public RedirectView denied(ModelMap model) {
		model.addAttribute("error", "Les informations entrées sont soit fausse soit incorrect. Veuillez recommencez.");
		return new RedirectView("login");
	}
	@GetMapping("/logout")
    public RedirectView logout(ModelMap model) {
		model.addAttribute("logout", "Vous avez bien été déconnecté");
		return new RedirectView("login");
    }
	//Spring Security see this :
	@GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", error);

        if (logout != null)
            model.addAttribute("msg", logout);

        return "login";
    }
}
