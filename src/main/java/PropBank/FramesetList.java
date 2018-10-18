package PropBank;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class FramesetList {

    private ArrayList<Frameset> frames;

    public FramesetList(){
        frames = new ArrayList<Frameset>();
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(".");
        try {
            File[] listOfFiles = new File(url.toURI().getPath()).listFiles();
            for (File file : listOfFiles){
                if (file.getName().startsWith("TUR10-") && file.getName().endsWith(".xml")){
                    frames.add(new Frameset(classLoader.getResourceAsStream(file.getName())));
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
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

}
