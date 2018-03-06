/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author KamrulHasan
 */
public class SlotMachine extends JFrame {

    private int wins, looses, totalCredits, numberOfGames;
    JButton btnReel;
    JButton btnAddCoin;
    JButton btnBetOne;
    JButton btnBetMax;
    JButton btnReset;
    JButton btnStatistics;
    JTextField txfValue1;
    JTextField txfValue2;
    JTextField txfValue3;
    JTextField txfAddCoin;
    JTextField txfBetOne;
    JLabel lblImage1;
    JLabel lblImage2;
    JLabel lblImage3;
    JLabel empty1;
    JLabel lblcredit;
    JLabel lblbet;
    JLabel lblinfo;
    Reel reel;
    Reel reel2;
    Reel reel3;
    int credit = 10;
    int bet = 0;

    MyWorker worker1;
    MyWorker worker2;
    MyWorker worker3;

    public SlotMachine() {

        Container cp = getContentPane();
        //set layout in the window
        cp.setBackground(Color.WHITE);
        cp.setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 2, 2, 2));

        lblcredit = new JLabel("Credit : 10");
        p1.add(lblcredit);

        txfAddCoin = new JTextField(credit + "");
        txfAddCoin.setEditable(false);
        p1.add(txfAddCoin);

        btnAddCoin = new JButton("Add Coin");
        p1.add(btnAddCoin);

        lblbet = new JLabel("Betting with: 0");
        p1.add(lblbet);

        txfBetOne = new JTextField(bet + "");
        txfBetOne.setEditable(false);
        p1.add(txfBetOne);

        btnBetOne = new JButton("Bet One");
        p1.add(btnBetOne);

        btnBetMax = new JButton("Bet Max ");
        p1.add(btnBetMax);

        btnStatistics = new JButton("Statistics");
        p1.add(btnStatistics);

