package entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the post database table.
 * 
 */
@Entity
@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPost;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfCreation;

	private String field;

	@Lob
	private byte[] mediaContent;

	private int reactNb;

	private int reportNb;

	private int savesNb;

	private String tags;

	private String textContent;

	private int user_idUser;

	public Post() {
	}

	public int getIdPost() {
		return this.idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public Date getDateOfCreation() {
		return this.dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public byte[] getMediaContent() {
		return this.mediaContent;
	}

	public void setMediaContent(byte[] mediaContent) {
		this.mediaContent = mediaContent;
	}

	public int getReactNb() {
		return this.reactNb;
	}

	public void setReactNb(int reactNb) {
		this.reactNb = reactNb;
	}

	public int getReportNb() {
		return this.reportNb;
	}

	public void setReportNb(int reportNb) {
		this.reportNb = reportNb;
	}

	public int getSavesNb() {
		return this.savesNb;
	}

	public void setSavesNb(int savesNb) {
		this.savesNb = savesNb;
	}

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTextContent() {
		return this.textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	public int getUser_idUser() {
		return this.user_idUser;
	}

	public void setUser_idUser(int user_idUser) {
		this.user_idUser = user_idUser;
	}

}