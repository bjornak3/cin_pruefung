package at.technikumwien;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.junit.Assert.assertEquals;

@Category(IntegrationTest.class)
public class CalculatorServletTest {
	// TODO 3 sinnvolle Integrationstests mittels HttpUnit erg�nzen

    private ServletRunner runner;
    private ServletUnitClient client;

    @Before
    public void setUp(){
        runner = new ServletRunner();
        runner.registerServlet("calculator", CalculatorServlet.class.getName());

        client = runner.newClient();
    }


    @Test
    public void testSumme() throws Exception{
        WebRequest request = new GetMethodWebRequest("http://test.meterware.com/calculator");

        request.setParameter("operand1", "2");
        request.setParameter("operand2", "3");
        System.out.println(request);
        WebResponse response = client.getResponse(request);
       assertEquals("Summe: 5", response.getText() );
    }

    @Test (expected = NumberFormatException.class)
    public void testUnsupportedOperand() throws Exception{
        WebRequest request = new GetMethodWebRequest("http://test.meterware.com/calculator");
        request.setParameter("operand1", "abc");

        WebResponse response = client.getResponse(request);
    }

    @Test (expected = NumberFormatException.class)
    public void testEmptyRequest() throws Exception{
        WebRequest request = new GetMethodWebRequest("http://test.meterware.com/calculator");

        WebResponse response = client.getResponse(request);

    }
}
