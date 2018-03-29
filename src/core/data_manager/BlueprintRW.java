package core.data_manager;
// Purpose: To manage RW of Blueprints

import core.blueprint.Blueprint;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BlueprintRW {
    
    private final String PATH = System.getProperty("user.home") + "\\ExamAssistant"
           + "\\user\\blueprints";
    
    public Blueprint readValue(String filename){
      // to read previously serialised object
        Blueprint obj = null;
        try (FileInputStream fs = new FileInputStream(PATH+"\\"+filename);) {
            ObjectInputStream ob = new ObjectInputStream(fs);
            obj = (Blueprint) ob.readObject();
            ob.close();
        } catch (FileNotFoundException | EOFException ex) {
            return null;
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
        return obj;  
    }
    
    public boolean writeValues(Blueprint obj, String filename) {
        // to write back changes...
        boolean success = true;
        // to write back the changes
        try (FileOutputStream fs = new FileOutputStream(PATH+"\\"+filename);) {
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
