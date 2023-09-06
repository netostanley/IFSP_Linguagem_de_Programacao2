/**
 @Author Ivaldo Fernandes (CB3020878) & Victoria Andraus (CB3021351)
	
 */

import java.util.UUID;

public class Aluno {
    String endereco, nome;
    int idade;
    UUID uuid;

    public String getEndereco() {
        return this.endereco;
    }
    public String getNome() {
        return this.nome;
    }
    public int getIdade() {
        return this.idade;
    }
    public UUID getUuid() {
        return this.uuid;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}