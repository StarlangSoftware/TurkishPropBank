package PropBank;

public class Argument {
    private final String argumentType;
    private String id;

    /**
     * A constructor of {@link Argument} class which takes argument string which is in the form of argumentType$id
     * and parses this string into argumentType and id. If the argument string does not contain '$' then the
     * constructor return a NONE type argument.
     *
     * @param argument  Argument string containing the argumentType and id
     */
    public Argument(String argument){
        if (argument.contains("$")){
            argumentType = argument.substring(0, argument.indexOf("$"));
            id = argument.substring(argument.indexOf("$") + 1);
        } else {
            argumentType = "NONE";
        }
    }

    /**
     * Another constructor of {@link Argument} class which takes argumentType and id as inputs and initializes corresponding attributes
     *
     * @param argumentType  Type of the argument
     * @param id  Id of the argument
     */
    public Argument(String argumentType, String id){
        this.argumentType = argumentType;
        this.id = id;
    }

    /**
     * Accessor for argumentType.
     *
     * @return argumentType.
     */
    public String getArgumentType(){
        return argumentType;
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
     * toString converts an {@link Argument} to a string. If the argumentType is "NONE" returns only "NONE", otherwise
     * it returns argument string which is in the form of argumentType$id
     *
     * @return string form of argument
     */
    public String toString(){
        if (argumentType.equals("NONE")){
            return argumentType;
        } else {
            return argumentType + "$" + id;
        }
    }

    /**
     * Setter for the id
     * @param id New id of the argument
     */
    public void setId(String id) {
        this.id = id;
    }

}
