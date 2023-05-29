
package interfaces;

import java.util.List;
import javax.swing.JOptionPane;

import projeto.entidades.Cliente;
import projeto.entidades.Flor;
import projeto.entidades.Fornecedor;
import projeto.entidades.Funcionario;
import projeto.entidades.Pedido;

public class FloriculturaApp {
	
	//repositorios 
	
	private static FlorService florService;
	private static ClienteService ClienteService;
	private static PedidoService pedidoService;
	private static FuncionarioService FuncionarioService;
	private static FornecedorService fornecedorService;
	
	public static void main(String[] args) {
		florService = new FlorServiceImpl();  
		ClienteService = new ClienteServiceImpl();
		pedidoService = new PedidoServiceImpl();
		FuncionarioService = new FuncionarioServiceImpl();
		fornecedorService = new FornecedorServiceImpl();

		exibirMenuPrincipal();
	}

	// PRINCIPAL
	
	private static void exibirMenuPrincipal() {
		String menuPrincipal = "Selecione uma opção:\n" + "1. Gerenciar Flores\n" + "2. Gerenciar Clientes\n"
				+ "3. Gerenciar Pedidos\n" + "4. Gerenciar Funcionarios\n" + "5. Gerenciar Fornecedores\n" + "0. Sair";
//enums
		int opcao;

		do {
			String opcaoStr = JOptionPane.showInputDialog(null, menuPrincipal);
			opcao = Integer.parseInt(opcaoStr);

			switch (opcao) {
			case 1:
				exibirMenuFlores();
				break;
			case 2:
				exibirMenuClientes();
				break;
			case 3:
				exibirMenuPedidos();
				break;
			case 4:
				exibirMenuFuncionarios();
				break;
			case 5:
				exibirMenuFornecedores();
				break;
			case 0:
				JOptionPane.showMessageDialog(null, "Saindo do programa.");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção invalida!");
			}
		} while (opcao != 0);
	}

	private static void exibirMenuFlores() {
		String menuFlores = "Selecione uma opção:\n" + "1. Cadastrar Flor\n" + "2. Atualizar Flor\n"
				+ "3. Remover Flor\n" + "4. Buscar Flor\n" + "5. Listar Flores\n" + "0. Voltar";

		int opcao;

		do {
			String opcaoStr = JOptionPane.showInputDialog(null, menuFlores);
			opcao = Integer.parseInt(opcaoStr);

			switch (opcao) {
			case 1:
				cadastrarFlor();
				break;
			case 2:
				atualizarFlor();
				break;
			case 3:
				removerFlor();
				break;
			case 4:
				buscarFlor();
				break;
			case 5:
				listarFlores();
				break;
			case 0:
				JOptionPane.showMessageDialog(null, "Voltando ao menu principal.");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção invalida!");
			}
		} while (opcao != 0);
	}

	private static void cadastrarFlor() {
		String nome = JOptionPane.showInputDialog(null, "Digite o nome da flor:");
		String cor = JOptionPane.showInputDialog(null, "Digite a cor da flor:");
		String precoStr = JOptionPane.showInputDialog(null, "Digite o preço da flor:");
		double preco = Double.parseDouble(precoStr);

		Flor flor = new Flor(nome, cor, preco);
		florService.cadastrarFlor(flor);

		JOptionPane.showMessageDialog(null, "Flor cadastrada com sucesso!");
	}

	private static void atualizarFlor() {
		String nome = JOptionPane.showInputDialog(null, "Digite o nome da flor a ser atualizada:");

		Flor flor = florService.buscarFlor(nome);

		if (flor != null) {
			String novaCor = JOptionPane.showInputDialog(null, "Digite a nova cor da flor:");
			String novoPrecoStr = JOptionPane.showInputDialog(null, "Digite o novo preço da flor:");
			double novoPreco = Double.parseDouble(novoPrecoStr);

			flor.setCor(novaCor);
			flor.setPreco(novoPreco);

			florService.atualizarFlor(flor);

			JOptionPane.showMessageDialog(null, "Flor atualizada com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Flor não encontrada!");
		}
	}

	private static void removerFlor() {
		String nome = JOptionPane.showInputDialog(null, "Digite o nome da flor a ser removida:");

		Flor flor = florService.buscarFlor(nome);

		if (flor != null) {
			florService.removerFlor(nome);
			JOptionPane.showMessageDialog(null, "Flor removida com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Flor não encontrada!");
		}
	}

