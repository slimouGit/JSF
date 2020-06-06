package de;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;


@Named
@ViewScoped
public class CalenderDialog implements Serializable {

    private Date validity;
    private String text;

    public void abmelden() {
        Date validity = this.validity;
        System.out.println("Validity: " + validity);
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
