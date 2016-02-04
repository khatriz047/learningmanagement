package mum.cs544.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 1024)
	private String questionbody;
	private String questiontype;
	private Date postDate;

	@ManyToOne
	private User user;

	@ManyToOne
	private Course course;

	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Answer> answers = new ArrayList<>();

	public Question() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getQuestionbody() {
		return questionbody;
	}

	public void setQuestionbody(String questionbody) {
		this.questionbody = questionbody;
	}

	public String getQuestiontype() {
		return questiontype;
	}

	public void setQuestiontype(String questiontype) {
		this.questiontype = questiontype;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public void addAnswer(Answer answer) {
		this.answers.add(answer);
	}

}