	private	static void buscarFlor() {
		String nome = JOptionPane.showInputDialog(null, "Digite o nome da flor a ser buscada:");

		Flor flor = florService.buscarFlor(nome);

		if (flor != null) {
			JOptionPane.showMessageDialog(null, "Flor encontrada:\n" + "Nome: " + flor.getNome() + "\n" + "Cor: "
					+ flor.getCor() + "\n" + "Preço: " + flor.getPreco());
		} else {
			JOptionPane.showMessageDialog(null, "Flor não encontrada!");
		}
	}

	private static void listarFlores() {
		List<Flor> flores = florService.listarFlores();

		StringBuilder mensagem = new StringBuilder("Lista de Flores:\n");

		for (Flor flor : flores) {
			mensagem.append("Nome: ").append(flor.getNome()).append("\n");
			mensagem.append("Cor: ").append(flor.getCor()).append("\n");
			mensagem.append("Preço: ").append(flor.getPreco()).append("\n\n");
		}

		JOptionPane.showMessageDialog(null, mensagem.toString());
	}

	//CLIENTES
	
	private static void exibirMenuClientes() {
		String menuClientes = "Selecione uma opção:\n" + "1. Cadastrar Cliente.\n" + "2. Atualização cadastral.\n"
				+ "3. Cancelamento do cadastro.\n" + "4. Buscar Cliente.\n" + "5. Listar todos os Clientes\n"
				+ "0. Voltar";

		int opcao;

		do {
			String opcaoStr = JOptionPane.showInputDialog(null, menuClientes);
			opcao = Integer.parseInt(opcaoStr);

			switch (opcao) {
			case 1:
				cadastrarCliente();
				break;
			case 2:
				atualizarCliente();
				break;
			case 3:
				removerCliente();
				break;
			case 4:
				buscarCliente();
				break;
			case 5:
				listarClientes();
				break;
			case 0:
				JOptionPane.showMessageDialog(null, "Voltando ao menu principal.");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção invalida!");
			}
		} while (opcao != 0);
	}

	private static void cadastrarCliente() {
		String nome = JOptionPane.showInputDialog(null, "Digite o nome do Cliente:");
		String telefone = JOptionPane.showInputDialog(null, "Digite o telefone do cliente:");
		String cidade = JOptionPane.showInputDialog(null, "Digite a cidade do Cliente:");

		Cliente cliente = new Cliente(nome, telefone, cidade);
		ClienteService.cadastrarCliente(cliente);

		JOptionPane.showMessageDialog(null, "Cliente cadastrado(a) com sucesso!");
	}

	private static void buscarCliente() {
		String nome = JOptionPane.showInputDialog(null, "Digite o nome do cliente a ser buscado:");

		Cliente cliente = ClienteService.buscarCliente(nome);

		if (cliente != null) {
			JOptionPane.showMessageDialog(null, "Cliente localizado!\n\n" + "Nome: " + cliente.getNome() + "\n"
					+ "Telefone: " + cliente.getTelefone() + "\n" + "Cidade: " + cliente.getCidade());
		} else {
			JOptionPane.showMessageDialog(null, "Cliente não localizado.");
		}
	}

	private static void atualizarCliente() {
		String nome = JOptionPane.showInputDialog(null, "Digite o nome do cliente a ser atualizado:");

		Cliente cliente = ClienteService.buscarCliente(nome);

		if (nome != null) {
			String novoNome = JOptionPane.showInputDialog(null, "Atualize o nome do cadastro:");
			String novoCidade = JOptionPane.showInputDialog(null, "Atualiza a cidade do cadastro:");
			String novoTelefone = JOptionPane.showInputDialog(null, "Atualize o telefone do cadastro:");

			cliente.setNome(novoNome);
			cliente.setCidade(novoCidade);
			cliente.setTelefone(novoTelefone);

			ClienteService.atualizarCliente(cliente);

			JOptionPane.showMessageDialog(null, "Cadastro atualizada com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Cliente não encontrado(a)!");
		}
	}

	private static void listarClientes() {
		List<Cliente> clientes = ClienteService.listarClientes();

		StringBuilder mensagem = new StringBuilder("Lista de Cadastros!\n\n");

		for (Cliente cliente : clientes) {
			mensagem.append("Nome: ").append(cliente.getNome()).append("\n");
			mensagem.append("Cidade: ").append(cliente.getCidade()).append("\n");
			mensagem.append("Telefone: ").append(cliente.getTelefone()).append("\n\n");
		}

		JOptionPane.showMessageDialog(null, mensagem.toString());
	}

