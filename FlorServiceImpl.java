package interfaces;



import java.util.ArrayList;
import java.util.List;
import projeto.entidades.Flor;


public class FlorServiceImpl implements FlorService {
    private List<Flor> flores;

    public FlorServiceImpl() {
        this.flores = new ArrayList<>();
    }

    @Override
    public void cadastrarFlor(Flor flor) {
        flores.add(flor);
    }

    @Override
    public void atualizarFlor(Flor flor) {
        for (Flor f : flores) {
            if (f.getNome().equals(flor.getNome())) {
                f.setCor(flor.getCor());
                f.setPreco(flor.getPreco

());
                break;
            }
        }
    }

    @Override
    public void removerFlor(String nome) {
        for (Flor flor : flores) {
            if (flor.getNome().equals(nome)) {
                flores.remove(flor);
                break;
            }
        }
    }

    @Override
    public Flor buscarFlor(String nome) {
        for (Flor flor : flores) {
            if (flor.getNome().equals(nome)) {
                return flor;
            }
        }
        return null;
    }

    @Override
    public List<Flor> listarFlores() {
        return flores;
    }
}
