import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * User: salim
 * Date: 25.05.2019 07:30
 */
@Named
@ViewScoped
public class MyClass implements Serializable {
    private final Logger LOG = LoggerFactory.getLogger(MyClass.class);

    private String person = "Dr. Jekyll";
    private String text;

    @PostConstruct
    public void init() {
        LOG.info("Class loaded");
    }


    public void changePerson(){
        LOG.info("Person was {}", this.person);
        if(person.equalsIgnoreCase("Dr. Jekyll")){
            person ="Mr. Hyde";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", "Person is "+ this.person));
        }else{
            person ="Dr. Jekyll";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Warning!", "Person is "+ this.person));
        }
        LOG.info("Person is {}", this.person);
    }

    public void btnSubmit(){
        LOG.info("Value is {}", this.text);

    }



    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
