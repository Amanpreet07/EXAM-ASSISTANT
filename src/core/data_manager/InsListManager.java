package core.data_manager;
// Ourpose: To manage RW of Institutional hierarchy.

import core.institute.Department;
import java.io.File;
import java.util.ArrayList;

public class InsListManager {
    
    // complete according to the front end
    private final String PATH = System.getProperty("user.home") + "\\ExamAssistant"
            + "\\user\\institution\\lists.exm";
    
    public ArrayList<Department> readDept(){
        // to read the department object from serialized file
        ArrayList<Department> ar = new ObjRW<Department>().read(new File(PATH));
        return ar;
    }
    
    
    
    
    
}
