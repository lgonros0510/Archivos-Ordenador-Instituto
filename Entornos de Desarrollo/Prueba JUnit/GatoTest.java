import org.junit.*;

public class GatoTest {

    @Test

    public void test() {

        Gato tom = new Gato();

        Assert.assertEquals("Mia", tom.habla());

    }
}