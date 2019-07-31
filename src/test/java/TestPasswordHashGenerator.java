import org.junit.Assert;
import org.junit.Test;
import util.PasswordHashGenerator;

public class TestPasswordHashGenerator {

    @Test
    public void testGetHash () throws Exception{
        String misha = PasswordHashGenerator.getCode("misha");
        byte[] bytes = "80e429465933609a76edaaa07f8e859cd4ff54e3aec07fc00d1220d333178ed3".getBytes();
        Assert.assertArrayEquals(bytes,misha.getBytes());
    }
}
