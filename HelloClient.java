import java.rmi.Naming;

class HelloClient {
	// Programa cliente para o exemplo "Hello, world!"
	public static void main (String[] args) {
		Teste t = new Teste();
		if	(args.length != 1) {
			System.err.println("HelloClient <server host>\n  ERRO: Nome de dominio ou IP nao fornecido!");
			System.exit(1);
		}
		System.setProperty("java.security.policy","UnoClient.policy");
		try {
			UnoInterface uno = (UnoInterface) Naming.lookup ("//"+args[0]+"/Hello");
			System.out.println (uno.say());
		} catch (Exception e) {
			System.out.println ("UnoClient failed:");
			e.printStackTrace();
		}
	}
}

