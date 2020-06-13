package de;

public class Behoerde {
    private long id;
    private String name;
    private String ort;


    public Behoerde(long id, String name, String ort) {
        this.id = id;
        this.name = name;
        this.ort = ort;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
}
