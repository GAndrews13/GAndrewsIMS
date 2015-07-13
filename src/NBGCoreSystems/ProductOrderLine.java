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
    private int quantity = 0;
    private double totalCost = 0;
    
    public Product Product() {
        return product;
    }

    public int Quantity() {
        return quantity;
    }

    public double TotalCost() {
        CalculateTotalCost();
        return totalCost;
    }

    public void Product(Product product) {
        this.product = product;
        CalculateTotalCost();
    }

    public void Quantity(int quantity) {
        this.quantity = quantity;
        CalculateTotalCost();
    }

    private void TotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    
    private void CalculateTotalCost()
    {
        TotalCost(product.ProductCost()*quantity);
    }
}
