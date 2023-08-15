public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qtd = 0;

    public Book (String name, Author[] authors, double price) {
                this.authors = authors;
        this.name = name;
        this.price = price;
    }

    public Book (String name, Author[] authors, double price, int qtd) {
                this.authors = authors;
        this.name = name;
        this.price = price;
        this.qtd = qtd;
    }

    public Author[] getAuthors() {
        return this.authors;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQtd() {
        return this.qtd;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        String retorno = "Book[name=" + getName() + ",authors={Author";
        for(int i = 0; i < this.getAuthors().length; i++) {
            retorno += "[name=" + this.authors[i].getName() + ",email=" + this.authors[i].getEmail() + ",gender=" + this.authors[i].getGender() + "]";
        }
        retorno += "}" + this.getPrice() + ",qtd=" + this.getQtd() + "]";
        return retorno;
    }

    public String getAuthorNames() {
        String retorno = "";

        for(int i = 0; i < this.getAuthors().length; i++) {
            if (this.getAuthors().length == 1) {
                retorno += this.authors[i].getName();
            }
            else {
                if (i == this.getAuthors().length - 1) {
                    retorno += this.authors[i].getName() + ", ";
                }
                else {
                    retorno += this.authors[i].getName();
                }
            }

        }
        return retorno;
    }
}
