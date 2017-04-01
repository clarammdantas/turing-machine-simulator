package FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import machine.TuringMachine;
import machine.TuringState;

public class FileReaderTXT {

	
	HashMap<String, TuringState> machine;
	private String fileName;

	/**
	 *  Constructor that receive filename and initialize FileReader
	 * @param fileName
	 */
	public FileReaderTXT(String fileName) {
		machine = new HashMap<>();
		this.fileName = fileName;
	}

	/**
	 * This method read an txt file and create states from Turing Machine
	 * @throws Exception 
	 */
	public void readState() throws Exception {
		if(!verifyMap()) {
			throw new Exception("machine map wasn't intialized");
		}
		
		BufferedReader file = new BufferedReader(
				new FileReader(
						new File(this.fileName)));
		
		String line;

		while((line = file.readLine()) != null) {
			if(!line.matches("^;.*") && !line.isEmpty()) {
				createState(line, machine);
			}
		}
		
		file.close();
	}
	
	/**
	 * this method create a state from string and put into hashmap
	 * @param line, machine
	 */
	private void createState(String line, HashMap<String, TuringState> machine) {
		String stateName = line.split(" ")[0];

		if(!machine.containsKey(stateName)) {
			if(stateName.equals("accept")) {
				machine.put(stateName, new TuringState(true, false));
			} else if(stateName.equals("reject")) {
				machine.put(stateName, new TuringState(false, true));
			} else {
				machine.put(stateName, new TuringState(false, false));
			}
		}
	}

	/**
	 *  This method read txt file, identify state and create your respective adjacency
	 * @throws IOException
	 */
	public void readAdjacency() throws IOException {
		BufferedReader file = new BufferedReader(
				new FileReader(
						new File(this.fileName)));
		
		String line;

		while((line = file.readLine()) != null) {
			if(!line.matches("^;.*") && !line.isEmpty()) {
				createAdjacency(line, machine);
			}
		}
		
		file.close();
	}

	/**
	 * this method create a adjacency from String received, into your respective state
	 * @param line
	 * @param machine
	 */
	private void createAdjacency(String line, HashMap<String, TuringState> machine) {
		String[] listStr = line.split(" ");
		
		machine.get(listStr[0]).
			addAdjacency(listStr[1], listStr[2], listStr[3], machine.get(listStr[4]));
	}

	/**
	 * return a machine from file readed and starting from position 1. 
	 * OBS: this file doesn't have tape(initialInput), you should set.
	 * @return
	 * @throws Exception 
	 */
	public TuringMachine getMachine() throws Exception {
		readState();
		readAdjacency();
		return new TuringMachine(null, 0, machine.get("0"));
	}
	
	
	/**
	 * return a machine from file readed and starting from position starter
	 * @param starter
	 * @return
	 * @throws Exception
	 */
	public TuringMachine getMachine(int starter) throws Exception {
		readState();
		readAdjacency();
		return new TuringMachine(null, starter, machine.get("0"));
	}

	/**
	 *  this method verify if machine map variable was initialized. 
	 * @return true if it was initialized or false if is null
	 */
	public boolean verifyMap() {
		if(this.machine == null) {
			return false;
		} else return true;
	}
}
