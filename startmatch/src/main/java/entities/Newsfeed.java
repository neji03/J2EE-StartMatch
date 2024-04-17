package entities;

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

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="newsfeed", fetch=FetchType.EAGER)
	private List<User> users;

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

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setNewsfeed(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setNewsfeed(null);

		return user;
	}

}