package mvcModel;

import java.util.ArrayList;
import java.util.List;

import entites.Account;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class AccountService
 */
@Stateless
@LocalBean
public class AccountService {
	@PersistenceContext(unitName="startmatch")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public AccountService() {
        // TODO Auto-generated constructor stub
    }
    public void createAccount(Account a) {
		em.persist(a);
		
	}

	public List<Account> getAllAccounts() {
		{
		    List<Account> accounts = new ArrayList<Account>();
		    TypedQuery<Account> query = em.createNamedQuery("Account.findAll",Account.class);
		    accounts = query.getResultList();
		    return accounts;
		    }

	}
}
