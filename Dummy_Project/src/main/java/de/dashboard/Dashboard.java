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
import java.util.*;

@Named
@ViewScoped
public class Dashboard implements Serializable {

    private PieChartModel npModel;
    private PieChartModel wpModel;
    private PieChartModel gwbModel;

    private int npGesamt;
    private int wpGesamt;
    private int gwbGesamt;

    private Map<String, List<String>> npStatusListe = new HashMap<>();
    private Map<String, List<String>> wpStatusListe = new HashMap<>();
    private Map<String, String> gwbStatusListe = new LinkedHashMap<>();

    List<String> colorList = new ArrayList<>();
    Map<String, String> gwbColorlist = new LinkedHashMap<>();

    @PostConstruct
    public void init() {

        this.colorList = new ArrayList<>(
                Arrays.asList("0cb500",
                        "00b57c",
                        "b53000","b50018",
                        "00a0b5",
                        "00d5f1"));

        this.gwbColorlist.put("Freigegeben", "0cb500");
        this.gwbColorlist.put("Unvollständig Erfasst", "00b57c");
        this.gwbColorlist.put("Abgemeldet", "b53000");

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

    private Map<String, String> initialisiereGwbStatusListe() {
        this.gwbStatusListe.put(
                "Freigegben", "Freigegeben"  );
        this.gwbStatusListe.put(
                "Unvollständig erfasst", "Unvollständig erfasst");
        this.gwbStatusListe.put(
                "Abgemeldet", "Abgemeldet");

        return this.gwbStatusListe;
    }


    private void createPieModels() {
        createNpModel();
        createWpModel();
        createGwbModel(this.gwbStatusListe);
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
        npModel.setSeriesColors(insertColorMap(this.colorList));
        npModel.setShadow(false);
        npModel.setExtender("pieExtender");

        this.npGesamt = 1;
    }

    private String insertColorMap(List<String> colorList) {
        List<String> tmpColorList = new ArrayList<>();
        colorList.forEach(color -> tmpColorList.add(color));
        return String.join(",", tmpColorList);
    }

    public String getColorOfList(String color) {
        return "#".concat(color);
    }

    public String doSomething(){
            return null;
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
        wpModel.setSeriesColors(insertColorMap(this.colorList));
        wpModel.setShadow(false);
        wpModel.setExtender("pieExtender");

        this.wpGesamt = 2;
    }

    private void createGwbModel(Map<String, String> gwbStatusListe) {
        gwbModel = new PieChartModel();

        for(Map.Entry<String, String> entry : gwbStatusListe.entrySet()){
            gwbModel.set(entry.getKey(),countGwbNachStatusListe(entry.getValue()));
        }

        gwbModel.setTitle("Gewerbebetriebe");
        gwbModel.setSeriesColors(insertColorMap(this.colorList));
        gwbModel.setShadow(false);
        gwbModel.setExtender("pieExtender");

        this.gwbGesamt = 3;
    }

    private int countGwbNachStatusListe(String status) {
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

    public int getNpGesamt() {
        return npGesamt;
    }

    public int getWpGesamt() {
        return wpGesamt;
    }

    public int getGwbGesamt() {
        return gwbGesamt;
    }

    public List<String> getColorList() {
        return colorList;
    }

    public Map<String, List<String>> getNpStatusListe() {
        return npStatusListe;
    }

    public Map<String, List<String>> getWpStatusListe() {
        return wpStatusListe;
    }

    public Map<String, String> getGwbStatusListe() {
        return gwbStatusListe;
    }

    public Map<String, String> getGwbColorlist() {
        return gwbColorlist;
    }
}
