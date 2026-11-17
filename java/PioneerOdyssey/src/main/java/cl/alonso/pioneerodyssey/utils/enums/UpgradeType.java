package cl.alonso.pioneerodyssey.utils.enums;

public enum UpgradeType {
    Hull("Cazco"),
    Energy("Energia"),
    Engine("Motor"),
    All("Cualquiera");

    private final String value;

    UpgradeType(String value) {this.value = value;}

    public String getValue() {return value;}

}
