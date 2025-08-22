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
        assertEquals(17531, framesetList.size());
    }

    @Test
    public void testArgSize() {
        int count = 0;
        for (int i = 0; i < framesetList.size(); i++){
            count += framesetList.getFrameSet(i).getFramesetArguments().size();
        }
        assertEquals(29473, count);
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
        assertEquals(418, (int) caseList.get("abl"));
        assertEquals(4633, (int) caseList.get("acc"));
        assertEquals(2402, (int) caseList.get("dat"));
        assertEquals(870, (int) caseList.get("gen"));
        assertEquals(451, (int) caseList.get("ins"));
        assertEquals(666, (int) caseList.get("loc"));
        assertEquals(2049, (int) caseList.get("nom"));
    }

    @Test
    public void testArgName() {
        HashMap<String, Integer> nameList = new HashMap<>();
        for (int i = 0; i < framesetList.size(); i++){
            for (FramesetArgument argument : framesetList.getFrameSet(i).getFramesetArguments()){
                updateHashMap(nameList, argument.getArgumentType());
            }
        }
        assertEquals(14535, (int) nameList.get("ARG0"));
        assertEquals(12996, (int) nameList.get("ARG1"));
        assertEquals(1865, (int) nameList.get("ARG2"));
        assertEquals(76, (int) nameList.get("ARG3"));
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
        assertEquals(475, (int) functionList.get("com"));
        assertEquals(14, (int) functionList.get("ext"));
        assertEquals(808, (int) functionList.get("loc"));
        assertEquals(195, (int) functionList.get("rec"));
        assertEquals(13, (int) functionList.get("pat"));
        assertEquals(10579, (int) functionList.get("ppt"));
        assertEquals(597, (int) functionList.get("src"));
        assertEquals(794, (int) functionList.get("gol"));
        assertEquals(156, (int) functionList.get("tmp"));
        assertEquals(14425, (int) functionList.get("pag"));
        assertEquals(1417, (int) functionList.get("dir"));
    }

}