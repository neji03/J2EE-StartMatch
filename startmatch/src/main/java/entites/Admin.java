package entites;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the admin database table.
 * 
 */
@Entity

@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")

public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAdmin;

	private String name;

	private int profil_idProfil;

	public Admin() {
	}

	public int getIdAdmin() {
		return this.idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProfil_idProfil() {
		return this.profil_idProfil;
	}

	public void setProfil_idProfil(int profil_idProfil) {
		this.profil_idProfil = profil_idProfil;
	}

}