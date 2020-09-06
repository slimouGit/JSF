package de.dashboard;

/**
 * User: salim
 * Date: 06.09.2020 13:27
 */
public class NpZielUrlMitFiltern implements ZielUrlErmitteln {
    private String weiterleitungsziel;
    public NpZielUrlMitFiltern(int index) {
        erstelleZielUrlMitFiltern(index);
    }

    public void erstelleZielUrlMitFiltern(int index) {
        switch (index) {
            case 0:
                this.weiterleitungsziel = "/content/index.xhtml?faces-redirect=true";
                break;
            case 1:
                this.weiterleitungsziel = "/content/index.xhtml?faces-redirect=true";
                break;
            case 2:
                this.weiterleitungsziel = "/content/index.xhtml?faces-redirect=true";
                break;
            case 3:
                this.weiterleitungsziel = "/content/index.xhtml?faces-redirect=true";
                break;
            case 4:
                this.weiterleitungsziel = "/content/index.xhtml?faces-redirect=true";
                break;
            case 5:
                this.weiterleitungsziel = "/content/index.xhtml?faces-redirect=true";
                break;
            default:
                this.weiterleitungsziel = "index.xhtml?faces-redirect=true";
        }
    }

    public String getWeiterleitungsziel() {
        return weiterleitungsziel;
    }
}
