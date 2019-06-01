import Enums.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Set<Position> he_bookList = new HashSet<Position>();

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

    private void bookPosition(String position) {
        Position bookedPosition = new Position(HE_List.valueOf(position).getType().getTypeValue(),
                HE_List.valueOf(position).getPosition(),
                HE_List.valueOf(position).getAmount());
        he_bookList.add(bookedPosition);
    }

    /***********************************************************************/

    public String getProjectName() {
        return projectName;
    }

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

    public Set<Position> getHe_bookList() {
        return he_bookList;
    }
}
