package interfaces;


import java.util.ArrayList;
import java.util.List;
import projeto.entidades.Cliente;


public class ClienteServiceImpl implements ClienteService {
    private List<Cliente> clientes;

    public ClienteServiceImpl() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void atualizarCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getNome().equals(cliente.getNome())) {
                c.setCidade(cliente.getCidade());
                c.setTelefone(cliente.getTelefone());
                break;
            }
        }
    }

    @Override
    public void removerCliente(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                clientes.remove(cliente);
                break;
            }
        }
    }

    @Override
    public Cliente buscarCliente(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> listarClientes() {
        return clientes;
    }
}
    

