package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static String gender = new String();
    public static String name = new String();
    public static String surname = new String();
    public static String phoneORSMS = new String();
    public static String year = new String();
    public static String membership = new String();

    public static void main(String[] args) {

        JFrame form = new JFrame();
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setTitle("Registration Form");
        form.setLayout(new BorderLayout(10,10));
        form.setVisible(true);
        form.setSize(750,250);

        JTextField surnameInput = new JTextField("Surname:");
        surnameInput.setPreferredSize(new Dimension(100,50));

        JTextField nameInput = new JTextField("Name:");
        nameInput.setPreferredSize(new Dimension(100,50));

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout());
        northPanel.add(nameInput);
        northPanel.add(surnameInput);
        form.add(northPanel,BorderLayout.NORTH);

        JRadioButton male = new JRadioButton("Male");
        male.setFocusable(false);
        JRadioButton female = new JRadioButton("Female");
        female.setFocusable(false);
        ButtonGroup genderSelect = new ButtonGroup();
        genderSelect.add(male);
        genderSelect.add(female);

        JCheckBox selectSMS = new JCheckBox("SMS");
        selectSMS.setFocusable(false);
        JCheckBox selectPhone = new JCheckBox("Phone");
        selectPhone.setFocusable(false);

        String[] years = {"2018", "2019", "2020", "2021"};
        JComboBox yearSelect = new JComboBox(years);

        String[] memberships = {"Standart", "Elite", "Super Elite"};
        JComboBox membershipSelect = new JComboBox(memberships);

        JPanel centerPanel = new JPanel();
        // centerPanel.setLayout(null); //null = Absolute Layout
        centerPanel.add(selectPhone);
        centerPanel.add(selectSMS);
        centerPanel.add(male);
        centerPanel.add(female);
        centerPanel.add(yearSelect);
        centerPanel.add(membershipSelect);
        form.add(centerPanel,BorderLayout.CENTER);

        JButton save = new JButton("Save");
        save.setPreferredSize(new Dimension(325,50));
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = nameInput.getText() + " ";
                System.out.println(name);
                surname = surnameInput.getText() + " ";
                System.out.println(surname);
                if(selectPhone.isSelected() && !selectSMS.isSelected()){
                    phoneORSMS = "Phone ";
                    System.out.println(phoneORSMS);
                }
                if(selectSMS.isSelected() && !selectPhone.isSelected()){
                    phoneORSMS = "SMS ";
                    System.out.println(phoneORSMS);
                }
                if(selectSMS.isSelected() && selectPhone.isSelected()){
                    phoneORSMS = "Phone + SMS ";
                    System.out.println(phoneORSMS);
                }
                if(male.isSelected()){
                    gender = "Male ";
                    System.out.println(gender);
                }
                if(female.isSelected()){
                    gender = "Female ";
                    System.out.println(gender);
                }
                year = yearSelect.getSelectedItem().toString() + " ";
                System.out.println(year);
                membership = membershipSelect.getSelectedItem().toString() + " ";
                System.out.println(membership);

                JOptionPane.showMessageDialog(null,name + surname + phoneORSMS + gender + year + membership,"Registered!", JOptionPane.WARNING_MESSAGE);

            }
        });
        save.setFocusable(false);

        JButton cancel = new JButton("Cancel");
        cancel.setPreferredSize(new Dimension(325,50));
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameInput.setText("Name:");
                surnameInput.setText("Surname:");
                selectPhone.setSelected(false);
                selectSMS.setSelected(false);
            }
        });
        cancel.setFocusable(false);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout());
        bottomPanel.add(save);
        bottomPanel.add(cancel);
        form.add(bottomPanel,BorderLayout.SOUTH);

        form.pack();
    }
}
