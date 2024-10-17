/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadorasimples;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kluvert
 */
public class InterfaceGUI extends JFrame implements ActionListener {

    JTextField textField;
    JLabel texto;
    JButton botaoClear, botaoAdd, botaoSub, botaoMul, botaoDiv, botaoIgual, botaoVirgula;
    JButton[] numberButtons = new JButton[10];

    double num1 = 0, num2 = 0;
    char operator;

    public InterfaceGUI() {
        criarJanela();
        criarComponentes();
        adicionarActionListener();
    }

    private void criarJanela() {
        setTitle("Calculadora Simples");
        setSize(600, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(30, 30, 30));
    }

    private void criarComponentes() {
        texto = new JLabel("");
        texto.setBounds(360, 45, 450, 75);
        texto.setFont(new Font("Consolas", Font.BOLD, 25));
        texto.setForeground(Color.white);
        add(texto);

        textField = new JTextField();
        textField.setBounds(75, 100, 450, 75);
        textField.setFont(new Font("Arial", PLAIN, 32));
        textField.setBackground(new Color(30, 30, 30));
        textField.setForeground(Color.white);
        textField.setEditable(false);
        add(textField);

        botaoClear = new JButton("C");
        botaoClear.setBounds(230, 210, 170, 70);
        botaoClear.setFont(new Font("Arial", PLAIN, 20));
        botaoClear.setBackground(new Color(66, 66, 66));
        botaoClear.setForeground(Color.white);
        add(botaoClear);

        botaoAdd = new JButton("+");
        botaoAdd.setBounds(410, 290, 120, 70);
        botaoAdd.setFont(new Font("Arial", PLAIN, 20));
        botaoAdd.setBackground(new Color(66, 66, 66));
        botaoAdd.setForeground(Color.white);
        add(botaoAdd);

        botaoSub = new JButton("-");
        botaoSub.setBounds(410, 450, 120, 70);
        botaoSub.setFont(new Font("Arial", PLAIN, 20));
        botaoSub.setBackground(new Color(66, 66, 66));
        botaoSub.setForeground(Color.white);
        add(botaoSub);

        botaoMul = new JButton("x");
        botaoMul.setBounds(410, 370, 120, 70);
        botaoMul.setFont(new Font("Arial", PLAIN, 20));
        botaoMul.setBackground(new Color(66, 66, 66));
        botaoMul.setForeground(Color.white);
        add(botaoMul);

        botaoDiv = new JButton("÷");
        botaoDiv.setBounds(410, 210, 120, 70);
        botaoDiv.setFont(new Font("Arial", PLAIN, 20));
        botaoDiv.setBackground(new Color(66, 66, 66));
        botaoDiv.setForeground(Color.white);
        add(botaoDiv);

        botaoIgual = new JButton("=");
        botaoIgual.setBounds(360, 530, 170, 70);
        botaoIgual.setFont(new Font("Arial", PLAIN, 20));
        botaoIgual.setBackground(new Color(66, 66, 66));
        botaoIgual.setForeground(Color.white);
        add(botaoIgual);

        botaoVirgula = new JButton(",");
        botaoVirgula.setBounds(230, 530, 120, 70);
        botaoVirgula.setFont(new Font("Arial", PLAIN, 20));
        botaoVirgula.setBackground(new Color(102, 102, 102));
        botaoVirgula.setForeground(Color.white);
        add(botaoVirgula);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(Integer.toString(i));
            numberButtons[i].setBackground(new Color(102, 102, 102));
            numberButtons[i].setForeground(Color.white);
            numberButtons[i].setFont(new Font("Arial", PLAIN, 20));
            add(numberButtons[i]);
        }

        numberButtons[7].setBounds(50, 290, 110, 70);
        numberButtons[8].setBounds(170, 290, 110, 70);
        numberButtons[9].setBounds(290, 290, 110, 70);
        numberButtons[4].setBounds(50, 370, 110, 70);
        numberButtons[5].setBounds(170, 370, 110, 70);
        numberButtons[6].setBounds(290, 370, 110, 70);
        numberButtons[1].setBounds(50, 450, 110, 70);
        numberButtons[2].setBounds(170, 450, 110, 70);
        numberButtons[3].setBounds(290, 450, 110, 70);
        numberButtons[0].setBounds(50, 530, 170, 70);
    }

    private void adicionarActionListener() {
        for (int i = 0; i < 10; i++) {
            numberButtons[i].addActionListener(this);
        }
        botaoClear.addActionListener(this);
        botaoAdd.addActionListener(this);
        botaoSub.addActionListener(this);
        botaoMul.addActionListener(this);
        botaoDiv.addActionListener(this);
        botaoIgual.addActionListener(this);
        botaoVirgula.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == botaoVirgula) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == botaoClear) {
            textField.setText("");
            texto.setText("");
            num1 = 0;
            num2 = 0;
        }

        if (e.getSource() == botaoAdd) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
            texto.setText(num1 + " +");
        }

        if (e.getSource() == botaoSub) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
            texto.setText(num1 + " -");
        }

        if (e.getSource() == botaoMul) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
            texto.setText(num1 + " x");
        }

        if (e.getSource() == botaoDiv) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
            texto.setText(num1 + " ÷");
        }

        if (e.getSource() == botaoIgual) {
            num2 = Double.parseDouble(textField.getText());
            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    texto.setText(num1 + " " + "+" + " " + num2 + " = ");
                    break;
                case '-':
                    result = num1 - num2;
                    texto.setText(num1 + " " + "-" + " " + num2 + " = ");
                    break;
                case '*':
                    result = num1 * num2;
                    texto.setText(num1 + " " + "x" + " " + num2 + " = ");
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                        texto.setText(num1 + " " + "÷" + " " + num2 + " = ");
                    } else {
                        texto.setText("Não é possível fazer divisão por zero");
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
        }
    }
}