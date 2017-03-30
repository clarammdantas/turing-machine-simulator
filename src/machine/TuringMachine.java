package machine;

import java.util.ArrayList;


public class TuringMachine {
	private TuringState currentState;
	private ArrayList<String> tape;
	private ArrayList<String> initialInput;
	private int headPosition;
	private int initialPosition;
	private TuringState initialState;
	
	public TuringMachine(ArrayList<String> initialInput, int initialPosition, TuringState initialState){
		this.tape = initialInput;
		this.headPosition = initialPosition;
		this.currentState = initialState;
		this.initialPosition = initialPosition;
		this.initialState = initialState;
		this.initialInput = initialInput;
		
	}
	
	
	public void nextStep(){
		
		TuringState nextState = currentState.getAdjacency(tape.get(headPosition));
		String[] action = currentState.getAction(tape.get(headPosition)).split(" ");
		String direction = action[0];
		String newSymbol = action[1];
		
		if (!newSymbol.equals("*")) // * signfica nao mudar a fita
			tape.set(headPosition, newSymbol);
		
		if (direction.equals("r")){
			headPosition++;
		}else if (direction.equals("l")){
			headPosition--;
		}
		
		this.currentState = nextState;
	}
	
	public void run(){
		while (!currentState.isAcceptanceState() && !currentState.isGarbageState()){
			this.nextStep();
		}
	}
	
	public void reset(){
		this.tape = initialInput;
		this.headPosition = initialPosition;
		this.currentState = initialState;
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
	
	public void setInitialInput(ArrayList<String> initialInput) {
		this.tape = initialInput;
	}
}