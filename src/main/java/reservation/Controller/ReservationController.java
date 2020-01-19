package reservation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import reservation.Model.Reservation;
import reservation.Model.Salle;
import reservation.Service.ReservationService;
import reservation.Service.ReservationsDto;
import reservation.utils.MailSender;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@GetMapping("/reservation/{numeroSalle}")
	public String reservation(ReservationsDto reservationsDto,@PathVariable String numeroSalle,Model model) {
		try{
			reservationService.getSalleByNum(numeroSalle);
		}
		catch(Exception e){
			return "accueil";
		}
		model.addAttribute("salle",numeroSalle);
		return "reservation";
	}
	@PostMapping("/reservation/{numeroSalle}")
	public String reservation(@Validated ReservationsDto reservationsDto, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			model.addAttribute("salle",reservationsDto.getSalle());
			return "reservation";
		}
		try{
			Reservation reservation = reservationService.reserver(reservationsDto);
			return "accueil";
		}
		catch(Exception e){
			return "reservation";
		}
	}
}