package PropBank;

import java.util.ArrayList;
import java.util.List;

public class Frameset {

    private ArrayList<FramesetArgument> framesetArguments;
    private String id;

    public Frameset(String id) {
        this.id = id;
        this.framesetArguments = new ArrayList<FramesetArgument>();
    }

    public boolean containsArgument(ArgumentType argumentType){
        for (FramesetArgument framesetArgument : framesetArguments){
            if (ArgumentType.getArguments(framesetArgument.getArgumentType()).equals(argumentType)){
                return true;
            }
        }
        return false;
    }

    public void addArgument(String type, String definition) {
        boolean check = false;
        for (FramesetArgument a : framesetArguments) {
            if (a.getArgumentType().equals(type)) {
                a.setDefinition(definition);
                check = true;
                break;
            }
        }
        if (!check) {
            FramesetArgument arg = new FramesetArgument(type, definition);
            framesetArguments.add(arg);
        }
    }
    public void deleteArgument(String type, String definition) {
        for (FramesetArgument a : framesetArguments) {
            if (a.getArgumentType().equals(type) && a.getDefinition().equals(definition)) {
                framesetArguments.remove(a);
                break;
            }
        }
    }
    public List<FramesetArgument> getFramesetArguments() {
        return framesetArguments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
