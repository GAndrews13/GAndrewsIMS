import java.io.*;
import java.util.logging.Level;
import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gandrews
 */
public class DataControler
{
    // <editor-comment desc="General Variables">
    private String programDirectory = System.getProperty("user.dir"); 
    private String configFileName = "config.NBG";
    
    private String databaseControllerIP;
    
    // </editor-comment desc="General Variables">

    // <editor-comment desc="Configuration file">
    public void createGeneralConfigFile()
    {
        PrintWriter writer = null;
        try
        {
            writer = new PrintWriter(programDirectory + "\\" + configFileName, "UTF-8");
            try
            {
                //TOOD Add custom config file data
                writer.println("<STARTCONFIG>");
                writer.println("databaseControllerIP | localhost");
                
                writer.println("<ENDCONFIG>");
            }
            catch (Exception e)
            {
                MessageHandling.ErrorHandle("CGCF02", e, Level.WARNING);
            }
            writer.flush();
        }
        catch (Exception e)
        {
            MessageHandling.ErrorHandle("CGCF01", e, Level.WARNING);
        }
        finally
        {
            writer.close();
        }
    }
    
    public void ReadConfigFile()
    {
        try
        {
            FileReader fr = new FileReader(programDirectory + "\\" + configFileName);
            BufferedReader textReader = new BufferedReader(fr);
            List<String> text = new ArrayList<String>();
            boolean ableToRead = true;
            while (ableToRead == true)
            {
                String read = textReader.readLine();
                String[] splitArray = new String[2]; 
                if(read.contains("|"))
                {
                    splitArray = read.split(read, '|');
                    //The title of the config line
                    //Index 1 contains the data that needs to be acted on
                    read = splitArray[0];
                }
                switch(read.trim())
                        {
                            case "<ENDCONFIG>":
                                ableToRead = false;
                            break;
                            case "databaseControllerIP":
                                databaseControllerIP = splitArray[1];
                                break;
                        }
            }
        }
        catch (Exception e)
        {
            MessageHandling.ErrorHandle("DCRCF01", e, Level.SEVERE);
        }
    }
    // </editor-comment desc="Configuration file">

}
