/**
 @Author Ivaldo Fernandes Barros Neto
 */

public class Teste {
    public static void main(String[] args) {
        Author autor = new Author("Ivaldo Fernandes", "alunoifsp@gmail.com", 'm');
        System.out.println(autor.getName());
        System.out.println(autor.getEmail());
        System.out.println(autor.getGender());
        System.out.println("");
        System.out.println(autor.toString());

    }
}
