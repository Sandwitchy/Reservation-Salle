package reservation.Dao;

import org.springframework.stereotype.Repository;
import reservation.Model.Salle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SalleDao {

    @PersistenceContext
    private EntityManager em;

    public List<Salle> getAllSalle() {
        return em.createQuery("select s from Salle s", Salle.class)
                .getResultList();
    }

    public Salle getSalleByNum(String numeroSalle) {

        return em.createQuery("select s from Salle s where s.numeroSalle = :num", Salle.class)
                .setParameter("num", numeroSalle)
                .getSingleResult();
    }
}