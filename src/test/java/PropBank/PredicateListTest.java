package PropBank;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class PredicateListTest {
    PredicateList predicateList;

    @Before
    public void setUp() {
        predicateList = new PredicateList();
    }

    @Test
    public void testPredicateSize() {
        assertEquals(8656, predicateList.size());
    }

    @Test
    public void testRoleSetSize() {
        int count = 0;
        for (String lemma : predicateList.getLemmaList()){
            count += predicateList.getPredicate(lemma).size();
        }
        assertEquals(10685, count);
    }

    @Test
    public void testRoleSize() {
        int count = 0;
        for (String lemma : predicateList.getLemmaList()){
            for (int i = 0; i < predicateList.getPredicate(lemma).size(); i++){
                count += predicateList.getPredicate(lemma).getRoleSet(i).size();
            }
        }
        assertEquals(27080, count);
    }

    @Test
    public void testFunction() {
        HashMap<String, Integer> functionList = new HashMap<>();
        for (String lemma : predicateList.getLemmaList()){
            for (int i = 0; i < predicateList.getPredicate(lemma).size(); i++){
                for (int j = 0; j < predicateList.getPredicate(lemma).getRoleSet(i).size(); j++){
                    String function = predicateList.getPredicate(lemma).getRoleSet(i).getRole(j).getF();
                    if (functionList.containsKey(function)){
                        functionList.put(function, functionList.get(function) + 1);
                    } else {
                        functionList.put(function, 1);
                    }
                }
            }
        }
        assertEquals(197, (int) functionList.get("com"));
        assertEquals(292, (int) functionList.get("ext"));
        assertEquals(580, (int) functionList.get("loc"));
        assertEquals(1104, (int) functionList.get("prd"));
        assertEquals(2395, (int) functionList.get("gol"));
        assertEquals(19, (int) functionList.get("adj"));
        assertEquals(980, (int) functionList.get("dir"));
        assertEquals(118, (int) functionList.get("prp"));
        assertEquals(1007, (int) functionList.get("mnr"));
        assertEquals(4, (int) functionList.get("rec"));
        assertEquals(679, (int) functionList.get("vsp"));
        assertEquals(14, (int) functionList.get("adv"));
        assertEquals(10282, (int) functionList.get("ppt"));
        assertEquals(267, (int) functionList.get("cau"));
        assertEquals(37, (int) functionList.get("tmp"));
        assertEquals(9105, (int) functionList.get("pag"));
    }

    @Test
    public void testN() {
        HashMap<String, Integer> nList = new HashMap<>();
        for (String lemma : predicateList.getLemmaList()){
            for (int i = 0; i < predicateList.getPredicate(lemma).size(); i++){
                for (int j = 0; j < predicateList.getPredicate(lemma).getRoleSet(i).size(); j++){
                    String n = predicateList.getPredicate(lemma).getRoleSet(i).getRole(j).getN();
                    if (nList.containsKey(n)){
                        nList.put(n, nList.get(n) + 1);
                    } else {
                        nList.put(n, 1);
                    }
                }
            }
        }
        assertEquals(8906, (int) nList.get("0"));
        assertEquals(10375, (int) nList.get("1"));
        assertEquals(5934, (int) nList.get("2"));
        assertEquals(1313, (int) nList.get("3"));
        assertEquals(417, (int) nList.get("4"));
        assertEquals(57, (int) nList.get("5"));
        assertEquals(6, (int) nList.get("6"));
        assertEquals(72, (int) nList.get("m"));
    }

}