package view;

import java.util.Scanner;

import Controller.Controller;

public class View {
	public static Scanner in = new Scanner(System.in);
	
	private static Controller controller;
	
	public View() {
		View.controller = new Controller();
	}
	
	public static void main(String[] args) throws Exception {
		int opcao;
		
		do {
			System.out.println("Digite sua opção:");
			System.out.println("1 - Para usar um dos nossos exemplos de máquina de Turing");
			System.out.println("2 - Para usar sua própria máquina de Turing");
			System.out.println("3 - Encerrar");
			
			System.out.print("Opção: ");
			opcao = in.nextInt();
			
			switch (opcao) {
			case 1:
				exampleMachine();
			
			case 2:
				
			case 3:
				break;
				
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
			
		} while (opcao != 3);
	}
	
	private static void exampleMachine() throws Exception {
		System.out.println("Digite a opção correspondente a máquina:");
		System.out.println("1 - Palíndromo binário");
		System.out.println("2 - Conversor de binário para decimal");
		System.out.println("3 - Adição binária");
		System.out.println("4 - Checa parênteses");
		
		System.out.print("Opção: ");
		int opcao = in.nextInt();
		
		switch (opcao) {
		case 1:
			controller.readFile("machine.txt");
			controller.createMachineFromFile();
			break;
			
		case 2:
			controller.readFile("machine2.txt");
			controller.createMachineFromFile();
			break;
			
		case 3:
			controller.readFile("machine3.txt");
			controller.createMachineFromFile();
			break;
			
		case 4:
			controller.readFile("machine4.txt");
			controller.createMachineFromFile();
			break;
		}
		
		System.out.println("Digite 1 se você quer ver a máquina executar passo a passo.");
		System.out.println("Caso contrário, digite 2.");
		
		String op = in.nextLine();
		
		if (op.equals("1"))
			runMachineStepByStep();
			
		else
			runMachine();
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
