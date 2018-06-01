package PropBank;

public class Role {
    private String description;
    private String f;
    private String n;

    public Role(String description, String f, String n){
        this.description = description;
        this.f = f;
        this.n = n;
    }

    public String getDescription(){
        return description;
    }

    public String getF(){
        return f;
    }

    public String getN(){
        return n;
    }

    public ArgumentType getArgumentType(){
        return ArgumentType.getArguments("ARG" + f.toUpperCase());
    }
}
