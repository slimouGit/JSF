package he;

import he.pdf.PdfCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;

@Named
@ViewScoped
public class HappyEuro extends AbstractHappyEuro {
    private final Logger LOG = LoggerFactory.getLogger(HappyEuro.class);

    private String projectName;

    @PostConstruct
    public void init() {
        this.projectName = "Happy Euro 4";
    }

    public void generatePdf() throws IOException {
        LOG.info("button clicked");
        String DEST = "documents/HappyEuro.pdf";
        new PdfCreator().createHE();
    }

    //--------------------------------------------------------------------------------------------------------

    public String getProjectName() {
        return projectName;
    }
}
