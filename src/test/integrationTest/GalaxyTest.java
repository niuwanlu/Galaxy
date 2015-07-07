import com.galaxy.GalaxyManager;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GalaxyTest {

    @Test
    public void main() {
        GalaxyManager galaxyManager = new GalaxyManager();
        galaxyManager.processInput("glob is I");
        galaxyManager.processInput("prok is V");
        galaxyManager.processInput("pish is X");
        galaxyManager.processInput("tegj is L");
        galaxyManager.processInput("glob glob Silver is 34 Credits");
        galaxyManager.processInput("glob prok Gold is 57800 Credits");
        galaxyManager.processInput("pish pish Iron is 3910 Credits");
        assertEquals("glob glob is 2", galaxyManager.processInput("how much is glob glob?"));
        assertEquals("pish pish is 20", galaxyManager.processInput("how much is pish pish?"));
        assertEquals("glob prok is 4", galaxyManager.processInput("how much is glob prok?"));
        assertEquals("pish tegj glob glob is 42", galaxyManager.processInput("how much is pish tegj glob glob?"));
        assertEquals("glob prok Silver is 68 Credits", galaxyManager.processInput("how many Credits is glob prok Silver ?"));
        assertEquals("glob prok Gold is 57800 Credits", galaxyManager.processInput("how many Credits is glob prok Gold ?"));
        assertEquals("glob prok Iron is 782 Credits", galaxyManager.processInput("how many Credits is glob prok Iron ?"));
        assertEquals("I have no idea what you are talking about", galaxyManager.processInput("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
    }
}