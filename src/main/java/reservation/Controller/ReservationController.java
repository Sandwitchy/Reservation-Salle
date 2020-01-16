package reservation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import reservation.Model.Reservation;
import reservation.Service.ReservationService;
import reservation.Service.ReservationsDto;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	
	@GetMapping("/reservation")
	public String reservation(ReservationsDto reservationsDto) {
		reservationsDto.setNom("matahi");
		return "reservation";
	}
	@PostMapping("/reservation")
	public String reservation(@Validated ReservationsDto reservationsDto, BindingResult bindingResult, Model model){
		Reservation reservation = reservationService.reserver(reservationsDto);
		model.addAttribute("reservation", reservation);
		return "reservation";
	}
	
}