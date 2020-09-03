package de.charts;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.PieChartModel;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class Charts implements Serializable {

    private String title;

    private PieChartModel npModel;
    private PieChartModel wpModel;
    private PieChartModel gwbModel;

    @PostConstruct
    public void init(){
        this.title = "Charts";
        createPieModels();
    }

    private void createPieModels() {
        createNpModel();
        createWpModel();
        createGwbModel();
    }

    private void createNpModel() {
        npModel = new PieChartModel();

        npModel.set("Freigegeben", 540);
        npModel.set("In Prüfung", 325);
        npModel.set("Storniert", 702);
        npModel.set("Zurückgewiesen", 0);
        npModel.set("Abgemeldet", 401);

        npModel.setTitle("NatürlichePersonen");
        npModel.setLegendPosition("w");
        npModel.setShadow(false);
    }

    private void createWpModel() {
        wpModel = new PieChartModel();

        wpModel.set("Freigegeben", 120);
        wpModel.set("In Prüfung", 80);
        wpModel.set("Storniert", 0);
        wpModel.set("Zurückgewiesen", 300);
        wpModel.set("Abgemeldet", 60);

        wpModel.setTitle("Wachpersonen");
        wpModel.setLegendPosition("w");
        wpModel.setShadow(false);
    }

    private void createGwbModel() {
        gwbModel = new PieChartModel();

        gwbModel.set("Freigegeben", 120);
        gwbModel.set("In Prüfung", 80);
        gwbModel.set("Abgemeldet", 20);

        gwbModel.setTitle("Gewerbebetriebe");
        gwbModel.setLegendPosition("w");
        gwbModel.setShadow(false);
    }

    public void npSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void wpSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void gwbSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PieChartModel getWpModel() {
        return wpModel;
    }

    public PieChartModel getNpModel() {
        return npModel;
    }

    public PieChartModel getGwbModel() {
        return gwbModel;
    }
}
