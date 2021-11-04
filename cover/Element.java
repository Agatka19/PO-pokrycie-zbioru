package cover;

public class Element extends Składnik {
    private int a;

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public boolean CzyZawieraLiczbe(int liczba) {
        return a == liczba;
    }
}
