package cover;

import java.util.ArrayList;
import java.util.Collections;

public class HeurystykaZachłanna extends WybranyAlgorytm {
    private ArrayList<Integer> wynik = new ArrayList<>();
    private int ilePokrywa = 0; //sprawdzimy potem czy ilość pokrytych elementów jest równa ilości elementów w zbiorze Z

    @Override
    public ArrayList<Integer> Wykonaj(RodzinaZbiorów rodzinaZbiorów, Zapytanie zapytanie) {
        int ilośćZbiorów = rodzinaZbiorów.GetRozmiar();
        int[] kandydaci = new int[ilośćZbiorów + 1];
        for (int i = 0; i < ilośćZbiorów; i++) {
            kandydaci[i] = 0;
        }
        int max = 0;
        int rozmiarZ = -zapytanie.getA();
        //dla każdego zbioru sprawdzimy czy zawiera liczbę k z zapytania
        for (int i = 1; i < ilośćZbiorów; i++) {
            for (int k = 1; k <= rozmiarZ; k++) {
                if (!zapytanie.Z[k] && rodzinaZbiorów.GetZbiór(i).CzyZawieraLiczbe(k)) {
                    kandydaci[i]++;
                    if (kandydaci[i] > kandydaci[max])
                        max = i;
                }
            }
        }
        //jak już wybierzemy zbiór, który pokrywa najwięcej, to "odhaczamy" sobie te liczby w Z, które są pokryte (po to to była tablica booli)
        for (int k = 1; k <= rozmiarZ; k++) {
            if (!zapytanie.Z[k] && rodzinaZbiorów.GetZbiór(max).CzyZawieraLiczbe(k)) {
                zapytanie.Z[k] = true;
                ilePokrywa++;
            }
        }
        if (max != 0)
            wynik.add(max);
        boolean nieDaSięWięcejPokryć = true; //żeby się nie zapętlić
        for (int i = 0; i < ilośćZbiorów && nieDaSięWięcejPokryć; i++) {
            if (kandydaci[i] != 0) {
                nieDaSięWięcejPokryć = false;
            }
        }
        if (!nieDaSięWięcejPokryć)
            Wykonaj(rodzinaZbiorów, zapytanie);
        if (ilePokrywa == rozmiarZ) {
            Collections.sort(wynik);
            return wynik;
        } else
            return null;
    }
}
