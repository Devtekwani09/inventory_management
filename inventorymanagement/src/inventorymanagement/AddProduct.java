package inventorymanagement;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class AddProduct extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField pro_name, pro_comp, pro_qty, pro_price;
    JLabel pro_id;
    JButton add, back;
    
    AddProduct() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Product Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Product Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        pro_name = new JTextField();
        pro_name.setBounds(200, 150, 150, 30);
        add(pro_name);
        
        
        JLabel labelsalary = new JLabel("Product Company");
        labelsalary.setBounds(400, 150, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        pro_comp = new JTextField();
        pro_comp.setBounds(600, 150, 150, 30);
        add(pro_comp);
        
        JLabel labeladdress = new JLabel("Product Quantity");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        pro_qty = new JTextField();
        pro_qty.setBounds(200, 250, 150, 30);
        add(pro_qty);
        
        JLabel labelphone = new JLabel("Price Per Item");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        pro_price = new JTextField();
        pro_price.setBounds(600, 250, 150, 30);
        add(pro_price);
        
        JLabel labelempId = new JLabel("Product id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        pro_id = new JLabel("" + number);
        pro_id.setBounds(200, 400, 150, 30);
        pro_id.setFont(new Font("serif", Font.PLAIN, 20));
        add(pro_id);
        
        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = pro_name.getText();
            String id = pro_id.getText();
            String comp = pro_comp.getText();
            String qty = pro_qty.getText();
            String price = pro_price.getText();
            
            
            try {
                Conn conn = new Conn();
                String query = "insert into product values('"+name+"', '"+id+"', '"+comp+"', '"+qty+"', '"+price+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddProduct();
    }
}
