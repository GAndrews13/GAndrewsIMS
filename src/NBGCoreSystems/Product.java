package NBGCoreSystems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
package NBGCoreSystems;

/**
 *Contains all relevant information that will be stored about products
 * @author gandrews
 */
public class Product {

    private int productID;
    private String productName;
    private int productStock;
    private int productCriticalLevel;
    private int productRecommendedLevel;
    private Double productCost;
    private int currentInOrder;
    private String status;

    public String Status() {
        return status;
    }

    public void Status(String status) {
        this.status = status;
    }

    //<editor-fold desc="Variable Manipulators">
    //<editor-fold desc="Getters">
    public int ProductID() {
        return productID;
    }

    public String ProductName() {
        return productName;
    }

    public int ProductStock() {
        return productStock;
    }

    public int ProductCriticalLevel() {
        return productCriticalLevel;
    }

    public int ProductRecommendedLevel() {
        return productRecommendedLevel;
    }

    public Double ProductCost() {
        return productCost;
    }

    public int CurrentInOrder()
    {
        return currentInOrder;
    }
    //</editor-fold desc="Getters">
    //</editor-fold desc="Setters">
    public void ProductID(int productID) {
        this.productID = productID;
    }

    public void ProductName(String productName) {
        this.productName = productName;
    }

    public void ProductStock(int productStockManipulator) {
        this.productStock += productStock;
    }

    public void ProductCriticalLevel(int productCriticalLevel) {
        this.productCriticalLevel = productCriticalLevel;
    }

    public void ProductRecommendedLevel(int productRecommendedLevel) {
        this.productRecommendedLevel = productRecommendedLevel;
    }

    public void ProductCost(Double productCost) {
        this.productCost = productCost;
    }

    public void CurrentInOrder(int currentInOrderManipulator)
    {
        currentInOrder += currentInOrderManipulator;
    }
    //</editor-fold desc="Setters">
    //</editor-fold desc="Variable Manipulators">

    //<editor-fold desc="Methods">
    //<editor-fold desc="Constructors">

    /**
     * Create a full product including an ID
     * @param inProductID
     * @param inProductName
     * @param inProductStock
     * @param inProductCriticalLevel
     * @param inProductRecommendedLevel
     * @param inProductCost 
     */
    public void Create(int inProductID, String inProductName, int inProductStock, int inProductCriticalLevel, int inProductRecommendedLevel, double inProductCost)
    {
        ProductID(inProductID);
        ProductName(inProductName);
        ProductStock(inProductStock);
        ProductRecommendedLevel(inProductRecommendedLevel);
        ProductCost(inProductCost);
    }
    /**
     * Create a product and retrieve the ID from the database
     */
    public void Create(String inProductName, int inProductStock, int inProductCriticalLevel, int inProductRecommendedLevel, double inProductCost)
    {
        ProductName(inProductName);
        ProductStock(inProductStock);
        ProductRecommendedLevel(inProductRecommendedLevel);
        ProductCost(inProductCost);
    }
    /**
     * Creates a new product from an object array
     */
    public void Create(Object[] inArray)
    {
        if(inArray.length == 5)
        {
            //ProductID(int.Parse(inArray[0].ToString()));
            ProductID(Integer.parseInt(inArray[0].toString()));
            ProductName(inArray[1].toString());
            ProductID(Integer.parseInt(inArray[2].toString()));
            ProductCriticalLevel(Integer.parseInt(inArray[3].toString()));
            ProductRecommendedLevel(Integer.parseInt(inArray[4].toString()));
        }
        else
        {
            //TODO Throw Exception
            //throw new Exception("Recieved Array Not Of Correct Length");
        }
    }
    //</editor-fold desc="Constructors">
    /**
     * Compares two instances of Product and returns true if share the same variables
     * @param inProduct
     * @return 
     */
    public boolean Compare(Product inProduct)
    {
        boolean comparison = true;
        while (comparison == true)
        {
            if(productID == inProduct.ProductID())
            {
                comparison = false;
            }
            if(productName == inProduct.ProductName())
            {
                comparison = false;
            }
            if(productStock == inProduct.ProductStock())
            {
                comparison = false;
            }
            if(productRecommendedLevel == inProduct.ProductRecommendedLevel())
            {
                comparison = false;
            }
            if(productCost == inProduct.ProductCost())
            {
                comparison = false;
            }
            break;
        }
        return comparison;
    }
    /**
     * Creates an object array ready for transmitting universally
     * @return 
     */
    public Object[] PrepareForTransmit()
    {
        Object[] returner = new Object[5];
        returner[0] = ProductID();
        returner[1] = ProductName();
        returner[2] = ProductStock();
        returner[3] = ProductCriticalLevel();
        returner[4] = ProductRecommendedLevel();
        return returner;
    }
    
    @Override
    public String toString()
    {
        String formatString = "Name: %-30s ID: %-10i Stock: %-10i Cost: %-10d Critical Level: %-10i Recommended Level: %-10i  ";
        return String.format(formatString, ProductName(), ProductID(), ProductStock(), ProductCost(),ProductCriticalLevel(), ProductRecommendedLevel());
    }
    //</editor-fold desc="Methods">


}
