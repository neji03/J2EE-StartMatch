package mvcModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entites.Admin;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class AdminService
 */
@Stateless
@LocalBean
public class AdminService {
	@PersistenceContext(unitName="startmatch")
	private EntityManager em;
	private ProfilService profilService;
    /**
     * Default constructor. 
     */
    public AdminService() {
        // TODO Auto-generated constructor stub
    }
    public Admin getAdminByLoginAndPwd(String email,String pwd){
    	List<Admin> admin=null;
    	  TypedQuery<Admin> query = em.createNamedQuery("Admin.findByLoginAndPwd",Admin.class);
    	  query.setParameter(1, email);
    	  query.setParameter(2, pwd);
    	  admin=query.getResultList();
    	  if(admin.size()!=0) {
    	  return admin.get(0);
    	  }
    	  return null;
    	  
    	 
		    
    }
	public Admin getAllAdmin() {
		Admin admin=null;
  	  TypedQuery<Admin> query = em.createNamedQuery("Admin.findAll",Admin.class);
  	  admin=query.getSingleResult();
		return admin;
	}
}
