/*Steven Prine
* CSC-346
* Prof.Noynaert
*/



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void haversine() {
        assertEquals(941.1, Main.haversine(50.03, 05.42,58.38,03.04), 1);
        assertEquals(2910, Main.haversine(22.25, 50.45, 22.36, 22.12) ,  1);
        assertEquals(157, Main.haversine(5 , -5, 4, -4) ,  1);
        assertEquals(1234, Main.haversine(10, -10, 20, -15) ,  1);
        assertEquals(628.9, Main.haversine(2, 2, -2, -2) ,  1);
    }

    @Test
    void miles() {
        //Converting Miles to Kilolmeters
        assertEquals(1, Main.miles(1.60934), 2);
        assertEquals(2, Main.miles(3.21), 2);
        assertEquals(3, Main.miles(4.82), 2);
        assertEquals(4, Main.miles(6.43), 2);
        assertEquals(50, Main.miles(80.46), 2);
    }

    @Test
    void kilometers() {
        //Converting Kilometers to Miles
        assertEquals(3, Main.kilometers(1.86), 2);
        assertEquals(5, Main.kilometers(3.10),2 );
        assertEquals(10, Main.kilometers(6.21),2 );
        assertEquals(50, Main.kilometers(31.06),2 );
        assertEquals(150, Main.kilometers(93.20),2 );
    }
}