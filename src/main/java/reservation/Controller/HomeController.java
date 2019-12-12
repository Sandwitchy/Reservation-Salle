package reservation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
	public RedirectView denied(ModelMap model) {
		model.addAttribute("error", "Les informartions entrées sont soit fausse soit incorrect. Veuillez recommencez.");
		return new RedirectView("login");
	}
	@GetMapping("/admin")
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;

	}
	@GetMapping("/logout")
    public String logout(ModelMap model) {
        return "accueil";
    }
	//Spring Security see this :
	@GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
}
