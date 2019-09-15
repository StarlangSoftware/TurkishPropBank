package PropBank;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PredicateList {
    private HashMap<String, Predicate> list;

    /**
     * A constructor of {@link PredicateList} class which reads all predicate files inside the 'Frames' folder. For each
     * file inside that folder, the constructor creates a Predicate and puts in inside the list {@link HashMap}.
     */
    public PredicateList(){
        Document doc;
        Node frameSetNode, predicateNode, roleSetNode, roleNode, rolesNode;
        DOMParser parser = new DOMParser();
        list = new HashMap<>();
        File[] listOfFiles = new File("Frames").listFiles();
        for (File file : listOfFiles){
            try {
                parser.parse(file.getAbsolutePath());
            } catch (SAXException | IOException e) {
                e.printStackTrace();
            }
            doc = parser.getDocument();
            frameSetNode = doc.getFirstChild();
            predicateNode = frameSetNode.getFirstChild();
            while (predicateNode != null){
                if (predicateNode.hasAttributes()){
                    String lemma = predicateNode.getAttributes().getNamedItem("lemma").getNodeValue();
                    Predicate newPredicate = new Predicate(lemma);
                    roleSetNode = predicateNode.getFirstChild();
                    while (roleSetNode != null){
                        if (roleSetNode.hasAttributes()){
                            String id = roleSetNode.getAttributes().getNamedItem("id").getNodeValue();
                            String name = roleSetNode.getAttributes().getNamedItem("name").getNodeValue();
                            RoleSet newRoleSet = new RoleSet(id, name);
                            rolesNode = roleSetNode.getFirstChild();
                            while (rolesNode != null && rolesNode.getFirstChild() == null){
                                rolesNode = rolesNode.getNextSibling();
                            }
                            if (rolesNode != null){
                                roleNode = rolesNode.getFirstChild();
                                while (roleNode != null){
                                    if (roleNode.hasAttributes()){
                                        String description, f, n;
                                        description = roleNode.getAttributes().getNamedItem("descr").getNodeValue();
                                        f = roleNode.getAttributes().getNamedItem("f").getNodeValue();
                                        n = roleNode.getAttributes().getNamedItem("n").getNodeValue();
                                        Role newRole = new Role(description, f, n);
                                        newRoleSet.addRole(newRole);
                                    }
                                    roleNode = roleNode.getNextSibling();
                                }
                            }
                            newPredicate.addRoleSet(newRoleSet);
                        }
                        roleSetNode = roleSetNode.getNextSibling();
                    }
                    list.put(newPredicate.getLemma(), newPredicate);
                }
                predicateNode = predicateNode.getNextSibling();
            }
        }
    }

    /**
     * The size method returns the number of predicates inside the list.
     *
     * @return the size of the list {@link HashMap}.
     */
    public int size(){
        return list.size();
    }

    /**
     * getPredicate method returns the {@link Predicate} with the given lemma.
     *
     * @param lemma  Lemma of the searched predicate
     * @return {@link Predicate} which has the given lemma.
     */
    public Predicate getPredicate(String lemma){
        return list.get(lemma);
    }

    /**
     * The method returns all lemma in the predicate list.
     * @return All lemma in the predicate list.
     */
    public Set<String> getLemmaList(){
        return list.keySet();
    }
}
