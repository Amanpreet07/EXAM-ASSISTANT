package core.data_manager;
//Purpose: To manage RW of counts 

import core.institute.Counts;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CountManager {
    
    private final String PATH = System.getProperty("user.home") + "\\ExamAssistant"
            + "\\user\\institution\\counts.exm";
    
    public Counts getValues() {
        // to read current serialised object.
        Counts obj = null;
        try (FileInputStream fs = new FileInputStream(PATH);) {
            ObjectInputStream ob = new ObjectInputStream(fs);
            obj = (Counts) ob.readObject();
            ob.close();
        } catch (FileNotFoundException | EOFException ex) {
            return null;
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
        return obj;
    }
    
    public boolean writeValues(Counts obj) {
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
    
    public boolean editValues(String param, boolean increment) {
        // increment is 'true' for +1, 'false' for -1
        boolean success = true;
        // retrieve values
        Counts obj = getValues();
        if (obj == null) {
            return false;
        }
        // manipulate parameter accordingly
        switch (param) {
            case "department":
                obj.setDepartments((increment)
                        ? obj.getDepartments() + 1 : obj.getDepartments() - 1);
                break;
            case "course":
                obj.setCourses((increment)
                        ? obj.getCourses() + 1 : obj.getCourses() - 1);
                break;
            case "semester":
                obj.setSemesters((increment)
                        ? obj.getSemesters() + 1 : obj.getSemesters() - 1);
                break;
            case "subject":
                obj.setSubjects((increment) ?
                        obj.getSubjects() + 1 : obj.getSubjects() - 1);
                break;
            default:
                return false;
        }
        // write the changes
        success = writeValues(obj);
        
        return success;
    }
    
}
