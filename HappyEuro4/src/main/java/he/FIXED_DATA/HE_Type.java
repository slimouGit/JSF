package he.FIXED_DATA;

/**
 * User: salim
 * Date: 31.05.2019 11:08
 */
public enum HE_Type {
    OUT("Ausgabe"),
    IN("Einnahme"),
    BANK("Guthaben");

    private final String typeValue;

    HE_Type(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getTypeValue() {
        return typeValue;
    }
}
