package ENUM;

/**
 * User: salim
 * Date: 31.05.2019 08:22
 */
public enum  HappyEuro_Positions {
    MIETE(Type.OUT, "Miete",800.00),
    STROM(Type.OUT,"Strom",65.00),
    INTERNET(Type.OUT,"Internet",39.95);

    private final String position;
    private final double amount;
    private final Type typeValue;

    HappyEuro_Positions(Type typeValue, String position, double amount) {
        this.typeValue = typeValue;
        this.position = position;
        this.amount = amount;
    }

    public Type getTypeValue() {
        return typeValue;
    }

    public double getAmount(){
        return amount;
    }

    public String getPosition(){
        return position;
    }




}
