/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbgardens;

import NBGCoreSystems.ProductOrderLine;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gandrews
 */
public class ProductOrder {
    private ArrayList<ProductOrderLine> productList = new ArrayList<ProductOrderLine>();
    private double totalCost;

    public List<ProductOrderLine> ProductList() {
        return productList;
    }

    public void ProductList(ArrayList<ProductOrderLine> productList) {
        this.productList = productList;
    }
    public void addProduct(ProductOrderLine inOrderLine)
    {
        productList.add(inOrderLine);
    }

    public double TotalCost() {
        return totalCost;
    }

    public void TotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    
    public void calculateTotal()
    {
        double runningTotal = 0;
        for(int i = 0; i<productList.size();i++)
        {
            runningTotal += productList.get(i).TotalCost();
        }
    }
}
