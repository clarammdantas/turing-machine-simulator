package state;
 
import java.util.HashMap;
 
/**
 * Classe que representa um estado no diagrama da maquina.
 * @author JoaoCarvalho
 *
 */
public class TuringState {
	private boolean isAcceptanceState;
	private boolean isGarbageState;
	private HashMap<String, TuringState> adjacency;
	private HashMap<String, String> action;
  
	public TuringState(boolean isAcceptanceState, boolean isGarbageState){
		this.isAcceptanceState = isAcceptanceState;
		this.isGarbageState = isGarbageState;
		this.adjacency = new HashMap<>();
		this.action = new HashMap<> ();
	}
	
	public TuringState getAdjacency(String currentSymbol){
		return this.adjacency.get(currentSymbol);
	}

	/**
	 * Metodo para tornar dois estados adjacentes
	 * @param currentSymbol
	 * 			Simbolo que deve ser encontrado na fita para ir para o estado adjacente
	 * @param newSymbol
	 * 			Simbolo que deve ser escrito na fita
	 * @param direction
	 * 			Direção a ser tomada na fita r = right ; l = left ; * = no change
	 * @param newState
	 * 			Estado adjacente
	 */
	public void addAdjacency(String currentSymbol, String newSymbol, String direction, TuringState newState){
		adjacency.put(currentSymbol, newState);
		String action = direction + " " + newSymbol;
		this.action.put(currentSymbol, action);
	}
	
	public String getAction(String currentSymbol){
		if (this.action.containsKey(currentSymbol)){
			return this.action.get(currentSymbol);
		}else{
			return this.action.get("*"); // * pode ser usado como coringa pra "qualquer caractere"
		}
	}
	
}
