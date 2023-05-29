package interfaces;

import java.util.List;
import projeto.entidades.Funcionario;

public interface FuncionarioService {
    void cadastrarFuncionario(Funcionario funcionario);
    void atualizarFuncionario(Funcionario funcionario);
    void removerFuncionario(String nome);
    Funcionario buscarFuncionario(String nome);
    List<Funcionario> listarFuncionarios();

}
