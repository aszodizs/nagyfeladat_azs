import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Object alap;
        Basket kosar = new Basket();
        System.out.println("--- WEBAZAR --- Webshop kedvezménnyel!");
        System.out.println("Ez egy webáruház, kérem válasszon az alábbi termékek közül!");
        Object.kedTipLista();  //Itt inicializálja a kedvezményeket
        try {
            System.out.println("Hány darab téliszalámit kér?");
            int teliSzalamiDb = sc.nextInt();
            //System.out.println("A választott mennyiség: "+teliSzalamiDb);
            if (teliSzalamiDb >= 0) {
                if (teliSzalamiDb > 0) {
                    alap = new Object("Téliszalámi", 2000d, "2=3", teliSzalamiDb);
                    //alap.kedvezmenyTipus = new HashMap<String,String>();
                    //alap.kedvezmenyTipus.put("2PER3","IGEN");
                    //System.out.println(alap.kedTipValue(alap.kedvezmenyTipus));
                    //System.out.println(alap.name);
                    kosar.addTermek(alap);
                    //System.out.println(alap);
                }
            } else {
                throw new InputMismatchException();
            }
            
            System.out.println("Hány darab gumikacsát kér?");
            //Scanner sc = new Scanner(System.in);
            int gumiKacsaDb = sc.nextInt();
            //System.out.println("A választott mennyiség: "+gumiKacsaDb);
            if (gumiKacsaDb >= 0) {
                if (gumiKacsaDb > 0) {
                    alap = new Object("Gumikacsa", 3000d, "2=3", gumiKacsaDb);
                    kosar.addTermek(alap);
                }
            } else {
                throw new InputMismatchException();
            }

            System.out.println("Hány darab uborkát kér?");
            int uborkaDb = sc.nextInt();
            //System.out.println("A választott mennyiség: "+uborkaDb);
            if (uborkaDb >= 0) {
                if (uborkaDb > 0) {
                    alap = new Object("Megapack Uborka", 2800d, "MEGAPACK", uborkaDb);
                    kosar.addTermek(alap);
                }
            } else {
                throw new InputMismatchException();
            }
            
            System.out.println("Hány darab gesztenyét kér?");
            int gesztenyeDb = sc.nextInt();
            //System.out.println("A választott mennyiség: "+gesztenyeDb);
            if (gesztenyeDb >=0 ) {
                if (gesztenyeDb > 0) {
                    alap = new Object("Megapack Gesztenye", 1000d, "MEGAPACK", gesztenyeDb);
                    kosar.addTermek(alap);
                }
            } else {
                throw new InputMismatchException();
            }
            
            System.out.println("\nA megvásárolni kívánt termékek:");
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            //System.out.println(kosar.getTermekek());
            for (Object k : kosar.getTermekek()) {
                System.out.println("Termék neve: " + k.getName() + "   " +
                        "Termék ára: " + k.getPrice() + "   " +
                        "Kedvezmény tipusa: " + k.getKedvezmenyTipus() + "   " +
                        "Termék darabszáma: " + k.getMennyiseg());
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------");

            calculator(kosar);
        } catch (InputMismatchException e) {
            System.out.println("Csak nullát vagy nullától nagyobb számot adhat meg!");
            //e.printStackTrace();
        }
    }

    private static void calculator(Basket kosar) {
        double eredetiAr = 0;
        double eredetiArOssz = 0;
        double kedvezmenyesAr = 0;
        double kedvAr1 = 0;
        double kedvAr2 = 0;
        String kedvezmenyTipus = "Nincs érvényesíthető kedvezmény!";
        String kedvezmenyTipus1 = null;
        String kedvezmenyTipus2 = null;
        int arKedvezmenyDb = 0;
        for (Object termek : kosar.getTermekek()) {
            /*System.out.println("Termék neve: " + termek.getName() + "   " +
                    "Termék ára: " + termek.getPrice() + "   " +
                    "Kedvezmény tipusa: " + termek.getKedvezmenyTipus() + "   " +
                    "Termék darabszáma: " + termek.getMennyiseg());*/
            eredetiAr = termek.getPrice() * termek.getMennyiseg();
            eredetiArOssz += eredetiAr;
            if (termek.getKedvezmenyTipus().equals("2=3") && termek.getMennyiseg() >= 3) {
                arKedvezmenyDb = termek.getMennyiseg() / 3;
                kedvAr1 += (termek.getPrice() * arKedvezmenyDb);
                kedvezmenyTipus1 = termek.kedTipValue(termek.getKedvezmenyTipus());

            } else if (termek.getKedvezmenyTipus().equals("MEGAPACK") && termek.getMennyiseg() >= 12){
                arKedvezmenyDb = termek.getMennyiseg() / 12;
                kedvAr2 += (arKedvezmenyDb * 6000);
                kedvezmenyTipus2 = termek.kedTipValue(termek.getKedvezmenyTipus());

            }
            if (kedvAr1 > 0 || kedvAr2 > 0){
                if (kedvAr1 > kedvAr2){
                    kedvezmenyesAr = eredetiArOssz - kedvAr1;
                    kedvezmenyTipus = kedvezmenyTipus1;
                } else {
                    kedvezmenyesAr = eredetiArOssz - kedvAr2;
                    kedvezmenyTipus = kedvezmenyTipus2;
                }
            }
        }

        System.out.println("A kosár eredeti ára: " + eredetiArOssz + "\n" +
                           "Kedvezményes ár: " + kedvezmenyesAr + "\n" +
                           "Érvényesített kedvezmény típusa: " + kedvezmenyTipus);
        //System.out.println("Árkedvezmény: " + arKedvezmenyDb);
    }
}
