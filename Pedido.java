package projeto.entidades;


public class Pedido {
	
    private String cliente;
    private String flores;
    private double numero;

    public Pedido(String cliente, String flores, double numero) {
        this.cliente = cliente;
        this.flores = flores;
        this.numero = numero;
    }
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public String getFlores() {
        return flores;
    }

    public void setFlores(String flores) {
        this.flores = flores;
    }
	public double getNumero() {
        return numero;
    }

    public void setNumero(Double numero) {
        this.numero = numero;
    }

}
