package cover;

import java.util.ArrayList;
import java.util.Scanner;

public class Wczytywanie {
    RodzinaZbiorów rodzinaZbiorów = new RodzinaZbiorów();

    //Pierwszy element to będzie pusty zbiór, żeby zacząc numerowac od 1
    public void DodajPusty(RodzinaZbiorów rodzinaZbiorów) {
        Element element = new Element();
        element.setA(0);
        Zbiór zbiór = new Zbiór();
        zbiór.DodajSkładnik(element);
        rodzinaZbiorów.DodajZbiór(zbiór);
    }

    Scanner czytaj = new Scanner(System.in);
    int wejście = czytaj.nextInt();

    public void Czytaj(int wejście) {
        if (wejście == 0) {
            //zbiór pusty to będzie zbiór zawierający 1 element: 0
            Zbiór zbiór = new Zbiór();
            Element element = new Element();
            element.setA(0);
            zbiór.DodajSkładnik(element);
            rodzinaZbiorów.DodajZbiór(zbiór);
        } else if (wejście > 0) {
            Zbiór zbiór = new Zbiór();
            int następna = czytaj.nextInt();
            PierwszaDodatnia(wejście, następna, zbiór); //oddzielna funckja na to, bo tu może być sporo róznych przypadków
            rodzinaZbiorów.DodajZbiór(zbiór);
        } else if (wejście < 0) {
            Zapytanie zapytanie = new Zapytanie();
            int następna = czytaj.nextInt();
            zapytanie.setA(wejście);
            zapytanie.setB(następna);
            zapytanie.DługośćZ();
            zapytanie.StwórzZbiórZ();
            ArrayList<Integer> wynik = new ArrayList<>();
            if (następna == 1) {
                AlgorytmDokładny algorytmDokładny = new AlgorytmDokładny();
                wynik = algorytmDokładny.Wykonaj(rodzinaZbiorów, zapytanie);
            } else if (następna == 2) {
                HeurystykaZachłanna heurystykaZachłanna = new HeurystykaZachłanna();
                wynik = heurystykaZachłanna.Wykonaj(rodzinaZbiorów, zapytanie);
            } else if (następna == 3) {
                HeurystykaNaiwna heurystykaNaiwna = new HeurystykaNaiwna();
                wynik = heurystykaNaiwna.Wykonaj(rodzinaZbiorów, zapytanie);
            }
            if (wynik != null) {
                for (int i = 0; i < wynik.size() - 1; i++)
                    System.out.print(wynik.get(i) + " "); //do wynik.size()-1, żeby nie wypisywać na końcu spacji
                System.out.println(wynik.get(wynik.size() - 1));
            } else
                System.out.println("0");
        }
        if (czytaj.hasNextInt()) {
            int wejście2 = czytaj.nextInt();
            Czytaj(wejście2);
        }
    }

    //sprawdzamy kolejne możliwe przypadki po wczytaniu liczby dodatniej
    private void PierwszaDodatnia(int wejście, int następna, Zbiór zbiór) {
        //jak następna jest zerem, to dodajemy nasze wejście do zbioru
        if (następna == 0) {
            Element element = new Element();
            element.setA(wejście);
            zbiór.DodajSkładnik(element);
            //jak następna jest znów dodatnia, to znaczy, ze tę pierwszą musimy dodać do zbuoru i wywoałujemy funkcję na następnej
        } else if (następna > 0) {
            Element element = new Element();
            element.setA(wejście);
            zbiór.DodajSkładnik(element);
            int następna2 = czytaj.nextInt();
            PierwszaDodatnia(następna, następna2, zbiór);
            //jak nastepna jest ujemna to wiemy, że mamy albo skończony albo nieskończony zbiór, więc będziemy musieli sprawdzać jeszcze kilka następnych
        } else if (następna < 0) {
            int następna2 = czytaj.nextInt();
            if (następna2 == 0) {
                Nieskończony nieskończony = new Nieskończony();
                nieskończony.setA(wejście);
                nieskończony.setB(następna);
                zbiór.DodajSkładnik(nieskończony);
            } else if (następna2 > 0) {
                Nieskończony nieskończony = new Nieskończony();
                nieskończony.setA(wejście);
                nieskończony.setB(następna);
                zbiór.DodajSkładnik(nieskończony);
                int następna3 = czytaj.nextInt();
                PierwszaDodatnia(następna2, następna3, zbiór);
            } else if (następna2 < 0) {
                Skończony skończony = new Skończony();
                skończony.setA(wejście);
                skończony.setB(następna);
                skończony.setC(następna2);
                zbiór.DodajSkładnik(skończony);
                //sprawdzamy jeszcze kolejną, bo jak nastepna3 nie jest 0, to dalej jesteśmy w tym samym zbiorze
                int następna3 = czytaj.nextInt();
                if (następna3 > 0) {
                    int następna4 = czytaj.nextInt();
                    PierwszaDodatnia(następna3, następna4, zbiór);
                }
            }
        }
    }
}