package view;

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

			case "2":

			case "3":
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}

		} while (opcao != "3");
	}

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

		
		
		if (op.equals("1")) {
			System.out.println("Aperte enter para executar próximo passo!");
			String continua;
			continua = in.nextLine();
			
			while(continua.isEmpty() && !controller.isAcceptanceState() && !controller.isGarbageState()) {
				controller.machineNextStep();
				continua = in.nextLine();
			}
			
		} else {
			controller.machineRun();
		}
		
		if(controller.isAcceptanceState()) System.out.println("turing decidível :D"+ line);
		else if(controller.isGarbageState()) System.out.println("turing decidível :("+line);
	}

	private static void runMachine() {
		System.out.print("Digite a palavra: ");
		String input = in.nextLine();

		controller.setMachineInitialInput(input);
	}

	private static void runMachineStepByStep() {
		System.out.println("Digite a palavra: ");
		String input = in.nextLine();

		controller.setMachineInitialInput(input);


	}

	private void userMachine() {
		System.out.println("Escreva a localização do programa da sua máquina:");


	}
}
