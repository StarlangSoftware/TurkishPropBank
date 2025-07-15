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
        assertEquals(17692, framesetList.size());
    }

    @Test
    public void testArgSize() {
        int count = 0;
        for (int i = 0; i < framesetList.size(); i++){
            count += framesetList.getFrameSet(i).getFramesetArguments().size();
        }
        assertEquals(29761, count);
    }

    private void updateHashMap(HashMap<String, Integer> map, String value){
        if (map.containsKey(value)){
            map.put(value, map.get(value) + 1);
        } else {
            map.put(value, 1);
        }
    }

    @Test
    public void testCase() {
        HashMap<String, Integer> caseList = new HashMap<>();
        for (int i = 0; i < framesetList.size(); i++){
            for (FramesetArgument argument : framesetList.getFrameSet(i).getFramesetArguments()){
                if (!argument.getGrammaticalCase().isEmpty()){
                    if (argument.getGrammaticalCase().contains("abl")){
                        updateHashMap(caseList, "abl");
                    }
                    if (argument.getGrammaticalCase().contains("acc")){
                        updateHashMap(caseList, "acc");
                    }
                    if (argument.getGrammaticalCase().contains("dat")){
                        updateHashMap(caseList, "dat");
                    }
                    if (argument.getGrammaticalCase().contains("gen")){
                        updateHashMap(caseList, "gen");
                    }
                    if (argument.getGrammaticalCase().contains("ins")){
                        updateHashMap(caseList, "ins");
                    }
                    if (argument.getGrammaticalCase().contains("loc")){
                        updateHashMap(caseList, "loc");
                    }
                    if (argument.getGrammaticalCase().contains("nom")){
                        updateHashMap(caseList, "nom");
                    }
                }
            }
        }
        assertEquals(422, (int) caseList.get("abl"));
        assertEquals(4690, (int) caseList.get("acc"));
        assertEquals(2423, (int) caseList.get("dat"));
        assertEquals(880, (int) caseList.get("gen"));
        assertEquals(459, (int) caseList.get("ins"));
        assertEquals(673, (int) caseList.get("loc"));
        assertEquals(2069, (int) caseList.get("nom"));
    }

    @Test
    public void testArgName() {
        HashMap<String, Integer> nameList = new HashMap<>();
        for (int i = 0; i < framesetList.size(); i++){
            for (FramesetArgument argument : framesetList.getFrameSet(i).getFramesetArguments()){
                updateHashMap(nameList, argument.getArgumentType());
            }
        }
        assertEquals(14669, (int) nameList.get("ARG0"));
        assertEquals(13127, (int) nameList.get("ARG1"));
        assertEquals(1886, (int) nameList.get("ARG2"));
        assertEquals(78, (int) nameList.get("ARG3"));
        assertEquals(1, (int) nameList.get("ARG4"));
    }

    @Test
    public void testArgFunction() {
        HashMap<String, Integer> functionList = new HashMap<>();
        for (int i = 0; i < framesetList.size(); i++){
            for (FramesetArgument argument : framesetList.getFrameSet(i).getFramesetArguments()){
                updateHashMap(functionList, argument.getFunction());
            }
        }
        assertEquals(481, (int) functionList.get("com"));
        assertEquals(14, (int) functionList.get("ext"));
        assertEquals(814, (int) functionList.get("loc"));
        assertEquals(198, (int) functionList.get("rec"));
        assertEquals(14, (int) functionList.get("pat"));
        assertEquals(10688, (int) functionList.get("ppt"));
        assertEquals(605, (int) functionList.get("src"));
        assertEquals(801, (int) functionList.get("gol"));
        assertEquals(156, (int) functionList.get("tmp"));
        assertEquals(14558, (int) functionList.get("pag"));
        assertEquals(1432, (int) functionList.get("dir"));
    }

}