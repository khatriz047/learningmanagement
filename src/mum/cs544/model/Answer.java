package mum.cs544.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity(name = "answer")
public class Answer {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@ManyToOne
	private Question question;

	@ManyToOne
	private User user;

	public Answer(){

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
