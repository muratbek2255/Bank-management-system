package com.example.Bank_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import static com.example.Bank_system.SQLConnect.*;

public class Signup extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JTextField t1,t2,t3,t4,t5,t6,t7, t8;
    JRadioButton r1,r2,r3,r4,r5;
    JButton b;


    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);

    Signup(){

        setTitle("ФОРМА ЗАЯВКИ НА НОВЫЙ СЧЕТ");

        ImageIcon i1 = new ImageIcon("src/main/java/icons/logo.jpg");
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(20, 0, 100, 100);
        add(l11);


        l1 = new JLabel("ЗАЯВЛЕНИЕ № "+first);
        l1.setFont(new Font("Raleway", Font.BOLD, 38));

        l2 = new JLabel("Страница 1: Личные данные");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));

        l3 = new JLabel("ИМЯ:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));

        l4 = new JLabel("ФАМИЛИЯ:");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));

        l6 = new JLabel("ПОЛ:");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));

        l7 = new JLabel("Электронная почта:");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));

        l8 = new JLabel("Статус:");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));

        l9 = new JLabel("Адрес:");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));

        l10 = new JLabel("ГОРОД:");
        l10.setFont(new Font("Raleway", Font.BOLD, 20));

        l11 = new JLabel("ПИН КОД:");
        l11.setFont(new Font("Raleway", Font.BOLD, 20));

        l12 = new JLabel("Государство:");
        l12.setFont(new Font("Raleway", Font.BOLD, 20));

        l13 = new JLabel("ДАТА создания");
        l13.setFont(new Font("Raleway", Font.BOLD, 14));

        l14 = new JLabel("Месяц");
        l14.setFont(new Font("Raleway", Font.BOLD, 14));

        l15 = new JLabel("Год");
        l15.setFont(new Font("Raleway", Font.BOLD, 14));


        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));

        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));

        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 14));

        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));

        t6 = new JTextField();
        t6.setFont(new Font("Raleway", Font.BOLD, 14));

        t7 = new JTextField();
        t7.setFont(new Font("Raleway", Font.BOLD, 14));

        t8 = new JTextField();
        t8.setFont(new Font("Raleway", Font.BOLD, 14));



        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);

        r3 = new JRadioButton("Married");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("Unmarried");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);

        r5 = new JRadioButton("Other");
        r5.setFont(new Font("Raleway", Font.BOLD, 14));
        r5.setBackground(Color.WHITE);

        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(r3);
        groupstatus.add(r4);
        groupstatus.add(r5);

        setLayout(null);


        l1.setBounds(140,20,600,40);
        add(l1);

        l2.setBounds(290,80,600,30);
        add(l2);

        l3.setBounds(100,140,100,30);
        add(l3);

        t1.setBounds(300,140,400,30);
        add(t1);

        l4.setBounds(100,190,200,30);
        add(l4);

        t2.setBounds(300,190,400,30);
        add(t2);

        l6.setBounds(100,290,200,30);
        add(l6);

        r1.setBounds(300,290,60,30);
        add(r1);

        r2.setBounds(450,290,90,30);
        add(r2);

        l7.setBounds(100,340,200,30);
        add(l7);

        t4.setBounds(300,340,400,30);
        add(t4);

        l8.setBounds(100,390,200,30);
        add(l8);

        r3.setBounds(300,390,100,30);
        add(r3);

        r4.setBounds(450,390,100,30);
        add(r4);

        r5.setBounds(635,390,100,30);
        add(r5);



        l9.setBounds(100,440,200,30);
        add(l9);

        t5.setBounds(300,440,400,30);
        add(t5);

        l10.setBounds(100,490,200,30);
        add(l10);

        t6.setBounds(300,490,400,30);
        add(t6);

        l11.setBounds(100,540,200,30);
        add(l11);

        t7.setBounds(300,540,400,30);
        add(t7);

        l12.setBounds(100,590,200,30);
        add(l12);

        t8.setBounds(300,590,400,30);
        add(t8);

        b.setBounds(620,660,80,30);
        add(b);

        b.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(500,120);
        setVisible(true);

        addWindowListener(new MyWindowAdapter());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formn = first;
        String name = t1.getText();
        String surname = t2.getText();
        String gender = null;
        if(r1.isSelected()) {
            gender = "Male";
        } else if (r2.isSelected()) {
            gender = "Female";
        }

        String email = t4.getText();
        String status_of_mar = null;
        if(r3.isSelected()){
            status_of_mar = "Married";
        }else if(r4.isSelected()){
            status_of_mar = "Unmarried";
        }else if(r5.isSelected()){
            status_of_mar = "Other";
        }

        String address = t5.getText();
        String city = t6.getText();
        String pincode = t7.getText();
        String state = t8.getText();

        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ey) {
            ey.printStackTrace();
        }

        try{

            if(t6.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Заполните все необходимые поля");
            }else{
                Connection connection = DriverManager.getConnection(DB_DATABASE, DB_USERNAME, DB_PASSWORD);
                String q1 = "insert into signup values('"+formn+"','"+name+"','"+surname+"','"+gender+"','"+email+"','"+status_of_mar+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                PreparedStatement preparedStatement = connection.prepareStatement(q1);
                preparedStatement.executeUpdate();

                new Signup2(first).setVisible(true);
                setVisible(false);
            }

        }catch(Exception ee){
            ee.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup().setVisible(true);
    }
}
