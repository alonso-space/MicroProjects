package cl.alonso.pioneerodyssey.utils.enums;

public enum WeaponType {
    Ballistic("Balistico"),
    Energy("Energia"),
    Missile("Misil"),
    All("Cualquiera");

    private final String value;

    WeaponType(String value) {this.value = value;}

    public String getValue() {return value;}

}
