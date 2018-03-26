package core.data_manager;
// Purpose: To manage RW of ADMIN profile

import core.user_manager.Admin;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ProfileManager {
    
    private final String PATH = System.getProperty("user.home") + "\\ExamAssistant"
            + "\\user\\profile.exm";
    
    public Admin getValue(){
        // to read previously serialised object
        Admin obj = null;
        try (FileInputStream fs = new FileInputStream(PATH);) {
            ObjectInputStream ob = new ObjectInputStream(fs);
            obj = (Admin) ob.readObject();
            ob.close();
        } catch (FileNotFoundException | EOFException ex) {
            return null;
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
        return obj;
    }
    
    public boolean writeValues(Admin obj) {
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
    
}
