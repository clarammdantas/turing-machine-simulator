package Controller;

import java.util.ArrayList;

import FileReader.FileReaderTXT;
import machine.TuringMachine;
import machine.TuringState;

public class Controller {

	TuringMachine machine;
	FileReaderTXT fileReader;
	
	public void readFile(String fileName) throws Exception {
		fileReader = new FileReaderTXT(fileName);
	}
	
	public void createMachineFromFile() throws Exception {
		this.machine = fileReader.getMachine();
	}
	
	public void createMachineFromFile(int starter) throws Exception {
		this.machine = fileReader.getMachine(starter);
	}
	
	public void machineRun() throws Exception {
		machine.run();
	}
	
	public void machineNextStep() throws Exception{
		machine.nextStep();
	}
	
	public void machineReset() {
		machine.reset();
	}
	
	public int getMachineHeadPosition() {
		return machine.getHeadPosition();
	}
	
	public TuringState getCurrentMachineState() {
		return machine.getCurrentState();
	}
	
	public String getMachineTape() {
		return machine.getTape().toString();
	}
	
	public void setMachineInitialInput(ArrayList<String> initialInput) {
		machine.setInitialInput(initialInput);
	}
}
