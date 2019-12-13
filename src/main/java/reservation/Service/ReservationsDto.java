package reservation.Service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReservationsDto {

	@NotNull(message = "Vous devez renseigner une date de debut !")
	private String dateDebut;

	@NotNull(message = "Vous devez renseigner la duree !")
	private int duree;
	
	private String nom;
	private String description;
	private String salle;
	private List<String> participants = new ArrayList<>();
	
	public List<String> getParticipants() {
		return participants;
	}
	public void setParticipants(List<String> participants) {
		this.participants = participants;
	}
	public String getSalle() {
		return salle;
	}
	public void setSalle(String salle) {
		this.salle = salle;
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
	

}
