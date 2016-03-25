package org.demo.users.web;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.demo.users.domain.User;
import org.demo.users.services.UserService;

@Named
@RequestScoped
public class UserAddController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private UserService userService;

    @Named
    @Produces
    @RequestScoped
    private User newUser = new User();

    public String create() {
    	userService.createUser(newUser);
    	return "success";
//        try {
//            userDao.createUser(newUser);
//            String message = "A new user with id " + newUser.getId() + " has been created successfully";
//            facesContext.addMessage(null, new FacesMessage(message));
//        } catch (Exception e) {
//            String message = "An error has occured while creating the user (see log for details)";
//            facesContext.addMessage(null, new FacesMessage(message));
//        }
    }
}
