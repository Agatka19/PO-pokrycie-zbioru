package cover;

public class Zapytanie {
    private int a, b;
    public boolean[] Z; //bool bo sprawdzamy czy już odwiedziliśmy, a indeks to będzie numer zbioru

    //funkcja, która stworzy nam tablicę Z odpowiedniej długości
    public void DługośćZ() {
        Z = new boolean[-getA() + 1];
    }

    public void StwórzZbiórZ() {
        for (int i = 0; i < -a; i++) {
            Z[i] = false;
        }
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA() {
        return a;
    }
}
