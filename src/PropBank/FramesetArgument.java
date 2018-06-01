package PropBank;

public class FramesetArgument {

    private String argumentType;
    private String definition;

    public FramesetArgument(String argumentType, String definition) {
        this.argumentType = argumentType;
        this.definition = definition;
    }

    public String getArgumentType() {
        return argumentType;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String toString(){
        return argumentType + ":" + definition;
    }
}
