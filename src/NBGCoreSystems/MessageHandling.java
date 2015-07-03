package NBGCoreSystems;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gandrews
 */
public class MessageHandling {
    /**
     * The logger used to record all interactions of notice
     */
    private static final Logger logger = Logger.getLogger(MessageHandling.class.getName());
    
    /**
     * Handles the errors
     * @param inLocation
     * a custom location that identifies where in the code the error has been thrown
     * @param inError
     * Identifies the error itself
     * @return 
     * A string that can be displayed either in a console format or a message box by the user
     */
    public static String ErrorHandle(String inLocation, Exception inError)
    {
        logger.log(Level.WARNING, inError.toString());
        String stringFormat = "Error: %s AT %s";
        return String.format(stringFormat, inError, inLocation);
    }
    /**
     * Allows a custom logging error level to be set in the error log
     * @param inLocation
     * The location of the error within the code
     * @param inError
     * The error itself
     * @param inLevel
     * The level that has been designated to the error
     * @return 
     */
    public static String ErrorHandle(String inLocation, Exception inError, Level inLevel)
    {
        logger.log(inLevel, inError.toString());
        String stringFormat = "Error: %s AT %s";
        String errorString = String.format(stringFormat, inError, inLocation);
        try
        {
            JOptionPane.showMessageDialog(null,"Error reported",errorString,JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception e)
        {
           ErrorHandle("EH01",e);
        }
        return errorString;
    }
    /**
     * 
    */
    public static String ErrorHandle(String inLocation, String inMessage, Exception inError, Level inLevel)
    {
        logger.log(inLevel, inError.toString());
        String stringFormat = "Error: %s AT %s";
        String errorString = String.format(stringFormat, inError, inLocation);
        try
        {
            JOptionPane.showMessageDialog(null,inMessage,errorString,JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception e)
        {
           ErrorHandle("EH01",e);
        }
        return errorString;
    }
    /*
     * Allows a general message to be logged
     * @param inLocation
     * Location that the log message was sent from
     * @param inLogMessage 
     * The message that is intended to be logged
     */
    public static void GeneralLog(String inLocation, String inLogMessage)
    {
        logger.log(Level.OFF, inLogMessage);
    }
    public static void GeneralLog(String inLocation, String inLogTitle, String inLogMessage)       
    {
        logger.log(Level.OFF, inLogTitle + ": " + inLogMessage);
    }
    public static void DatabaseLog(String inRequest, String inAddress)
    {
        logger.log(Level.INFO,inAddress+" requested: " + inRequest);
    }
    /**
     * Displays a pop up message
     * @param inTitle
     * @param inMessage 
     */
    public static void PopUpMessage(String inTitle, String inMessage)
    {
        JOptionPane.showMessageDialog(null,inMessage,inTitle,JOptionPane.ERROR_MESSAGE);
    }
}
