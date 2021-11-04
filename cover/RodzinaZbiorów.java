package cover;

import java.util.ArrayList;

public class RodzinaZbiorów {
    private ArrayList<Zbiór> zbiory = new ArrayList<>();

    public int GetRozmiar() {
        return zbiory.size();
    }

    public void DodajZbiór(Zbiór zbiór) {
        zbiory.add(zbiór);
    }

    public Zbiór GetZbiór(int i) {
        return zbiory.get(i);
    }

}
