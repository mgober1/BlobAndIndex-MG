import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class Index {
    
    private HashMap <String, String> hm;
    private PrintWriter pw;
    public Index() throws FileNotFoundException
    {
        hm = new HashMap <String, String> ();
        pw = new PrintWriter ("index");
    }

    public void initialize () throws IOException
    {
        
        File path = new File("objects");
        path.mkdirs();
        File file = new File ("index");
        //String path = "objects" + File.separator + "index";
        if (!file.exists())
        {
            //File newFile = new File
            file.createNewFile();
        }
    }

    public void addBlobs (String fileName) throws Throwable
    {
        Blob blob = new Blob (fileName);
        String s = Blob.encryptPassword(fileName);
        hm.put (blob.originalName(), s);
        
        for (HashMap.Entry <String, String> entry : hm.entrySet ())
        {
            String string = entry.getKey () + " : " + entry.getValue ();
            pw.println (string);
        }
        pw.close();
    }

    public void removeBlob (String fileName) throws FileNotFoundException
    {
        hm.remove (fileName);
        
        for (HashMap.Entry <String, String> entry : hm.entrySet ())
        {
            pw.println (entry.getKey () + " : " + entry.getValue ());

        }
        pw.close();
    }
 }


