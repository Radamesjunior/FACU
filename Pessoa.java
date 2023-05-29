package projeto.entidades;

public abstract class Pessoa {
    private String nome;

    // construtor, getters e setters

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
