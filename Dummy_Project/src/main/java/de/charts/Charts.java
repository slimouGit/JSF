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

    private PieChartModel pieModel1;

    @PostConstruct
    public void init(){
        this.title = "Charts";
        createPieModels();
    }

    private void createPieModels() {
        createPieModel1();
    }

    private void createPieModel1() {
        pieModel1 = new PieChartModel();

        pieModel1.set("Freigegeben", 540);
        pieModel1.set("In Prüfung", 325);
        pieModel1.set("Storniert", 702);
        pieModel1.set("Zurückgewiesen", 421);
        pieModel1.set("Abgemeldet", 1);

        pieModel1.setTitle("Wachpersonen");
        pieModel1.setLegendPosition("w");
        pieModel1.setShadow(false);
    }

    public void itemSelect(ItemSelectEvent event) {
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

    public PieChartModel getPieModel1() {
        return pieModel1;
    }
}
