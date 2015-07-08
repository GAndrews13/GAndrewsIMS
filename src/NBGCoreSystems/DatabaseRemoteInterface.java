
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
public interface DatabaseRemoteInterface extends Remote {


    /**
     * Returns all database information
     */
        public List<Product> ReadAllProducts();
    /**
     * Returns a certain products details
     */
        public Product ReadProduct(int inID);
    /**
     * Creates a new product
     */
        public void CreateProduct(Product inProduct);
    /**
     * Changes the state of a product
     */
        //public void UpdateState(Product inProduct);
    /**
     * Updates a products details after being changed
     */
        public void UpdateProduct(Product inProduct);
}
