/**
 @Author Ivaldo Fernandes (CB3020878)

 */

public class Pessoa {
    private static int kp = 0;
    private String nome;
    private char sexo;
    private int idade;

    public Pessoa()
    {
        kp++;
    }

    public Pessoa(String s, char c, int i)
    {
        kp++;
        setNome(s);
        setSexo(c);
        setIdade(i);
    }

    public void setKp(int Kp) {
        kp = Kp;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getKp() {
        return kp;
    }

    public String getNome() {
        return this.nome;
    }

    public char getSexo() {
        return this.sexo;
    }

    public int getIdade() {
        return this.idade;
    }


}
