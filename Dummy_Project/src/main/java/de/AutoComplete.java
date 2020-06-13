package de;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named
@ViewScoped
public class AutoComplete implements Serializable {
    private List<Behoerde> behoerden = new ArrayList<>();
    private Map<String,Long> gefundeneBehoerden = new HashMap<>();
    private List<Behoerde> gefundeneBehoerdenListe = new ArrayList<>();
    private String behoerde;
    private Behoerde gefundeneBehoerde;

    @PostConstruct
    public void init() {
        behoerden.add(new Behoerde(1l, "Bezirksamt Frankfurt", "Frankfurt"));
        behoerden.add(new Behoerde(2l, "Stadtverwaltung Frankfurt", "Frankfurt"));
        behoerden.add(new Behoerde(3l,"Landesamt Kassel", "Kassel"));
        behoerden.add(new Behoerde(4l,"Bezirksamt Köln", "Köln"));
        behoerden.add(new Behoerde(5l, "Kandesamt München", "München"));
    }

    public List<String> behoerdenList(String enteredValue) {
        this.gefundeneBehoerden.clear();
        List<String> behoerden = new ArrayList<>();
        for (Behoerde item : this.behoerden) {
            if (item.getName().toLowerCase().contains(enteredValue.toLowerCase())) {
                behoerden.add(item.getName());
                this.gefundeneBehoerden.put(item.getName(),item.getId());
                this.gefundeneBehoerdenListe.add(item);
            }
        }
        return behoerden;
    }

    public void zeigeBehoerde(){
        System.out.println("Eingegebene Behoerde " + this.behoerde);
        System.out.println("Gefundene Behorden " + this.gefundeneBehoerden);
        System.out.println("Gefundene Behorden-Objekte " + this.gefundeneBehoerdenListe);
        for(Behoerde behoerde:this.gefundeneBehoerdenListe){
            System.out.println("Behoerde " + behoerde.getId() + " " + behoerde.getName());
        }

        Long behoerdenId = this.gefundeneBehoerden.get(this.behoerde);
        System.out.println("Ermittelte ID " + behoerdenId);


        Optional<Behoerde> gefundeneBehoerde = this.gefundeneBehoerdenListe
                .stream().parallel()
                .filter(behoerde -> behoerde.getName().equalsIgnoreCase(this.behoerde)).findFirst();

        System.out.println("Ermittelte Behoerde by Stream " + gefundeneBehoerde);


    }

    public List<Behoerde> getBehoerden() {
        return behoerden;
    }

    public void setBehoerden(List<Behoerde> behoerden) {
        this.behoerden = behoerden;
    }

    public Map<String, Long> getGefundeneBehoerden() {
        return gefundeneBehoerden;
    }

    public void setGefundeneBehoerden(Map<String, Long> gefundeneBehoerden) {
        this.gefundeneBehoerden = gefundeneBehoerden;
    }

    public String getBehoerde() {
        return behoerde;
    }

    public void setBehoerde(String behoerde) {
        this.behoerde = behoerde;
    }
}
