package core.data_manager;
// Purpose: To manager RW of PDF files.

import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfManager {

    // Document Properties
    // -> Page Size
    // -> Password
    // -> Allow Printing or Degrader Printing
    // -> Allow Modification of contents or not
    // -> Encryption Type AES 128/256
    
    private Rectangle pageSize;
    private String password;
    private int printType;
    private int modification;
    private int encryption;

    public PdfManager() {
        pageSize = PageSize.A4;
        password = null;
        printType = PdfWriter.ALLOW_PRINTING;
        modification = PdfWriter.ALLOW_MODIFY_CONTENTS;
        encryption = PdfWriter.ENCRYPTION_AES_128;
    }

    public PdfManager(Rectangle pageSize, String password, int printType, 
            int modification, int encryption) {
        this.pageSize = pageSize;
        this.password = password;
        this.printType = printType;
        this.modification = modification;
        this.encryption = encryption;
    }

    public Rectangle getPageSize() {
        return pageSize;
    }

    public void setPageSize(Rectangle pageSize) {
        this.pageSize = pageSize;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPrintType() {
        return printType;
    }

    public void setPrintType(int printType) {
        this.printType = printType;
    }

    public int getModification() {
        return modification;
    }

    public void setModification(int modification) {
        this.modification = modification;
    }

    public int getEncryption() {
        return encryption;
    }

    public void setEncryption(int encryption) {
        this.encryption = encryption;
    }
    
    
   
      
}
