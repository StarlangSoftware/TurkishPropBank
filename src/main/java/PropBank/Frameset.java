package PropBank;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Frameset {

    private ArrayList<FramesetArgument> framesetArguments;
    private String id;

    /**
     * A constructor of {@link Frameset} class which takes id as input and initializes corresponding attribute
     *
     * @param id  Id of the frameset
     */
    public Frameset(String id) {
        this.id = id;
        this.framesetArguments = new ArrayList<FramesetArgument>();
    }

    /**
     * Another constructor of {@link Frameset} class which takes inputStream as input and reads the frameset
     *
     * @param inputStream  inputStream to read frameset
     */
    public Frameset(InputStream inputStream){
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream, "UTF-8");
            Element eElement = doc.getDocumentElement();
            id = eElement.getAttribute("id");
            framesetArguments = new ArrayList<FramesetArgument>();
            for (int i = 0; i < eElement.getElementsByTagName("ARG").getLength(); i++) {
                framesetArguments.add(new FramesetArgument(((Element) eElement.getElementsByTagName("ARG").item(i)).getAttribute("name"), eElement.getElementsByTagName("ARG").item(i).getTextContent()));
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
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
     */
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
            BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(id + ".xml"), "UTF-8"));
            fout.write("\t<FRAMESET id=\"" + id + "\">\n");
            for (FramesetArgument framesetArgument : framesetArguments) {
                fout.write("\t\t<ARG name=\"" + framesetArgument.getArgumentType() + "\">" + framesetArgument.getDefinition() + "</ARG>\n");
            }
            fout.write("\t</FRAMESET>\n");
            fout.close();
        } catch (IOException e){
        }
    }

}
