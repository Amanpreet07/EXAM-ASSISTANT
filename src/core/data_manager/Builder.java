package core.data_manager;

// Purpose: to deal with directories in the background.
import java.io.File;
import java.io.IOException;

public class Builder {

    public String rootPath = System.getProperty("user.home") + "\\ExamAssistant";

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

    // method to verify the core files and their last known size
    public static int checkIntegrity() {
        int status = 1; // 0 is error, 1 is good

        return status;
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
            // complete this.......
            default:
        }

        return path;
    }

    // method to rebuilt core files
    public static boolean attempRepair() {
        boolean success = true;

        return success;
    }
}
