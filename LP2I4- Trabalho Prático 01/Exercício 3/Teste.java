/**
 * @Author Ivaldo Fernandes - CB3020878
 */

public class Teste {
    public static void main(String[] args) {
        Student teste1 = new Student("Ivaldo Fernandes", "Rua CB3020878", "X", 20, 3.0);
        Staff teste2 = new Staff("Luiz Gustavo", "Rua CB3015386", "Instituto Federal", 2100);

        System.out.println(teste1.toString());
        System.out.println(teste2.toString());
    }
}
