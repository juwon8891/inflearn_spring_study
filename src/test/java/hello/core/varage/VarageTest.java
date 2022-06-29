package hello.core.varage;

public class VarageTest {
    void sum(String a, String... b) {
        for (String s : b) {
            System.out.print(s + a);
        }
    }

    public static void main(String[] args) {
        VarageTest vt = new VarageTest();
        vt.sum("-","a", "b", "c");
    }
}
