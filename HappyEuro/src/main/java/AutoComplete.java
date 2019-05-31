/**
 * User: salim
 * Date: 31.05.2019 09:37
 */
import ENUM.HappyEuro_Positions;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ManagedBean
public class AutoComplete {

    private HappyEuro_Positions position;

    @Inject
    private HappyEuro happyEuro;



    // Method To Display The Country List On The JSF Page
    public List happyEuroList() {
        List happyEuroPositions = new ArrayList();
        happyEuroPositions.add(HappyEuro_Positions.MIETE.getPosition());
        happyEuroPositions.add(HappyEuro_Positions.INTERNET.getPosition());
        happyEuroPositions.add(HappyEuro_Positions.STROM.getPosition());
        Collections.sort(happyEuroPositions);
        return happyEuroPositions;
    }

    public HappyEuro_Positions getPositionName() {
        return position;
    }

    public void setPositionName(HappyEuro_Positions position) {
        this.position = position;
    }

    public List<String> completeEnum(String query) {
        List<String> match = new ArrayList<String>();
        HappyEuro_Positions[] units = HappyEuro_Positions.values();
        for (int i = 0; i < units.length; i++) {
            if (units[i].name().contains(query))
                match.add(units[i].getPosition());
        }
        return match;
    }

    private HappyEuro_Positions unit;
    private String enumString;

    public String getEnumString() {
        return this.enumString;
    }

    public void setEnumString(String enumString) {
        this.unit = HappyEuro_Positions.valueOf(enumString);
    }
}
