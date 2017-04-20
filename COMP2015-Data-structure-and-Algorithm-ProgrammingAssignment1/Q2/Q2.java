import java.util.Scanner;

public class Q2 {
	@SuppressWarnings("serial")
	class InputException extends Exception {
	}

	public static void menu() {
		System.out.println("\nCommands");
		System.out.println("========");
		System.out.println("Insert a character.");
		System.out.println("	command: insert {character}");
		System.out.println("	e.g.: insert A\n");

		System.out.println("Delete a specific character.");
		System.out.println("	command: delete {character}");
		System.out.println("	e.g.: delete M\n");

		System.out.println("Build an AVL tree.");
		System.out.println("	command: build {a set of characters separated by whitespaces}\n");
		System.out.println("	e.g.: build S P I D E R M A N\n");

		System.out.println("Output a pre-order traversal string.");
		System.out.println("	command: preorder\n");

		System.out.println("Quit this program.");
		System.out.println("	command: quit\n");
	}
	
	public Q2() {
		
		Tree tree = new Tree();
		
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		String command;
		String[] substr;

		System.out.println("Type 'help' to get command menu.");

		while (running) {
			try {
				System.out.print("\ncommand> ");
				command = scanner.nextLine().trim();
				if (command.charAt(0) == '+' || command.charAt(0) == '-')
					command = command.charAt(0) + " " + command.substring(1).trim();
				substr = command.split(" ");
				switch (substr[0].toLowerCase()) {
				case "insert":
					if (substr.length != 2)
						throw new InputException();
					
					tree.insert(substr[1]);
					break;
				case "delete":
					if (substr.length != 2)
						throw new InputException();
					
					tree.delete(substr[1]);
					break;

				case "build":
					if (substr.length < 2)
						throw new InputException();

					tree.root = tree.buildAVL(command.substring(substr[0].length() + 1));
					break;
				case "preorder":
					System.out.println(tree.preorder());
					break;
				case "quit":
					running = false;
					break;
				case "help":
					menu();
					break;
				default:
					throw new InputException();
				}
			} catch (NumberFormatException|InputException ex) {
				System.out.println("Invalid command! Type 'help' to get command menu.");
			}
		}
		scanner.close();
	}
	
	public static void main(String[] args) {
		new Q2();
	}

}
