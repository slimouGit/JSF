package content;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class Saved implements Serializable {
    private final Logger LOG = LoggerFactory.getLogger(Saved.class);
    private String name;

    @PostConstruct
    public void init() {
        if (null != this.name) {
            LOG.info("Name {}", this.name);
        }
    }


    public String navigateTo(String retVal) {
        String newUrl = retVal.concat("?faces-redirect=true&includeViewParams=true");
        return newUrl;
    }

    /***********************************************************************/


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
