package Com.Beans;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Rdv")
public class Rdv {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_Rdv")
	private int idRdv;
	
	@Column(name = "motif_Rdv")
	private String motifRdv;
	
	@Column(name = "date_Rdv")
	private String dateRdv;
	
	@Column(name ="acceptation_Rdv", nullable = false, columnDefinition = "boolean default false")
	private boolean isAccepted = false;
	
	
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name = "identifiant_User")
	private User user;
	
	
	public Rdv() {
		
	}


	public Rdv(String motifRdv, String dateRdv, boolean isAccepted, User user) {
		super();
		this.motifRdv = motifRdv;
		this.dateRdv = dateRdv;
		this.isAccepted = isAccepted;
		this.user = user;
	}


	public int getIdRdv() {
		return idRdv;
	}


	public void setIdRdv(int idRdv) {
		this.idRdv = idRdv;
	}


	public String getMotifRdv() {
		return motifRdv;
	}


	public void setMotifRdv(String motifRdv) {
		this.motifRdv = motifRdv;
	}


	public String getDateRdv() {
		return dateRdv;
	}


	public void setDateRdv(String dateRdv) {
		this.dateRdv = dateRdv;
	}


	public boolean isAccepted() {
		return isAccepted;
	}


	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Rdv [idRdv=" + idRdv + ", motifRdv=" + motifRdv + ", dateRdv=" + dateRdv + ", isAccepted=" + isAccepted
				+ ", user=" + user + "]";
	}


	
	
	
	
	
	
	
	
}
