package inventorymanagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateProduct extends JFrame implements ActionListener {

    JTextField pro_comp, pro_qty, pro_price;
    JLabel lblname, id;
    JButton update, back;
    String pro_id;

    UpdateProduct(String pro_id) {
        this.pro_id = pro_id;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Product Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelname = new JLabel("Product Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);

        JLabel labelfname = new JLabel("Product Company");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);

        pro_comp = new JTextField();
        pro_comp.setBounds(600, 150, 150, 30);
        add(pro_comp);

        JLabel labelsalary = new JLabel("Product quantity");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);

        pro_qty = new JTextField();
        pro_qty.setBounds(600, 200, 150, 30);
        add(pro_qty);

        JLabel labeladdress = new JLabel("Product Price");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);

        pro_price = new JTextField();
        pro_price.setBounds(200, 250, 150, 30);
        add(pro_price);

        JLabel labelempId = new JLabel("Product id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);

        id = new JLabel();
        id.setBounds(200, 400, 150, 30);
        id.setFont(new Font("serif", Font.PLAIN, 20));
        add(id);

        try {
            Conn c = new Conn();
            String query = "select * from product where product_id = '" + pro_id + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("product_name"));
                id.setText(rs.getString("product_id"));
                pro_comp.setText(rs.getString("product_company"));
                pro_qty.setText(rs.getString("product_quantity"));
                pro_price.setText(rs.getString("product_price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        update = new JButton("Update Details");
        update.setBounds(250, 550, 150, 40);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);

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
        if (ae.getSource() == update) {
            String comp = pro_comp.getText();
            String qty = pro_qty.getText();
            String price = pro_price.getText();

            try {
                Conn conn = new Conn();
                String query = "update product set product_company = '" + comp + "', product_quantity = '" + qty + "', product_price = '" + price + "' where product_id = '" + pro_id + "'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
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
        new UpdateProduct("");
    }
}
