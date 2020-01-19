package reservation.Dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import reservation.Model.Reservation;;

@Repository
public class ReservationDao {

	@PersistenceContext
	private EntityManager em;

	public void save(Reservation reservation) {
		em.persist(reservation);
	}

	public List<Reservation> getAll() {
		return em.createQuery("select r from Reservation r order by r.dateDebut desc", Reservation.class)
				.getResultList();
	}
}