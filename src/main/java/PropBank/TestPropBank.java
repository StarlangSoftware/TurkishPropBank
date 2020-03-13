package PropBank;

public class TestPropBank {

    public static void readPredicateList(){
        PredicateList predicateList = new PredicateList();
        for (String lemma : predicateList.getLemmaList()){
            Predicate predicate = predicateList.getPredicate(lemma);
            for (int i = 0; i < predicate.size(); i++){
                String s = lemma + "\t";
                RoleSet roleSet = predicate.getRoleSet(i);
                s = s + roleSet.getId() + "\t" + roleSet.getName() + "\t";
                for (int j = 0; j < 5; j++){
                    Role role = roleSet.getRoleWithArgument(Integer.toString(j));
                    if (role != null){
                        s = s + role.getDescription() + "\t";
                    } else {
                        s = s + "\t";
                    }
                }
                System.out.println(s);
            }
        }
    }

    public static void readFrameSetList(){
        FramesetList framesetList = new FramesetList();
        System.out.println(framesetList.size());
    }

    public static void main(String[] args){
        readFrameSetList();
    }
}
