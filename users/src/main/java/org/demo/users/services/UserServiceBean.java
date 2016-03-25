package org.demo.users.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.demo.users.domain.User;

@Named("userService")
@Stateful
public class UserServiceBean implements UserService {

	@Inject
	private Logger logger;
	
    @Inject
    private FacesContext facesContext;

    @Named
    @Produces
    @RequestScoped
    private User newUser = new User();
    
    @Inject
    private EntityManager entityManager;

    public User getForUsername(String username) {
    	logger.info("call getForUsername(" + username +")");
        try {
            Query query = entityManager.createQuery("select u from User u where u.username = ?");
            query.setParameter(1, username);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void createUser(User user) {
    	logger.info("createUser =" + user.getUsername());
        entityManager.persist(user);
    }
    
//    public String createUser(User user) {
//    	logger.info("createUser =" + user.getUsername());
//    	String result = "failure"; 
//    	try {
//	    	String message = "A new user with id " + newUser.getId() + " has been created successfully";
//	        facesContext.addMessage(null, new FacesMessage(message));
//	        entityManager.persist(user);
//	        result = "success";
//    	} catch (Exception e) {
//            String message = "An error has occured while creating the user (see log for details)";
//            facesContext.addMessage(null, new FacesMessage(message));
//        }
//    	return result;
//    }

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		logger.info("call getAllUsers(）");
		List<User> users = new ArrayList<User>();

		try {
			Query q = entityManager.createQuery("select u from User as ur order by u.username");
			users = (List<User>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

}
