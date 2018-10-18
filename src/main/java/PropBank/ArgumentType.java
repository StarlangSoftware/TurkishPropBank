package PropBank;

public enum ArgumentType {
    NONE, PREDICATE, ARG0, ARG1, ARG2, ARG3, ARG4, ARG5, ARGMNONE, ARGMEXT, ARGMLOC, ARGMDIS, ARGMADV, ARGMCAU, ARGMTMP, ARGMPNC, ARGMMNR, ARGMDIR;

    public static ArgumentType getArguments(String argumentsType){
        if (argumentsType == null){
            return ArgumentType.NONE;
        } else {
            if (argumentsType.equalsIgnoreCase("ARG0")){
                return ArgumentType.ARG0;
            } else {
                if (argumentsType.equalsIgnoreCase("ARG1")){
                    return ArgumentType.ARG1;
                } else {
                    if (argumentsType.equalsIgnoreCase("ARG2")){
                        return ArgumentType.ARG2;
                    } else {
                        if (argumentsType.equalsIgnoreCase("ARG3")){
                            return ArgumentType.ARG3;
                        } else {
                            if (argumentsType.equalsIgnoreCase("ARG4")){
                                return ArgumentType.ARG4;
                            } else{
                                if(argumentsType.equalsIgnoreCase("ARG5")){
                                    return  ArgumentType.ARG5;
                                }else {
                                    if (argumentsType.equalsIgnoreCase("ARGMADV")){
                                        return ArgumentType.ARGMADV;
                                    } else{
                                        if (argumentsType.equalsIgnoreCase("ARGMCAU")){
                                            return ArgumentType.ARGMCAU;
                                        } else{
                                            if (argumentsType.equalsIgnoreCase("ARGMDIR")){
                                                return ArgumentType.ARGMDIR;
                                            } else{
                                                if (argumentsType.equalsIgnoreCase("ARGMDIS")){
                                                    return ArgumentType.ARGMDIS;
                                                } else{
                                                    if (argumentsType.equalsIgnoreCase("ARGMEXT")){
                                                        return ArgumentType.ARGMEXT;
                                                    } else{
                                                        if (argumentsType.equalsIgnoreCase("ARGMLOC")){
                                                            return ArgumentType.ARGMLOC;
                                                        } else{
                                                            if (argumentsType.equalsIgnoreCase("ARGMMNR")){
                                                                return ArgumentType.ARGMMNR;
                                                            } else{
                                                                if (argumentsType.equalsIgnoreCase("ARGMTMP")){
                                                                    return ArgumentType.ARGMTMP;
                                                                } else{
                                                                    if (argumentsType.equalsIgnoreCase("ARGMNONE")){
                                                                        return ArgumentType.ARGMNONE;
                                                                    } else{
                                                                        if (argumentsType.equalsIgnoreCase("ARGMPNC")){
                                                                            return ArgumentType.ARGMPNC;
                                                                        } else{
                                                                            if (argumentsType.equalsIgnoreCase("PREDICATE")){
                                                                                return ArgumentType.PREDICATE;
                                                                            } else {
                                                                                return ArgumentType.NONE;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

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