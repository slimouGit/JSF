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
    private String position;
    private List<HE_List> positions = new ArrayList<HE_List>();
    private String selectedPosition;
    private List<Position> he_bookList = new ArrayList<Position>();

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
    }

    public void displayLocation() {
        LOG.info("Selected value {} ", HE_List.valueOf(position).getPosition());
        FacesMessage msg;
        if (position != null) {
            bookPosition(position);
            msg = new FacesMessage("Selected", HE_List.valueOf(position).getType().getTypeValue()
                    + " " + HE_List.valueOf(position).getPosition()
                    + " " + HE_List.valueOf(position).getAmount());
            this.selectedPosition = HE_List.valueOf(position).getType().getTypeValue()
                    + ": " + HE_List.valueOf(position).getPosition()
                    + " " + HE_List.valueOf(position).getAmount() + " Euro";
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

    public String getProjectName() {
        return projectName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
}
