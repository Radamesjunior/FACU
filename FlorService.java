package interfaces;


import java.util.List;
import projeto.entidades.Flor;


interface FlorService {

    public void cadastrarFlor(Flor flor);

    public Flor buscarFlor(String nome);

    public void atualizarFlor(Flor flor);

    public void removerFlor(String nome);

    public List<Flor> listarFlores();
    
}
