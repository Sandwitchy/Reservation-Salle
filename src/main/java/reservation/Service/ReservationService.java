package reservation.Service;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservation.Dao.ReservationDao;
import reservation.Model.Participant;
import reservation.Model.Reservation;


@Service
public class ReservationService {

	@Autowired
	private ReservationDao reservationDao;
	
	@Transactional()
	public Reservation reserver(ReservationsDto reservationDto) {
		
		Reservation reservation = new Reservation(reservationDto.getDateDebut(),
				reservationDto.getDuree(),
				reservationDto.getNom(),
				reservationDto.getDescription());
		
		/*Salle salle = new Salle(reservationDto.getSalle());
		reservation.setSalle(salle);
		*/
		List<Participant> participantsList = new ArrayList<Participant>();
		for(String participantMail : reservationDto.getParticipants()) {
			Participant participant = new Participant(participantMail);
			participantsList.add(participant);
		}
		reservation.setParticipants(participantsList);
		reservationDao.save(reservation);
		return reservation;
	}
	
	@Transactional()
	public List<Reservation> getAll() {
		return reservationDao.getAll();
	}
	
}
