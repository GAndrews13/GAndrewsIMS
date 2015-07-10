/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbgims;

import NBGCoreSystems.MessageHandling;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import nbgardens.DatabaseCentre;
import Interfaces.InitialScreen;

/**
 *
 * @author Gareth
 */
public class NBGIMS extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        InitialScreen screen = new InitialScreen();
        screen.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
        {
            DatabaseCentre dbc = new DatabaseCentre();
            try
            {
                System.out.println("DBC registered on the registry started");
                Registry reg = LocateRegistry.createRegistry(1099);
                reg.bind("DatabaseCentre",dbc);
                System.out.println("DBC registered on the registry");
            }
            catch (Exception e)
            {
                MessageHandling.ErrorHandle("NBGIMSM02", "Error registering Database Centre", e, Level.SEVERE);
            }
            
        }
        catch (Exception e)
        {
            //FIXME
            MessageHandling.ErrorHandle("NBGIMSM01", "Error starting Database Centre", e, Level.SEVERE);
        }
        launch(args);
    }
    
}
