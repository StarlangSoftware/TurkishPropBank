package PropBank;

import java.util.ArrayList;

public class ArgumentList {

    private final ArrayList<Argument> arguments;

    /**
     * Constructor of argument list from a string. The arguments for a word is a concatenated list of arguments
     * separated via '#' character.
     * @param argumentList String consisting of arguments separated with '#' character.
     */
    public ArgumentList(String argumentList) {
        arguments = new ArrayList<>();
        String[] items = argumentList.split("#");
        for (String item : items) {
            arguments.add(new Argument(item));
        }
    }

    /**
     * Overloaded toString method to convert an argument list to a string. Concatenates the string forms of all
     * arguments with '#' character.
     * @return String form of the argument list.
     */
    public String toString(){
        if (arguments.isEmpty()){
            return "NONE";
        } else {
            String result = arguments.get(0).toString();
            for (int i = 1; i < arguments.size(); i++){
                result += "#" + arguments.get(i).toString();
            }
            return result;
        }
    }

    /**
     * Replaces id's of predicates, which have previousId as synset id, with currentId.
     * @param previousId Previous id of the synset.
     * @param currentId Replacement id.
     */
    public void updateConnectedId(String previousId, String currentId){
        for (Argument argument : arguments) {
            if (argument.getId().equals(previousId)){
                argument.setId(currentId);
            }
        }
    }

    /**
     * Adds a predicate argument to the argument list of this word.
     * @param predicateId Synset id of this predicate.
     */
    public void addPredicate(String predicateId){
        if (!arguments.isEmpty() && arguments.get(0).getArgumentType().equals("NONE")){
            arguments.remove(0);
        }
        arguments.add(new Argument("PREDICATE", predicateId));
    }

    /**
     * Removes the predicate with the given predicate id.
     */
    public void removePredicate(){
        for (Argument argument : arguments) {
            if (argument.getArgumentType().equals("PREDICATE")){
                arguments.remove(argument);
                break;
            }
        }
    }

    /**
     * Checks if one of the arguments is a predicate.
     * @return True, if one of the arguments is predicate; false otherwise.
     */
    public boolean containsPredicate(){
        for (Argument argument : arguments) {
            if (argument.getArgumentType().equals("PREDICATE")){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if one of the arguments is a predicate with the given id.
     * @param predicateId Synset id to check.
     * @return True, if one of the arguments is predicate; false otherwise.
     */
    public boolean containsPredicateWithId(String predicateId){
        for (Argument argument : arguments) {
            if (argument.getArgumentType().equals("PREDICATE") && argument.getId().equals(predicateId)){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the arguments as an array list of strings.
     * @return Arguments as an array list of strings.
     */
    public ArrayList<String> getArguments() {
        ArrayList<String> result = new ArrayList<>();
        for (Argument argument : arguments) {
            result.add(argument.toString());
        }
        return result;
    }

    /**
     * Checks if the given argument with the given type and id exists or not.
     * @param argumentType Type of the argument to search for.
     * @param id Id of the argument to search for.
     * @return True if the argument exists, false otherwise.
     */
    public boolean containsArgument(String argumentType, String id){
        for (Argument argument : arguments) {
            if (argument.getArgumentType().equals(argumentType) && argument.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
