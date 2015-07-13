/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NBGCoreSystems;

import hr.ngs.templater.Configuration;
import hr.ngs.templater.ITemplateDocument;
import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import nbgardens.ProductOrder;

/**
 *
 * @author Gareth
 */
public class ReportWriting {
    
    private String defaultReportTitle = "NBG Stock Report ";
    private String defaultProductOrderTitle = "NBG Product Order "; 
    private String programDirectory = System.getProperty("user.dir"); 
    private String reportDirectory = programDirectory + "\\Reports\\";
    private String title = ""; //TITLE
    private String additionalTitle = ""; //SUBTITLE
    private String dateTime; //DATETIME
    private Object data; //DATA
    private final String reportTemplate = "Resources\\Template.docx";
    /**
     * Basic constructor
     */
    public ReportWriting(String inTitle)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date = new Date();
        dateTime = dateFormat.format(date);
        title = inTitle;
    }
    
    /**
     * Allows you to assign a list of information to be imported into a stock report
     */
    public void information(List<Product> inProducts)
    {
        //data = inProducts;
        writeToDocument(inProducts);
    }
    
    //Allows you to assign a list of product orders to be included in a product order line
    public void information(List<ProductOrder> inOrders,String inSupplier)
    {
        //data = inOrders;        
        writeToDocumentPOL(inOrders);
    }
    
    /**
     * Converts products to an array of information that can be imported into the template
     */
    private String[][] productListToDoubleArray(List<Product> inProducts)
    {
        String[][] returner = new String[inProducts.size()+1][9];
        //Titles
        returner[0][0] = "Product ID";
        returner[0][1] = "Product Name";
        returner[0][2] = "Product Stock";
        returner[0][3] = "Product Critical Level";
        returner[0][4] = "Product Recommended Level";
        returner[0][5] = "Product Cost";
        returner[0][6] = "Product Current in Order";
        returner[0][7] = "Product Status";
        returner[0][8] = "Porousware Status";
                
        //Actual Code
        for(int i = 1;i<inProducts.size();i++)
        {
            returner[i][0] = Integer.toString(inProducts.get(i).ProductID());
            returner[i][1] = inProducts.get(i).ProductName();
            returner[i][2] = Integer.toString(inProducts.get(i).ProductStock());
            returner[i][3] = Integer.toString(inProducts.get(i).ProductCriticalLevel());
            returner[i][4] = Integer.toString(inProducts.get(i).ProductRecommendedLevel());
            returner[i][5] = Double.toString(inProducts.get(i).ProductCost());
            returner[i][6] = Integer.toString(inProducts.get(i).CurrentInOrder());
            returner[i][7] = inProducts.get(i).ProductStatus().toString();
            returner[i][8] = Boolean.toString(inProducts.get(i).Porousware());
        }
        return returner;
    }
    
    
    
    private String[][] productOrderListToDoubleArray(List<ProductOrder> inProductOrderLines)
    {
        String[][] returner = new String[0][9];
        return returner;
    }
            
            
    /**
     * Writes the information provided to a document
     */
    private void writeToDocument(List<Product> inProducts)
    {
        //http://templater.info/downloads
        try
        {
            ByteArrayOutputStream boas = new ByteArrayOutputStream();
            InputStream inputTemplate = new FileInputStream(reportTemplate);
            ITemplateDocument document = Configuration.factory().open(inputTemplate, "docx", boas);
            
            document.templater().replace("TITLE",title);
            document.templater().replace("SUBTITLE",additionalTitle);
            document.templater().replace("DATE",dateTime);
            //ADD data
            document.templater().replace("TABLE1",productListToDoubleArray(inProducts));
            
            document.flush();
            
            byte[] results = boas.toByteArray();
            String dateTimeString = dateTime.replace('\\', ':');
            FileOutputStream fos = new FileOutputStream(String.format(reportDirectory+"%s (%s).docx",title,dateTimeString));
            fos.write(results);
            fos.close();
            openDialog(String.format(reportDirectory+"%s (%s).docx",title,dateTimeString));
        }
        catch (Exception e)
        {
            MessageHandling.ErrorHandle("RWWD01","Could not create report", e, Level.SEVERE);
        }
    }
    
    /**
     * Writes product order lines to the template
     * @param inProducts 
     */
    private void writeToDocumentPOL(List<ProductOrder> inProductOrderLines)
    {
        //http://templater.info/downloads
        try
        {
            ByteArrayOutputStream boas = new ByteArrayOutputStream();
            InputStream inputTemplate = new FileInputStream(reportTemplate);
            ITemplateDocument document = Configuration.factory().open(inputTemplate, "docx", boas);
            
            document.templater().replace("TITLE",title);
            document.templater().replace("SUBTITLE",additionalTitle);
            document.templater().replace("DATETIME",dateTime);
            //ADD data
            document.templater().replace("TABLE1",productOrderListToDoubleArray(inProductOrderLines));
            
            document.flush();
            
            byte[] results = boas.toByteArray();
            String dateTimeString = dateTime.replace('\\', ':');
            FileOutputStream fos = new FileOutputStream(String.format(reportDirectory+"%s (%s).docx",title,dateTimeString));
            fos.write(results);
            fos.close();
            openDialog(String.format(reportDirectory+"%s (%s).docx",title,dateTimeString));
        }
        catch (Exception e)
        {
            MessageHandling.ErrorHandle("RWWD01","Could not create report", e, Level.SEVERE);
        }
    }
    
    private void openDialog(String inFileName)
    {
        try
        {
            int response = JOptionPane.showConfirmDialog(null,"Would you like to open the stock report?","Stock report creation successful",JOptionPane.YES_NO_OPTION);
            if(response == JOptionPane.YES_OPTION)
            {
                Desktop.getDesktop().open(new File(inFileName));
            }
        }
        catch (Exception e)
        {
            MessageHandling.ErrorHandle("RWOD01", "Error opening report file.", e, Level.ALL);
        }
    }
}
