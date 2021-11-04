package cover;

public class Main {
    public static void main(String[] args) {
        Wczytywanie wczytywanie = new Wczytywanie();
        wczytywanie.DodajPusty(wczytywanie.rodzinaZbiorów);
        wczytywanie.Czytaj(wczytywanie.wejście);
    }
}
