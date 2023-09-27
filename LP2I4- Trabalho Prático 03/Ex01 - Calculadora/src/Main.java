/**
 @Author Ivaldo Fernandes (CB3020878)

 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


class Ex01 extends JFrame implements ActionListener {

    private JFrame f;
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JTextField tf = new JTextField();

    private Button b0 = new Button("0");
    private JButton b1 = new JButton("1");
    private JButton b2 = new JButton("2");
    private JButton b3 = new JButton("3");
    private JButton b4 = new JButton("4");
    private JButton b5 = new JButton("5");
    private JButton b6 = new JButton("6");
    private JButton b7 = new JButton("7");
    private JButton b8 = new JButton("8");
    private JButton b9 = new JButton("9");

    private JButton bdiv = new JButton("/");
    private JButton badd = new JButton("+");
    private JButton bsub = new JButton("-");
    private JButton bmult = new JButton("*");
    private JButton bigual = new JButton("=");
    private JButton bponto = new JButton(".");
    private JButton bc = new JButton("C");
    private ArrayList<String> arrayConta = new ArrayList<String>();
    private ArrayList<Double> resultArray = new ArrayList<Double>();
    private boolean ponto = true;


    Ex01 (String titulo, int largura, int altura, int colinic, int lininic)
    {
        // super(titulo);

        // setSize(largura,altura);
        // setLocation(colinic,lininic);
        // setLayout(new GridLayout(2, 1));
        f = new JFrame(titulo);
        f.setSize(largura, altura);
        f.setLocation(colinic, lininic);
        f.setLayout(new GridLayout(2, 1));
        p1.setLayout(new GridLayout(1, 1));
        p2.setLayout(new GridLayout(5, 4));

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        bigual.addActionListener(this);
        badd.addActionListener(this);
        bsub.addActionListener(this);
        bdiv.addActionListener(this);
        bponto.addActionListener(this);
        bmult.addActionListener(this);
        bc.addActionListener(this);


        p1.add(tf);
        p2.add(b7);
        p2.add(b8);
        p2.add(b9);
        p2.add(bdiv);
        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        p2.add(bmult);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(bsub);
        p2.add(b0);
        p2.add(bponto);
        p2.add(bigual);
        p2.add(badd);
        p2.add(bc);


        f.add(p1);
        f.add(p2);

        f.setVisible(true);
    }

    public boolean podePonto()
    {
        boolean retorno = false;
        char lastchar = tf.getText().charAt(tf.getText().length() - 1);

        if (lastchar != '.' && lastchar != ' ' && lastchar != '+' && lastchar != '-' && lastchar != '*' && lastchar != '/') {
            retorno = true;
        }
        return retorno;
    }

    public boolean podeSinal()
    {
        boolean retorno = false;
        char lastchar = tf.getText().charAt(tf.getText().length() - 1);


        if (lastchar != '.' && lastchar != ' ' && lastchar != '+' && lastchar != '-' && lastchar != '*' && lastchar != '/') {
            retorno = true;
        }

        return retorno;
    }

    public boolean podeSubtrair()
    {
        boolean retorno = false;
        char lastchar;

        if (tf.getText().length() == 0)
        {
            retorno = true;
        }
        else
        {
            lastchar = tf.getText().charAt(tf.getText().length() - 1);

            if (lastchar != '.' && lastchar != '-') {
                retorno = true;
            }
        }
        return retorno;
    }

    public double resultado()
    {
        double resultado = 0;
        String s = "";

        // PEGA A STRING E ALOCA OS VALORES DOS NUMEROS E SINAIS ORGANIZADOS POR ÍNDICE
        // NÚMERO EM ÍNDICES PARES E SINAIS EM ÍNDICES ÍMPARES

        for (int x = 0; x < tf.getText().length(); x++)
        {
            if (tf.getText().charAt(x) == '-' && x != 0)
            {
                if (!Character.isDigit(tf.getText().charAt(x - 1)))
                {
                    s += "-";
                }
                else
                {
                    arrayConta.add(s);
                    s = "";
                    s += tf.getText().charAt(x);
                    arrayConta.add(s);
                    s = "";
                }
            }

            else if (tf.getText().charAt(x) == '-' && x == 0)
            {
                s += "-";
            }

            else if (Character.isDigit(tf.getText().charAt(x)) || tf.getText().charAt(x) == '.')
            {
                s += tf.getText().charAt(x);
            }

            else if (tf.getText().charAt(x) == '+' || tf.getText().charAt(x) == '*' || tf.getText().charAt(x) == '/')
            {
                arrayConta.add(s);
                s = "";
                s += tf.getText().charAt(x);
                arrayConta.add(s);
                s = "";
            }
        }
        arrayConta.add(s);

        // ALOCA NUMA LISTA DE DOUBLE TODOS OS NUMEROS

        for (int y = 0; y < arrayConta.size(); y++)
        {
            if (y % 2 == 0 && arrayConta.get(y) != null)
            {
                resultArray.add(Double.parseDouble(arrayConta.get(y)));
            }
        }

        System.out.println(resultArray);

        // FAZ A CONTA DE ACORDO COM UMA COMPARAÇÃO ENTRE AS LISTAS
        int contador = 1;
        for (int y = 0; y < arrayConta.size(); y++)
        {
            if (y % 2 != 0 && arrayConta.get(y) != null)
            {
                System.out.println("Contador: " + contador);
                if (arrayConta.get(y).charAt(0) == '+')
                {
                    if (y == 1)
                    {
                        System.out.println(contador);
                        System.out.println("Resultado: " + resultArray.get(contador - 1) + " + " + resultArray.get(contador));
                        resultado = resultArray.get(contador - 1) + resultArray.get(contador);

                    }
                    else
                    {
                        System.out.println(contador);
                        System.out.println("Resultado: " + resultado + " + " + resultArray.get(contador));
                        resultado += resultArray.get(contador);

                    }
                    contador = contador + 1;
                }
                else if (arrayConta.get(y).charAt(0) == '-')
                {

                    if (y == 1)
                    {
                        System.out.println(contador);
                        System.out.println("Resultado: " + resultArray.get(contador - 1) + " - " + resultArray.get(contador));
                        resultado = resultArray.get(contador - 1) - resultArray.get(contador);

                    }
                    else
                    {
                        System.out.println(contador);
                        System.out.println("Resultado: " + resultado + " - " + resultArray.get(contador));
                        resultado -= resultArray.get(contador);

                    }
                    contador = contador + 1;
                }
                else if (arrayConta.get(y).charAt(0) == '*')
                {

                    if (y == 1)
                    {
                        System.out.println(contador);
                        System.out.println("Resultado: " + resultArray.get(contador - 1) + " * " + resultArray.get(contador));
                        resultado = resultArray.get(contador - 1) * resultArray.get(contador);

                    }
                    else
                    {
                        System.out.println(contador);
                        System.out.println("Resultado: " + resultado + " * " + resultArray.get(contador));
                        resultado *= resultArray.get(contador);

                    }
                    contador = contador + 1;
                }

                else if (arrayConta.get(y).charAt(0) == '/')
                {
                    if (y == 1)
                    {
                        System.out.println(contador);
                        System.out.println("Resultado: " + resultArray.get(contador - 1) + " / " + resultArray.get(contador));
                        resultado = resultArray.get(contador - 1) / resultArray.get(contador);

                    }
                    else
                    {
                        System.out.println(contador);
                        System.out.println("Resultado: " + resultado + " / " + resultArray.get(contador));
                        resultado /= resultArray.get(contador);

                    }
                    contador = contador + 1;
                }
            }
        }
        System.out.println(resultado);
        arrayConta = new ArrayList<String>();
        resultArray = new ArrayList<Double>();
        return resultado;
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == b0)
        {
            tf.setText(tf.getText() + 0);
        }

        if (e.getSource() == b1)
        {
            tf.setText(tf.getText() + 1);
        }

        if (e.getSource() == b2)
        {
            tf.setText(tf.getText() + 2);
        }

        if (e.getSource() == b3)
        {
            tf.setText(tf.getText() + 3);
        }

        if (e.getSource() == b4)
        {
            tf.setText(tf.getText() + 4);
        }

        if (e.getSource() == b5)
        {
            tf.setText(tf.getText() + 5);
        }

        if (e.getSource() == b6)
        {
            tf.setText(tf.getText() + 6);
        }

        if (e.getSource() == b7)
        {
            tf.setText(tf.getText() + 7);
        }

        if (e.getSource() == b8)
        {
            tf.setText(tf.getText() + 8);
        }

        if (e.getSource() == b9)
        {
            tf.setText(tf.getText() + 9);
        }

        if (e.getSource() == badd)
        {
            if (podeSinal())
                tf.setText(tf.getText() + "+");

            ponto = true;
        }

        if (e.getSource() == bsub)
        {
            if (podeSubtrair())
                tf.setText(tf.getText() + "-");

            ponto = true;
        }

        if (e.getSource() == bdiv)
        {
            if (podeSinal())
                tf.setText(tf.getText() + "/");

            ponto = true;
        }

        if (e.getSource() == bmult)
        {
            if (podeSinal())
                tf.setText(tf.getText() + "*");

            ponto = true;
        }

        if (e.getSource() == bc)
        {
            tf.setText(" ");
            arrayConta = new ArrayList<String>();
            resultArray = new ArrayList<Double>();
        }

        if (e.getSource() == bponto)
        {
            if (podePonto() && ponto == true) {
                tf.setText(tf.getText() + ".");
                ponto = false;
            }

        }

        if (e.getSource() == bigual)
        {
            double r = resultado();
            tf.setText(String.valueOf(r));
            if (Double.POSITIVE_INFINITY == r)
            {
                JOptionPane.showMessageDialog(f, "Divisão por Zero não é entendida");
            }


        }

    }




}

public class Main {
    public static void main(String[] args)
    {
        new Ex01("Ex01", 300, 300, 10, 10);
    }
}