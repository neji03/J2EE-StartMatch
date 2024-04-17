package mvcModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Profil;
import entities.User;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class userService
 */
@Stateless
@LocalBean
public class UserService {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="startmatch")
	private EntityManager em;
    public UserService() {
        // TODO Auto-generated constructor stub
    }
    public List<User> getAllSujects()
    {
    List<User> users = new ArrayList<User>();
    TypedQuery<User> query = em.createNamedQuery("User.findAll",User.class);
    users = query.getResultList();
    return users;
    }
    public List<User> getUserByID(int idUser)
    {
	List<User> users = new ArrayList<User>();
	TypedQuery<User> query = em.createNamedQuery("User.findByID",User.class);
	query.setParameter(1, idUser);
	users = query.getResultList();
	return users;
    }
    public List<User> getUserByProfil(Profil p)
    {
	List<User> users = new ArrayList<User>();
	TypedQuery<User> query = em.createNamedQuery("User.findByProfil",User.class);
	query.setParameter(1, p);
	users = query.getResultList();
	return users;
    }
    public void createUser(User user) {
		em.persist(user);
	}
    public List<User> deleteUserById(int idUser){
    	List<User> users=new ArrayList<User>();
    	User u=em.find(User.class, idUser);
    	if (u!=null) {
    		em.remove(u);
    	}
    	TypedQuery<User> query=em.createNamedQuery("User.findAll", User.class);
    	users=query.getResultList();
    	return users;
    }
    public User updateUser(User u) {
    	User user= new User();
    	TypedQuery<User> query = em.createNamedQuery("User.findByID",User.class);
    	query.setParameter(1, u.getIdUser());
    	user = (User) query.getResultList();
    	if (u.getAddress()!="") {
    		user.setAddress(u.getAddress());
    	}
    	if (u.getBio()!="") {
    		user.setBio(u.getBio());
    	}
    	if (u.getCpic()!=null) {
    		user.setCpic(u.getCpic());
    	}
    	if (u.getPpic()!=null) {
    		user.setPpic(u.getPpic());
    	}
    	if (u.getEmail()!="") {
    		user.setEmail(u.getEmail());
    	}
    	if(u.getPhone_Num()!=0)user.setPhone_Num(u.getPhone_Num());
    	if(u.getField()!="") user.setField(u.getField());
    	if(u.getIsPerson()!=1) {
    		if(u.getPDateOfBirth()!=null) user.setPDateOfBirth(u.getPDateOfBirth());
        	if(u.getPExpertise()!="") user.setPExpertise(u.getPExpertise());
        	if(u.getPFirst_name()!="")user.setPFirst_name(u.getPFirst_name());
        	if(u.getPLast_name()!="")user.setPLast_name(u.getPLast_name());
        	if(u.getPGender()!="")user.setPGender(u.getPGender());
        	if(u.getPJobPosition()!="")user.setPJobPosition(u.getPJobPosition());
    	}else {
    		if(u.getSDateOfCreation()!=null)user.setSDateOfCreation(u.getSDateOfCreation());
    		if(u.getSName()!="")user.setSName(u.getSName());
    	}
    	return user;
    }
    
    
}
