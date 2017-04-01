package test.machine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import FileReader.FileReaderTXT;
import machine.TuringMachine;

public class FileReaderTest {

	LinkedList<String> initialInput;
	FileReaderTXT fr;
	
	@Before
	public void setUp() throws Exception {
		fr = new FileReaderTXT("machine.txt");
		String input = "1001001";
		createInput(input);
		

	}
	
	public void createInput(String input){
		initialInput = new LinkedList<>();
		for (int i = 0; i < input.length(); i++){
			initialInput.add(input.substring(i, i + 1));
		}
		
	}

	@Test
	public void test() throws Exception {
		TuringMachine machine = fr.getMachine();
		machine.setInitialInput(initialInput);
		
		machine.run();
		assertEquals("[_, _, _, _, _, _, _, _]", machine.getTape().toString()); // 1100001
		assertTrue(machine.getCurrentState().isAcceptanceState()); 
	

	}
	
	@Test
	public void test2() throws Exception {
		TuringMachine machine = fr.getMachine(5);


		machine.setInitialInput(initialInput);
		machine.run();
		assertEquals("[1, 0, 0, 1, 0, _, 1, _]", machine.getTape().toString());
		assertFalse(machine.getCurrentState().isAcceptanceState());
	} 
	
	@Test
	public void testTreta() throws Exception{
		fr = new FileReaderTXT("machine2.txt");
		String input = "10110";
		createInput(input);
 
		TuringMachine machine = fr.getMachine(0);
		machine.setInitialInput(initialInput);
		machine.run();
		assertEquals("[_, 2, 2, _, _, _, _, _, _, _]", machine.getTape().toString());
		//System.out.println(machine.getTape());
	}

	@Test
	public void testBinaryAddition() throws Exception{
		fr = new FileReaderTXT("machine3.txt");
		String input = "110110_101011";
		createInput(input);
		
		TuringMachine machine = fr.getMachine(0);
		machine.setInitialInput(initialInput);
		machine.run();
		assertEquals("[_, 1, 1, 0, 0, 0, 0, 1, _, _, _, _, _, _, _, _]", machine.getTape().toString());
	}
	
	public void testParenthesesChecker() throws Exception {
		fr = new FileReaderTXT("machine4.txt");
		String input = "12(2+(3^(4-1)))";
		createInput(input);
		
		TuringMachine machine = fr.getMachine(0);
		machine.setInitialInput(initialInput);
		machine.run();
		assertTrue(machine.getCurrentState().isAcceptanceState());
	}
}
