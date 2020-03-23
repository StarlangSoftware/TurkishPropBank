package PropBank;

/**
 * Enumerated class for argument type.
 */

public enum ArgumentType {
    NONE, PREDICATE, ARG0, ARG1, ARG2, ARG3, ARG4, ARG5, ARGMNONE, ARGMEXT, ARGMLOC, ARGMDIS, ARGMADV, ARGMCAU, ARGMTMP, ARGMPNC, ARGMMNR, ARGMDIR;

    /**
     * The getArguments method takes an argumentsType string and returns the {@link ArgumentType} form of it.
     *
     * @param argumentsType  Type of the argument in string form
     * @return Type of the argument in {@link ArgumentType} form
     */
    public static ArgumentType getArguments(String argumentsType){
        switch (argumentsType)
        {
            case "ARG0":
                return ArgumentType.ARG0;
            case "ARG1":
                return ArgumentType.ARG1;
            case "ARG2":
                return ArgumentType.ARG2;
            case "ARG3":
                return ArgumentType.ARG3;
            case "ARG4":
                return ArgumentType.ARG4;
            case "ARG5":
                return ArgumentType.ARG5;
            case "ARGMADV":
                return ArgumentType.ARGMADV;
            case "ARGMCAU":
                return ArgumentType.ARGMCAU;
            case "ARGMDIR":
                return ArgumentType.ARGMDIR;
            case "ARGMDIS":
                return ArgumentType.ARGMDIS;
            case "ARGMEXT":
                return ArgumentType.ARGMEXT;
            case "ARGMLOC":
                return ArgumentType.ARGMLOC;
            case "ARGMMNR":
                return ArgumentType.ARGMMNR;
            case "ARGMTMP":
                return ArgumentType.ARGMTMP;
            case "ARGMNONE":
                return ArgumentType.ARGMNONE;
            case "ARGMPNC":
                return ArgumentType.ARGMPNC;
            case "PREDICATE":
                return ArgumentType.PREDICATE;
            default:
                return ArgumentType.NONE;
        }
    }

    /**
     * The getPropbankType method takes an argumentType in {@link ArgumentType} form and returns the string form of it.
     *
     * @param argumentType  Type of the argument in {@link ArgumentType} form
     * @return Type of the argument in string form
     */
    public static String getPropbankType(ArgumentType argumentType){
        if (argumentType == null)
            return "NONE";
        switch (argumentType){
            case ARG0:
                return "ARG0";
            case ARG1:
                return "ARG1";
            case ARG2:
                return "ARG2";
            case ARG3:
                return "ARG3";
            case ARG4:
                return "ARG4";
            case ARG5:
                return "ARG5";
            case ARGMADV:
                return "ARGMADV";
            case ARGMCAU:
                return "ARGMCAU";
            case ARGMDIR:
                return "ARGMDIR";
            case ARGMDIS:
                return "ARGMDIS";
            case ARGMEXT:
                return "ARGMEXT";
            case ARGMLOC:
                return "ARGMLOC";
            case ARGMMNR:
                return "ARGMMNR";
            case ARGMTMP:
                return "ARGMTMP";
            case ARGMNONE:
                return "ARGMNONE";
            case ARGMPNC:
                return "ARGMPNC";
            case PREDICATE:
                return "PREDICATE";
            default:
                return "NONE";
        }
    }

}
