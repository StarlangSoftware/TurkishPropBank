package PropBank;

import java.io.*;
import java.util.*;

public class FramesetList {

    private ArrayList<Frameset> frames;

    public FramesetList(){
        frames = new ArrayList<Frameset>();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("files.txt");
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()){
            frames.add(new Frameset(classLoader.getResourceAsStream(scanner.next())));
        }
    }

    public Map<ArgumentType, String> readFromXML(String synSetId) {
        Map<ArgumentType, String> frameset = new HashMap<ArgumentType, String>();
        for (Frameset f:frames){
            if (f.getId().equals(synSetId)){
                for (int i = 0; i < f.getFramesetArguments().size(); i++){
                    frameset.put(ArgumentType.valueOf(f.getFramesetArguments().get(i).getArgumentType()), f.getFramesetArguments().get(i).getDefinition());
                }
            }
        }
        return frameset;
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
