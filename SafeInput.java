public class SafeInput {

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while(retString.length() == 0);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int retInt = -1;
        boolean run = true;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine();
                run = false;
            } else {
                pipe.nextLine();
            }
        } while (run);
        return retInt;
    }
    

    public static double getDouble(Scanner pipe, String prompt) {
        double retDouble = -1;
        boolean run = true;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                run = false;
            } else {
                pipe.nextLine();
            }
        } while (run);
        return retDouble;
    }

    private static boolean isInRangeInt(int num, int low, int high) {
        return (num >= low && num <= high);
    }
    

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retInt = -1;
        boolean run = true;
        String trash = "";
        do {
            System.out.print("\n" + prompt + " [" + low + ", " + high + "]: ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine();
                if (isInRangeInt(retInt, low, high)) {
                    run = false;
                }
            } else {
                pipe.nextLine();
            }
        } while (run);
        return retInt;
    }
    

    private static boolean isInRangeDouble(double num, double low, double high) {
       return (num >= low && num <= high);
    }
    

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retDouble = -1;
        boolean run = true;
        
        do {
            System.out.print("\n" + prompt + " [" + low + ", " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                if (isInRangeDouble(retDouble, low, high)) {
                    run = false;
                }
            } else {
                pipe.nextLine();
            }
        } while (run);
        return retDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean retBool = false;
        String ans = "";
        boolean run = true;
        do {
            System.out.print("\n" + prompt + "? [Y/N] ");
            if (pipe.hasNext()) {
                ans = pipe.nextLine().toUpperCase();
                if (ans.equals("Y") || ans.equals("N")) {
                    run = false;
                }
            }
        } while (run);
        if (ans.equals("Y")) {
            retBool = true;
        }
        return retBool;
    }
    

    
    public static String getRegExString(Scanner pipe, String prompt, String RegEx) {
        String stringToSearch = "";
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            stringToSearch = pipe.nextLine();
            Pattern regexPattern = Pattern.compile(RegEx);
            Matcher regexMatcher = regexPattern.matcher(stringToSearch);
            if (regexMatcher.find()) {
                return regexMatcher.group(0);
            } 
        } while(true);
    }
    
    public static void prettyHeader(String msg) {
        if (msg.length() < 52) {
            int position = 0;
            int valSpacesAfter = 0;
            boolean isEvenLength = (msg.length() % 2 == 0);
            for (int i = 0; i < 3; i++) {
                if (i % 2 == 0) {
                    for(int j = 0; j < 60; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                } else {
                    position = (54 - msg.length());
                    System.out.print("***");
                    for (int k = 0; k < position / 2; k++) {
                        System.out.print(" ");
                    }
                    System.out.print(msg);
                    if (isEvenLength) {
                        valSpacesAfter = position / 2;
                    } else {
                        valSpacesAfter = position / 2 + 1;
                    }
                    for (int l = 0; l < valSpacesAfter; l++) {
                        System.out.print(" ");
                    }
                    System.out.println("***");
                }
            }
        } else {
            System.out.println("Your message is too long, please try again with a shorter message.");
        }
    }
}
