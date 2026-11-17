package cl.alonso.pioneerodyssey.utils.enums;

public enum Category {
    Category1(1),
    Category2(2),
    Category3(3),
    Category4(4);
    /*
    Category5(5),
    Category6(6),
    Category7(7),
    Category8(8),
    Category9(9),
    Category10(10);
    */

    private final int value;

    Category(int value) {this.value = value;}

    public int getValue() {return value;}
}
