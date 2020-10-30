import java.util.HashMap;

public abstract class Material {
    private final String name;
    private final double price;
    private static HashMap<String,String> kedvezmeny;
    private final String kedvezmenyTipus;

    public Material(String name, double price, String kedvezmenyTipus) {
        this.name = name;
        this.price = price;
        this.kedvezmenyTipus = kedvezmenyTipus;
    }

    public static void kedTipLista () {
        //HashMap<String, String>
                kedvezmeny = new HashMap<String, String>();
        kedvezmeny.put("2=3", "KETTŐT FIZET, HÁRMAT KAP");
        kedvezmeny.put("MEGAPACK", "MEGAPACK -6000");
        //return kedvezmeny.keySet();
        //= new HashMap<String, String>();
    }

    public String kedTipValue ( String kt) {
        return kedvezmeny.get(kt);
    }

    /*public static void main(String[] args) {
      kedTipLista();
      System.out.println(kedTipLista());
    }*/

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getKedvezmenyTipus() {
        return kedvezmenyTipus;
    }
}
