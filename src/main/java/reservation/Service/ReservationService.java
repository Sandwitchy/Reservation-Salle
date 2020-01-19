package reservation.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import reservation.Dao.ReservationDao;
import reservation.Dao.SalleDao;
import reservation.Model.Participant;
import reservation.Model.Reservation;
import reservation.Model.Salle;
import reservation.utils.MailSender;


@Service
public class ReservationService {

	@Autowired
	private ReservationDao reservationDao;
	@Autowired
	private SalleDao salleDao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Reservation reserver(ReservationsDto reservationDto) {
		
		Reservation reservation = new Reservation(
				reservationDto.getDateDebut(),
				reservationDto.getDuree(),
				reservationDto.getNom(),
				reservationDto.getDescription()
		);

		Salle salle = getSalleByNum(reservationDto.getSalle());
		reservation.setSalle(salle);

		List<Participant> participantsList = new ArrayList<Participant>();
		for(String participantMail : reservationDto.getParticipants()) {
			if(!participantMail.isEmpty()){
				Participant participant = new Participant(participantMail);
				MailSender mail = new MailSender(participantMail,reservationDto.getNom(),reservationDto.getDescription(),reservationDto.getSalle(),reservationDto.getDateDebut());
				mail.envoyer();
				participantsList.add(participant);
			}
		}
		reservation.setParticipants(participantsList);
		reservationDao.save(reservation);
		return reservation;
	}
	
	@Transactional(readOnly = true)
	public List<Reservation> getAll() {
		return reservationDao.getAll();
	}
	@Transactional(readOnly = true)
	public List<Salle> getAllSalle() {
		return salleDao.getAllSalle();
	}

	@Transactional(readOnly = true)
	public Salle getSalleByNum(String numeroSalle) {
		return salleDao.getSalleByNum(numeroSalle);
	}
}