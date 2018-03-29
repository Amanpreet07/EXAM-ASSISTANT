package core.data_manager;
// Purpose: To manager RW of PDF files.

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import core.blueprint.Blueprint;
import core.blueprint.Bmeta;
import core.user_manager.Admin;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import setup.SetupManager;

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
    private String path;

    public PdfManager() {
        pageSize = PageSize.A4;
        password = null;
        printType = PdfWriter.ALLOW_PRINTING;
        modification = PdfWriter.ALLOW_MODIFY_CONTENTS;
        encryption = PdfWriter.ENCRYPTION_AES_128;
        path = null;
    }

    public PdfManager(Rectangle pageSize, String password, int printType,
            int modification, int encryption, String path) {
        this.pageSize = pageSize;
        this.password = password;
        this.printType = printType;
        this.modification = modification;
        this.encryption = encryption;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    // To sign document properties
    private void stamp(String source, String destination,
            byte[] user, int printType, int modification, int encryption)
            throws IOException, DocumentException {

        PdfReader reader = new PdfReader(source);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(destination));
        byte[] ownerPassword = "D@MIEN$".getBytes();
        if (modification == 0) {
            stamper.setEncryption(user, ownerPassword, printType,
                    encryption | PdfWriter.DO_NOT_ENCRYPT_METADATA);
        } else {
            stamper.setEncryption(user, ownerPassword, printType | modification,
                    encryption | PdfWriter.DO_NOT_ENCRYPT_METADATA);
        }
        stamper.close();
        reader.close();

    }

    // to pass data to stamp
    public void stampManager(String filename, byte[] user, int printType,
            int modification, int encryption) throws IOException, DocumentException {
        SetupManager.createFolder("secured", Builder.returnPath("paper"));
        SetupManager.createFile(filename, Builder.returnPath("paper") + "\\secured");
        // new folder and file are created..
        // stamp file
        stamp(Builder.returnPath("paper") + "\\" + filename,
                Builder.returnPath("paper") + "\\secured\\" + filename,
                user, printType, modification, encryption);
        File f_old = new File(Builder.returnPath("paper") + "\\" + filename);
        // delete old file..
        f_old.delete();

    }

    // to write file to the provided destination.
    public void cloneToPath(String filename) throws IOException {
        File f = null;
        if (getPassword() == null) {
            f = new File(Builder.returnPath("paper") + "\\" + filename);
        } else {
            f = new File(Builder.returnPath("paper") + "\\secured\\" + filename);
        }
        File f2 = new File(getPath() + "\\" + filename);
        Files.copy(f.toPath(), f2.toPath());
    }

    // to find and locate object in meta array
    private Bmeta findObject(Bmeta arr[], int pos, int order) {
        // pos 0 : no alignment
        // pos 1 : left alignment
        // pos 2 : right alignment
        Bmeta b = null;
        if (pos==2) {
            // if alignment is right
            for (Bmeta arr1 : arr) {
                if (arr1.getGroupNumber() == order) {
                    if (arr1.getAlignment() == Paragraph.ALIGN_RIGHT) {
                        b = arr1;
                    }
                }
            }
        } else if(pos==1){
            // if alignment is left
            for (Bmeta arr1 : arr) {
                if (arr1.getGroupNumber() == order) {
                    if (arr1.getAlignment() == Paragraph.ALIGN_LEFT) {
                        b = arr1;
                    }
                }
            }
        }
        else{
            // for pos 0
            for (Bmeta arr1 : arr) {
                if(arr1.getGroupNumber() == order){
                    b = arr1;
                }
            }
        }
        return b;
    }

    // to write the pdf
    public void writePdf(String filename, Blueprint b) throws DocumentException, FileNotFoundException {

        Bmeta lElement = null; // for left element in a group
        Bmeta rElement = null; // for right element in a group
        String value = null; // for final value to be written
        Document dc = new Document(getPageSize());
        // doc meta data
        dc.addCreator("Exam Assistant");
        dc.addAuthor(new Admin().getName());
        dc.addCreationDate();

        PdfWriter.getInstance(dc, new 
            FileOutputStream(Builder.returnPath("paper") + "\\" + filename));
        dc.open();

        // Blueprint writing...
        // b meta writing
        Bmeta obj[] = b.getBmeta();
           
            for (int i = 1; i <= 10; i++) {
                Bmeta obj1 = findObject(obj, 0, i);
                 if(obj1 == null){
                     break;
                     // if no object found..stop the iteration..
                 }
            
                    if (obj1.isGroup()) {
                        // if its a group
                        lElement = findObject(obj, 1, obj1.getGroupNumber());
                        rElement = findObject(obj, 2, obj1.getGroupNumber());
                        // chunk is to align para into left and right
                        Chunk ch1 = new Chunk(new VerticalPositionMark());
                        if (lElement.getAlias() == null) {
                            // if alias is null, leave it blank...only value
                            value = lElement.getValue();
                        } else {
                            value = lElement.getAlias() + lElement.getValue();
                        }
                        Paragraph p = new Paragraph();
                        Chunk ch = new Chunk(value, 
                            FontFactory.getFont(lElement.getFont(),lElement.getSize()));
                        p.add(ch);
                        // first element at left position ↑
                        // second element, Blank space in between ↓
                        p.add(ch1);
                        // Third element in the right
                        if (rElement.getAlias() == null) {
                            // if alias is null, leave it blank...only value
                            value = rElement.getValue();
                        } else {
                            value = rElement.getAlias() + rElement.getValue();
                        }
                        Chunk ch2 = new Chunk(value,
                            FontFactory.getFont(rElement.getFont(),rElement.getSize()));
                        p.add(ch2);
                        dc.add(p);

                    } else {
                        // if not a group then write simply
                        if (obj1.getAlias() == null) {
                            // if alias is null, leave it blank...only value
                            value = obj1.getValue();
                        } else {
                            value = obj1.getAlias() + obj1.getValue();
                        }
                        Paragraph p1 = new Paragraph(value,
                                FontFactory.getFont(obj1.getFont(), obj1.getSize()));
                        p1.setAlignment(obj1.getAlignment());
                        dc.add(p1);
                    }
                    break;
           
            } // meta writing done
        } 

    }