	private static void removerCliente() {
		String nome = JOptionPane.showInputDialog(null, "Digite o nome do cliente que será cancelado:");

		Cliente cliente = ClienteService.buscarCliente(nome);

		if (cliente != null) {
			ClienteService.removerCliente(nome);
			JOptionPane.showMessageDialog(null, "Cadastro cancelado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Serviço não encontrado!");
		}

	}

	//FUNCIONARIOS
	
	private static void exibirMenuFuncionarios() {
		String menuFuncionario = "Selecione uma opção:\n" + "1. Cadastrar Funcionario.\n"
				+ "2. Atualização Funcionario.\n" + "3. Remoção de Funcionario.\n" + "4. Buscar Funcionario.\n"
				+ "5. Listar todos os Funcionarios.\n" + "0. Voltar";

		int opcao;

		do {
			String opcaoStr = JOptionPane.showInputDialog(null, menuFuncionario);
			opcao = Integer.parseInt(opcaoStr);

			switch (opcao) {
			case 1:
				cadastrarFuncionario();
				break;
			case 2:
				atualizarFuncionario();
				break;
			case 3:
				removerFuncionario();
				break;
			case 4:
				buscarFuncionario();
				break;
			case 5:
				listarFuncionario();
				break;
			case 0:
				JOptionPane.showMessageDialog(null, "Voltando ao menu principal;");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção invalida!");
			}
		} while (opcao != 0);
	}

	private static void cadastrarFuncionario() {

		String nome = JOptionPane.showInputDialog(null, "Digite o nome do Funcionario:");
		String cargo = JOptionPane.showInputDialog(null, "Digite o cargo do Funcionario :");
		String telefone = JOptionPane.showInputDialog(null, "Digite o telefone do cliente:");

		Funcionario funcionario = new Funcionario(nome, cargo, telefone);
		FuncionarioService.cadastrarFuncionario(funcionario);

		JOptionPane.showMessageDialog(null, "Funcionario cadastrado(a) com sucesso!");
	}

	private static void buscarFuncionario() {
		String nome = JOptionPane.showInputDialog(null, "Digite o nome do funcionario a ser buscado:");

		Funcionario funcionario = FuncionarioService.buscarFuncionario(nome);

		if (funcionario != null) {
			JOptionPane.showMessageDialog(null, "Funcionario localizado!\n\n" + "Nome: " + funcionario.getNome() + "\n"
					+ "Cargo: " + funcionario.getCargo() + "\n" + "Telefone: " + funcionario.getTelefone());
		} else {
			JOptionPane.showMessageDialog(null, "Funcionario não localizado.");
		}
	}

	private static void atualizarFuncionario() {
		String nome = JOptionPane.showInputDialog(null, "Digite o nome do funcionario:");

		Funcionario funcionario = FuncionarioService.buscarFuncionario(nome);

		if (nome != null) {
			String novoNome = JOptionPane.showInputDialog(null, "Atualize o nome do funcionario:");
			String novoCargo = JOptionPane.showInputDialog(null, "Atualiza o cargo do funcionario:");
			String novoTelefone = JOptionPane.showInputDialog(null, "Atualize o telefone do funcionario:");

			funcionario.setNome(novoNome);
			funcionario.setCargo(novoCargo);
			funcionario.setTelefone(novoTelefone);

			FuncionarioService.atualizarFuncionario(funcionario);

			JOptionPane.showMessageDialog(null, "Cadastro atualizada com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Cliente não encontrado(a)!");
		}
	}

	private static void listarFuncionario() {
		List<Funcionario> funcionarios = FuncionarioService.listarFuncionarios();

		StringBuilder mensagem = new StringBuilder("Lista de Funcionarios!\n\n");

		for (Funcionario funcionario : funcionarios) {
			mensagem.append("Nome: ").append(funcionario.getNome()).append("\n");
			mensagem.append("Cargo: ").append(funcionario.getCargo()).append("\n");
			mensagem.append("Telefone: ").append(funcionario.getTelefone()).append("\n\n");
		}

		JOptionPane.showMessageDialog(null, mensagem.toString());
	}

