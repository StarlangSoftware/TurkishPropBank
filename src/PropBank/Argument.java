package PropBank;

public class Argument {
    private String argumentType;
    private String id;

    public Argument(String argument){
        if (argument.contains("$")){
            argumentType = argument.substring(0, argument.indexOf("$"));
            id = argument.substring(argument.indexOf("$") + 1);
        } else {
            argumentType = "NONE";
        }
    }

    public Argument(String argumentType, String id){
        this.argumentType = argumentType;
        this.id = id;
    }

    public String getArgumentType(){
        return argumentType;
    }

    public String getId(){
        return id;
    }

    public String toString(){
        if (argumentType.equals("NONE")){
            return argumentType;
        } else {
            return argumentType + "$" + id;
        }
    }
}
