package test.machine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import FileReader.FileReaderTXT;
import machine.TuringMachine;

public class FileReaderTest {

	ArrayList<String> initialInput;
	FileReaderTXT fr;
	
	@Before
	public void setUp() throws Exception {
		fr = new FileReaderTXT("machine.txt");

		initialInput = new ArrayList<>();
		initialInput.add("_");
		initialInput.add("1");
		initialInput.add("0");
		initialInput.add("0");
		initialInput.add("1");
		initialInput.add("0");
		initialInput.add("0");
		initialInput.add("1");
		initialInput.add("_");

	}

	@Test
	public void test() throws Exception {
		TuringMachine machine = fr.getMachine();
		machine.setInitialInput(initialInput);
		
		machine.run();
		assertEquals("[_, _, _, _, _, _, _, _, _]", machine.getTape().toString());
		assertTrue(machine.getCurrentState().isAcceptanceState());

	}
	
	@Test
	public void test2() throws Exception {
		TuringMachine machine = fr.getMachine(5);


		machine.setInitialInput(initialInput);
		machine.run();
		assertEquals("[_, 1, 0, 0, 1, _, 0, 1, _]", machine.getTape().toString());
		assertFalse(machine.getCurrentState().isAcceptanceState());
	}
}
