/*
    Ivaldo Fernandes - CB3020878
*/

import java.sql.*;
import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cadastro extends Frame implements ActionListener {

    private JFrame f = new JFrame();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();

    private JTextField tx1 = new JTextField();
    private JTextField tx2 = new JTextField();
    private JTextField tx3 = new JTextField();
    private JTextField tx4 = new JTextField();
    private JTextField tx5 = new JTextField();

    private JLabel l1 = new JLabel("Nome");
    private JLabel l2 = new JLabel("Idade");
    private JLabel l3 = new JLabel("Peso");
    private JLabel l4 = new JLabel("Altura");
    private JLabel l5 = new JLabel("Objetivo");

    private JButton b1 = new JButton("Incluir");
    private JButton b2 = new JButton("Limpar");
    private JButton b3 = new JButton("Apresenta Dados");
    private JButton b4 = new JButton("Sair");

    private JTextArea txtArea = new JTextArea("", 30, 20);

    private Connection con;

    public Cadastro(String titulo, int largura, int altura, int colinic, int lininic) {
        f = new JFrame(titulo);
        f.setSize(largura, altura);
        f.setLocation(colinic, lininic);
        f.setLayout(new GridLayout(2, 2));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        p1.add(b1);

        f.add(p1);

        p2.setLayout(new GridLayout(5,2));

        p2.add(l1);
        p2.add(tx1);
        p2.add(l2);
        p2.add(tx2);
        p2.add(l3);
        p2.add(tx3);
        p2.add(l4);
        p2.add(tx4);
        p2.add(l5);
        p2.add(tx5);

        f.add(p2);

        p3.setLayout(new GridLayout(3, 1));

        p3.add(b2);
        p3.add(b3);
        p3.add(b4);

        f.add(p3);

        p4.setLayout(new FlowLayout(FlowLayout.CENTER));
        txtArea.setEnabled(false);
        p4.add(txtArea);

        f.add(p4);


        f.setVisible(true);

        try {
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=TPFinal; integratedSecurity=true";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
            System.out.println("Conexão OK");
        }
        catch (SQLException e) {
            System.out.println("SQL Exception " + e);
        }
        catch (Exception e) {
            System.out.println("Anything else exception " + e);
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                Statement st = con.createStatement();

                st.executeUpdate("Insert into InformacoesPessoais values ('" + tx1.getText() + "'," + tx2.getText() + "," + tx3.getText() + "," + tx4.getText() + ",'" + tx5.getText()  + "')");
            }
            catch (SQLException error) {
                System.out.println(error.getMessage());
            }
        }

        else if (e.getSource() == b2) {
            tx1.setText("");
            tx2.setText("");
            tx3.setText("");
            tx4.setText("");
            tx5.setText("");
        }

        else if (e.getSource() == b3) {
            String retorno = "";

            try {
                Statement st = con.createStatement();
                ResultSet rs;

                rs = st.executeQuery("Select * from InformacoesPessoais");

                while (rs.next()) {
                    Academia aluno = new Academia(rs.getString(1), rs.getInt(2), rs.getFloat(3), rs.getFloat(4), rs.getString(5));
                    Gson gson = new Gson();
                    retorno += gson.toJson(aluno) + "\n";
                }
            }
            catch (Exception error) {
                System.out.println(error.getMessage());
            }

            JOptionPane.showMessageDialog(null, retorno, "Dados em JSON", JOptionPane.INFORMATION_MESSAGE);
        }

        else if (e.getSource() == b4) {
            System.exit(0);
        }
    }

    public static void main(String[] args)
    {


        new Cadastro("TPFinal", 500, 400, 20, 20);

    }
}

