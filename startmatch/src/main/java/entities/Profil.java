package entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the profil database table.
 * 
 */
@Entity
@NamedQuery(name="Profil.findAll", query="SELECT p FROM Profil p")
public class Profil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String login;

	private String password;

	//bi-directional many-to-one association to Admin
	@OneToMany(mappedBy="profil", fetch=FetchType.EAGER)
	private List<Admin> admins;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="profil", fetch=FetchType.EAGER)
	private List<User> users;

	public Profil() {
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

	public List<Admin> getAdmins() {
		return this.admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public Admin addAdmin(Admin admin) {
		getAdmins().add(admin);
		admin.setProfil(this);

		return admin;
	}

	public Admin removeAdmin(Admin admin) {
		getAdmins().remove(admin);
		admin.setProfil(null);

		return admin;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setProfil(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setProfil(null);

		return user;
	}

}