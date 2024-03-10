package PropBank;

import Xml.XmlElement;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Frameset {

    private final ArrayList<FramesetArgument> framesetArguments;
    private String id;

    /**
     * A constructor of {@link Frameset} class which takes id as input and initializes corresponding attribute
     *
     * @param id  Id of the frameset
     */
    public Frameset(String id) {
        this.id = id;
        this.framesetArguments = new ArrayList<>();
    }

    /**
     * Another constructor of {@link Frameset} class which takes inputStream as input and reads the frameset
     *
     * @param frameSetNode  XmlElement to read frameset
     */
    public Frameset(XmlElement frameSetNode){
        id = frameSetNode.getAttributeValue("id");
        framesetArguments = new ArrayList<>();
        XmlElement argNode = frameSetNode.getFirstChild();
        while (argNode != null){
            framesetArguments.add(new FramesetArgument(argNode.getAttributeValue("name"), argNode.getPcData(), argNode.getAttributeValue("function")));
            argNode = argNode.getNextSibling();
        }
    }

    /**
     * containsArgument method which checks if there is an {@link Argument} of the given argumentType.
     *
     * @param argumentType  ArgumentType of the searched {@link Argument}
     * @return true if the {@link Argument} with the given argumentType exists, false otherwise.
     */
    public boolean containsArgument(ArgumentType argumentType){
        for (FramesetArgument framesetArgument : framesetArguments){
            if (ArgumentType.getArguments(framesetArgument.getArgumentType()).equals(argumentType)){
                return true;
            }
        }
        return false;
    }

    /**
     * The addArgument method takes a type and a definition of a {@link FramesetArgument} as input, then it creates a new FramesetArgument from these inputs and
     * adds it to the framesetArguments {@link ArrayList}.
     *
     * @param type  Type of the new {@link FramesetArgument}
     * @param definition Definition of the new {@link FramesetArgument}
     * @param function Function of the new {@link FramesetArgument}
     */
    public void addArgument(String type, String definition, String function) {
        boolean check = false;
        for (FramesetArgument a : framesetArguments) {
            if (a.getArgumentType().equals(type)) {
                a.setDefinition(definition);
                check = true;
                break;
            }
        }
        if (!check) {
            FramesetArgument arg = new FramesetArgument(type, definition, function);
            framesetArguments.add(arg);
        }
    }

    /**
     * The deleteArgument method takes a type and a definition of a {@link FramesetArgument} as input, then it searches for the FramesetArgument with these type and
     * definition, and if it finds removes it from the framesetArguments {@link ArrayList}.
     *
     * @param type  Type of the to be deleted {@link FramesetArgument}
     * @param definition Definition of the to be deleted {@link FramesetArgument}
     */
    public void deleteArgument(String type, String definition) {
        for (FramesetArgument a : framesetArguments) {
            if (a.getArgumentType().equals(type) && a.getDefinition().equals(definition)) {
                framesetArguments.remove(a);
                break;
            }
        }
    }

    /**
     * Accessor for framesetArguments.
     *
     * @return framesetArguments.
     */
    public List<FramesetArgument> getFramesetArguments() {
        return framesetArguments;
    }

    /**
     * Accessor for id.
     *
     * @return id.
     */
    public String getId() {
        return id;
    }

    /**
     * Mutator for id.
     *
     * @param id to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Saves the {@link Frameset} in an xml file format.
     */
    public void saveAsXml(){
        try {
            BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(Paths.get(id + ".xml")), StandardCharsets.UTF_8));
            fout.write("\t<FRAMESET id=\"" + id + "\">\n");
            for (FramesetArgument framesetArgument : framesetArguments) {
                fout.write("\t\t<ARG name=\"" + framesetArgument.getArgumentType() + "\" function=\"" +
                        framesetArgument.getFunction() + "\">" + framesetArgument.getDefinition() + "</ARG>\n");
            }
            fout.write("\t</FRAMESET>\n");
            fout.close();
        } catch (IOException ignored){
        }
    }

}
