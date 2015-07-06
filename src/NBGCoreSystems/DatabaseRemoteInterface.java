
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NBGCoreSystems;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author Gareth
 */
public interface DatabaseRemoteInterface {
    /**
     * Returns all database information
     */
    public interface ReadAllProducts extends Remote
    {
        public List<Product> ReadAllProducts();
    }
    /**
     * Returns a certain products details
     */
    public interface ReadProduct extends Remote
    {
        public Product ReadProduct(int inID);
    }
    /**
     * Creates a new product
     */
    public interface CreateProduct extends Remote
    {
        public void CreateProduct(Product inProduct);
    }
    /**
     * Changes the state of a product
     */
    public interface ChangeState extends Remote
    {
        public void UpdateProduct(Product inProduct);
    }
    /**
     * Updates a products details after being changed
     */
    public interface UpdateProduct extends Remote
    {
        public void UpdateProduct(Product inProduct);
    }
}
