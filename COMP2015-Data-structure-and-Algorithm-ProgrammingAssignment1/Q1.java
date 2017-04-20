import java.util.Scanner;

public class Q1 {
	@SuppressWarnings("serial")
	class InputException extends Exception {
	}
	
	public static void menu() {
		System.out.println("\nCommands");
		System.out.println("========");
		System.out.println("Append a number at the end of the list.");
		System.out.println("	command: append {number}");
		System.out.println("	e.g.: append 10\n");
		System.out.println("Insert a number in the specific position of the list.");
		System.out.println("	command: insert {number} {position}");
		System.out.println("	e.g.: insert 8 2\n");

		System.out.println("Get the position of a specific number stored in the list.");
		System.out.println("	command: find {number}");
		System.out.println("	e.g.: find 7\n");

		System.out.println("Delete a specific number from the list.");
		System.out.println("	command: delete {number}");
		System.out.println("	e.g.: delete 7\n");

		System.out.println("Get the status of the list.");
		System.out.println("	command: status\n");

		System.out.println("Print the sequence numbers stored in the list.");
		System.out.println("	command: traversal\n");

		System.out.println("Print the numbers stored in the array.");
		System.out.println("	command: printArr\n");

		System.out.println("Quit this program.");
		System.out.println("	command: quit\n");
	}

	public Q1() {
		MyList list = new MyList(5);
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		String command;
		String[] substr;

		System.out.println("Type 'help' to get command menu.");

		while (running) {
			try {
				System.out.print("\ncommand> ");
				command = scanner.nextLine().trim();
				substr = command.split(" ");
				switch (substr[0].toLowerCase()) {
				case "append":
					if (substr.length != 2)
						throw new InputException();
					
					if (!list.append(Integer.parseInt(substr[1])))
						System.out.println("Fail to append!");
					break;
				case "insert":
					if (substr.length != 3)
						throw new InputException();

					if (!list.insert(Integer.parseInt(substr[1]), Integer.parseInt(substr[2])))
						System.out.println("Fail to insert!");
					break;
				case "delete":
					if (substr.length != 2)
						throw new InputException();

					if (!list.delete(Integer.parseInt(substr[1])))
						System.out.println("Fail to delete!");
					break;
				case "find":
					if (substr.length != 2)
						throw new InputException();

					System.out.println("position is " + list.find(Integer.parseInt(substr[1])));
					break;
				case "traversal":
					list.traversal();
					break;
				case "status":
					System.out.println(list.status());
					break;
				case "printarr":
					list.printArray();
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
		new Q1();
	}
}
