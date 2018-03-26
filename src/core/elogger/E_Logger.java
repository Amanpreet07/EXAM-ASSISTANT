package core.elogger;

// Purpose: To handle all the logs RW
import core.Holder;
import core.extras.DateManip;
import java.io.File;
import java.io.IOException;
import setup.SetupManager;
import writelib.Writer;

public class E_Logger {

    // folder name depends on current 'monthname' both for guest and admin
    // file name is 'log.exm'
    public boolean writeLog(String data, String dateType) {
        boolean success = true;
        if (determineUser().equals("ADMIN")) {
            success = write(data, dateType, folderChooser("ADMIN"));
        } else {
            success = write(data, dateType, folderChooser("GUEST"));
        }
        return success;
    }

    private String folderChooser(String user) {

        String currentMonth = DateManip.getCurrentDT("month"); // current month name
        File file = null; // needed for getting name list
        // save log folders to avoid processing while multiple comparisons further
        // in the code
        String adminLogPath = System.getProperty("user.home") + "\\ExamAssistant"
                + "\\user\\logs";
        String guestLogPath = System.getProperty("user.home") + "\\ExamAssistant"
                + "\\global\\temp";
        boolean found = false; // flag for matching folder name

        if (user.equals("ADMIN")) {
            file = new File(adminLogPath);
        } else {
            file = new File(guestLogPath);
        }
        // list of existing folders in the log folder BY MONTH
        String existingList[] = file.list();
        // check for folder by name of month 
        for (String existingList1 : existingList) {
            if (existingList1.contains(currentMonth)) {
                found = true;
                break;
            } else {
                found = false;
            }
        }
        // if found return folder, otherwise create new folder and return file
        // name within it
        if (found == true) {
            if (user.equals("ADMIN")) {
                return adminLogPath + "\\" + currentMonth;
            } else {
                return guestLogPath + "\\" + currentMonth;
            }
        } else {
            // if folder does not exist
            // create folder first in correct user directory
            if (user.equals("ADMIN")) {
                SetupManager.createFolder(currentMonth, adminLogPath);
                // method from my custom library
                return adminLogPath + "\\" + currentMonth;
            } else {
                SetupManager.createFolder(currentMonth, guestLogPath);
                // method from my custom library
                return guestLogPath + "\\" + currentMonth;
            }
        }
        // doesn't check for file existance..
    }

    private String determineUser() {
        return Holder.getInstance().getSession();
    }

    private boolean write(String data, String dateType, String path) {
        boolean success = true;
        String timestamp = DateManip.getCurrentDT(dateType);
        // check if file exists or not
        File f = new File(path + "\\log.exm");
        if (!f.exists()) {
            try {
                // create if !exists
                f.createNewFile();
            } catch (IOException ex) {
                return false;
            }
        }
        String toWrite = determineUser() + "-->" + timestamp + "-->" + data;
        // write after checking..
        Writer.writeData_Single("log.exm", path, toWrite,
                true, Writer.ENCRYPT);
        return success;
    }

}
