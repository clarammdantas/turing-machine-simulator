package test.machine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

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
		assertEquals("[_, _, _, _, _, _, _, _, _]", machine.getTape().toString()); // 1100001
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
	
	@Test
	public void testTreta() throws Exception{
		fr = new FileReaderTXT("machine2.txt");
		initialInput = new ArrayList<>();
		//10110
		initialInput.add("_");
		initialInput.add("_");
		initialInput.add("_");
		initialInput.add("_");
		initialInput.add("_");
		initialInput.add("_");
		initialInput.add("1");
		initialInput.add("0");
		initialInput.add("1");
		initialInput.add("1");
		initialInput.add("0");
		initialInput.add("_"); 
		initialInput.add("_");
		initialInput.add("_");
		initialInput.add("_");
		initialInput.add("_");
		initialInput.add("_");
		
		TuringMachine machine = fr.getMachine(6);
		machine.setInitialInput(initialInput);
		machine.run();
		System.out.println(machine.getTape());
		
		/*initialInput.add("_");
		initialInput.add("1");
		initialInput.add("1");
		initialInput.add("0");
		initialInput.add("1");
		initialInput.add("1");
		initialInput.add("0");
		initialInput.add("_");
		initialInput.add("1");
		initialInput.add("0");
		initialInput.add("1");
		initialInput.add("0");
		initialInput.add("1");
		initialInput.add("1");
		initialInput.add("_"); */
	}

}
