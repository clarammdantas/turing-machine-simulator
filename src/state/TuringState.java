package state;
 
import java.util.HashMap;
 
public class TuringState {
	private boolean isAcceptanceState;
	private boolean isGarbageState;
	private HashMap<String, TuringState> adjacency;
 
	public TuringState(boolean isAcceptanceState, boolean isGarbageState){
		this.isAcceptanceState = isAcceptanceState;
		this.isGarbageState = isGarbageState;
	}
	
	public HashMap<String, TuringState> getAdjacency(){
		return this.adjacency;
	}
}
