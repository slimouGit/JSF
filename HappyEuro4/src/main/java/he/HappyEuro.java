package he;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class HappyEuro extends AbstractHappyEuro {
    private final Logger LOG = LoggerFactory.getLogger(HappyEuro.class);

    private String projectName;

    @PostConstruct
    public void init() {
        this.projectName = "Happy Euro 4";
    }

    //--------------------------------------------------------------------------------------------------------

    public String getProjectName() {
        return projectName;
    }
}
