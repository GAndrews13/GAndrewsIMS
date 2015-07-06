package NBGCoreSystems;

import java.io.*;
import java.util.logging.Level;
import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.lang.SecurityManager;
import java.rmi.server.UnicastRemoteObject;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gandrews
 */
public class DataController //extends UnicastRemoteObject implements DatabaseRemoteInterface
{
    

    /**
     *Creates the datacontroller
     */
    public DataController()
        {
            //Creates a security manager which controls and assesses if code has the right to access or run within the system
            //if(System.getSecurityManager() == null)
            {
            //    System.setSecurityManager(new SecurityManager());
            }
            CreateGeneralConfigFile();
            ReadConfigFile();
        }
        // <editor-comment desc="General Variables">
        private String programDirectory = System.getProperty("user.dir"); 
        public String ProgramDirectory() {
            return programDirectory;
        }
        private String configFileName = "config.NBG";

        private char splitCharacter = '|';

        private String databaseControllerIP;
        public String DatabaseControllerIP() {
            return databaseControllerIP;
        }
        public void DatabaseControllerIP(String databaseControllerIP) {
            this.databaseControllerIP = databaseControllerIP;
        }

        private int databaseControllerPort = 3306;//62825;
        public int DatabaseControllerPort() {
            return databaseControllerPort;
        }
        public void DatabaseControllerPort(int databaseControllerPort) {
            this.databaseControllerPort = databaseControllerPort;
        }
    // </editor-comment desc="General Variables">



        // <editor-comment desc="Configuration file">
        public void CreateGeneralConfigFile()
        {
            MessageHandling.GeneralLog("DCCGC02", "Creating general config file");
            PrintWriter writer = null;
            try
            {
                //writer = new PrintWriter(programDirectory + "\\" + configFileName, "UTF-8");
                writer = new PrintWriter("C:\\\\users\\Gareth\\desktop\\" + configFileName, "UTF-8");
                try
                {
                    //TOOD Add custom config file data
                    writer.println("<STARTCONFIG>");
                    writer.println("databaseControllerIP"+splitCharacter+"localhost");

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
                    //FIXME Code not splitting text correctly
                    String read = textReader.readLine();
                    String[] splitArray = new String[0]; 
                    String splitString = new String();
                    splitString += splitCharacter;
                    if(read.contains(splitString))
                    {
                        splitArray = read.split(read, splitCharacter);

                        //The title of the config line
                        //Index 1 contains the data that needs to be acted on
                        //read = splitArray[0];
                        System.out.println(read.toString());
                    }
                    switch(read.trim())
                            {
                                case "<ENDCONFIG>":
                                    ableToRead = false;
                                break;
                                case "databaseControllerIP":
                                    databaseControllerIP = splitArray[3];
                                    break;
                                case "databaseControllerPort":
                                    databaseControllerPort = Integer.parseInt(splitArray[3]);
                                    break;
                            }
                }
            }
            catch (Exception e)
            {
                MessageHandling.ErrorHandle("DCRCF01", e, Level.SEVERE);
            }
        }
          /**
         * Returns the date time in a readable format
         * @return 
         */
        public static String DateTime()
        {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:MM:SS");
            return dateFormat.format(date);
        }
        // </editor-comment desc="Configuration file">
        //<editor-comment desc= "Remote methods">

        //</editor-comment desc= "Remote methods">
    
}
