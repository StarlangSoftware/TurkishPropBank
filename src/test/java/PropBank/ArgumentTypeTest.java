package PropBank;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArgumentTypeTest {

    @Test
    public void testArgumentType() {
        assertEquals(ArgumentType.getArguments("arg0"), ArgumentType.ARG0);
        assertEquals(ArgumentType.getArguments("argmdis"), ArgumentType.ARGMDIS);
        assertEquals(ArgumentType.getArguments("Arg1"), ArgumentType.ARG1);
        assertEquals(ArgumentType.getArguments("Argmdir"), ArgumentType.ARGMDIR);
    }

}
