package entites;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the newsfeed database table.
 * 
 */
@Entity
@NamedQuery(name="Newsfeed.findAll", query="SELECT n FROM Newsfeed n")
public class Newsfeed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idNewsFeed;

	private String lastFilter;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="newsfeed", fetch=FetchType.EAGER)
	private List<Utilisateur> utilisateurs;

	public Newsfeed() {
	}

	public int getIdNewsFeed() {
		return this.idNewsFeed;
	}

	public void setIdNewsFeed(int idNewsFeed) {
		this.idNewsFeed = idNewsFeed;
	}

	public String getLastFilter() {
		return this.lastFilter;
	}

	public void setLastFilter(String lastFilter) {
		this.lastFilter = lastFilter;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setNewsfeed(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setNewsfeed(null);

		return utilisateur;
	}

}