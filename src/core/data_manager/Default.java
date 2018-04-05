package core.data_manager;
// Purpose: to provide default values to core files.

import core.institute.Counts;
import java.util.ArrayList;
import java.util.Arrays;
import writelib.Writer;


public class Default {

    // core method to write the default files.
    public static void writeDefault(String list[]) {
        for (String list1 : list) {
            if (gotValue(list1)) {
                chooseValue(list1);
            } else {
                // file with no value
                continue;
            }
        }
    }

    // method to scan the fileList and return if got value
    private static boolean gotValueList(int index) {
        boolean gotIt = false;
        // list of files
        switch (index) {
            case 0:
                gotIt = false;   // objRW
                break;
            case 1:
                gotIt = false;   // objRW
                break;
            case 2:
                gotIt = false;   // objRW
                break;
            case 3:
                gotIt = false;   // objRW
                break;
            case 4:
                gotIt = false;   // InstitutionManager
                break;
            case 5:
                gotIt = true;    // Counts Manager
                break;
            case 6:
                gotIt = false;   // InsListManager / ObjRW
                break;
            case 7:
                gotIt = true;    // StatManager 
                break;
            case 8:
                gotIt = true;    // StatManager 
                break;
            case 9:
                gotIt = true;    // StatManager 
                break;
            case 10:
                gotIt = false;    // objRW 
                break;
            case 11:
                gotIt = true;     //.. filelist 
                break;
            case 12:
                gotIt = false;    // objRW
                break;
            case 13:
                gotIt = false;    // UserManager 
                break;
            case 14:
                gotIt = false;    // MetaManager 
                break;
            case 15:
                gotIt = true;    // ..License 
                break;
            case 16:
                gotIt = true;    // ..License 
                break;
            case 17:
                gotIt = true;    // ..License 
                break;
        }
        return gotIt;
    }

    // method to tell if the file needs a default value or not
    private static boolean gotValue(String path) {
        String fileList[] = new Builder().fileList;
        int pos = 0;
        // find position in the array
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].equals(path)) {
                pos = i;
            }
        }
        return gotValueList(pos); // if it has a true value
    }

    // method to choose appropriate data writing method for the file
    private static void chooseValue(String path) {

        String fileList[] = new Builder().fileList;
        int pos = 0;
        // find position in the array
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].equals(path)) {
                pos = i;
            }
        }
        // choose writing method
        switch (pos) {
            case 5:
                countWriter();
                break;
            case 7:
                statQuesWriter();
                break;
            case 8:
                statPaperWriter();
                break;
            case 9:
                statBankWriter();
                break;
            case 11:
                fileListWriter();
                break;
            case 15:
                licenseWriter();
                break;
            case 16:
                contactWriter();
                break;
            case 17:
                helpWriter();
        }
    }
    // value writers for different files ↓↓↓
    private static void countWriter(){
        Counts obj = new Counts(0, 0, 0, 0);
        new CountManager().writeValues(obj);
    }
    
    private static void statQuesWriter(){
        String val = "0";
        String filename = "questions.exm";
        String path = Builder.returnPath("stats");
        Writer.writeData_Single(filename, path, val, false, Writer.ENCRYPT);
    }
    
    private static void statPaperWriter(){
        String val = "0";
        String filename = "papers.exm";
        String path = Builder.returnPath("stats");
        Writer.writeData_Single(filename, path, val, false, Writer.ENCRYPT);
    }
    
    private static void statBankWriter(){
        String val = "0";
        String filename = "banks.exm";
        String path = Builder.returnPath("stats");
        Writer.writeData_Single(filename, path, val, false, Writer.ENCRYPT);
    }
    
    private static void fileListWriter(){
        String l1[] = new Builder().folderList;
        String l2[] = new Builder().fileList;
        // add all names to a single list
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(l1));
        list.addAll(Arrays.asList(l2));
        // write all the values to the file
        String filename = "file_list.exm";
        String path = Builder.returnPath("meta");
        Writer.writeData_Block(filename, path,
                list.toArray(new String[list.size()]), true, Writer.ENCRYPT);
        
    }
    
    private static void licenseWriter(){
        
    }
    
    private static void contactWriter(){
        
    }
    
    private static void helpWriter(){
        
    }
    
}
