package Com.Beans;



import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;






@Entity
@Table(name="QUESTIONS")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_Question")
	private int idQuestion ; 
	
	
	@Column(name = "description_Question")
	private String descriptionQuestions;
	
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name = "identifiant")
	private User user;
	
	@OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Reponce> reponces = new ArrayList<Reponce>();
	

	public Question() {
		
	}
	
	public Question(String descriptionQuestions,User user) {
		super();
		this.descriptionQuestions = descriptionQuestions;
		this.user = user;	
	}

	public int getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	public String getDescriptionQuestions() {
		return descriptionQuestions;
	}
	public void setDescriptionQuestions(String descriptionQuestions) {
		this.descriptionQuestions = descriptionQuestions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Reponce> getReponces() {
		return reponces;
	}
	public void setReponces(ArrayList<Reponce> reponces) {
		this.reponces = reponces;
	}
	
	
	@Override
	public String toString() {
		return "Question [idQuestion=" + idQuestion + ", descriptionQuestions=" + descriptionQuestions + ", user="
				+ user + "]";
	}

	

	
	
	
	

	
	
	
	
	
	
	
	
	

}
