package es.panel;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;

 
@Named
@ViewScoped
public class UserWizard implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user = new User();
     
    private boolean skip;
     
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
     
    public void save() {        
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getFirstname());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
     
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
    
    public void validateStep1(FacesContext context, UIComponent component, Object value) throws ValidatorException  {
    	boolean condition = false;
        if (condition) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Validtion message", "Validation summary"));
        }
    }
}