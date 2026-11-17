package cl.alonso.pioneerodyssey.utils;

public class Quad<X, Y, Z, W> {
    public final X first;
    public final Y second;
    public final Z third;
    public final W fourth;

    public Quad(X first, Y second, Z third, W fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    public X getFirst() { return first; }
    public Y getSecond() { return second; }
    public Z getThird() { return third; }
    public W getFourth() {return fourth;}

}
