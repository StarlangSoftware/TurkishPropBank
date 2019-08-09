package PropBank;

import java.util.ArrayList;

public class Predicate {
    private String lemma;
    private ArrayList<RoleSet> roleSets;

    /**
     * A constructor of {@link Predicate} class which takes lemma as input and initializes lemma with this input.
     * The constructor also initializes the roleSets array.
     *
     * @param lemma  Lemma of the predicate
     */
    public Predicate(String lemma){
        this.lemma = lemma;
        roleSets = new ArrayList<>();
    }

    /**
     * Accessor for lemma.
     *
     * @return lemma.
     */
    public String getLemma(){
        return lemma;
    }

    /**
     * The addRoleSet method takes a {@link RoleSet} as input and adds it to the roleSets {@link ArrayList}.
     *
     * @param roleSet  RoleSet to be added
     */
    public void addRoleSet(RoleSet roleSet){
        roleSets.add(roleSet);
    }

    /**
     * The size method returns the size of the roleSets {@link ArrayList}.
     *
     * @return the size of the roleSets {@link ArrayList}.
     */
    public int size(){
        return roleSets.size();
    }

    /**
     * The getRoleSet method returns the roleSet at the given index.
     *
     * @param index  Index of the roleSet
     * @return {@link RoleSet} at the given index.
     */
    public RoleSet getRoleSet(int index){
        return roleSets.get(index);
    }

    /**
     * Another getRoleSet method which returns the roleSet with the given roleSet id.
     *
     * @param roleId  Id of the searched roleSet
     * @return {@link RoleSet} which has the given id.
     */
    public RoleSet getRoleSet(String roleId){
        for (RoleSet roleSet : roleSets){
            if (roleSet.getId().equals(roleId)){
                return roleSet;
            }
        }
        return null;
    }
}
