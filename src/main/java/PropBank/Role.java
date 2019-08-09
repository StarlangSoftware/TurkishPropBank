package PropBank;

public class Role {
    private String description;
    private String f;
    private String n;

    /**
     * A constructor of {@link Role} class which takes description, f, and n as inputs and initializes corresponding with these inputs.
     *
     * @param description  Description of the role
     * @param f  Argument Type of the role
     * @param n  Number of the role
     */
    public Role(String description, String f, String n){
        this.description = description;
        this.f = f;
        this.n = n;
    }

    /**
     * Accessor for description.
     *
     * @return description.
     */
    public String getDescription(){
        return description;
    }

    /**
     * Accessor for f.
     *
     * @return f.
     */
    public String getF(){
        return f;
    }

    /**
     * Accessor for n.
     *
     * @return n.
     */
    public String getN(){
        return n;
    }

    /**
     * Constructs and returns the argument type for this role.
     *
     * @return Argument type for this role.
     */
    public ArgumentType getArgumentType(){
        return ArgumentType.getArguments("ARG" + f.toUpperCase());
    }
}
