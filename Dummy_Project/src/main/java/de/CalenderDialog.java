package de;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;


@Named
@ViewScoped
public class CalenderDialog implements Serializable {

    private Date abmeldeDatum;

    public void abmelden() {
        Date validity = this.abmeldeDatum;
        System.out.println("Validity: " + validity);
    }

    public Date getAbmeldeDatum() {
        return abmeldeDatum;
    }

    public void setAbmeldeDatum(Date abmeldeDatum) {
        this.abmeldeDatum = abmeldeDatum;
    }

}
