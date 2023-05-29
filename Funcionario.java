package projeto.entidades;


public class Funcionario  {
    private String nome;
    private String cargo;
    private String telefone;

    public Funcionario(String nome, String cargo, String telefone) {
    	this.nome = nome;
        this.cargo = cargo;
        this.telefone = telefone;
    }
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome){
    	this.nome = nome;
    	
    }
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getTelefone() {
    	return telefone;
    }
    
    public void setTelefone(String telefone) {
    	this.telefone = telefone;
    }

    }

