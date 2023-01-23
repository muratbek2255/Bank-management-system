package com.example.Bank_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

import static com.example.Bank_system.SQLConnect.*;

public class Deposit extends JFrame implements ActionListener{

    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String pin;
    Deposit(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon("src/main/java/icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

        l1 = new JLabel("ВВЕДИТЕ СУММУ, ЧТО ВЫ ХОТИТЕ ПОЛУЧИТЬ");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(190,350,400,35);
        l3.add(l1);

        t1.setBounds(190,420,320,25);
        l3.add(t1);

        b1.setBounds(390,588,150,35);
        l3.add(b1);

        b2.setBounds(390,633,150,35);
        l3.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(960,1080);
        setUndecorated(true);
        setLocation(500,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Пожалуйста, введите сумму, которую вы хотите внести");
                }else{
                    Class.forName("com.postgresql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(DB_DATABASE, DB_USERNAME, DB_PASSWORD);
                    String q1 = "insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')";
                    PreparedStatement preparedStatement = connection.prepareStatement(q1);
                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}
