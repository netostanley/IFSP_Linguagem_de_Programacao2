/**
 @Author Ivaldo Fernandes (CB3020878)

 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class TP04 extends Frame implements ActionListener {
    private JFrame f;
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JTextField t1 = new JTextField();
    private JLabel l1 = new JLabel("Nome: ");
    private JButton b1 = new JButton("Pesquisar");
    private JLabel lnome = new JLabel("Nome: ");
    private JLabel lsalario = new JLabel("Salario: ");
    private JLabel lcargo = new JLabel("Cargo: ");
    private JTextField tnome = new JTextField();
    private JTextField tsalario = new JTextField();
    private JTextField tcargo = new JTextField();
    private JButton b2 = new JButton("Anterior");
    private JButton b3 = new JButton("Proximo");

	

    TP04 (String titulo, int largura, int altura, int colinic, int lininic)
    {
        f = new JFrame(titulo);
        f.setSize(largura, altura);
        f.setLocation(colinic, lininic);
        f.setLayout(new BorderLayout(10, 10));
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		GridLayout gridp3 = new GridLayout(4, 2);
		gridp3.setVgap(2);
		p3.setLayout(gridp3);
		
		t1.setPreferredSize(new Dimension(200, 40));
		tnome.setEditable(false);
		tsalario.setEditable(false);
		tcargo.setEditable(false);


		p1.add(l1);
		p1.add(t1);

		b1.addActionListener(this);	

		p2.add(b1);
		p3.add(lnome);
		p3.add(tnome);
		p3.add(lsalario);
		p3.add(tsalario);
		p3.add(lcargo);
		p3.add(tcargo);

		b2.addActionListener(this);
		b3.addActionListener(this);

		p3.add(b2);
		p3.add(b3);
		

		f.add(p1, BorderLayout.NORTH);
		f.add(p2, BorderLayout.CENTER);
		f.add(p3, BorderLayout.SOUTH);

		f.setVisible(true);
		}

		public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1) 
		{
			try
			{
				String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=tp04; integratedSecurity=true";
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con;
				con = DriverManager.getConnection(url);
				System.out.println ("Conexao OK");
				Statement st = con.createStatement();
				ResultSet rs;
				rs = st.executeQuery("SELECT NomeFunc, SalarioFunc, ID_Cargo FROM dbo.tbfuncs JOIN dbo.tbcargo on ID_Cargo = ID WHERE NomeFunc LIKE '%" + t1.getText() + "%'");

				rs.next();
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));

				tnome.setText(rs.getString(1));
				tsalario.setText(rs.getString(2));
				tcargo.setText(rs.getString(3));

				rs.close();
				st.close();
				
			
				
				//dados da conexao
				DatabaseMetaData db = con.getMetaData();
				System.out.println("Conectado a "+db.getURL());
				System.out.println("Conexao "+db.getConnection());
				System.out.println("Driver "+db.getDriverName());
				System.out.println("Usuario "+db.getUserName());
				System.out.println("----------------------------------");
				con.close();
			}
			catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
			catch (Exception f) {

			System.out.println("Problemas ao tentar conectar com o banco de dados: " + f);
			}

		}
		else if (e.getSource() == b2) 
		{
			try
			{
				String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=TP04; integratedSecurity=true";
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con;
				con = DriverManager.getConnection(url);
				System.out.println ("Conexao OK");
				Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs;
				rs = st.executeQuery("SELECT NomeFunc, SalarioFunc, ID_Cargo FROM dbo.tbfuncs JOIN dbo.tbcargo on ID_Cargo = ID");

				while (rs.next()) 
				{
					System.out.println (rs.getString(1));
					System.out.println(tnome.getText());
					if (rs.getString(1).equals(tnome.getText())) { rs.previous(); break; }
					
				}

				tnome.setText(rs.getString(1));
				tsalario.setText(rs.getString(2));
				tcargo.setText(rs.getString(3));
				
			
			}

			catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
			catch (Exception f) {

			System.out.println("Problemas ao tentar conectar com o banco de dados: " + f);
			}
		
		}

		

		else if (e.getSource() == b3) 
		{
			try
			{
				String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=TP04; integratedSecurity=true";
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con;
				con = DriverManager.getConnection(url);
				System.out.println ("Conexao OK");
				Statement st = con.createStatement();
				ResultSet rs;
				rs = st.executeQuery("SELECT NomeFunc, SalarioFunc, ds_cargo FROM dbo.tbfuncs JOIN dbo.tbcargos on ID_Cargo = ID");
				
				while (rs.next()) 
				{
					System.out.println (rs.getString(1));
					System.out.println(tnome.getText());
					if (rs.getString(1).equals(tnome.getText())) { rs.next(); break; }
					
				}

				tnome.setText(rs.getString(1));
				tsalario.setText(rs.getString(2));
				tcargo.setText(rs.getString(3));
				
				rs.close();
				st.close();
			}

			catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			}
			catch (Exception f) {

			System.out.println("Problemas ao tentar conectar com o banco de dados: " + f);
			}
		
		}

	}

		public static void main(String[] args) {
			TP04 teste = new TP04("TP04", 500, 250, 10, 10);
    }
}	