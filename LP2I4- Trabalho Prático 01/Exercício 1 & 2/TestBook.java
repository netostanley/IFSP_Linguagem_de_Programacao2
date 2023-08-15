/**
 @Author Ivaldo Fernandes Barros Neto
 */


public class TestBook {
    public static void main(String[] args) {
        Author[] authors = new Author[2];
        authors[0] = new Author("Autor 01", "autor01@gmail.com.br", 'm');
        authors[1] = new Author("Autor 02", "autor02@gmail.com.br", 'm');
        Book testeBook = new Book("Codigo Limpo", authors, 19.99, 99);
        System.out.println(testeBook.toString());
    }
}
