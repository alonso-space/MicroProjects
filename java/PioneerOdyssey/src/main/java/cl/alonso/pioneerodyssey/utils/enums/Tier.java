package cl.alonso.pioneerodyssey.utils.enums;

public enum Tier {
    Tier1(1),
    Tier2(2),
    Tier3(3),
    Tier4(4);
    /*
    Tier5(5),
    Tier6(6),
    Tier7(7),
    Tier8(8),
    Tier9(9),
    Tier10(10);
    */

    private final int value;

    Tier(int value) {this.value = value;}

    public int getValue() {return value;}

    public Tier nextOrMax() {
        Tier[] vals = values();
        int ord = this.ordinal();
        if (ord < vals.length - 1) {
            return vals[ord + 1];
        } else {
            return this;
        }
    }
}
