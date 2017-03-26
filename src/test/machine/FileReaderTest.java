package test.machine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import FileReader.FileReaderTXT;
import machine.TuringMachine;

public class FileReaderTest {

	@Test
	public void test() throws Exception {
		FileReaderTXT fr= new FileReaderTXT("machine.txt");
		
		fr.readState();
		fr.readAdjacency();
		
		TuringMachine machine = fr.getMachine();
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
		
		machine.setInitialInput(initialInput);
		
		
		machine.run();
		assertEquals("[_, _, _, _, _, _, _, _, _]", machine.getTape().toString());
		assertTrue(machine.getCurrentState().isAcceptanceState());
	}
}
