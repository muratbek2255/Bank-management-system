package com.example.Bank_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import static com.example.Bank_system.SQLConnect.*;

public class Signup2 extends JFrame implements ActionListener{

    JLabel l1,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JButton b;
    JRadioButton r1,r2,r3,r4;
    JTextField t1,t2;
    JComboBox c3,c4,c5;
    String formn;
    Signup2(String formn){

        ImageIcon i1 = new ImageIcon("src/main/java/icons/logo.jpg");
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        add(l14);


        this.formn = formn;
        setTitle("ФОРМА ЗАЯВКИ НА НОВЫЙ СЧЕТ - СТРАНИЦА 2");

        l1 = new JLabel("Страница 2: Дополнительные сведения");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));

        l4 = new JLabel("Доход: ");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));

        l5 = new JLabel("Образование:");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));

        l11 = new JLabel("Квалификация:");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));

        l6 = new JLabel("Кто ты:");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));

        l7 = new JLabel("PAN Number:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));

        l9 = new JLabel("Пенсионер:");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));

        l10 = new JLabel("Существующий аккаунт:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));

        l12 = new JLabel("Form No:");
        l12.setFont(new Font("Raleway", Font.BOLD, 13));

        l13 = new JLabel(formn);
        l13.setFont(new Font("Raleway", Font.BOLD, 13));

        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);

        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);


        String income[] = {"Null","<10000","<25000","<50000"," Выше 100000","Выше 1000000"};
        c3 = new JComboBox(income);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));

        String education[] = {"Не окончил","Закончил","Магистр","Докторант","Другоe"};
        c4 = new JComboBox(education);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));

        String occupation[] = {"Наемный работник", "Самозанятый", "Бизнесмен", "Студент", "Пенсионер", "Другие"};
        c5 = new JComboBox(occupation);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));


        setLayout(null);


        l12.setBounds(700,10,60,30);
        add(l12);

        l13.setBounds(760,10,60,30);
        add(l13);

        l1.setBounds(280,30,600,40);
        add(l1);


        l4.setBounds(100,220,100,30);
        add(l4);

        c3.setBounds(350,220,320,30);
        add(c3);

        l5.setBounds(100,270,150,30);
        add(l5);

        c4.setBounds(350,270,320,30);
        add(c4);

        l11.setBounds(100,290,150,30);
        add(l11);

        l6.setBounds(100,340,150,30);
        add(l6);

        c5.setBounds(350,340,320,30);
        add(c5);

        l7.setBounds(100,390,150,30);
        add(l7);

        t1.setBounds(350,390,320,30);
        add(t1);

        l9.setBounds(100,490,150,30);
        add(l9);

        r1.setBounds(350,490,100,30);
        add(r1);

        r2.setBounds(460,490,100,30);
        add(r2);

        l10.setBounds(100,540,180,30);
        add(l10);

        r3.setBounds(350,540,100,30);
        add(r3);

        r4.setBounds(460,540,100,30);
        add(r4);

        b.setBounds(570,640,100,30);
        add(b);

        b.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,750);
        setLocation(500,120);
        setVisible(true);

        addWindowListener(new MyWindowAdapter());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String income = (String)c3.getSelectedItem();
        String education = (String)c4.getSelectedItem();
        String occupation = (String)c5.getSelectedItem();

        String pan = t1.getText();


        String scitizen = "";
        if(r1.isSelected()){
            scitizen = "Yes";
        }
        else if(r2.isSelected()){
            scitizen = "No";
        }

        String eaccount = "";
        if(r3.isSelected()){
            eaccount = "Yes";
        }else if(r4.isSelected()){
            eaccount = "No";
        }

        try{
            if(t2.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Class.forName("com.postgresql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(DB_DATABASE, DB_USERNAME, DB_PASSWORD);
                String q1 = "insert into signup_two values('"+formn+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+scitizen+"','"+eaccount+"')";

                PreparedStatement preparedStatement = connection.prepareStatement(q1);
                preparedStatement.executeUpdate();

                new Signup2(formn).setVisible(true);
                setVisible(false);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup2("").setVisible(true);
    }
}
