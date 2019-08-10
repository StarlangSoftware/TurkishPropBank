package PropBank;

public class FramesetArgument {

    private String argumentType;
    private String definition;

    /**
     * A constructor of {@link FramesetArgument} class which takes argumentType and definition as input and initializes corresponding attributes
     *
     * @param argumentType  ArgumentType of the frameset argument
     * @param definition  Definition of the frameset argument
     */
    public FramesetArgument(String argumentType, String definition) {
        this.argumentType = argumentType;
        this.definition = definition;
    }

    /**
     * Accessor for argumentType.
     *
     * @return argumentType.
     */
    public String getArgumentType() {
        return argumentType;
    }

    /**
     * Accessor for definition.
     *
     * @return definition.
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * Mutator for definition.
     *
     * @param definition to set.
     */
    public void setDefinition(String definition) {
        this.definition = definition;
    }

    /**
     * toString converts an {@link FramesetArgument} to a string. It returns argument string which is in the form of
     * argumentType:definition
     *
     * @return string form of frameset argument
     */
    public String toString(){
        return argumentType + ":" + definition;
    }
}
