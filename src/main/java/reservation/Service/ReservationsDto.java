package reservation.Service;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ReservationsDto {

	@NotEmpty(message = "Vous devez renseigner une date de debut.")
	private String dateDebut;

	@NotNull(message = "Vous devez renseigner la duree.")
	private int duree;

	@NotEmpty(message = "Veuillez renseigner un nom.")
	private String nom;

	private String salle;

	@NotEmpty(message = "Veuillez renseigner une description.")
	private String description;


	@NotEmpty(message = "Veuillez renseigner au moin un participants.")
	private List<String> participants;
	
	public List<String> getParticipants() {
		return participants;
	}
	public void setParticipants(List<String> participants) {
		this.participants = participants;
	}

	public String getDateDebut() {
		return dateDebut;
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

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getSalle() {
		return salle;
	}

	public void setSalle(String salle) {
		this.salle = salle;
	}
}