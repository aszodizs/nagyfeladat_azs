public class Object extends Material{
    private final int mennyiseg;
    public Object(String name, double price, String kedvezmenyTipus, int mennyiseg) {
        super(name,price,kedvezmenyTipus);
        this.mennyiseg = mennyiseg;
    }

    public int getMennyiseg() {
        return mennyiseg;
    }
}
