package Enums;

/**
 * User: salim
 * Date: 31.05.2019 10:58
 */
public enum HE_List {
    MIETE(HE_Type.OUT, "Miete",800.00),
    STROM(HE_Type.OUT, "Strom",65.00),
    INTERNET(HE_Type.OUT, "Internet",39.95),
    STRATO(HE_Type.OUT, "Strato",9.95),
    PARKPLATZ(HE_Type.IN, "Parkplatz",50.00),
    MIMI_MIETE(HE_Type.IN, "Mimi Miete",325.00),
    ADOBE(HE_Type.OUT, "Adobe",29.95);

    private final String position;
    private final double amount;
    private final HE_Type type;

    HE_List(HE_Type type, String position, double amount) {
        this.type = type;
        this.position = position;
        this.amount = amount;
    }

    public HE_Type getType() {
        return type;
    }

    public double getAmount(){
        return amount;
    }

    public String getPosition(){
        return position;
    }
}
