import com.galaxy.GalaxyManager;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GalaxyTest {

    @Test
    public void main() {
        GalaxyManager galaxyManager = new GalaxyManager();
        galaxyManager.processInput("glob is I");
        galaxyManager.processInput("pork is V");
        galaxyManager.processInput("pish is X");
        galaxyManager.processInput("tegj is L");
        assertEquals("glob glob is 2", galaxyManager.processInput("how much is glob glob?"));
        assertEquals("pish pish is 20", galaxyManager.processInput("how much is pish pish?"));
        assertEquals("glob pork is 4", galaxyManager.processInput("how much is glob pork?"));
        assertEquals("pish tegj glob glob is 42", galaxyManager.processInput("how much is pish tegj glob glob?"));
    }
}