package main;

import org.junit.Test;
import java.util.Scanner;
import static org.junit.Assert.*;

public class UnitTestConn4{

    @Test
    public void UnitTestConn4Horizontal() {
    	
    	// Checking horizontal lines
    	final int bSize = 3;
    	Conn4Model myUnit = new Conn4Model(bSize);
    	//Assigning the first horizontal line to all X
    	for (int i = 0; i <bSize ; i++)
    			myUnit.setSquare(0,i, 'X');
        assertEquals(true, myUnit.checkSolution(bSize));
    }
    
    @Test
    public void UnitTestConn4Vertical() {
    	
    	// Checking horizontal lines
    	final int bSize = 3;
    	Conn4Model myUnit = new Conn4Model(bSize);
    	//Assigning the first horizontal line to all X
    	for (int i = 0; i <bSize ; i++)
    			myUnit.setSquare(i,0, 'X');
        assertEquals(true, myUnit.checkSolution(bSize));
    }
    
    @Test
    public void UnitTestConn4Diag() {
    	
    	// Checking forward diagonal lines
    	final int bSize = 3;
    	Conn4Model myUnit = new Conn4Model(bSize);
    	//Assigning the first diagonal line to all X
    	for (int i = 0; i <bSize ; i++)
    		myUnit.setSquare(i,i, 'X');
        assertEquals(true, myUnit.checkSolution(bSize));
    }
    
    @Test
    public void UnitTestConn4RevDiag() {
    	
    	//Checking reverse diagonal lines
    	final int bSize = 3;
    	Conn4Model myUnit = new Conn4Model(bSize);
    	//Assigning the reverse diagonal line to all X
    	myUnit.setSquare(0,2, 'X');
    	myUnit.setSquare(1,1, 'X');
    	myUnit.setSquare(2,0, 'X');
        assertEquals(true, myUnit.checkSolution(bSize));
    }
    @Test
    public void UnitTestConn4RevDiagBAD() {
    	
    	//Checking reverse diagonal lines
    	final int bSize = 3;
    	Conn4Model myUnit = new Conn4Model(bSize);
    	//expecting false from check solution
    	myUnit.setSquare(0,2, 'O');
    	myUnit.setSquare(1,1, 'X');
    	myUnit.setSquare(2,0, 'X');
        assertEquals(true, myUnit.checkSolution(bSize));
    }
    
    
}
    
    
    
    
    

        
   
