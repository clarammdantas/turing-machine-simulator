package machine;

import java.util.ArrayList;
import java.util.HashMap;

import state.TuringState;

public class TuringMachine {
	private TuringState currentState;
	private ArrayList<String> tape;
	private int headPosition;
	private HashMap<String, TuringState> states;
	
	public TuringMachine(ArrayList<String> initialInput, int initialPosition, HashMap<String, TuringState> states){
		this.tape = initialInput;
		this.headPosition = initialPosition;
		this.states = states;
		this.currentState = states.get("0"); // Estado inicial será sempre 0
	}
	
	public void nextStep(){
		TuringState nextState = currentState.getAdjacency(tape.get(headPosition));
		String[] action = currentState.getAction(tape.get(headPosition)).split(" ");
		String direction = action[0];
		String newSymbol = action[1];
		
		tape.set(headPosition, newSymbol);
		if (direction.equals("r")){
			headPosition++;
		}else if (direction.equals("l")){
			headPosition--;
		}
		
		this.currentState = nextState;
	}
	
	public ArrayList<String> getTape(){
		return this.tape;
	}
	
	public int getHeadPosition(){
		return this.headPosition;
	}
	
	public TuringState getCurrentState(){
		return this.currentState;
	}
}