package de.dashboard;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.PieChartModel;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class Dashboard implements Serializable {

    private PieChartModel npModel;
    private PieChartModel wpModel;
    private PieChartModel gwbModel;

    private Map<String, List<String>> npStatusListe = new HashMap<>();
    private Map<String, List<String>> wpStatusListe = new HashMap<>();
    private Map<String, List<String>> gwbStatusListe = new HashMap<>();

    @PostConstruct
    public void init() {
        initialisiereStatusListen();
        createPieModels();
    }

    private void initialisiereStatusListen() {
        this.npStatusListe = initialisiereNpStatusListe();
        this.wpStatusListe = initialisiereWpStatusListe();
        this.gwbStatusListe = initialisiereGwbStatusListe();
    }


    private Map<String, List<String>> initialisiereNpStatusListe() {
        return null;
    }

    private Map<String, List<String>> initialisiereWpStatusListe() {
        return null;
    }

    private Map<String, List<String>> initialisiereGwbStatusListe() {
        this.gwbStatusListe.put(
                "Freigegben",
                new ArrayList<String>() {{ add("Freigegeben"); }} );
        this.gwbStatusListe.put(
                "Unvollständig erfasst",
                new ArrayList<String>() {{ add("Unvollständig erfasst"); }} );
        this.gwbStatusListe.put(
                "Abgemeldet",
                new ArrayList<String>() {{ add("Abgemeldet"); }} );

        return this.gwbStatusListe;
    }


    private void createPieModels() {
        createNpModel();
        createWpModel();
        createGwbModel();
    }


    private void createNpModel() {
        npModel = new PieChartModel();

        npModel.set("Freigegeben", 200);
        npModel.set("In Prüfung", 100);
        npModel.set("Zu loöschen", 200);
        npModel.set("Nicht zugelassen", 200);
        npModel.set("Änderungsantrag", 200);
        npModel.set("Sonstige", 200);

        npModel.setTitle("NatürlichePersonen");
        npModel.setSeriesColors("0cb500,00b57c,b53000,b50018,00a0b5,00d5f1");
        npModel.setShadow(false);
        npModel.setExtender("pieExtender");
    }

    private void createWpModel() {
        wpModel = new PieChartModel();

        wpModel.set("Freigegeben", 200);
        wpModel.set("In Prüfung", 80);
        wpModel.set("Storniert", 320);
        wpModel.set("Nicht zugelassen", 300);
        wpModel.set("Änderungsantrag", 160);
        wpModel.set("Ersterfassung", 260);

        wpModel.setTitle("Wachpersonen");
        wpModel.setSeriesColors("0cb500,00b57c,b53000,b50018,00a0b5,00d5f1");
        wpModel.setShadow(false);
        wpModel.setExtender("pieExtender");
    }

    private void createGwbModel() {
        gwbModel = new PieChartModel();

        for(Map.Entry<String, List<String>> entry : this.gwbStatusListe.entrySet()){
            gwbModel.set(entry.getKey(),countGwbNachStatusListe(entry.getValue()));
        }

        gwbModel.setTitle("Gewerbebetriebe");
        gwbModel.setSeriesColors("0cb500,00b57c,b53000");
        gwbModel.setShadow(false);
        gwbModel.setExtender("pieExtender");
    }

    private int countGwbNachStatusListe(List<String> statusListe) {
        //TODO: dao aufrufen, um Objekte anhand Statusliste zu zaehlen
        return 42;
    }


    public void npSelect(ItemSelectEvent event) {
        NpZielUrlMitFiltern weiterleitungNp = new NpZielUrlMitFiltern(event.getItemIndex());
        redirect(weiterleitungNp.getWeiterleitungsziel());
    }

    public void wpSelect(ItemSelectEvent event) {
        String target;
        System.out.println("Item Index: " + event.getItemIndex() + " Series Index: " + event.getSeriesIndex());
        switch (event.getItemIndex()) {
            case 0:
                target = "/content/index.xhtml?faces-redirect=true";
                break;
            case 1:
                target = "/content/index.xhtml?faces-redirect=true";
                break;
            case 2:
                target = "/content/index.xhtml?faces-redirect=true";
                break;
            case 3:
                target = "/content/index.xhtml?faces-redirect=true";
                break;
            case 4:
                target = "/content/index.xhtml?faces-redirect=true";
                break;
            case 5:
                target = "/content/index.xhtml?faces-redirect=true";
                break;
            default:
                target = "index.xhtml?faces-redirect=true";
        }
        redirect(target);
    }

    public void gwbSelect(ItemSelectEvent event) {
        String target;
        System.out.println("Item Index: " + event.getItemIndex() + " Series Index: " + event.getSeriesIndex());
        switch (event.getItemIndex()) {
            case 0:
                target = "/content/index.xhtml?faces-redirect=true";
                break;
            case 1:
                target = "/content/index.xhtml?faces-redirect=true";
                break;
            case 2:
                target = "/content/index.xhtml?faces-redirect=true";
                break;
            default:
                target = "index.xhtml?faces-redirect=true";
        }
        redirect(target);
    }


    public String redirect(String target) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExternalContext extContext = ctx.getExternalContext();
        String url = extContext.encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx, target));

        try {
            extContext.redirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return url;
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
