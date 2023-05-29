package interfaces;

import java.util.ArrayList;
import java.util.List;
import projeto.entidades.Funcionario;

public class FuncionarioServiceImpl implements FuncionarioService {
    private List<Funcionario> funcionarios;

    public FuncionarioServiceImpl() {
        this.funcionarios = new ArrayList<>();
    }

    @Override
    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    @Override
    public void atualizarFuncionario(Funcionario funcionario) {
        for (Funcionario f : funcionarios) {
            if (f.getNome().equals(funcionario.getNome())) {
                f.setCargo(funcionario.getCargo

());
                break;
            }
        }
    }

    @Override
    public void removerFuncionario(String nome) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome)) {
                funcionarios.remove(funcionario);
                break;
            }
        }
    }

    @Override
    public Funcionario buscarFuncionario(String nome) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome)) {
                return funcionario;
            }
        }
        return null;
    }

    @Override
    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }
}

