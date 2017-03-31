package test.machine;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import machine.*;

public class TuringMachineTest {

	@Test
	public void test() throws Exception {
		TuringState q0 = new TuringState(false, false);
		TuringState qo = new TuringState(false, false);
		TuringState qi = new TuringState(false, false);
		TuringState q2o = new TuringState(false, false);
		TuringState q2i = new TuringState(false, false);
		TuringState q3 = new TuringState(false, false);
		TuringState q4 = new TuringState(false, false);
		TuringState acc = new TuringState(true, false);
		TuringState rej = new TuringState(false, true);
		
		q0.addAdjacency("0", "_", "r", qo);
		q0.addAdjacency("1", "_", "r", qi);
		q0.addAdjacency("_", "_", "*", acc);
		
		qo.addAdjacency("_", "_", "l", q2o);
		qo.addAdjacency("*", "*", "r", qo);
		
		qi.addAdjacency("_", "_", "l", q2i);
		qi.addAdjacency("*", "*", "r", qi);
		
		q2o.addAdjacency("0", "_", "l", q3);
		q2o.addAdjacency("_", "_", "*", acc);
		q2o.addAdjacency("*", "*", "*", rej);
		
		q2i.addAdjacency("1", "_", "l", q3);
		q2i.addAdjacency("_", "_", "*", acc);
		q2i.addAdjacency("*", "*", "*", rej);
		
		q3.addAdjacency("_", "_", "*", acc);
		q3.addAdjacency("*", "*", "l", q4);
		
		q4.addAdjacency("*", "*", "l", q4);
		q4.addAdjacency("_", "_", "r", q0);
		
		// input = "1001001";
		ArrayList<String> initialInput = new ArrayList<>();
		initialInput.add("_");
		initialInput.add("1");
		initialInput.add("0");
		initialInput.add("0");
		initialInput.add("1");
		initialInput.add("0");
		initialInput.add("0");
		initialInput.add("1");
		initialInput.add("_");

		TuringMachine machine = new TuringMachine(initialInput, 1, q0);
		machine.run();
		assertEquals("[_, _, _, _, _, _, _, _, _]", machine.getTape().toString());
		assertTrue(machine.getCurrentState().isAcceptanceState());
		
		initialInput = new ArrayList<>();
		initialInput.add("_");
		initialInput.add("1");
		initialInput.add("0");
		initialInput.add("0");
		initialInput.add("_");
		
		machine = new TuringMachine(initialInput, 1, q0);
		machine.run();
		assertTrue(machine.getCurrentState().isGarbageState());
		
		//System.out.println(machine.getTape().toString());
		//System.out.println(machine.getCurrentState().isAcceptanceState());
	}

}
