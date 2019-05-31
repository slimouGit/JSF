package ENUM;

/**
 * User: salim
 * Date: 31.05.2019 08:24
 */
public enum Type {
    IN("income"),
    OUT("outcome");

    private final String typeValue;

    Type(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getTypeValue() {
        return typeValue;
    }
}
