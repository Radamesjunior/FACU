package interfaces;

import java.util.List;
import projeto.entidades.Pedido;

public interface PedidoService {
    void cadastrarPedido(Pedido pedido);
    void atualizarPedido(Pedido pedido);
    void removerPedido(String cliente);
    Pedido buscarPedido(String cliente);
    List<Pedido> listarPedido();


    
}
