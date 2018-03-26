package core.data_manager;
// Purpose: To manage RW of stats in user directory

import readlib.Reader;
import writelib.Writer;

public class StatManager {

    private final String PATH = System.getProperty("user.home") + "\\ExamAssistant"
            + "\\user\\stats";

    private void editVal(boolean increment, String filename) {
        // increment is 'true' for +1, 'false' for -1
        // read existing value from the file...
        String value[] = Reader.readAll(filename, PATH, Reader.ENCRYPTED);
        int val = Integer.parseInt(value[0]);
        // change the value and write it back
        String newVal = (increment) ? String.valueOf(val + 1) : String.valueOf(val - 1);
        Writer.overwrite_Line(filename, PATH, value[0], newVal, Writer.ENCRYPT,
                Writer.UPDATE);
        // done....
    }

    public void editBank(boolean increment) {
        editVal(increment, "banks.exm");
    }

    public void editPaper(boolean increment) {
        editVal(increment, "papers.exm");
    }

    public void editQuestion(boolean increment) {
        editVal(increment, "questions.exm");
    }

}
