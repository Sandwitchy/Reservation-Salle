package reservation.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dateDebut;
	private int duree;
	private String nom;
	private String description;

	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_salle")
	private Salle salle;

	@OneToMany(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_reservation")
	private List<Participant> participants = new ArrayList<>();

	public Reservation() {
	}
	public Reservation(String dateDebut,int duree,String nom,String description) {
		this.dateDebut = dateDebut;
		this.duree = duree;
		this.nom = nom;
		this.description = description;
	}
	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public String getDateDebut() {
		return dateDebut;
	}
	
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom ;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
}