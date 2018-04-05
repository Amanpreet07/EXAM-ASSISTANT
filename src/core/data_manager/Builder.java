package core.data_manager;

// Purpose: to deal with directories in the background.
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Builder {

    public String rootPath = System.getProperty("user.home") + "\\ExamAssistant";
    private static ArrayList<String> missingFolders = new ArrayList<>();
    private static ArrayList<String> missingFiles = new ArrayList<>();
    
    public String folderList[] = {
        rootPath + "\\user", // just numbers to quickly find index number
        rootPath + "\\user\\blueprints",
        rootPath + "\\user\\institution", // 2
        rootPath + "\\user\\bank",
        rootPath + "\\user\\papers",
        rootPath + "\\user\\logs", // 5
        rootPath + "\\user\\stats",
        rootPath + "\\global",
        rootPath + "\\global\\temp", // 8
        rootPath + "\\global\\metadata",
        rootPath + "\\global\\current",
        rootPath + "\\License" // 11
    };

    public String fileList[] = {
        folderList[0] + "\\profile.exm",
        folderList[0] + "\\todo.exm", // 1
        folderList[0] + "\\notes.exm",
        folderList[0] + "\\notif.exm",
        folderList[2] + "\\profile.exm", // 4
        folderList[2] + "\\counts.exm",
        folderList[2] + "\\lists.exm",
        folderList[6] + "\\questions.exm", // 7
        folderList[6] + "\\papers.exm",
        folderList[6] + "\\banks.exm",
        folderList[9] + "\\paths.exm", // 10
        folderList[9] + "\\file_list.exm",
        folderList[9] + "\\recent.exm",
        folderList[9] + "\\users.exm", // 13
        folderList[9] + "\\integrity.exm",
        folderList[11] + "\\license.txt",
        folderList[11] + "\\contact.txt", // 16
        folderList[11] + "\\help.html"
    };

    // method to create files at first startup...
    public int initFiles() {
        int status = 1; // 0 is error, 1 is good.
        new File(rootPath).mkdir(); // to make initial directory
        // make root folders first
        for (String folderList1 : folderList) {
            new File(folderList1).mkdir();
        }
        // make default files in folders
        for (String filelist : fileList) {
            try {
                new File(filelist).createNewFile();
            } catch (IOException ex) {
                status = 0;
            }
        }

        // add default values to these files (where required)
        return status;
    }

    // to look for core files 
    public boolean validate() {
        boolean success = true;
        File f;
        for (String list : folderList) {
            f = new File(list);
            if (!f.exists()) {
                // if folder not found.
                success = false;
                missingFolders.add(list); // to add to list of missing files
            }
        }
        for (String list2 : fileList) {
            f = new File(list2);
            if (!f.exists()) {
                // file does not exist
                success = false;
                missingFiles.add(list2);
            }
        }
        return success;
    }

    // method to verify the core files and their last known size
    public static boolean checkIntegrity() {
        boolean success = true;
        long newSize = 0;
        try {
            newSize = Files.size(new File(returnPath("integrity")).toPath());
        } catch (Exception e) {
            success = false;
        }
        String val = new MetaManager().readIntegrity(); // reads from the file
        long oldSize = Long.parseLong(val);
        if (newSize != oldSize) {
            success = false;
        }
        return success;
    }

    // method to return paths of folders and files.
    public static String returnPath(String type) {
        String path = null;
        Builder b = new Builder();
        switch (type) {
            case "log_guest":
                path = b.folderList[8];
                break;
            case "log_admin":
                path = b.folderList[5];
                break;
            case "stats":
                path = b.folderList[6];
                break;
            case "ins_counts":
                path = b.fileList[5];
                break;
            case "ins_profile":
                path = b.fileList[4];
                break;
            case "admin_profile":
                path = b.fileList[0];
                break;
            case "paper":
                path = b.folderList[4];
                break;
            case "integrity":
                path = b.fileList[14];
                break;
            case "meta":
                path = b.folderList[9];
                break;
            // complete this.......
            default:
        }

        return path;
    }

    // method to rebuilt core files
    public static boolean attempRepair() {
        boolean success = true;
        Builder b = new Builder();
        File f;
        try{
        for (String folder : Builder.missingFolders) {
            f = new File(folder);
            f.mkdir();
        }
        for (String file : Builder.missingFiles) {
            f = new File(file);
            f.createNewFile();
        }
        Default.writeDefault(missingFiles.toArray(new String[missingFiles.size()]));
        
        }catch(Exception e){
            success = false;
        }
        return success;
    }
}
