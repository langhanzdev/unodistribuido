import java.rmi.Naming;

class UnoClient {
	// Programa cliente para o exemplo "Hello, world!"
	public static void main (String[] args) {
		Teste t = new Teste();
		if	(args.length != 1) {
			System.err.println("HelloClient <server host>\n  ERRO: Nome de dominio ou IP nao fornecido!");
			System.exit(1);
		}
		System.setProperty("java.security.policy","HelloClient.policy");
		try {
			UnoInterface uno = (UnoInterface) Naming.lookup ("//"+args[0]+"/Hello");
			System.out.println (uno.say());
		} catch (Exception e) {
			System.out.println ("HelloClient failed:");
			e.printStackTrace();
		}
	}
}

