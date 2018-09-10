package PropBank;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.*;

public class FramesetList {

    public static final int SAVE = 1;
    public static final int DELETE = 2;
    private String fileName;
    private Document doc;
    private ArrayList<Frameset> frames;

    public FramesetList(){
        this.fileName = "frameset.xml";
        ClassLoader classLoader = getClass().getClassLoader();
        frames = XMLToFrames(classLoader.getResourceAsStream(fileName));
    }

    public FramesetList(String fileName){
        this.fileName = fileName;
        try {
            frames = XMLToFrames(new FileInputStream(new File(fileName)));
        } catch (FileNotFoundException e) {
        }
    }

    public Map<ArgumentType, String> readFromXML(String id) {
        Map<ArgumentType, String> frameset = new HashMap<ArgumentType, String>();
        for (Frameset f:frames){
            if (f.getId().equals(id)){
                for(int i = 0;i<f.getFramesetArguments().size();i++){
                    frameset.put(ArgumentType.valueOf(f.getFramesetArguments().get(i).getArgumentType()), f.getFramesetArguments().get(i).getDefinition());
                }
            }
        }
        return  frameset;
    }

    public boolean frameExists(String synSetId){
        for (Frameset f:frames){
            if (f.getId().equals(synSetId)){
                return true;
            }
        }
        return false;
    }

    public Frameset getFrameSet(String synSetId){
        for (Frameset f:frames){
            if (f.getId().equals(synSetId)){
                return f;
            }
        }
        return null;
    }

    public void addFrameset(Frameset frameset){
        frames.add(frameset);
    }

    public Frameset getFrameSet(int index){
        return frames.get(index);
    }

    public int size(){
        return frames.size();
    }

    public void saveAsXml(String id, String argumentType, String definition, int condition){
        Writer writer;
        try {
            writer = new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8");
            BufferedWriter fout = new BufferedWriter(writer);
            int i;
            boolean check = false;
            boolean deleteCheck = false;
            fout.write("<FRAMES>\n");
            for(Frameset f:frames){
                if(f.getId().equals(id)){
                    switch (condition){
                        case SAVE:
                            f.addArgument(argumentType, definition);
                            break;
                        case DELETE:
                            f.deleteArgument(argumentType, definition);
                    }
                    check = true;
                }
                if (f.getFramesetArguments().size() != 0) {
                    fout.write("\t<FRAMESET id=\"" + f.getId() + "\">\n");
                    for (i = 0; i < f.getFramesetArguments().size(); i++) {
                        fout.write("\t\t<ARG name=\"" + f.getFramesetArguments().get(i).getArgumentType().toString() + "\">" + f.getFramesetArguments().get(i).getDefinition() + "</ARG>\n");
                    }
                    fout.write("\t</FRAMESET>\n");
                } else {
                    deleteCheck = true;
                }
            }
            if (deleteCheck){
                Frameset f = null;
                for (Frameset e : frames){
                    if (e.getId().equals(id)){
                        f = e;
                    }
                }
                frames.remove(f);
            }
            if (!check){
                fout.write("\t<FRAMESET id=\"" + id + "\">\n\t\t<ARG name=\"" + argumentType + "\">" + definition + "</ARG>\n\t</FRAMESET>\n");
                Frameset f = new Frameset(id);
                f.addArgument(argumentType, definition);
                frames.add(f);
            }
            fout.write("</FRAMES>\n");
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Frameset> XMLToFrames(InputStream inputStream){
        ArrayList<Frameset> framesets = new ArrayList<Frameset>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputStream, "UTF-8");
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        NodeList nList = doc.getElementsByTagName("FRAMESET");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                Frameset frame = new Frameset(eElement.getAttribute("id"));
                for (int i = 0; i < eElement.getElementsByTagName("ARG").getLength(); i++) {
                    frame.addArgument(((Element) eElement.getElementsByTagName("ARG").item(i)).getAttribute("name"), eElement.getElementsByTagName("ARG").item(i).getTextContent());
                }
                framesets.add(frame);
            }
        }
        return framesets;
    }
}
