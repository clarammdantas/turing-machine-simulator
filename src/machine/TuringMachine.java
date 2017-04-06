package machine;

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
	
	
	/**
	 * Baseado no que é lido na fita a maquina de turing determina para qual estado ir
	 * Imprime o estado atual, estado da fita e a posição do cabeçote.
	 * @throws Exception
	 * 			Caso nao exista estado adjacente para o que foi lido na fita
	 */
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
	
	/**
	 * Executa o metodo nextStep ate que se chegue num estado de aceitacao ou de lixo
	 * @throws Exception
	 */
	public void run() throws Exception{
		while (!currentState.isAcceptanceState() && !currentState.isGarbageState()){
			this.nextStep();
		}
	}
	
	/**
	 * Reseta a fita para a entrada inicial e volta para o estado inicial
	 */
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
	
	public TuringState getCurrentState() throws CloneNotSupportedException{
		return this.currentState;
	}
	
	public void setInitialInput(LinkedList<String> initialInput) {
		this.tape = initialInput;
		if (this.initialInput == null)
			this.initialInput = initialInput;
	}
	
	public void setHeadPosition(int i){
		this.headPosition = i;
	}
	
	public void setState(TuringState state){
		this.currentState = state;
	}
	
	public boolean isAcceptanceState(){
		return this.currentState.isAcceptanceState();
	}
	
	public boolean isGarbageState(){
		return this.currentState.isGarbageState();
	}
}