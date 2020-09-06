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
    private String inputValue;

    @PostConstruct
    public void init() {
        this.projectTitle = "Dummy Project";
        this.tagLabel = "Dummy Tag Label";
    }

    public void zeigeProjekttitel(){
        System.out.println("Projekttitel" + this.inputValue);
    }

    public String redirect(){
        return "/content/charts/charts.xhtml?faces-redirect=true";
    }



    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getTagLabel() {
        return tagLabel;
    }

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }
}
