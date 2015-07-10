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

    private int productID = 0;
    private String productName = "";
    //FIXME
    private int productStock = 0;
    //FIXME
    private int productCriticalLevel = 0;
    private int productRecommendedLevel = 0;
    private Double productCost = 0.0;
    private int currentInOrder = 0;
    private ProductStatus ProductStatus;

    public ProductStatus ProductStatus() {
        return ProductStatus;
    }

    public void ProductStatus(ProductStatus status) {
        this.ProductStatus = status;
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

    public int CurrentInOrder() {
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
        this.productStock += productStockManipulator;
    }

    public void ProductCriticalLevel(int productCriticalLevelManipulator) {
        this.productCriticalLevel = productCriticalLevelManipulator;
    }

    public void ProductRecommendedLevel(int productRecommendedLevelManipulator) {
        this.productRecommendedLevel = productRecommendedLevelManipulator;
    }

    public void ProductCost(Double productCostManipulator) {
        this.productCost = productCostManipulator;
    }

    public void CurrentInOrder(int currentInOrderManipulator) {
        currentInOrder += currentInOrderManipulator;
    }
    //</editor-fold desc="Setters">
    //</editor-fold desc="Variable Manipulators">

    //<editor-fold desc="Methods">
    //<editor-fold desc="Constructors">
    /**
     * Create a full product including an ID
     *
     * @param inProductID
     * @param inProductName
     * @param inProductStock
     * @param inProductCriticalLevel
     * @param inProductRecommendedLevel
     * @param inProductCost
     */
    public Product(int inProductID, String inProductName, int inProductStock, int inProductCriticalLevel, int inProductRecommendedLevel, double inProductCost) {
        ProductID(inProductID);
        ProductName(inProductName);
        ProductStock(inProductStock);
        ProductCriticalLevel(inProductCriticalLevel);
        ProductRecommendedLevel(inProductRecommendedLevel);
        ProductCost(inProductCost);
        ProductStatus(ProductStatus.InStock);
    }
    
    /**
     * Creates a product without an ID which would be assigned by the database
     */
    public Product(String inProductName, int inProductStock, int inProductCriticalLevel, int inProductRecommendedLevel, double inProductCost)
    {
        ProductName(inProductName);
        ProductStock(inProductStock);
        ProductCriticalLevel(inProductCriticalLevel);
        ProductRecommendedLevel(inProductRecommendedLevel);
        ProductCost(inProductCost);
        ProductStatus(ProductStatus.InStock);
    }     

    /**
     * Create a full product including an ID and status
     *
     * @param inProductID
     * @param inProductName
     * @param inProductStock
     * @param inProductCriticalLevel
     * @param inProductRecommendedLevel
     * @param inProductCost
     * @param inStatus
     */
    public Product(int inProductID, String inProductName, int inProductStock, int inProductCriticalLevel, int inProductRecommendedLevel, double inProductCost, ProductStatus inStatus) {
        ProductID(inProductID);
        ProductName(inProductName);
        ProductStock(inProductStock);
        ProductCriticalLevel(inProductCriticalLevel);
        ProductRecommendedLevel(inProductRecommendedLevel);
        ProductCost(inProductCost);
        ProductStatus(inStatus);
    
    }

    //</editor-fold desc="Constructors">

    /**
     * Compares two instances of Product and returns true if share the same
     * variables
     *
     * @param inProduct
     * @return
     */
    public boolean Compare(Product inProduct) {
        boolean comparison = true;
        while (comparison == true) {
            if (productID == inProduct.ProductID()) {
                comparison = false;
            }
            if (productName == inProduct.ProductName()) {
                comparison = false;
            }
            if (productStock == inProduct.ProductStock()) {
                comparison = false;
            }
            if (productRecommendedLevel == inProduct.ProductRecommendedLevel()) {
                comparison = false;
            }
            if (productCost == inProduct.ProductCost()) {
                comparison = false;
            }
            break;
        }
        return comparison;
    }

    /**
     * Creates an object array ready for putting into the table
     */
    public Object[] PrepareForTable()
    {
        Object[] returner = new Object[7];
        returner[0] = this.ProductID();
        returner[1] = this.ProductName();
        returner[2] = this.ProductStock();
        returner[3] = this.ProductCost();
        returner[4] = this.ProductStatus();        
        returner[5] = this.ProductCriticalLevel();        
        returner[6] = this.ProductRecommendedLevel();        
        return returner;
    }

    /**
     * Create a product and retrieve the ID from the database
     */

    @Override
    public String toString() {
        String formatString = "Name: %-30s ID: %-10s Stock: %-10s Cost: %-10s Critical Level: %-10s Recommended Level: %-10s  ";
        return String.format(formatString, ProductName(), ProductID(), ProductStock(), ProductCost(), ProductCriticalLevel(), ProductRecommendedLevel());
    }
    //</editor-fold desc="Methods">

}
