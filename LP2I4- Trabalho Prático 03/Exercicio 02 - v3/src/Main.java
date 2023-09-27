/**
 @Author Ivaldo Fernandes (CB3020878)

 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Ex02_V3 extends Frame implements ActionListener {
    private JFrame f;
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();

    private JTextField tfNum = new JTextField();
    private JTextField tfNome = new JTextField("");
    private CheckboxGroup cbgSexo = new CheckboxGroup();
    private Checkbox cbM = new Checkbox("M", cbgSexo, false);
    private Checkbox cbF = new Checkbox("F", cbgSexo, false);
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


    Ex02_V3 (String titulo, int largura, int altura, int colinic, int lininic)
    {
        f = new JFrame(titulo);
        f.setSize(largura, altura);
        f.setLocation(colinic, lininic);
        f.setLayout(new GridLayout(4, 1));
        p1.setLayout(new GridLayout(2, 2));
        p2.setLayout(new GridLayout(1, 3));
        p3.setLayout(new GridLayout(1, 2));
        p4.setLayout(new GridLayout(1, 4));

        tfNum.setEnabled(false);

        bOk.addActionListener(this);
        bMostrar.addActionListener(this);
        bLimpar.addActionListener(this);
        bSair.addActionListener(this);

        p1.add(lNum);
        p1.add(tfNum);
        p1.add(lNome);
        p1.add(tfNome);
        p2.add(lSexo);
        p2.add(cbF);
        p2.add(cbM);
        p3.add(lIdade);
        p3.add(tfIdade);

        p4.add(bOk);
        p4.add(bLimpar);
        p4.add(bMostrar);
        p4.add(bSair);

        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.add(p4);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bOk) {

            System.out.println("Nome: " + tfNome.getText());
            System.out.println("Idade: " +tfIdade.getText());

            if (tfIdade.getText().isEmpty() || tfNome.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(f, "CAMPOS AINDA NÃO PREENCHIDOS!");
            }
            else if(cbgSexo.getSelectedCheckbox().getLabel() != "M" && cbgSexo.getSelectedCheckbox().getLabel() != "F")
            {
                JOptionPane.showMessageDialog(f, "PREENCHA O SEXO!");
            }
            else if (!tfIdade.getText().matches("[0-9]*"))
            {
                JOptionPane.showMessageDialog(f, "CAMPO 'Idade' ACEITA APENAS NÚMEROS!");
            }
            else
            {
                UmaPessoa = new Pessoa(tfNome.getText(), cbgSexo.getSelectedCheckbox().toString().charAt(0), Integer.parseInt(tfIdade.getText()));
            }
        }

        else if (e.getSource() == bLimpar) {
            tfNum.setText(" ");
            tfNome.setText(" ");
            tfIdade.setText(" ");
            cbgSexo.setSelectedCheckbox(null);
        }

        else if (e.getSource() == bMostrar) {
            tfNum.setText("" + UmaPessoa.getKp());
            tfNome.setText("" + UmaPessoa.getNome());
            tfIdade.setText("" + UmaPessoa.getIdade());
            cbgSexo.setSelectedCheckbox(UmaPessoa.getSexo() == cbF.getName().charAt(0) ? cbF : cbM);
        }

        else if (e.getSource() == bSair) {
            f.dispose();
        }
    }

    public static void main(String[] args) {
        new Ex02_V3("Ex02", 400, 200, 10, 10);
    }
}
