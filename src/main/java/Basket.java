import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final List<Object> termekek = new ArrayList<>();
    public void addTermek(Object termek){
        termekek.add(termek);
    }

    public List<Object> getTermekek() {
        return new ArrayList<> (termekek);
    }
}
