package interfaces;

import java.util.ArrayList;
import java.util.List;
import projeto.entidades.Fornecedor;

public class FornecedorServiceImpl implements FornecedorService {
    private List<Fornecedor> fornecedores;

    public FornecedorServiceImpl() {
        this.fornecedores = new ArrayList<>();
    }

    @Override
    public void cadastrarFornecedor(Fornecedor fornecedor) {
        fornecedores.add(fornecedor);
    }

    @Override
    public void atualizarFornecedor(Fornecedor fornecedor) {
        for (Fornecedor f : fornecedores) {
            if (f.getNome().equals(fornecedor.getNome())) {
                f.setEndereco(fornecedor.getEndereco());
                f.setTelefone(fornecedor.getTelefone());
                break;
            }
        }
    }

    @Override
    public void removerFornecedor(String nome) {
        for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor.getNome().equals(nome)) {
                fornecedores.remove(fornecedor);
                break;
            }
        }
    }

    @Override
    public Fornecedor buscarFornecedor(String nome) {
        for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor.getNome().equals(nome)) {
                return fornecedor;
            }
        }
        return null;
    }

    @Override
    public List<Fornecedor> listarFornecedores() {
        return fornecedores;
    }
}
