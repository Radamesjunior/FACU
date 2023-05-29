package interfaces;

import java.util.ArrayList;
import java.util.List;
import projeto.entidades.Pedido;

public class PedidoServiceImpl implements PedidoService {
    private List<Pedido> pedidos;

    public PedidoServiceImpl() {
        this.pedidos = new ArrayList<>();
    }

    @Override
    public void cadastrarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    @Override
    public void atualizarPedido(Pedido pedido) {
        for (Pedido p : pedidos) {
            if ( p.getCliente().equals(pedido.getCliente())) {
                p.setFlores(pedido.getFlores());
               
    }
            break;
        }
    }

    @Override
    public Pedido buscarPedido(String cliente) {
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().equals(cliente)) {
                return pedido;
            }
        }
        return null;
    }
    @Override
    public void removerPedido(String cliente) {
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().equals(cliente)) {
                pedidos.remove(pedido);
                break;
            }
        }
    }

    @Override
    public List<Pedido> listarPedido() {
        return pedidos;
    }
}

