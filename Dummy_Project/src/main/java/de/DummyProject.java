package de;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Named
@ViewScoped
public class DummyProject implements Serializable {
    private String projectTitle;
    private String tagLabel;
    private Date validity;

    @PostConstruct
    public void init() {
        this.projectTitle = "Dummy Project";
        this.tagLabel = "Dummy Tag Label";
        if (null != this.validity) {
            System.out.println("Init validity is " + this.validity);
        }
    }

    public void readValidity() {
        LocalDate validity = new Validity().convertDate(this.validity);
        System.out.println("LocalDate: " + validity);
        System.out.println("Date: " + this.validity);
        init();
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public String getTagLabel() {
        return tagLabel;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }
}
