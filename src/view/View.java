package view;

import javax.swing.JFileChooser;
import java.util.Scanner;

import Controller.Controller;

public class View {
	private static final String line = System.getProperty("line.separator").toString();
	public static Scanner in = new Scanner(System.in);

	private static Controller controller;

	public View() {
		View.controller = new Controller();
	}


	public static void main(String[] args) throws Exception {
		View view = new View();

		String opcao;

		do {
			System.out.println("Digite sua opção:");
			System.out.println("1 - Para usar um dos nossos exemplos de máquina de Turing");
			System.out.println("2 - Para usar sua própria máquina de Turing");
			System.out.println("3 - Encerrar");

			System.out.print("Opção: ");
			opcao = in.nextLine();

			switch (opcao) {
			case "1":
				view.exampleMachine();
				break;

			case "2":
				view.userMachine();
				break;

			case "3":
				opcao = "3";
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}

		} while (opcao != "3");
	}

	/**
	 * Roda alguma das máquinas de exemplo.
	 * @throws Exception
	 */
	private void exampleMachine() throws Exception {
		System.out.println("Digite a opção correspondente a máquina:");
		System.out.println("1 - Palíndromo binário");
		System.out.println("2 - Conversor de binário para decimal");
		System.out.println("3 - Adição binária");
		System.out.println("4 - Checa parênteses");

		System.out.print("Opção: ");
		String opcao = in.nextLine();

		switch (opcao) {
		case "1":
			controller.readFile("machine.txt");
			controller.createMachineFromFile();
			break;

		case "2":
			controller.readFile("machine2.txt");
			controller.createMachineFromFile();
			break;

		case "3":
			controller.readFile("machine3.txt");
			controller.createMachineFromFile();
			break;

		case "4":
			controller.readFile("machine4.txt");
			controller.createMachineFromFile();
			break;
		}

		System.out.println("Digite a palavra: ");
		controller.setMachineInitialInput(in.nextLine());

		System.out.println("Digite 1 se você quer ver a máquina executar passo a passo.");
		System.out.println("Caso contrário, digite 2.");

		String op = in.nextLine();

		runOrStep(op);
	}

	/**
	 * Roda a máquina do usuário.
	 * @throws Exception
	 */
	private void userMachine() throws Exception {
		System.out.println("Escolha o arquivo correspondente a maquina que você deseja executar.");

		JFileChooser machinePath = new JFileChooser();
		machinePath.showOpenDialog(null);

		controller.readFile(machinePath.getSelectedFile().getAbsolutePath());
		controller.createMachineFromFile();

		System.out.println("Digite a palavra: ");
		controller.setMachineInitialInput(in.nextLine());
		
		System.out.println("Digite 1 se você quer ver a máquina executar passo a passo.");
		System.out.println("Digite 2 se você quer executar run");

		String op = in.nextLine();

		runOrStep(op);
	}

	/**
	 * Executa a máquina de uma só vez ou passo a passo.
	 * @param op
	 * @throws Exception
	 */
	private void runOrStep(String op) throws Exception {
		controller.printMachine();
		if (op.equals("1")) {
			System.out.println("Aperte enter para executar próximo passo!");
			System.out.println("Digite undo para voltar para o passo anterior.");
			String continua;
			continua = in.nextLine();

			boolean flagUndo = false;

			while(!controller.isAcceptanceState() && !controller.isGarbageState()) {


				if (flagUndo && continua.equals("undo")) {
					controller.undo();
				}

				else if(continua.isEmpty()) {
					flagUndo = true;
					controller.machineNextStep();
				} else {
					System.out.println("Comando invalido. Pressione enter para próximo passo ou digite undo, caso queira voltar passo anterior");
				}

				continua = in.nextLine();
			}

		} else if(op.equals("2")) {
			controller.machineRun();
		} else {
			System.out.println("Você digitou opção inexistente, voltará para o início");
		}

		if(controller.isAcceptanceState()) System.out.println("turing decidível :D"+ line);
		else if(controller.isGarbageState()) System.out.println("turing decidível :("+line);

	}
}
