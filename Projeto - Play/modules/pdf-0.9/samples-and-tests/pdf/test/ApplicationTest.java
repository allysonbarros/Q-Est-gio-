<<<<<<< HEAD
import org.junit.Test;
import play.mvc.Http.Response;
import play.test.FunctionalTest;



public class ApplicationTest extends FunctionalTest {
  @Test
  public void testThatIndexPageWorks() {
    Response response = GET("/");
    
    assertIsOk(response);
    assertContentType("text/html", response);
    assertCharset(play.Play.defaultWebEncoding, response);
  } 
=======
import org.junit.Test;
import play.mvc.Http.Response;
import play.test.FunctionalTest;



public class ApplicationTest extends FunctionalTest {
  @Test
  public void testThatIndexPageWorks() {
    Response response = GET("/");
    
    assertIsOk(response);
    assertContentType("text/html", response);
    assertCharset(play.Play.defaultWebEncoding, response);
  } 
>>>>>>> e8d293a3969a08f5bef6b755b900379480bfc5e2
}