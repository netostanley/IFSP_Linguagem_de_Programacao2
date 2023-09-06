/**
 @Author Ivaldo Fernandes (CB3020878) & Victoria Andraus (CB3021351)
	
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.*;

public class Painel implements ActionListener{
    JFrame janela = new JFrame();	

    JPanel main = new JPanel(new BorderLayout());
    JPanel painelPrinc = new JPanel(new GridLayout(3, 2, 10, 10));
    JPanel painelSpr = new JPanel(new GridLayout(1, 4));
        
    JTextField txt = new JTextField(5);

    private ArrayList<Aluno> lista_aluno = new ArrayList<>();

    private JTextField tfNome = new JTextField();
    private	JTextField tfIdade = new JTextField();
    private	JTextField tfEndereco = new JTextField();

    private	Button btnOk = new Button("Ok");
    private	Button btnSair = new Button("Sair");
    private	Button btnMostrar = new Button("Mostrar");
    private	Button btnLimpar = new Button("Limpar");

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnOk) {
            Aluno aluno = new Aluno();
            aluno.setEndereco(tfEndereco.getText());
            aluno.setNome(tfNome.getText());
            aluno.setIdade(Integer.valueOf(tfIdade.getText()).intValue());
            UUID id_aluno = UUID.randomUUID();
            aluno.setUuid(id_aluno);

            lista_aluno.add(aluno);
        }
        else if (e.getSource() == btnLimpar) {
            tfEndereco.setText(null);
            tfIdade.setText(null);
            tfNome.setText(null);
        }
        else if (e.getSource() == btnSair) {
            janela.dispose();
        }
        else if(e.getSource() == btnMostrar) {
            String mensagem = "";

            for (int i = 0; i < lista_aluno.size(); i++) {
                mensagem += lista_aluno.get(i).getUuid() + " Nome: " + lista_aluno.get(i).getNome() + "\n";
            }

            JOptionPane.showMessageDialog(janela, mensagem);
        }

    }

    public Painel(){
        
        janela.setTitle("TP02 - LP2I4");
        janela.setSize(400,180);
        janela.setLocation(500,250);
        
        janela.add(main);

        main.add(painelPrinc, BorderLayout.NORTH);
        painelPrinc.add(new Label("Nome: "));
        painelPrinc.add(tfNome);
        painelPrinc.add(new Label("Idade: "));
        painelPrinc.add(tfIdade);
        painelPrinc.add(new Label("Endereço: "));
        painelPrinc.add(tfEndereco);
        
        btnOk.addActionListener(this);
        btnMostrar.addActionListener(this);
        btnSair.addActionListener(this);
        btnLimpar.addActionListener(this);

        main.add(painelSpr, BorderLayout.SOUTH);
        painelSpr.add(btnOk);
        painelSpr.add(btnLimpar);
        painelSpr.add(btnMostrar);
        painelSpr.add(btnSair);
        

        janela.setVisible(true);    
    }


    public static void main(String[] args) {
        new Painel();
    }
}