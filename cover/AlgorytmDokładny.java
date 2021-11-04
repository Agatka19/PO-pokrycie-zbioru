package cover;

import java.util.ArrayList;

public class AlgorytmDokładny extends WybranyAlgorytm {

    private ArrayList<Integer> wynik = new ArrayList<>();
    //w tablicy optymalne będziemy zapisywać wszytskie rozwiązania, które pokrywają zbiór Z, a dopiero potem z nich wybierać
    private ArrayList<boolean[]> optymalne = new ArrayList<>();

    @Override
    public ArrayList<Integer> Wykonaj(RodzinaZbiorów rodzinaZbiorów, Zapytanie zapytanie) {
        CiągBinarny ciągBinarny = new CiągBinarny();
        ciągBinarny.Długość(rodzinaZbiorów);
        ciągBinarny.GeneratorBinarny(1, optymalne, rodzinaZbiorów, zapytanie);
        if (optymalne.size() == 0)
            return null;
        int min = Integer.MAX_VALUE;
        int indeks = 0;
        for (int i = 0; i < optymalne.size(); i++) {
            int licz = 0;
            for (int j = 0; j < optymalne.get(i).length; j++) {
                if (optymalne.get(i)[j]) {
                    licz++;
                }
            }
            if (licz < min) {
                min = licz;
                indeks = i;
            }
        }
        for (int i = 1; i < optymalne.get(indeks).length; i++) {
            if (optymalne.get(indeks)[i])
                wynik.add(i);
        }
        return wynik;
    }
}