	private static void removerFuncionario() {
		String nome = JOptionPane.showInputDialog(null, "Digite o nome o funcionario que será desligado:");

		Funcionario funcionario = FuncionarioService.buscarFuncionario(nome);

		if (funcionario != null) {
			FuncionarioService.removerFuncionario(nome);
			JOptionPane.showMessageDialog(null, "Funcionario desligado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Funcionario não localizado!");
		}

	}

	// FORNECEDORES 

	private static void exibirMenuFornecedores() {
		String menuFornecedor = "Selecione uma opção:\n" + "1. Cadastrar Fornecedor.\n" + "2. Atualização Fornecedor.\n"
				+ "3. Remoção de Fornecedor.\n" + "4. Buscar Fornecedor.\n" + "5. Listar todos os Fornecedor.\n"
				+ "0. Voltar";

		int opcao;

		do {
			String opcaoStr = JOptionPane.showInputDialog(null, menuFornecedor);
			opcao = Integer.parseInt(opcaoStr);

			switch (opcao) {
			case 1:
				cadastrarFornecedor();
				break;
			case 2:
				atualizarFornecedor();
				break;
			case 3:
				removerFornecedor();
				break;
			case 4:
				buscarFornecedor();
				break;
			case 5:
				listarFornecedor();
				break;
			case 0:
				JOptionPane.showMessageDialog(null, "Voltando ao menu principal...");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção invalida!");
			}
		} while (opcao != 0);
	}

	private static void cadastrarFornecedor() {

		String nome = JOptionPane.showInputDialog(null, "Digite o nome do Fornecedor:");
		String endereco = JOptionPane.showInputDialog(null, "Digite o endereço do Fornecedor:");
		String telefone = JOptionPane.showInputDialog(null, "Digite o número de contato do Fornecedor:");

		Fornecedor fornecedor = new Fornecedor(nome, endereco, telefone);
		fornecedorService.cadastrarFornecedor(fornecedor);

		JOptionPane.showMessageDialog(null, "Fornecedor cadastrado(a) com sucesso!");
	}

	private static void atualizarFornecedor() {
		String nome = JOptionPane.showInputDialog(null, "Digite qual o fornecedor:");

		Fornecedor fornecedor = fornecedorService.buscarFornecedor(nome);

		if (nome != null) {
			String novoNome = JOptionPane.showInputDialog(null, "Atualize o nome do fornecedor");
			String novoEndereco = JOptionPane.showInputDialog(null, "Atualiza o endereço do fornecedor:");
			String novoTelefone = JOptionPane.showInputDialog(null, "Atualize o telefone do fornecedor:");

			fornecedor.setNome(novoNome);
			fornecedor.setEndereco(novoEndereco);
			fornecedor.setTelefone(novoTelefone);

			fornecedorService.atualizarFornecedor(fornecedor);

			JOptionPane.showMessageDialog(null, "Cadastro atualizada com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Serviço não localizado!");
		}
	}

	private static void removerFornecedor() {
	String nome = JOptionPane.showInputDialog(null, "Nome do fornecedor:");

	Fornecedor fornecedor = fornecedorService.buscarFornecedor(nome);

	if (fornecedor != null) {
		fornecedorService.removerFornecedor(nome);
		JOptionPane.showMessageDialog(null, "Fornecedor desvinculado!");
	} else {
		JOptionPane.showMessageDialog(null, "Fornecedor não localizado!");
	}

}
	
	private static void buscarFornecedor() {
	String nome = JOptionPane.showInputDialog(null, "Qual fornecedor deseja verificar:");

	Fornecedor fornecedor = fornecedorService.buscarFornecedor(nome);

	if (fornecedor != null) {
		JOptionPane.showMessageDialog(null, "Funcionario localizado!\n\n" + "Nome: " + fornecedor.getNome() + "\n"
				+ "Endereço: " + fornecedor.getEndereco() + "\n" + "Telefone: " + fornecedor.getTelefone());
	} else {
		JOptionPane.showMessageDialog(null, "Fornecedor não localizado!");
	}
	}
	
	private static void listarFornecedor() {
	
		List<Fornecedor> fornecedor = fornecedorService.listarFornecedores();

	StringBuilder mensagem = new StringBuilder("Lista de Fornecedores!\n\n");

	for (Fornecedor f : fornecedor) {
		mensagem.append("Nome: ").append(f.getNome()).append("\n");
		mensagem.append("Endereço: ").append(f.getEndereco()).append("\n");
		mensagem.append("Telefone: ").append(f.getTelefone()).append("\n\n");
	}

	JOptionPane.showMessageDialog(null, mensagem.toString());
}