//        empty1 = new JLabel();
//        p1.add(empty1);
        cp.add(p1, BorderLayout.NORTH);

        JPanel p2 = new JPanel();
        txfValue1 = new JTextField("");
        txfValue1.setEditable(false);
        p2.add(txfValue1);
        cp.add(p2, BorderLayout.WEST);

        lblImage1 = new JLabel("", JLabel.LEFT);
        cp.add(lblImage1, BorderLayout.WEST);

        txfValue2 = new JTextField();
        txfValue2.setEditable(false);
        p2.add(txfValue2);
        cp.add(p2, BorderLayout.CENTER);

        lblImage2 = new JLabel("", JLabel.CENTER);
        cp.add(lblImage2, BorderLayout.CENTER);

        txfValue3 = new JTextField();
        txfValue3.setEditable(false);
        p2.add(txfValue3);
        cp.add(p2, BorderLayout.EAST);

        lblImage3 = new JLabel("", JLabel.RIGHT);
        cp.add(lblImage3, BorderLayout.EAST);

        JPanel p3 = new JPanel();
        btnReel = new JButton("SPIN");
        p3.add(btnReel);
        cp.add(p3, BorderLayout.SOUTH);

        btnReset = new JButton("Reset");
        p3.add(btnReset);
        cp.add(p3, BorderLayout.SOUTH);

        lblinfo = new JLabel("");
        p3.add(lblinfo);
        cp.add(p3, BorderLayout.SOUTH);

        reel = new Reel();
        Symbol faceImage = reel.Spin();
        lblImage1.setIcon(faceImage.getImage());
        txfValue1.setText(Integer.toString(faceImage.getValue()));

        reel2 = new Reel();
        Symbol faceImage2 = reel.Spin();
        lblImage2.setIcon(faceImage2.getImage());
        txfValue2.setText(Integer.toString(faceImage2.getValue()));

        reel3 = new Reel();
        Symbol faceImage3 = reel.Spin();
        lblImage3.setIcon(faceImage3.getImage());
        txfValue3.setText(Integer.toString(faceImage3.getValue()));

        MyListener handler = new MyListener();
        btnReel.addActionListener(handler);
        btnBetOne.addActionListener(handler);
        btnReset.addActionListener(handler);
        btnBetMax.addActionListener(handler);
        btnAddCoin.addActionListener(handler);
        btnStatistics.addActionListener(handler);

        worker1 = new MyWorker(lblImage1, reel);
        worker2 = new MyWorker(lblImage2, reel);
        worker3 = new MyWorker(lblImage3, reel);
    }

    private class MyListener extends MouseAdapter implements ActionListener {
        private Component popup;

        @Override
        public void mouseClicked(MouseEvent evt) {
            if (evt.getSource().equals(lblImage1)) {
                worker1.cancel(true);
                worker2.cancel(true);
                worker3.cancel(true);
            } else if (evt.getSource().equals(lblImage2)) {
                worker1.cancel(true);
                worker2.cancel(true);
                worker3.cancel(true);
            } else if (evt.getSource().equals(lblImage3)) {
                worker1.cancel(true);
                worker2.cancel(true);
                worker3.cancel(true);
            }

            Symbol faceImage1 = reel.Spin();
            Symbol faceImage2 = reel2.Spin();
            Symbol faceImage3 = reel3.Spin();

            lblImage1.setIcon(faceImage1.getImage());
            txfValue1.setText(Integer.toString(faceImage1.getValue()));
            lblImage2.setIcon(faceImage2.getImage());
            txfValue2.setText(Integer.toString(faceImage2.getValue()));
            lblImage3.setIcon(faceImage3.getImage());
            txfValue3.setText(Integer.toString(faceImage3.getValue()));
            
            System.out.println("reel1 :" +faceImage1.getValue());
            System.out.println("reel2 :" +faceImage2.getValue());
            System.out.println("reel3 :" +faceImage3.getValue());
            
            if ((faceImage1.comapareTo(faceImage2)==0)&&(faceImage1.compareTo(faceImage3)==0)&&(faceImage2.compareTo(faceImage3)==0)){
                int points=faceImage1.getValue();
                System.out.println("points");
                
                int won=points*bet;
                System.out.println(bet);
                System.out.println(won);
                JOptionPane.showMessageDialog(popup, "You Won: " +won+ " credits","Message", JOptionPane.PLAIN_MESSAGE);
                txfAddCoin.setText(credit +"");
                bet=0;
                txfBetOne.setText(bet + "");
                wins++;
                
                
            }
            else if (faceImage1.compareTo(faceImage3)==0){
            int points=faceImage1.getValue();
            System.out.println(points);
            int won = points*bet;
            System.out.println(bet);
            credit = credit + won;
            System.out.println(won);
            JOptionPane.showMessageDialog(popup, "You Won: " +won+ " credits","Message", JOptionPane.PLAIN_MESSAGE);
                txfAddCoin.setText(credit +"");
                bet=0;
                txfBetOne.setText(bet + "");
                wins++;
            
        } else if (faceImage2.compareTo(faceImage3)==0){
            int points=faceImage2.getValue();
            System.out.println(points);
            int won = points*bet;
            System.out.println(bet);
            credit = credit + won;
            System.out.println(won);
            JOptionPane.showMessageDialog(popup, "You Won: " +won+ " credits","Message", JOptionPane.PLAIN_MESSAGE);
                txfAddCoin.setText(credit +"");
                bet=0;
                txfBetOne.setText(bet + "");
                wins++;
            
        } else if ((faceImage1.comapareTo(faceImage2)!=0)&&(faceImage1.compareTo(faceImage3)!=0)&&(faceImage2.compareTo(faceImage3)!=0)){
                JOptionPane.showMessageDialog(popup, "You Lost","Message", JOptionPane.PLAIN_MESSAGE);
                bet=0;
                txfBetOne.setText(bet +"");
                looses++;
            
                }

        }

        public void actionPerformed(ActionEvent evt) {
            String btnLabel = evt.getActionCommand();
            if (btnLabel.equals("Bet One")) {
                if (credit <= 0) {
                    lblinfo.setText("Not enough credit to bet");
                } else {
                    credit--;
                    bet++;
                    lblcredit.setText("Credit: " + credit);
                    lblbet.setText("Betting with: " + bet + "    ");
                }

            } else if (btnLabel.equals("Reset")) {
                credit += bet;// If user resets the credit add it all
                // back to the inital credit
                bet = 0;
                lblcredit.setText("Credit: " + credit);
                lblbet.setText("Credit betting with: " + bet + "    ");
                btnBetMax.setEnabled(true);
            } else if (btnLabel.equals("Bet Max")) {
                if (credit <= 2) {
                    lblinfo.setText("Not enough credit to place a maximum bet");
                } else {
                    credit -= 3;
                    bet += 3;
                    lblcredit.setText("Credit: " + credit);
                    lblbet.setText("Credit betting with: " + bet + "    ");
                    btnBetMax.setEnabled(false);

                }
            } else if (btnLabel.equals("Add Coin")) {
                credit++;// Increase credit
                lblcredit.setText("Credit: " + credit);
                lblbet.setText("Betting with: " + bet + " ");

            } else if (btnLabel.equals("SPIN")) {
                if (credit < 0 || bet <= 0) {
                    JOptionPane.showMessageDialog(popup, "You need to insert credit to spin");
                } else {
                    Symbol faceImage1 = reel.Spin();
                    Symbol faceImage2 = reel2.Spin();
                    Symbol faceImage3 = reel3.Spin();

                    lblImage1.setIcon(faceImage1.getImage());
                    txfValue1.setText(Integer.toString(faceImage1.getValue()));
                    lblImage2.setIcon(faceImage2.getImage());
                    txfValue2.setText(Integer.toString(faceImage2.getValue()));
                    lblImage3.setIcon(faceImage3.getImage());
                    txfValue3.setText(Integer.toString(faceImage3.getValue()));
                    totalCredits += bet;
                    numberOfGames++;
                    if (worker1.isCancelled() || worker2.isCancelled() || worker3.isCancelled()) {
                        worker1 = new MyWorker(lblImage1, reel);
                        worker2 = new MyWorker(lblImage2, reel2);
                        worker3 = new MyWorker(lblImage3, reel3);

                        worker1.execute();
                        worker2.execute();
                        worker3.execute();

                    } else {
                        worker1.execute();
                        worker2.execute();
                        worker3.execute();
                    }

                }

            } else if (btnLabel.equals("Statistics")) {
                if (numberOfGames == 0) {
                    new Statistics(wins, looses, 0).setVisible(true);
                } else {
                    new Statistics(wins, looses, new Double(totalCredits / numberOfGames)).setVisible(true);
                }

            }
        }

    }


}
