package cover;

import java.util.ArrayList;

public class Zbiór {
    private ArrayList<Składnik> składniki = new ArrayList<>();

    public void DodajSkładnik(Składnik składnik) {
        boolean jużJest = false;
        for (int i = 0; i < składniki.size(); i++) {
            if (składniki.get(i) == składnik)
                jużJest = true;
        }
        if (!jużJest)
            składniki.add(składnik);
    }

    public boolean CzyZawieraLiczbe(int liczba) {
        for (int i = 0; i < składniki.size(); i++) {
            if (składniki.get(i).CzyZawieraLiczbe(liczba))
                return true;
        }
        return false;
    }
}
