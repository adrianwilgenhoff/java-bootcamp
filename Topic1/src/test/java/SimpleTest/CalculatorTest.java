/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleTest;

import com.mycompany.topic1.Calculator;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Adrian
 */
public class CalculatorTest {

    
    @Test
    public void testAdd(){
        
        assertEquals(5, Calculator.add(2, 3));
        
    }
    
}
