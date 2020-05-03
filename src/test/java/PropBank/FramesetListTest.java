package PropBank;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class FramesetListTest {
    FramesetList framesetList;

    @Before
    public void setUp()  {
        framesetList = new FramesetList();
    }

    @Test
    public void testFrames() {
        assertEquals(17691, framesetList.size());
    }

    @Test
    public void testArgSize() {
        int count = 0;
        for (int i = 0; i < framesetList.size(); i++){
            count += framesetList.getFrameSet(i).getFramesetArguments().size();
        }
        assertEquals(29759, count);
    }

    @Test
    public void testArgName() {
        HashMap<String, Integer> nameList = new HashMap<>();
        for (int i = 0; i < framesetList.size(); i++){
            for (FramesetArgument argument : framesetList.getFrameSet(i).getFramesetArguments()){
                if (nameList.containsKey(argument.getArgumentType())){
                    nameList.put(argument.getArgumentType(), nameList.get(argument.getArgumentType()) + 1);
                } else {
                    nameList.put(argument.getArgumentType(), 1);
                }
            }
        }
        assertEquals(14668, (int) nameList.get("ARG0"));
        assertEquals(13126, (int) nameList.get("ARG1"));
        assertEquals(1886, (int) nameList.get("ARG2"));
        assertEquals(78, (int) nameList.get("ARG3"));
        assertEquals(1, (int) nameList.get("ARG4"));
    }

    @Test
    public void testArgFunction() {
        HashMap<String, Integer> functionList = new HashMap<>();
        for (int i = 0; i < framesetList.size(); i++){
            for (FramesetArgument argument : framesetList.getFrameSet(i).getFramesetArguments()){
                if (functionList.containsKey(argument.getFunction())){
                    functionList.put(argument.getFunction(), functionList.get(argument.getFunction()) + 1);
                } else {
                    functionList.put(argument.getFunction(), 1);
                }
            }
        }
        assertEquals(481, (int) functionList.get("com"));
        assertEquals(14, (int) functionList.get("ext"));
        assertEquals(814, (int) functionList.get("loc"));
        assertEquals(198, (int) functionList.get("rec"));
        assertEquals(14, (int) functionList.get("pat"));
        assertEquals(10687, (int) functionList.get("ppt"));
        assertEquals(605, (int) functionList.get("src"));
        assertEquals(801, (int) functionList.get("gol"));
        assertEquals(156, (int) functionList.get("tmp"));
        assertEquals(14557, (int) functionList.get("pag"));
        assertEquals(1432, (int) functionList.get("dir"));
    }

}