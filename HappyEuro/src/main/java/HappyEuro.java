import Interface.Position;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * User: salim
 * Date: 25.05.2019 14:50
 */

@Named
@ViewScoped
public class HappyEuro implements Serializable {
    private final Logger LOG = LoggerFactory.getLogger(HappyEuro.class);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");
    private String currentDate;
    private String type;
    private String position;
    private double amount;

    private Double amountBank = 0.0;
    private List<Position> income = new ArrayList<>();
    private double amountIncome = 0.0;
    private List<Position> outcome = new ArrayList<>();
    private double amountOutcome = 0.0;

    private double result;

    @PostConstruct
    public void init() {
        LOG.info("Hello HappyEuro");
        this.currentDate = formatter.format(LocalDate.now());
    }

    public void calculatePosition() {
        LOG.info("Input: Type {}, Position {} Amount {}", this.type, this.position, this.amount);
        Position position = new Position(this.type, this.position, this.amount);
        if (this.type.equalsIgnoreCase("income")) {
            this.income.add(position);
            this.amountIncome += position.getAmount();
        } else {
            this.outcome.add(position);
            this.amountOutcome += position.getAmount();
        }
        calculateResult();
    }

    private void calculateResult() {
        this.result = (this.amountBank + this.amountIncome) - this.amountOutcome;
        RequestContext.getCurrentInstance().update("list");
    }


    public void removeItem(Position positionToDelete) {
        if (positionToDelete.getType().equalsIgnoreCase("income")) {
            this.income.remove(positionToDelete);
        } else {
            this.outcome.remove(positionToDelete);
        }
        calculateResult();
    }


    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
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

    public void setAmountBank(Double amountBank) {
        this.amountBank = amountBank;
    }

    public List<Position> getIncome() {
        return income;
    }

    public List<Position> getOutcome() {
        return outcome;
    }

    public Double getAmountBank() {
        return amountBank;
    }

    public double getAmountIncome() {
        return amountIncome;
    }

    public double getAmountOutcome() {
        return amountOutcome;
    }

    public double getResult() {
        return result;
    }
}
