package PropBank;

import java.util.ArrayList;

public class Predicate {
    private String lemma;
    private ArrayList<RoleSet> roleSets;

    public Predicate(String lemma){
        this.lemma = lemma;
        roleSets = new ArrayList<>();
    }

    public String getLemma(){
        return lemma;
    }

    public void addRoleSet(RoleSet roleSet){
        roleSets.add(roleSet);
    }

    public int size(){
        return roleSets.size();
    }

    public RoleSet getRoleSet(int index){
        return roleSets.get(index);
    }

    public RoleSet getRoleSet(String roleId){
        for (RoleSet roleSet : roleSets){
            if (roleSet.getId().equals(roleId)){
                return roleSet;
            }
        }
        return null;
    }
}