	// PEDIDOS 
	
	private static void exibirMenuPedidos() {
	String menuPedidos = "Selecione uma opção:\n" + "1. Cadastrar Pedido.\n"
			+ "2. Atualização do Pedido.\n" + "3. Finalizar o Pedido.\n" + "4. Buscar Pedido.\n"
			+ "5. Listar todos os Pedidos.\n" + "0. Voltar";

	int opcao;

	do {
		String opcaoStr = JOptionPane.showInputDialog(null, menuPedidos);
		opcao = Integer.parseInt(opcaoStr);

		switch (opcao) {
		case 1:
			cadastrarPedido();
			break;
		case 2:
			atualizarPedido();
			break;
		case 3:
			removerPedido();
			break;
		case 4:
			buscarPedido();
			break;
		case 5:
			listarPedido();
			break;
		case 0:
			JOptionPane.showMessageDialog(null, "Voltando ao menu principal.");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção invalida!");
		}
	} while (opcao != 0);
}
	
	private static void cadastrarPedido() {

	 String cliente  = JOptionPane.showInputDialog(null, "Digite o nome do solicitante:");
	 String flores = JOptionPane.showInputDialog(null, "Qual a flor desejada:");
	 String numeroStr = JOptionPane.showInputDialog(null, "Numero do pedido ordem de serviço: ");
	 double numero = Double.parseDouble(numeroStr);
	 
	 Pedido pedido = new Pedido (cliente,flores,numero);
	 pedidoService.cadastrarPedido (pedido); 

	JOptionPane.showMessageDialog(null, "Pedido cadastrado, lembre-se de alterar manualmente no estoque.");
	}

	private static void buscarPedido() {

		String cliente = JOptionPane.showInputDialog(null, "Cliente que você deseja buscar pedido:");

		Pedido pedido = pedidoService.buscarPedido(cliente);

		if (pedido != null) {
			JOptionPane.showMessageDialog(null, "Pedido localizado!\n\n" + "Cliente: " + pedido.getCliente() + "\n"
			+ "Flor: " + pedido.getFlores() + "\n" + "Numero da O.S: " + pedido.getNumero());
		} else {
			JOptionPane.showMessageDialog(null, "Pedido não localizado");
		}
	}

	private static void atualizarPedido() {
		String cliente= JOptionPane.showInputDialog(null, "Digite o nome do cliente a ser atualizado:");

		Pedido pedido = pedidoService.buscarPedido(cliente);

		if (pedido != null) {
			String novoCliente = JOptionPane.showInputDialog(null, "Atualize o nome do solicitante do pedido:");
			String novoFlores = JOptionPane.showInputDialog(null, "Atualize qual a flor solicitada:");
			JOptionPane.showMessageDialog(null, "Não é possível atualizar o número de pedido.");

			pedido.setCliente(novoCliente);
			pedido.setFlores(novoFlores);

			pedidoService.atualizarPedido(pedido);

			JOptionPane.showMessageDialog(null, "Cadastro atualizada com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Cliente não encontrado(a)!");
		}
	}
	
	private static void removerPedido() {
		String cliente = JOptionPane.showInputDialog(null, "Nome do cliente que será removido o pedido:");

		Pedido pedido = pedidoService.buscarPedido(cliente);

		if (pedido != null) {
			pedidoService.removerPedido(cliente);
			JOptionPane.showMessageDialog(null, "Pedido cancelado;");
		} else {
			JOptionPane.showMessageDialog(null, "Pedido não localizado.");
		}
}
	
	private static void listarPedido() {
		
		List<Pedido> pedido = pedidoService.listarPedido();

	StringBuilder mensagem = new StringBuilder("Lista de todos os pedidos!\n\n");

	for (Pedido p : pedido) {
		mensagem.append("Nome: ").append(p.getCliente()).append("\n");
		mensagem.append("Solicitação: ").append(p.getFlores()).append("\n");
		mensagem.append("Numero de ORDEM: ").append(p.getNumero()).append("\n\n");
	}

	JOptionPane.showMessageDialog(null, mensagem.toString());
}
}
