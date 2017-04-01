package machine;

import java.util.ArrayList;
import java.util.LinkedList;


public class TuringMachine {
	private TuringState currentState;
	private LinkedList<String> tape;
	private LinkedList<String> initialInput;
	private int headPosition;
	private int initialPosition;
	private TuringState initialState;
	
	public TuringMachine(LinkedList<String> initialInput, int initialPosition, TuringState initialState){
		this.tape = initialInput;
		this.headPosition = initialPosition;
		this.currentState = initialState;
		this.initialPosition = initialPosition;
		this.initialState = initialState;
		this.initialInput = initialInput;
		
	}
	
	
	public void nextStep() throws Exception{
		
		TuringState nextState = currentState.getAdjacency(tape.get(headPosition));
		String[] action = currentState.getAction(tape.get(headPosition)).split(" ");
		String direction = action[0];
		String newSymbol = action[1];
		
		if (!newSymbol.equals("*")) // * signfica nao mudar a fita
			tape.set(headPosition, newSymbol);
		
		if (direction.equals("r")){
			headPosition++;
			if (headPosition >= tape.size()){
				this.tape.add("_");
			}
		}else if (direction.equals("l")){
			headPosition--;
			if (headPosition == -1){
				this.tape.addFirst("_");
				headPosition = 0;
			}
		}
		
		this.currentState = nextState;
	}
	
	public void run() throws Exception{
		while (!currentState.isAcceptanceState() && !currentState.isGarbageState()){
			this.nextStep();
		}
	}
	
	public void reset(){
		this.tape = initialInput;
		this.headPosition = initialPosition;
		this.currentState = initialState;
	}
	
	public LinkedList<String> getTape(){
		return this.tape;
	}
	
	public int getHeadPosition(){
		return this.headPosition;
	}
	
	public TuringState getCurrentState(){
		return this.currentState;
	}
	
	public void setInitialInput(LinkedList<String> initialInput) {
		this.tape = initialInput;
	}
}