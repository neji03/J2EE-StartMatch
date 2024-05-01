package entites;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the profil database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Profil.findAll", query="SELECT p FROM Profil p"),
@NamedQuery(name="Profil.findByLogin", query="SELECT p FROM Profil p where login=?1"),
@NamedQuery(name="Profil.findById", query="SELECT p FROM Profil p where idProfil=?1")
})
public class Profil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProfil;

	private String login;

	private String password;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="profil", fetch=FetchType.EAGER)
	private List<Utilisateur> utilisateurs;

	public Profil() {
	}

	public int getIdProfil() {
		return this.idProfil;
	}

	public void setIdProfil(int idProfil) {
		this.idProfil = idProfil;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setProfil(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setProfil(null);

		return utilisateur;
	}

}