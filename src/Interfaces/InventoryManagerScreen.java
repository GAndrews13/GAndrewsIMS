package Interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import NBGCoreSystems.DatabaseRemoteInterface;
import NBGCoreSystems.MessageHandling;
import NBGCoreSystems.Product;
import NBGCoreSystems.ProductOrderLine;
import NBGCoreSystems.ProductStatus;
import NBGCoreSystems.ReportWriting;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.table.DefaultTableModel;
import nbgardens.DatabaseCentre;
import javax.swing.table.TableModel;
import nbgardens.ProductOrder;

/**
 *
 * @author gandrews
 */
public class InventoryManagerScreen extends javax.swing.JFrame {

    private DefaultTableModel productManagerTableModel;
    
    private static DatabaseRemoteInterface dri;
    /**
     * Creates new form InventoryManagerScreen
     */
    public InventoryManagerScreen() {
        //Create the report directory if it doesn't exist
                File directory = new File(System.getProperty("user.dir")+ "\\Reports\\");
		try
		{
			directory.mkdir();
		}
		catch (Exception e) 
		{
                        MessageHandling.ErrorHandle("IMS01", "Error creating report directory", e, Level.ALL);
		}
                try
                {
                    dri = new DatabaseCentre();
                    try
                    {
                        initComponents();
                        jPanel7.getRootPane().setDefaultButton(button_UpdateProduct);
                        jPanel7.getRootPane().addKeyListener(new KeyListener() {

                            @Override
                            public void keyTyped(KeyEvent e) {
                                if(e.getKeyCode() == KeyEvent.VK_TAB)
                                {
                                    if(checkboxPorousware.isSelected())
                                    {
                                        checkboxPorousware.setSelected(false);
                                    }
                                    else
                                    {
                                        checkboxPorousware.setSelected(true);
                                    }
                                }
                            }

                            @Override
                            public void keyPressed(KeyEvent e) {
                                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public void keyReleased(KeyEvent e) {
                                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }
                        });
                        productManagerTable.getSelectionModel().setSelectionMode(SINGLE_SELECTION);
                        
                        productManagerTable.addMouseListener(new MouseListener() {

                            @Override
                            public void mouseClicked(MouseEvent e) {
                                updateTextBoxes(getRow());
                            }

                            @Override
                            public void mousePressed(MouseEvent e) {
                                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public void mouseReleased(MouseEvent e) {
                            //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                            //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                //updateTextBoxes(getRow());
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                //ClearTextBox();
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }
                        });
                    }
                    catch (Exception e)
                    {
                        MessageHandling.ErrorHandle("IMS03", "Error creating UI", e, Level.ALL);
                    }
                    refreshTable();
                    
                }
                catch (Exception e)
                {
                        MessageHandling.ErrorHandle("IMS02", "Error creating interface with DatabaseCentre", e, Level.ALL);
                }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productManagerTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        textBoxProductID = new java.awt.TextField();
        textBoxProductName = new java.awt.TextField();
        label1 = new java.awt.Label();
        label4 = new java.awt.Label();
        textboxProductStock = new java.awt.TextField();
        textboxProductCost = new java.awt.TextField();
        label5 = new java.awt.Label();
        label3 = new java.awt.Label();
        textboxMinimumStock = new java.awt.TextField();
        textboxRecommendedStock = new java.awt.TextField();
        label7 = new java.awt.Label();
        label6 = new java.awt.Label();
        button_UpdateProduct = new javax.swing.JButton();
        button_CreateNewProduct = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textArea1 = new java.awt.TextArea();
        comboBoxProductStatus = new javax.swing.JComboBox();
        jButton6 = new javax.swing.JButton();
        checkboxPorousware = new javax.swing.JCheckBox();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Inventory Management System");
        jLabel1.setToolTipText("");

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(1080, 800));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(800, 600));
        jTabbedPane1.setName("tabInterface"); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1080, 800));

        jToggleButton1.setText("Server Accepting Requests");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 706, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Database Controls", jPanel5);

        jButton1.setText("Open Report Directory");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Create Product Order Form");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Create Stock Report");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 1075, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(573, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reports", jPanel6);

        jPanel4.setMaximumSize(new java.awt.Dimension(1080, 777));

        productManagerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Stock", "Cost", "Status", "Minimum Stock", "Recommended Stock", "Porousware"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productManagerTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        productManagerTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        productManagerTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(productManagerTable);

        label2.setMaximumSize(new java.awt.Dimension(50, 50));
        label2.setMinimumSize(new java.awt.Dimension(50, 50));
        label2.setText("Product ID:");

        textBoxProductID.setEditable(false);
        textBoxProductID.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textBoxProductID.setMaximumSize(new java.awt.Dimension(50, 50));
        textBoxProductID.setMinimumSize(new java.awt.Dimension(50, 50));

        textBoxProductName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textBoxProductName.setMaximumSize(new java.awt.Dimension(50, 50));
        textBoxProductName.setMinimumSize(new java.awt.Dimension(50, 50));

        label1.setMaximumSize(new java.awt.Dimension(50, 50));
        label1.setMinimumSize(new java.awt.Dimension(50, 50));
        label1.setText("Product Name:");

        label4.setMaximumSize(new java.awt.Dimension(50, 50));
        label4.setMinimumSize(new java.awt.Dimension(50, 50));
        label4.setText("Product Stock:");

        textboxProductStock.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textboxProductStock.setMaximumSize(new java.awt.Dimension(50, 50));
        textboxProductStock.setMinimumSize(new java.awt.Dimension(50, 50));

        textboxProductCost.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textboxProductCost.setMaximumSize(new java.awt.Dimension(50, 50));
        textboxProductCost.setMinimumSize(new java.awt.Dimension(50, 50));

        label5.setMaximumSize(new java.awt.Dimension(50, 50));
        label5.setMinimumSize(new java.awt.Dimension(50, 50));
        label5.setText("Product Cost:");

        label3.setMaximumSize(new java.awt.Dimension(50, 50));
        label3.setMinimumSize(new java.awt.Dimension(50, 50));
        label3.setText("Minimum Stock:");

        textboxMinimumStock.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textboxMinimumStock.setMaximumSize(new java.awt.Dimension(50, 50));
        textboxMinimumStock.setMinimumSize(new java.awt.Dimension(50, 50));

        textboxRecommendedStock.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textboxRecommendedStock.setMaximumSize(new java.awt.Dimension(50, 50));
        textboxRecommendedStock.setMinimumSize(new java.awt.Dimension(50, 50));

        label7.setMaximumSize(new java.awt.Dimension(50, 50));
        label7.setMinimumSize(new java.awt.Dimension(50, 50));
        label7.setText("Recommended Stock:");

        label6.setMaximumSize(new java.awt.Dimension(50, 50));
        label6.setMinimumSize(new java.awt.Dimension(50, 50));
        label6.setText("Product Status:");

        button_UpdateProduct.setText("Edit Selected Product");
        button_UpdateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_UpdateProductActionPerformed(evt);
            }
        });

        button_CreateNewProduct.setText("Create New Product");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Log");

        textArea1.setEditable(false);

        comboBoxProductStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "InStock", "LowStock", "OutOfStock", "Discontinued" }));

        jButton6.setText("Clear Fields");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        checkboxPorousware.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkboxPorousware.setText("Has Porousware");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addComponent(button_UpdateProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_CreateNewProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkboxPorousware, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textArea1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(label5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(label3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(label7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(comboBoxProductStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(textBoxProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textboxMinimumStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                            .addComponent(textboxProductCost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textboxProductStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textboxRecommendedStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(textBoxProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textBoxProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textBoxProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textboxProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textboxProductCost, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(textboxMinimumStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textboxRecommendedStock, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxProductStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkboxPorousware, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(button_UpdateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_CreateNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        button_CreateNewProduct.setVisible(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Product Manager", jPanel4);

        jTabbedPane1.setSelectedComponent(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Produict Manager");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTable()
    {
        try
        {
            List<Product> list =  dri.ReadAllProducts();
            populateTable(list);
        }
        catch (Exception e)
        {
            MessageHandling.ErrorHandle("IMSRT01", "Error refreshing table", e, Level.ALL);
        }
    }
    
    private void ClearTextBox()
    {
        textBoxProductID.setText("");
        textBoxProductName.setText("");
        textboxProductStock.setText("");
        textboxProductCost.setText("");
        textboxMinimumStock.setText("");
        textboxRecommendedStock.setText("");
        comboBoxProductStatus.setSelectedItem(0);
        checkboxPorousware.setSelected(false);

    }
    
    private void updateTextBoxes(String inID,
            String inName,
            String inStock,
            String inCost,
            String inProductStatus,
            String inMinStock,
            String inRecStock,
            String inPorousware)
    {           
        textBoxProductID.setText(inID);
        textBoxProductName.setText(inName);
        textboxProductStock.setText(inStock);
        textboxProductCost.setText(inCost);
        textboxMinimumStock.setText(inMinStock);
        textboxRecommendedStock.setText(inRecStock);
        if(inPorousware == "true")
        {
            checkboxPorousware.setSelected(true);
        }
        else
        {
            checkboxPorousware.setSelected(false);
        }
        switch(inProductStatus)
        {
            case "InStock":
                comboBoxProductStatus.setSelectedItem(1);
                break;
            case "LowStock":
                comboBoxProductStatus.setSelectedItem(2);
                break;
            case "OutOfStock":
                comboBoxProductStatus.setSelectedItem(3);
                break;
            case "Discontinued":
                comboBoxProductStatus.setSelectedItem(4);
                break;
            default:
                comboBoxProductStatus.setSelectedItem(0);
                break;
        }
        
    }
    
    private void updateTextBoxes(String[] inData)
    {
        updateTextBoxes(
                inData[0], //ID
                inData[1], //Name
                inData[2], //Stock
                inData[3], //Cost
                inData[4], //Status
                inData[5], //Minimum
                inData[6], //Recommended
                inData[7]); //Porous
    }
    
    private String[] getRow()
    {
        String[] Result = new String[productManagerTable.getRowCount()];
        for(int i = 0;i<productManagerTable.getModel().getColumnCount();i++)
        {
            Result[i] = productManagerTable.getModel().getValueAt(productManagerTable.getSelectedRow(),i).toString();
        }
        return Result;
    }
    
    private void setRow(Object[] inStrings)
    {
        DefaultTableModel temp = (DefaultTableModel)  productManagerTable.getModel();
        temp.setValueAt(inStrings[0], productManagerTable.getSelectedRow(),0);
        temp.setValueAt(inStrings[1], productManagerTable.getSelectedRow(),1);
        temp.setValueAt(inStrings[2], productManagerTable.getSelectedRow(),2);
        temp.setValueAt(inStrings[3], productManagerTable.getSelectedRow(),3);
        temp.setValueAt(inStrings[4], productManagerTable.getSelectedRow(),4);
        temp.setValueAt(inStrings[5], productManagerTable.getSelectedRow(),5);
        temp.setValueAt(inStrings[6], productManagerTable.getSelectedRow(),6);
        temp.setValueAt(inStrings[7], productManagerTable.getSelectedRow(),7);
        productManagerTable.setModel(temp);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here
        try
        {
            File reportDirectory = new File(System.getProperty("user.dir")+ "\\Reports\\");
            Desktop.getDesktop().open(reportDirectory);
        }
        catch (Exception e)
        {
            MessageHandling.ErrorHandle("IMS02", "Could not open report directory",e, Level.WARNING);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //TODO add in report creation
        ReportWriting rw = new ReportWriting("Stock Report");
        try
        {
            List<Product> list =  dri.ReadAllProducts();
            rw.information(list);
        }
        catch (Exception e)
        {
            MessageHandling.ErrorHandle("IMSJ3A1","Error reading stock information",e,Level.WARNING);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //TODO add in product creation and editing
        ReportWriting rw = new ReportWriting("Purchase Order");
        try
        {
            List<Product> list = dri.ReadAllProducts();
            List<ProductOrderLine> PLOList = new ArrayList<ProductOrderLine>();
            for(Product p : list)
            {
                if(p.ProductStock() <= p.ProductCriticalLevel())
                {
                    ProductOrderLine pol = new ProductOrderLine();
                    pol.Product(p);
                    pol.Quantity(p.ProductCriticalLevel() - p.ProductStock());
                    PLOList.add(pol);
                }
            }
            ProductOrder po = new ProductOrder();
            po.ProductList((ArrayList<ProductOrderLine>) PLOList);
            rw.information(po, "NBG Supplier");
        }
        catch (Exception e)
        {
            MessageHandling.ErrorHandle("IMSJ3A2","Error reading stock information",e,Level.WARNING);            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if(jToggleButton1.isSelected())
        {
            jToggleButton1.setText("Server Not Accepting Connections");
        }
        else
        {
            jToggleButton1.setText("Server Accepting Connections");
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void textbox_ProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textbox_ProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textbox_ProductNameActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //TODO add a new product feature, change UI to include all items
        //Product tempProduct = new Product(textbox_ProductName.getText(),textbox_ProductStock.getText(),);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void button_UpdateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_UpdateProductActionPerformed
        try
        {
            String prodStatusString = comboBoxProductStatus.getSelectedItem().toString();
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
            boolean porousware;
            if(checkboxPorousware.isSelected())
            {
                porousware = true;
            }
            else
            {
                porousware = false;
            }
             
             try
             {
                 Product tempProduct;
                 tempProduct = new Product(
                         Integer.parseInt(textBoxProductID.getText()),
                         textBoxProductName.getText(),
                         Integer.parseInt(textboxProductStock.getText()),
                         Integer.parseInt(textboxMinimumStock.getText()),
                         Integer.parseInt(textboxRecommendedStock.getText()),
                         Double.parseDouble(textboxProductCost.getText()),
                         
                         ProductStatus.InStock,
                         porousware);
                //Update Local records
                 dri.UpdateProduct(tempProduct);
                 //MessageHandling.PopUpMessage("Product Updated", "Product (" + tempProduct.ProductID()+") " + tempProduct.ProductName() + " has been updated");
                 //Update remote records
                 
                 //Update UI
                 refreshTable();
                //setRow(new String[]{textBoxProductID.getText(),textBoxProductName.getText(),textboxProductStock.getText(),textboxProductCost.getText(),comboBoxProductStatus.toString(),textboxMinimumStock.getText(),textboxRecommendedStock.getText()});
             }
             catch (Exception e)
             {
                         MessageHandling.PopUpMessage("Error changing table", "Data could not be input into the table: " + e.getMessage());
             }
             
        }
        catch (Exception e)
        {
                    MessageHandling.ErrorHandle("IMSUPB01", "Unable to connect to database to update product", e, Level.WARNING);
        }
    }//GEN-LAST:event_button_UpdateProductActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ClearTextBox();
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InventoryManagerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryManagerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryManagerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryManagerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryManagerScreen().setVisible(true);
            }
        });
    }
    
    /**
     * Fills the table with the information returned from the database
     */
    public void populateTable(List<Product> inList)
    {
        //TODO call remote method to return and assign values to the table
        try
        {
            //productManagerTableModel.setNumRows(0);
            productManagerTableModel = (DefaultTableModel) productManagerTable.getModel();
            productManagerTableModel.setRowCount(0);
            for(Product p : inList)
            {
                Object[] rowData = p.PrepareForTable();  
                
                if(productManagerTableModel != null)
                {
                    productManagerTableModel.addRow(rowData);
                }
                else
                {
                    MessageHandling.PopUpMessage("TableModel Void", "Error with Table Model");
                }
            }
            //productManagerTable.setModel(productManagerTableModel);
        }
        catch (Exception e)
        {
                MessageHandling.ErrorHandle("IMSPT01", "Problem setting up table with information requested", e, Level.SEVERE);
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_CreateNewProduct;
    private javax.swing.JButton button_UpdateProduct;
    private javax.swing.JCheckBox checkboxPorousware;
    private javax.swing.JComboBox comboBoxProductStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private javax.swing.JTable productManagerTable;
    private java.awt.TextArea textArea1;
    private java.awt.TextField textBoxProductID;
    private java.awt.TextField textBoxProductName;
    private java.awt.TextField textboxMinimumStock;
    private java.awt.TextField textboxProductCost;
    private java.awt.TextField textboxProductStock;
    private java.awt.TextField textboxRecommendedStock;
    // End of variables declaration//GEN-END:variables

}
