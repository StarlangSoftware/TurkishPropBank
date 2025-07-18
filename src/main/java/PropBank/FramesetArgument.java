package PropBank;

public class FramesetArgument {

    private final String argumentType;
    private String function;
    private String definition;
    private String grammaticalCase;

    /**
     * A constructor of {@link FramesetArgument} class which takes argumentType and definition as input and initializes corresponding attributes
     *
     * @param argumentType  ArgumentType of the frameset argument
     * @param definition  Definition of the frameset argument
     * @param function  Function of the frameset argument
     */
    public FramesetArgument(String argumentType, String definition, String function, String grammaticalCase) {
        this.argumentType = argumentType;
        this.definition = definition;
        this.function = function;
        this.grammaticalCase = grammaticalCase;
    }

    /**
     * Accessor for grammaticalCase.
     *
     * @return grammaticalCase.
     */
    public String getGrammaticalCase() {
        return grammaticalCase;
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
     * Accessor for function.
     *
     * @return function.
     */
    public String getFunction() {
        return function;
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
     * Mutator for function.
     *
     * @param function to set.
     */
    public void setFunction(String function) {
        this.function = function;
    }

    /**
     * Mutator for grammaticalCase.
     *
     * @param grammaticalCase to set.
     */
    public void setGrammaticalCase(String grammaticalCase) {
        this.grammaticalCase = grammaticalCase;
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
