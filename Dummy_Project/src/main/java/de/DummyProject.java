package de;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;


@Named
@ViewScoped
public class DummyProject implements Serializable {
    private String projectTitle;
    private String tagLabel;

    @PostConstruct
    public void init() {
        this.projectTitle = "Dummy Project";
        this.tagLabel = "Dummy Tag Label";
    }



    public String getProjectTitle() {
        return projectTitle;
    }

    public String getTagLabel() {
        return tagLabel;
    }

}
