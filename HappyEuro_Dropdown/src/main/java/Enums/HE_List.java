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
    ADOBE(HE_Type.OUT, "Adobe",29.95),
    LOTTERIE(HE_Type.OUT, "Fernseh Lotterie",20.00),
    HANDY(HE_Type.OUT, "Handy",20.00),
    UNITY(HE_Type.OUT, "Unity Media",39.95),
    GEZ(HE_Type.OUT, "GEZ",52.50),
    FAHRKARTE(HE_Type.OUT, "Fahrkarte",92.50),
    RECHTSCHUTZ(HE_Type.OUT, "Rechtschutz",23.72),
    HAFTPFLICHT(HE_Type.OUT, "Haftpflicht",10.00),
    PARKPLATZ(HE_Type.IN, "Parkplatz",50.00),
    MIMI_MIETE(HE_Type.IN, "Mimi Miete",325.00),
    OUTPUT(HE_Type.OUT, null,0.0),
    INTAKE(HE_Type.IN, null,0.0),
    BANK(HE_Type.BANK, null,0.0);

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
