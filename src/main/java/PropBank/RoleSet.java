package PropBank;

import java.util.ArrayList;

public class RoleSet {
    private String id;
    private String name;
    private ArrayList<Role> roles;

    /**
     * A constructor of {@link RoleSet} class which takes id and name as inputs and initializes corresponding attributes
     * with these inputs.
     *
     * @param id  Id of the roleSet
     * @param name Name of the roleSet
     */
    public RoleSet(String id, String name){
        this.id = id;
        this.name = name;
        roles = new ArrayList<>();
    }

    /**
     * Accessor for id.
     *
     * @return id.
     */
    public String getId(){
        return id;
    }

    /**
     * Accessor for name.
     *
     * @return name.
     */
    public String getName(){
        return name;
    }

    /**
     * The addRole method takes a {@link Role} as input and adds it to the roles {@link ArrayList}.
     *
     * @param role  Role to be added
     */
    public void addRole(Role role){
        roles.add(role);
    }

    /**
     * The getRole method returns the role at the given index.
     *
     * @param index  Index of the role
     * @return {@link Role} at the given index.
     */
    public Role getRole(int index){
        return roles.get(index);
    }

    /**
     * Finds and returns the role with the given argument number n. For example, if n == 0, the method returns
     * the argument ARG0.
     * @param n Argument number
     * @return The role with the given argument number n.
     */
    public Role getRoleWithArgument(String n){
        for (Role role : roles){
            if (role.getN().equals(n)){
                return role;
            }
        }
        return null;
    }

    /**
     * The size method returns the size of the roles {@link ArrayList}.
     *
     * @return the size of the roles {@link ArrayList}.
     */
    public int size(){
        return roles.size();
    }
}
