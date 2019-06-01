import Enums.HE_List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: salim
 * Date: 31.05.2019 10:40
 */
@Named
@ViewScoped
public class HappyEuro implements Serializable {
    private final Logger LOG = LoggerFactory.getLogger(HappyEuro.class);
    private String projectName;
    private String positionDropdown;
    private String positionAuto;
    private List<HE_List> positions = new ArrayList<HE_List>();
    private String selectedPosition;
    private List<Position> he_bookList = new ArrayList<Position>();
    private List<Position> intakes = new ArrayList<Position>();
    private List<Position> outputs = new ArrayList<Position>();

    private String type;
    private String position;
    private double amount;

    @PostConstruct
    public void init() {
        this.projectName = "Happy Euro Dropdown";
        positions.add(HE_List.MIETE);
        positions.add(HE_List.STROM);
        positions.add(HE_List.INTERNET);
        positions.add(HE_List.ADOBE);
        positions.add(HE_List.MIMI_MIETE);
        positions.add(HE_List.STRATO);
        positions.add(HE_List.PARKPLATZ);
        positions.add(HE_List.OUTPUT);
        positions.add(HE_List.INTAKE);
        generateAutoCompletedList();
    }

    public List<HE_List> generateAutoCompletedList() {
        List<HE_List> he_positions = new ArrayList<HE_List>();
        for (HE_List item : HE_List.values()) {
            he_positions.add(item);
        }
//        he_positions.add(HE_List.MIETE);
//        he_positions.add(HE_List.STROM);
//        he_positions.add(HE_List.INTERNET);
//        he_positions.add(HE_List.ADOBE);
//        he_positions.add(HE_List.MIMI_MIETE);
//        he_positions.add(HE_List.STRATO);
//        he_positions.add(HE_List.PARKPLATZ);
        return he_positions;
    }

    public void displayDropdownValue() {
        LOG.info("Selected value {} ", HE_List.valueOf(positionDropdown).getPosition());
        setType(HE_List.valueOf(positionDropdown).getType().getTypeValue());
        FacesMessage msg;
        if (positionDropdown != null) {
            bookPosition(positionDropdown);
            msg = new FacesMessage("Selected", HE_List.valueOf(positionDropdown).getType().getTypeValue()
                    + " " + HE_List.valueOf(positionDropdown).getPosition()
                    + " " + HE_List.valueOf(positionDropdown).getAmount());
            this.selectedPosition = HE_List.valueOf(positionDropdown).getType().getTypeValue()
                    + ": " + HE_List.valueOf(positionDropdown).getPosition()
                    + " " + HE_List.valueOf(positionDropdown).getAmount() + " Euro";
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected.");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void displayAutoselectValue() {
        LOG.info("Selected value {} ", HE_List.valueOf(positionAuto).getPosition());
        setType(HE_List.valueOf(positionAuto).getType().getTypeValue());
        FacesMessage msg;
        if (positionAuto != null) {
            bookPosition(positionAuto);
            msg = new FacesMessage("Selected", HE_List.valueOf(positionAuto).getType().getTypeValue()
                    + " " + HE_List.valueOf(positionAuto).getPosition()
                    + " " + HE_List.valueOf(positionAuto).getAmount());
            this.selectedPosition = HE_List.valueOf(positionAuto).getType().getTypeValue()
                    + ": " + HE_List.valueOf(positionAuto).getPosition()
                    + " " + HE_List.valueOf(positionAuto).getAmount() + " Euro";
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected.");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deletePosition(Position pos){
        this.he_bookList.remove(pos);
    }

    public void bookPosition(String position) {
        LOG.info("Position {}", position);
        Position bookedPosition = new Position(HE_List.valueOf(position).getType().getTypeValue(),
                HE_List.valueOf(position).getPosition(),
                HE_List.valueOf(position).getAmount());
        he_bookList.add(bookedPosition);
    }

    public void addPosition() {
        LOG.info("Position {}", this.type);
        Position addedPosition = new Position(this.type,
                this.position,
                this.amount);
        he_bookList.add(addedPosition);
        if( !he_bookList.isEmpty())
            he_bookList.remove( he_bookList.size() - 2 );
    }



    /***********************************************************************/


    public String getPositionAuto() {
        return positionAuto;
    }

    public void setPositionAuto(String positionAuto) {
        this.positionAuto = positionAuto;
    }

    public String getPositionDropdown() {
        return positionDropdown;
    }

    public void setPositionDropdown(String positionDropdown) {
        this.positionDropdown = positionDropdown;
    }

    public List<HE_List> getPositions() {
        return positions;
    }

    public String getSelectedPosition() {
        return selectedPosition;
    }

    public List<Position> getHe_bookList() {
        return he_bookList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Position> getIntakes() {
        return intakes;
    }

    public List<Position> getOutputs() {
        return outputs;
    }
}
