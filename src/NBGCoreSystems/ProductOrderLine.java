/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NBGCoreSystems;

/**
 *
 * @author gandrews
 */
public class ProductOrderLine {
    private Product product;
    private int quantity;
    private int totalCost;
    
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
