package model;

import java.util.ArrayList;

public class BaseDeDados {
	private static ArrayList<Cliente> clientes;
	
	public static void createBase() throws ClienteException{
		clientes = new ArrayList<Cliente>();
		inicializarBase();
	}
	
	private static void inicializarBase() throws ClienteException{
		try {
			Cliente cliente1 = new Cliente("maria@gmail.com");
			adicionarCliente(cliente1);
			
			Cliente cliente2 = new Cliente("maria@gmail.com");
			adicionarCliente(cliente2);
			
			Cliente cliente3 = new Cliente("ze@gmail.com");
			adicionarCliente(cliente3);
			
			Cliente cliente4 = new Cliente(null);
			adicionarCliente(cliente4);
			
		} catch (ClienteException e) {
			e.printStackTrace();
		}
	}
	
	public static Cliente buscarCliente(String email) throws ClienteException {
		ClienteException clienteException = new ClienteException(null);
		
		if (email == null || email.isEmpty()) {
			throw new ClienteException(clienteException.CLIENTE_INVALID);
		}
		
		for (Cliente clienteCurrent : clientes) {	
			if (clienteCurrent.email.equals(email)) {
				return clienteCurrent;
			}
		}
		
		return null;
	}
	
	public static boolean isCliente(Cliente cliente) throws ClienteException {
		ClienteException clienteException = new ClienteException(null);
		
		if (cliente == null || cliente.email == null) {
			throw new ClienteException(clienteException.CLIENTE_INVALID);
		}
		
		return true;
	}
	
	public static boolean adicionarCliente(Cliente cliente) throws ClienteException {
		ClienteException clienteException = new ClienteException(null);
		
		if (!isCliente(cliente)) {
			throw new ClienteException(clienteException.CLIENTE_INVALID);
		}
		
		if (buscarCliente(cliente.email) != null) {
			throw new ClienteException(clienteException.CLIENTE_EXIST_ERROR);
		}
		
		clientes.add(cliente);
		return true;
	}
	
	public static ArrayList<Cliente> getPessoas() {
		return clientes;
	}
}
