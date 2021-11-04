package cover;

public class Nieskończony extends Składnik {
    private int a, b;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public boolean CzyZawieraLiczbe(int liczba) {
        return (liczba - a) >= 0 && (liczba - a) % (-b) == 0;
    }
}
