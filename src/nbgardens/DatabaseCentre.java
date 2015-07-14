package nbgardens;
import NBGCoreSystems.MessageHandling;
import NBGCoreSystems.Product;
import NBGCoreSystems.ProductStatus;
import java.net.*; 
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

//
/**
 *
 * @author gandrews
 */
public class DatabaseCentre  extends UnicastRemoteObject
implements NBGCoreSystems.DatabaseRemoteInterface {
    
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
    static String databaseURL = "jdbc:mysql://Localhost/nbgdatabase";
    public void databaseURL(String inDatabaseAddress)
    {
        databaseURL = "jdbc:mysql://"+inDatabaseAddress+"/nbgdatabase";
    }
    public String databaseURL()
    {
        return databaseURL;
    }
    static final String databaseDriver = "com.mysql.jdbc.Driver";
    //TODO add various levels of editability based on rights and user access patterns
    static String databaseUsername = "root";//"mUser";
    static String databasePassword = "netbuilder";//netbuilder";
    private Connection conn;
    private Statement statement;
    
    private List<Product> productDatabase = new ArrayList<Product>();
    //<editor-comment desc="Constructors">
    /**
     * Default Constructor for the database
     */
    public DatabaseCentre () throws RemoteException
    {
        try
        {
            //Assign the RMI Server name
            productDatabase.clear();
            readProductEntrysSQL();
            
        }
        catch (Exception e)
        {
            MessageHandling.ErrorHandle("DBCDB01", "Error setting up new listening connection", e, Level.SEVERE);
        }
    }
    //</editor-comment desc="Constructors">
    
    /**
     * creates a connection to the database
     */
    public void createConnection()
    {
        try
	{
            Class.forName(databaseDriver);
            conn = DriverManager.getConnection(databaseURL,databaseUsername,databasePassword);
            System.out.println("Connection To database created");
	}
	catch (Exception e)
	{
            MessageHandling.ErrorHandle("DBCCC01", "Database Connection failed", e, Level.SEVERE);
	}
    }
    
    /**
     * Disconnects from the database
     */
    public void closeConnection()
    {
        try
        {
            conn.close();
            System.out.println("Connection To database closed");
        }
        catch (Exception e)
        {
            MessageHandling.ErrorHandle("DBCCC02", "Closing Database Connection failed", e, Level.SEVERE);
        }
    }
    @Deprecated
    public void UpdateProductSQL(Product inProduct)
    {
	try
	{
            String porouswareBool = "0";
            if(inProduct.Porousware())
            {
                porouswareBool = "1";
            }
            String updateString = String.format(
                "ProductName=\"%s\",Stock=%s,RequiredStock=%s,CriticalLevel=%s,Cost=%s,currentInOrder=%s,ProductStatus=%s,Porousware=%s",
                inProduct.ProductName(),
                inProduct.ProductStock(),
                inProduct.ProductCriticalLevel(),
                inProduct.ProductRecommendedLevel(),
                inProduct.ProductCost(),
                inProduct.CurrentInOrder(),
                inProduct.ProductStatus(),
                porouswareBool
                        );
            String updateConditions = "productID = " + Integer.toString(inProduct.ProductID());
            UpdateSQLSubmit("product",updateString, updateConditions);
	}
	catch (Exception e)
	{
            MessageHandling.ErrorHandle("BDCUP01", e);
	}
    }
    /**
     * Generate update method formatting for SQL update requests
     * @param inTable
     * @param inObject
     */
    private void UpdateSQLSubmit(String inTable, String inRequest, String inCondition)
    {
    	createConnection();
	try
	{
            statement = conn.createStatement();
            String updateString = String.format("UPDATE %s SET %s WHERE %s; ", inTable, inRequest, inCondition);
            
            statement.executeUpdate(updateString);
	}
	catch (Exception e)
	{
            MessageHandling.ErrorHandle("DBCUSQL01", "Unable to send Update request", e, Level.ALL);
	}
	closeConnection();
    }
    
    /**
     * Creates a new product in the database
     */
    public void CreateProductSQL(Product inProduct)
	{
		createConnection();
		try
		{
			statement = conn.createStatement();
		}
		catch (Exception e)
		{
			MessageHandling.ErrorHandle("DBCCNP01", "Unable to create SQL Statement", e, Level.ALL);
		}
                
                String porouswareBool = "0";
                if(inProduct.Porousware())
                {
                    porouswareBool = "1";
                }
		String defaultString = String.format(
                "\"%s\",%s,%s,%s,%s,%s,%s",
                inProduct.ProductName(),
                inProduct.ProductStock(),
                inProduct.ProductCriticalLevel(),
                inProduct.ProductRecommendedLevel(),
                inProduct.ProductCost(),
                inProduct.ProductStatus(),
                porouswareBool
                );
		try
		{
			statement.executeUpdate("INSERT INTO product (ProductName,Stock,RequiredStock,CriticalLevel,Cost,currentInOrder,ProductStatus) VALUE " + defaultString);
		}
		catch (Exception e)
		{
			MessageHandling.ErrorHandle("DBCCNP02", "Unable to push update to database", e, Level.ALL);
		}
                finally
                {
                    closeConnection(); 
                }
    }
    
    /**
     * Reads all products from the database
     */
    public void readProductEntrysSQL()
    {
	createConnection();
	try
	{
            statement = conn.createStatement();
	}
	catch (Exception e)
	{
            MessageHandling.ErrorHandle("DBCRA01", "Error reading from database", e, Level.SEVERE);
	}
        String defaultString = "SELECT ProductID, ProductName, Stock, RequiredStock, CriticalLevel, Cost, currentInOrder, ProductStatus, Porousware FROM Product";
        try
        {
            ResultSet results = statement.executeQuery(defaultString);
            while(results.next())
            {
                int prodID = results.getInt("ProductID");
		String prodName = results.getString("ProductName");
		int prodStock = results.getInt("Stock");
		int prodReqStock = results.getInt("RequiredStock");
		int prodCriticalLevel = results.getInt("CriticalLevel");
		int prodCost = results.getInt("Cost");
                boolean prodPorousware = results.getBoolean("Porousware");
                String prodStatusString = results.getString("ProductStatus"); 
                ProductStatus prodStatus;
                switch(prodStatusString)
                {
                    case "InStock":
                        prodStatus = ProductStatus.InStock;
                        break;
                    case "Discontinued":
                        prodStatus = ProductStatus.Discontinued;
                        break;
                    case "LowStock":
                        prodStatus = ProductStatus.LowStock;
                        break;
                    default:
                        prodStatus = ProductStatus.LowStock;
                        break;
                }
                
                Product tempProduct = new Product(prodID,prodName,prodStock,prodCriticalLevel,prodReqStock,prodCost,prodStatus,prodPorousware);
                tempProduct.ProductStatus(prodStatus);
                productDatabase.add(tempProduct);
                
            }
	}
	catch (Exception e)
	{
            MessageHandling.ErrorHandle("DBCRA02", "Error creating new product", e, Level.SEVERE);
        }
    closeConnection();
    }
    
    /**
     * Sends the requested alert to the desired connected users
     */
    public void SendAlert(ArrayList<String> inDesiredIP, String inAlertMessage)
    {
        
    }
    //#region SQL Methods
    
    //#region Remote Methods
    @Override
    public List<Product> ReadAllProducts() 
    {
        return productDatabase;
    }
    
    @Override
    public Product ReadProduct(int inID) 
    {
        Product returnProduct = null;
        for(int i = 0; i < productDatabase.size();i++)
        {
            if(productDatabase.get(i).ProductID()==inID)
            {
                returnProduct = productDatabase.get(i);
            }
        }
        return returnProduct;
    }
    
    @Override
    public void CreateProduct(Product inProduct)
    {
        CreateProductSQL(inProduct);
    }
    
    public String ChangeState(Product inProduct) throws RemoteException
    {
        String returnMessage = "";
        return returnMessage;
    }
    
    @Override
    public void UpdateProduct(Product inProduct)
    {
        try
        {   
            for(int i = 0; i < productDatabase.size();i++)
            {
                if(productDatabase.get(i).ProductID() == inProduct.ProductID())
                {
                     productCheck(inProduct, i);
                    productDatabase.set(i, inProduct);
                }
            }
            //Update the Local database
            //Update the SQL
                String porouswareBool = "0";
                if(inProduct.Porousware())
                {
                    porouswareBool = "1";
                }
                String defaultString = String.format(
                "ProductName='%s', Stock=%s, RequiredStock=%s, CriticalLevel=%s, Cost=%s, currentInOrder=%s, ProductStatus='%s', Porousware=%s",
                inProduct.ProductName(),
                inProduct.ProductStock(),
                inProduct.ProductRecommendedLevel(),
                inProduct.ProductCriticalLevel(),                
                inProduct.ProductCost(),
                inProduct.CurrentInOrder(),
                inProduct.ProductStatus(),
                porouswareBool
                );
                    String updateConditions;
                    updateConditions = "productID=" + Integer.toString(inProduct.ProductID());
                    UpdateSQLSubmit("product",defaultString, updateConditions);
		}
		catch (Exception e)
		{
                    MessageHandling.ErrorHandle("BDCUP01", "Error updating product", e, Level.SEVERE);
		}
    }
    
    /**
     * Checks the products for logic errors
     */
    public void productCheck(Product inProduct,int inInt)
    {
        try
        {
            //Error problems
            if(inProduct.ProductRecommendedLevel() < inProduct.ProductCriticalLevel())
            {
                MessageHandling.mismatchedValues(inProduct);
                throw new Exception ("Mismatch error");
            }
            //Flag messages
            if(inProduct.ProductStock() > productDatabase.get(inInt).ProductStock())
            {
                MessageHandling.stockIncrease(inProduct, inProduct.ProductStock()-productDatabase.get(inInt).ProductStock());
            }
            if(inProduct.ProductStock()<=inProduct.ProductCriticalLevel())
            {
                MessageHandling.stockLow(inProduct);
            }
        }
        catch (Exception e)
        {
            MessageHandling.ErrorHandle("DBCPC01", e, Level.FINE,false);
        }
    }
}
