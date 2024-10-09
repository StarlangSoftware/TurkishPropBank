package PropBank;

import Xml.XmlDocument;
import Xml.XmlElement;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Set;

public class PredicateList {
    private final HashMap<String, Predicate> list;

    /**
     * A constructor of {@link PredicateList} class which reads all predicate files inside the 'Frames' folder. For each
     * file inside that folder, the constructor creates a Predicate and puts in inside the list {@link HashMap}.
     */
    public PredicateList(){
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("english-propbank.xml");
        XmlDocument doc = new XmlDocument(inputStream);
        doc.parse();
        XmlElement framesNode = doc.getFirstChild();
        XmlElement frameSetNode = framesNode.getFirstChild();
        list = new HashMap<>();
        while (frameSetNode != null){
            XmlElement predicateNode = frameSetNode.getFirstChild();
            while (predicateNode != null){
                if (predicateNode.hasAttributes()){
                    String lemma = predicateNode.getAttributeValue("lemma");
                    Predicate newPredicate = new Predicate(lemma);
                    XmlElement roleSetNode = predicateNode.getFirstChild();
                    while (roleSetNode != null){
                        if (roleSetNode.hasAttributes()){
                            String id = roleSetNode.getAttributeValue("id");
                            String name = roleSetNode.getAttributeValue("name");
                            RoleSet newRoleSet = new RoleSet(id, name);
                            XmlElement rolesNode = roleSetNode.getFirstChild();
                            while (rolesNode != null && rolesNode.getFirstChild() == null){
                                rolesNode = rolesNode.getNextSibling();
                            }
                            if (rolesNode != null){
                                XmlElement roleNode = rolesNode.getFirstChild();
                                while (roleNode != null){
                                    if (roleNode.hasAttributes()){
                                        String description, f, n;
                                        description = roleNode.getAttributeValue("descr");
                                        f = roleNode.getAttributeValue("f");
                                        n = roleNode.getAttributeValue("n");
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
            frameSetNode = frameSetNode.getNextSibling();
        }
    }

    public String toJson(){
        StringBuilder jsonString = new StringBuilder("[\n");
        for (String key : list.keySet()){
            Predicate predicate = list.get(key);
            jsonString.append("\t{\"lemma\": \"").append(predicate.getLemma()).append("\", \"rolesets\":[\n");
            for (int i = 0; i < predicate.size(); i++){
                RoleSet roleSet = predicate.getRoleSet(i);
                jsonString.append("\t\t{\"id\":\"").append(roleSet.getId()).append("\", \"name\":\"").append(roleSet.getName()).append("\", \"roles\":[\n");
                for (int j = 0; j < roleSet.size(); j++){
                    Role role = roleSet.getRole(j);
                    if (j != roleSet.size() - 1){
                        jsonString.append("\t\t\t{\"descr\":\"").append(role.getDescription()).append("\", \"f\":\"").append(role.getF()).append("\", \"n\":\"").append(role.getN()).append("\"},\n");
                    } else {
                        jsonString.append("\t\t\t{\"descr\":\"").append(role.getDescription()).append("\", \"f\":\"").append(role.getF()).append("\", \"n\":\"").append(role.getN()).append("\"}\n");
                    }
                }
                if (i != predicate.size() - 1){
                    jsonString.append("\t\t\t]\n\t\t},\n");
                } else {
                    jsonString.append("\t\t\t]}\n");
                }
            }
            jsonString.append("\t\t]\n\t},\n");
        }
        return jsonString + "\n]";
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
