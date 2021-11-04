package cover;

public class Skończony extends Składnik {
    private int a, b, c;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public boolean CzyZawieraLiczbe(int liczba) {
        return liczba <= -c && (liczba - a) >= 0 && (liczba - a) % (-b) == 0;
    }
}
