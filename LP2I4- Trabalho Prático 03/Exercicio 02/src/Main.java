/**
 @Author Ivaldo Fernandes (CB3020878)

 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Ex02 extends Frame implements ActionListener {

    private JFrame f;
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();

    private JTextField tfNum = new JTextField();
    private JTextField tfNome = new JTextField("");
    private JTextField tfSexo = new JTextField("");
    private JTextField tfIdade = new JTextField("");

    private JLabel lNum = new JLabel("Número: ");
    private JLabel lNome = new JLabel("Nome: ");
    private JLabel lSexo = new JLabel("Sexo: ");
    private JLabel lIdade = new JLabel("Idade: ");

    private JButton bOk = new JButton("OK");
    private JButton bLimpar = new JButton("Limpar");
    private JButton bMostrar = new JButton("Mostrar");
    private JButton bSair = new JButton("Sair");
    private Pessoa UmaPessoa;


    Ex02 (String titulo, int largura, int altura, int colinic, int lininic)
    {
        f = new JFrame(titulo);
        f.setSize(largura, altura);
        f.setLocation(colinic, lininic);
        f.setLayout(new GridLayout(2, 1));
        p1.setLayout(new GridLayout(4, 2));
        p2.setLayout(new GridLayout(1, 4));

        tfNum.setEnabled(false);

        bOk.addActionListener(this);
        bMostrar.addActionListener(this);
        bLimpar.addActionListener(this);
        bSair.addActionListener(this);

        p1.add(lNum);
        p1.add(tfNum);
        p1.add(lNome);
        p1.add(tfNome);
        p1.add(lSexo);
        p1.add(tfSexo);
        p1.add(lIdade);
        p1.add(tfIdade);

        p2.add(bOk);
        p2.add(bLimpar);
        p2.add(bMostrar);
        p2.add(bSair);

        f.add(p1);
        f.add(p2);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bOk) {

            System.out.println("Nome: " + tfNome.getText());
            System.out.println("Sexo: " + tfSexo.getText());
            System.out.println("Idade: " +tfIdade.getText());

            if (tfIdade.getText().isEmpty() || tfNome.getText().isEmpty() || tfSexo.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(f, "CAMPOS AINDA NÃO PREENCHIDOS!");
            }
            else if (!tfSexo.getText().toUpperCase().equals("M") && !tfSexo.getText().toUpperCase().equals("F"))
            {
                JOptionPane.showMessageDialog(f, "CAMPO 'Sexo' ACEITA APENAS 'M' OU 'F'!");
            }
            else if (!tfIdade.getText().matches("[0-9]*"))
            {
                JOptionPane.showMessageDialog(f, "CAMPO 'Idade' ACEITA APENAS NÚMEROS!");
            }
            else
            {
                UmaPessoa = new Pessoa(tfNome.getText(), tfSexo.getText().charAt(0), Integer.parseInt(tfIdade.getText()));
            }
        }

        else if (e.getSource() == bLimpar) {
            tfNum.setText(" ");
            tfNome.setText(" ");
            tfIdade.setText(" ");
            tfSexo.setText(" ");
        }

        else if (e.getSource() == bMostrar) {
            tfNum.setText("" + UmaPessoa.getKp());
            tfNome.setText("" + UmaPessoa.getNome());
            tfIdade.setText("" + UmaPessoa.getIdade());
            tfSexo.setText("" + UmaPessoa.getSexo());
        }

        else if (e.getSource() == bSair) {
            f.dispose();
        }
    }

    public static void main(String[] args) {
        new Ex02("Ex02", 400, 250, 10, 10);
    }
}
