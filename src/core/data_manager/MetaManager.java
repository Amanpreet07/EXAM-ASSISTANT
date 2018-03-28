package core.data_manager;
// Purpose: To manage the RW of metadata files like 'file-list' and 'integrity'

import readlib.Reader;
import writelib.Writer;

public class MetaManager {
    
    private final String PATH = System.getProperty("user.home") + "\\ExamAssistant"
            + "\\global\\metadata";
    
    public String readIntegrity(){
        String val[] = null;
        val = Reader.readAll("integrity.exm", PATH, Reader.ENCRYPTED);
        return val[0];
    }
    
    public void writeIntegrity(String val){
        Writer.writeData_Single("integrity.exm", PATH, val, false, Writer.ENCRYPT);
    }
    
    public void updateIntegrity(String val){
        Writer.clearFile("integrity.exm", PATH); // all data removed..
        // write new data now
        writeIntegrity(val);
    }
     
}
