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
@Table(name="REPONSES")
public class Reponce {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_Reponse")
	private int idReponce ;
	
	@Column(name = "description_Reponse")
	private String DescriptionReponse;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name = "identifiant")
	private User user;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name = "identifiant_Question")
	private Question question;
	
	
	

	public Reponce() {
		super();
	}

	public Reponce(String descriptionReponse, Question question,User user) {
		super();
		DescriptionReponse = descriptionReponse;
		this.question = question;
		this.user = user;
	}

	public int getIdReponce() {
		return idReponce;
	}

	public void setIdReponce(int idReponce) {
		this.idReponce = idReponce;
	}

	public String getDescriptionReponse() {
		return DescriptionReponse;
	}

	public void setDescriptionReponse(String descriptionReponse) {
		DescriptionReponse = descriptionReponse;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Reponce [idReponce=" + idReponce + ", DescriptionReponse=" + DescriptionReponse + ", question="
				+ question + "]";
	}
	
}
