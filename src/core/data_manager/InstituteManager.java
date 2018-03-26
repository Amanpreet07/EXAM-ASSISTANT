package core.data_manager;
// Purpose: To manage RW of Institution class

import core.institute.Institution;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class InstituteManager {
    
    private final String PATH = System.getProperty("user.home") + "\\ExamAssistant"
           + "\\user\\institution\\profile.exm";
    
    public Institution getValue(){
        // to read previously serialised object
        Institution obj = null;
        try (FileInputStream fs = new FileInputStream(PATH);) {
            ObjectInputStream ob = new ObjectInputStream(fs);
            obj = (Institution) ob.readObject();
            ob.close();
        } catch (FileNotFoundException | EOFException ex) {
            return null;
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
        return obj;
    }
    
    public boolean writeValues(Institution obj) {
        // to write back changes...
        boolean success = true;
        // to write back the changes
        try (FileOutputStream fs = new FileOutputStream(PATH);) {
            ObjectOutputStream ob = new ObjectOutputStream(fs);
            ob.writeObject(obj);
            ob.close();
        } catch (FileNotFoundException ex) {
            success = false;
        } catch (IOException ex) {
            success = false;
        }
        return success;
    }
    
    // no need to have a data manipulation method as it can be done directly
    // from the front end by passing a new object..
    
}
