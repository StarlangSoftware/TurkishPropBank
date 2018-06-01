package PropBank;

import java.util.ArrayList;

public class RoleSet {
    private String id;
    private String name;
    private ArrayList<Role> roles;

    public RoleSet(String id, String name){
        this.id = id;
        this.name = name;
        roles = new ArrayList<>();
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void addRole(Role role){
        roles.add(role);
    }

    public Role getRole(int index){
        return roles.get(index);
    }

    public int size(){
        return roles.size();
    }
}
