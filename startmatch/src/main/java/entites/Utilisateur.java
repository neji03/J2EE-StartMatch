package entites;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u"),
	@NamedQuery(name="Utilisateur.findBynbReports", query="SELECT u FROM Utilisateur u where account.reportsNb>0"),
	@NamedQuery(name="Utilisateur.findByID", query="SELECT u FROM Utilisateur u where idUser =?1"),
	@NamedQuery(name="Utilisateur.findByProfil", query="SELECT u FROM Utilisateur u where profil =?1"),
	@NamedQuery(name="Utilisateur.findByLoginAndPwd", query="SELECT u FROM Utilisateur u where profil.login =?1 AND profil.password=?2")
})
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;

	private String address;

	private String bio;

	@Lob
	private byte[] cpic;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String email;

	private String field;

	private byte isPerson;

	@Temporal(TemporalType.DATE)
	private Date PDateOfBirth;

	private String PExpertise;

	private String PFirst_name;

	private String PGender;

	private int phone_Num;

	private String PJobPostition;

	private String PLast_name;

	@Lob
	private byte[] ppic;

	@Temporal(TemporalType.DATE)
	private Date SDateOfCreation;

	private String SName;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="utilisateur", fetch=FetchType.EAGER)
	private List<Post> posts;

	//bi-directional many-to-one association to Account
	@ManyToOne
	private Account account;

	//bi-directional many-to-one association to Newsfeed
	@ManyToOne
	private Newsfeed newsfeed;

	//bi-directional many-to-one association to Profil
	@ManyToOne
	private Profil profil;

	public Utilisateur() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBio() {
		return this.bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public byte[] getCpic() {
		return this.cpic;
	}

	public void setCpic(byte[] cpic) {
		this.cpic = cpic;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public byte getIsPerson() {
		return this.isPerson;
	}

	public void setIsPerson(byte isPerson) {
		this.isPerson = isPerson;
	}

	public Date getPDateOfBirth() {
		return this.PDateOfBirth;
	}

	public void setPDateOfBirth(Date PDateOfBirth) {
		this.PDateOfBirth = PDateOfBirth;
	}

	public String getPExpertise() {
		return this.PExpertise;
	}

	public void setPExpertise(String PExpertise) {
		this.PExpertise = PExpertise;
	}

	public String getPFirst_name() {
		return this.PFirst_name;
	}

	public void setPFirst_name(String PFirst_name) {
		this.PFirst_name = PFirst_name;
	}

	public String getPGender() {
		return this.PGender;
	}

	public void setPGender(String PGender) {
		this.PGender = PGender;
	}

	public int getPhone_Num() {
		return this.phone_Num;
	}

	public void setPhone_Num(int phone_Num) {
		this.phone_Num = phone_Num;
	}

	public String getPJobPostition() {
		return this.PJobPostition;
	}

	public void setPJobPostition(String PJobPostition) {
		this.PJobPostition = PJobPostition;
	}

	public String getPLast_name() {
		return this.PLast_name;
	}

	public void setPLast_name(String PLast_name) {
		this.PLast_name = PLast_name;
	}

	public byte[] getPpic() {
		return this.ppic;
	}

	public void setPpic(byte[] ppic) {
		this.ppic = ppic;
	}

	public Date getSDateOfCreation() {
		return this.SDateOfCreation;
	}

	public void setSDateOfCreation(Date SDateOfCreation) {
		this.SDateOfCreation = SDateOfCreation;
	}

	public String getSName() {
		return this.SName;
	}

	public void setSName(String SName) {
		this.SName = SName;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setUtilisateur(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setUtilisateur(null);

		return post;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Newsfeed getNewsfeed() {
		return this.newsfeed;
	}

	public void setNewsfeed(Newsfeed newsfeed) {
		this.newsfeed = newsfeed;
	}

	public Profil getProfil() {
		return this.profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

}