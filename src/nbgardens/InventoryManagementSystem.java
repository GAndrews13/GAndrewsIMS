/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbgardens;

import NBGCoreSystems.DatabaseRemoteInterface;
import NBGCoreSystems.MessageHandling;
import NBGCoreSystems.Product;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author gandrews
 */
public class InventoryManagementSystem
{
    /**
     * Contains the products that were gathered from the Database controller
     */
    private ArrayList<Product> productDatabase = new ArrayList<Product>();
    public ArrayList<Product> ProductDatabase()
    {
        return productDatabase;
    }
    public void ProductDatabase(ArrayList<Product> inList)
    {
        productDatabase = inList;
    }
    
    /**
     *  Calls the database controller and returns and assigns the productDatabase ready for use
     */
    public void populateProductDatabase()
    {
        //TODO gather product database and copy into
        try
        {
            productDatabase =(ArrayList<Product>) Naming.lookup("//localhost//DatabaseCentre"); // invoke(DatabaseRemoteInterface.ReadAllProducts);
        }
        catch (Exception e)
        {
            MessageHandling.ErrorHandle("IMSPPD01", "Error collecting product information from server", e, Level.SEVERE);
        }
        
    }
}
