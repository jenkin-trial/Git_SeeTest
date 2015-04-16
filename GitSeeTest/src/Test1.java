
//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
 *
*/
public class Test1 {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\pallavi.snehal\\workspace\\project2";
    protected Client client = null;

    @Before
    public void setUp(){
        client = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "CitiBankDemo");
    }

    @Test
    public void testCitiBankDemo(){
        client.setDevice("adb:GT-I9500 (1)");
        client.launch("com.citiuat/.mobeix", true, false);
        client.sleep(3000);
        client.verifyElementFound("NATIVE", "xpath=//*[@class='com.mobeix.ui.ButtonUI']", 4);
        client.click("NATIVE", "xpath=//*[@class='com.mobeix.ui.ButtonUI']", 4, 1);
        client.sleep(2000);
        client.verifyElementFound("NATIVE", "xpath=//*[@class='com.mobeix.ui.ButtonUI']", 0);
        client.click("NATIVE", "xpath=//*[@class='com.mobeix.ui.ButtonUI']", 0, 1);
        client.sleep(3000);
        client.verifyElementFound("NATIVE", "xpath=//*[@text='By Location']", 0);
        client.sleep(2000);
        client.click("NATIVE", "xpath=//*[@text='By Location']", 0, 1);
        client.sleep(3000);
        client.verifyElementFound("NATIVE", "xpath=//*[@text='Bengaluru']", 0);
        client.click("NATIVE", "xpath=//*[@text='Bengaluru']", 0, 1);
        client.sleep(3000);
        client.verifyElementFound("NATIVE", "xpath=//*[@text='Shopping']", 0);
        client.click("NATIVE", "xpath=//*[@text='Shopping']", 0, 1);
        client.sleep(3000);
        client.verifyElementFound("NATIVE", "xpath=//*[@text='Vibes Healthcare- Koramangla']", 0);
        client.click("NATIVE", "xpath=//*[@text='Vibes Healthcare- Koramangla']", 0, 1);
        client.sleep(3000);
        client.verifyElementFound("NATIVE", "xpath=//*[@class='com.mobeix.ui.cl']", 0);
        client.click("NATIVE", "xpath=//*[@class='com.mobeix.ui.cl']", 0, 1);
        if(client.applicationClose("com.citiuat")){
            // If statement
        }
    }

    @After
    public void tearDown(){
        client.generateReport(true);
    }
}
