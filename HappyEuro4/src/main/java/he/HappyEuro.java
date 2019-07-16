package he;

import he.FIXED_DATA.HE_List;
import he.FIXED_DATA.HE_Type;
import he.pdf.PdfCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class HappyEuro extends AbstractHappyEuro {
    private final Logger LOG = LoggerFactory.getLogger(HappyEuro.class);

    private String projectName;
    private String position;
    private List<Position> intakes = new ArrayList<Position>();
    private double intakeAmount = 0.0;
    private List<Position> outputs = new ArrayList<Position>();
    private double outputsAmount = 0.0;
    private double bankAmount = 0.0;
    private double result = 0.0;

    @PostConstruct
    public void init() {
        this.projectName = "Happy Euro 4";
    }


    /**
     * List fuer Autocomplete erzeugen
     */
    public List<HE_List> positionList(String enteredValue) {
        LOG.info("POS {}", enteredValue);
        List<HE_List> he_positions = new ArrayList<HE_List>();
        for (HE_List item : HE_List.values()) {
            if (item.toString().toLowerCase().startsWith(enteredValue.toLowerCase())) {
                he_positions.add(item);
            }
        }
        return he_positions;
    }


    /**
     * Eintrag entgegennehmen und weiterreichen
     */
    public void submitPosition() {
        LOG.info("Selected value {} ", HE_List.valueOf(position).getPosition());
        FacesMessage msg;
        if (position != null) {
            //Eintrag zur Verarbeitung weiterreichen
            bookPosition(position);

            //Erfolgsnachricht ausgeben
            msg = new FacesMessage("Position", HE_List.valueOf(position).getType().getTypeValue()
                    + " " + HE_List.valueOf(position).getPosition()
                    + " " + HE_List.valueOf(position).getAmount());
        } else {
            //Fehler ausgeben
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Position is not selected.");
            LOG.error("Position konnt nicht verarbeitet werden");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


    /**
     * Eintrag verarbeiten
     * @param position
     */
    private void bookPosition(String position) {

        Position positionToBook = new Position(HE_List.valueOf(position).getType().getTypeValue(),
                HE_List.valueOf(position).getPosition(),
                HE_List.valueOf(position).getAmount());

        handlePosition(positionToBook);
    }

    /**
     * @param positionToBook
     */
    private void handlePosition(Position positionToBook) {
        String positionType = positionToBook.getType();
        if(positionType.equalsIgnoreCase(HE_Type.OUT.getTypeValue())){
            this.outputs.add(positionToBook);
            this.outputsAmount += positionToBook.getAmount();
        }
        if(positionType.equalsIgnoreCase(HE_Type.IN.getTypeValue())){
            this.intakes.add(positionToBook);
            this.intakeAmount += positionToBook.getAmount();
        }
        if(positionType.equalsIgnoreCase(HE_Type.BANK.getTypeValue())){
            this.bankAmount = positionToBook.getAmount();
        }
        calculateResult();
    }

    private void calculateResult() {
        this.result = (this.bankAmount + this.intakeAmount) - this.outputsAmount;
    }


    /**
     * PDF generieren
     * @throws IOException
     */
    public void generatePdf() throws IOException {
        LOG.info("button clicked");
        String DEST = "documents/HappyEuro.pdf";
        new PdfCreator().createHE();
    }

    //--------------------------------------------------------------------------------------------------------

    public String getProjectName() {
        return projectName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Position> getIntakes() {
        return intakes;
    }

    public void setIntakes(List<Position> intakes) {
        this.intakes = intakes;
    }

    public List<Position> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<Position> outputs) {
        this.outputs = outputs;
    }

    public double getBankAmount() {
        return bankAmount;
    }

    public void setBankAmount(double bankAmount) {
        this.bankAmount = bankAmount;
    }

    public double getIntakeAmount() {
        return intakeAmount;
    }

    public void setIntakeAmount(double intakeAmount) {
        this.intakeAmount = intakeAmount;
    }

    public double getOutputsAmount() {
        return outputsAmount;
    }

    public void setOutputsAmount(double outputsAmount) {
        this.outputsAmount = outputsAmount;
    }

    public double getResult() {
        return result;
    }
}
