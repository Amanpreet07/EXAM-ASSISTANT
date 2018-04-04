package core.data_manager;
// To manage read write of bank class

import core.extras.Bank;
import core.extras.BankQues;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import setup.SetupManager;

public class BankRW {
    
    private final String PATH = System.getProperty("user.home") + "\\ExamAssistant"
           + "\\user\\bank";
    
    public Bank readValue(String filename){
      // to read previously serialised object
        Bank obj = null;
        try (FileInputStream fs = new FileInputStream(PATH+"\\"+filename);) {
            ObjectInputStream ob = new ObjectInputStream(fs);
            obj = (Bank) ob.readObject();
            ob.close();
        } catch (FileNotFoundException | EOFException ex) {
            return null;
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
        return obj;  
    }
    
    private boolean writeValues(Bank obj, String filename) {
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
    
    public boolean writeObj(Bank obj, String filename){
      boolean success = true;
      // check for file
      File f = new File(PATH+"\\"+filename);
      if(!f.exists()){
      // create new and write object
      SetupManager.createFile(filename, PATH);
        success = writeValues(obj, filename);
      }
      else{
        // add more questions to it
        Bank b = readValue(filename);
        BankQues bqOld[] = b.getQuestions();
        BankQues bqNew[] = obj.getQuestions();
        ArrayList<BankQues> ar = new ArrayList<>(Arrays.asList(bqOld));
          // append these new questions in old
        ar.addAll(Arrays.asList(bqNew));
        // now make a new object to write
        Bank bNew = new Bank();
        bNew.setDeptName(obj.getDeptName());
        bNew.setCourseName(obj.getCourseName());
        bNew.setSubjectCode(obj.getSubjectCode());
        bNew.setSubjectName(obj.getSubjectName());
        bNew.setQuestions(ar.toArray(new BankQues[ar.size()]));
        // write back
        success = writeValues(bNew, filename);
      }
      
      return success;
    }
    
    
}
