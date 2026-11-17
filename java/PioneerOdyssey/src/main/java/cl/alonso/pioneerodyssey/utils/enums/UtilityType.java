package cl.alonso.pioneerodyssey.utils.enums;

public enum UtilityType {
    Auxiliary("Auxiliar"),
    Offensive("Ofensivo"),
    Defensive("Defensiva"),
    All("Cualquiera");

    private final String value;

    UtilityType(String value) {this.value = value;}

    public String getValue() {return value;}

}