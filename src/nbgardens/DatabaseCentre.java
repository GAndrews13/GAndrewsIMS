package nbgardens;
import NBGCoreSystems.DataController;
import NBGCoreSystems.MessageHandling;
import NBGCoreSystems.MessageHandling;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*; 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.logging.Level;

//
/**
 *
 * @author gandrews
 */
public class DatabaseCentre implements Runnable {
    
    /**
     * Used to keep track of the IP's connected to the database manager
     */
    private ArrayList<String> connectedIPs = new ArrayList<String>();
    //Are new users able to connect to the server
    private boolean acceptingConnections = true;
    //Socket which the database accepts a connection from
    private ServerSocket avaliableSocket;
    private int serverPort = 3306;
    public int ServerPort() {
        return serverPort;
    }

    public void ServerPort(int serverPort) {
        this.serverPort = serverPort;
    }
    
    //<editor-comment desc="Constructors">
    /**
     * Default Constructor for the database
     */
    public DatabaseCentre()
    {
        try
        {
            System.out.println("Database Centre Initalized");
            avaliableSocket = new ServerSocket(serverPort);
            //Relocate to appropiate area within code
            String threadName = NBGCoreSystems.DataController.DateTime();
            Thread t = new Thread(this,threadName);  
            t.start();
        }
        catch (Exception e)
        {
            MessageHandling.ErrorHandle("DBCDB01", "Error setting up new listening connection", e, Level.SEVERE);
        }
    }
    //</editor-comment desc="Constructors">

    /**
     * The method which runs when a thread of this class is created
     */
    @Override
    public void run() {
        RecieveRequests();
    }
    
    /**
     * Enums outlining possible request types
     */
    public enum requestTypes{
        READING,CREATING,UPDATING,STATECHANGE
    }
    /**
     * Sends the request to a database
     */
    public void SendRequest()
    {
        
    }
    /**
     * Recieves with the request from a remote connection
     */
    public void RecieveRequests()
    {
        try
        {
            System.out.println("Starting to listen");
            Socket connectionSocket = avaliableSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            //Read in data from the client
            String clientRecievedMessage = inFromClient.readLine();
            HandleRequest(clientRecievedMessage, connectionSocket.getRemoteSocketAddress().toString());
            System.out.println("Request Recieved from: " + connectionSocket.getRemoteSocketAddress().toString() + ". Now starting again");
        }
        catch (Exception e)
        {
            MessageHandling.ErrorHandle("DBCRR01", e, Level.SEVERE);
        }
    }
    /**
     * Uses the requests to perform the appropiate actions
     */
    public void HandleRequest(String inMessage, String inIP)
    {
        System.out.println("Message recieved: " + inMessage);
        MessageHandling.DatabaseLog(inMessage, inIP);
        //TODO add message handling and improve efficiancy
        String[] messageBreakDown = inMessage.split(" ");
        for(int i = 0; i< messageBreakDown.length;i++)
        {
            switch(messageBreakDown[i])
            {
                case "":
                    break;
                case "TEST":
                    testHandle();
                    break;
            }
        }
    }
    /**
     * A method used for testing a connection and the servers capability for handling requests
     */
    public void testHandle()
    {
        System.out.println("TEST Message acknowledged");
        MessageHandling.GeneralLog("DCTH01", "Test Completed", "Test Completed");
    }
    /**
     * Sends the requested alert to the desired connected users
     */
    public void SendAlert(ArrayList<String> inDesiredIP, String inAlertMessage)
    {
        
    }
}
