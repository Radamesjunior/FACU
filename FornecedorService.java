package interfaces;

import java.util.List;
import projeto.entidades.Fornecedor;

public interface FornecedorService {
    void cadastrarFornecedor(Fornecedor fornecedor);
    void atualizarFornecedor(Fornecedor fornecedor);
    void removerFornecedor(String nome);
    Fornecedor buscarFornecedor(String nome);
    List<Fornecedor> listarFornecedores();
 
}
