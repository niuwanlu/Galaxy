import com.galaxy.GalaxyManager;
import org.junit.Test;

public class GalaxyTest {

    @Test
    public void main() {
        GalaxyManager galaxyManager = new GalaxyManager();
        galaxyManager.processInput("glob is I");
        galaxyManager.processInput("pish is X");
        galaxyManager.processInput("how much is glob glob?");
        galaxyManager.processInput("how much is pish pish?");
    }
}