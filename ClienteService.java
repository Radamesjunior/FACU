package interfaces;

import java.util.List;
import projeto.entidades.Cliente;

public interface ClienteService {
    void cadastrarCliente(Cliente cliente);
    void atualizarCliente(Cliente cliente);
    void removerCliente(String nome);
    Cliente buscarCliente(String nome);
    List<Cliente> listarClientes();
    
}
