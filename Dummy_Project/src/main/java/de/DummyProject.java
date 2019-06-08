package de;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;


@Named
@ViewScoped
public class DummyProject implements Serializable {
    private String projectTitle;

    @PostConstruct
    public void init() {
        this.projectTitle = "Dummy Project";
    }

    public String getProjectTitle() {
        return projectTitle;
    }
}
