package projetintegre;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Button;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Label;
import javax.swing.JRadioButton;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1093, 542);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user = new JTextField();
		user.setBounds(16, 297, 273, 36);
		contentPane.add(user);
		user.setColumns(10);
		
		password = new JPasswordField();
		password.setOpaque(false);
		password.setBounds(16, 373, 273, 36);
		contentPane.add(password);
		

		
		JLabel lblNewLabel = new JLabel("Identifiant :");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("PT Serif Caption", Font.PLAIN, 15));
		lblNewLabel.setBounds(6, 269, 109, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de passe :");
		lblNewLabel_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1.setFont(new Font("PT Serif Caption", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(6, 345, 142, 16);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton btnAdmin = new JRadioButton("Admin");
		btnAdmin.setForeground(new Color(139, 0, 0));
		btnAdmin.setFont(new Font("PT Serif Caption", Font.PLAIN, 15));
		btnAdmin.setOpaque(false);
		btnAdmin.setBounds(6, 108, 141, 23);
		contentPane.add(btnAdmin);
		
		JRadioButton btnMoniteur = new JRadioButton("Moniteur");
		btnMoniteur.setForeground(new Color(139, 0, 0));
		btnMoniteur.setFont(new Font("PT Serif Caption", Font.PLAIN, 15));
		btnMoniteur.setOpaque(false);
		btnMoniteur.setBounds(6, 160, 141, 23);
		contentPane.add(btnMoniteur);
		
		JRadioButton btnCandidat = new JRadioButton("Candidat");
		btnCandidat.setFont(new Font("PT Serif Caption", Font.PLAIN, 15));
		btnCandidat.setForeground(new Color(139, 0, 0));
		btnCandidat.setOpaque(false);
		btnCandidat.setBounds(6, 207, 141, 23);
		contentPane.add(btnCandidat);
		
		JButton btnconnecter = new JButton("Se connecter");
		btnconnecter.setForeground(new Color(139, 0, 0));
		btnconnecter.setFont(new Font("PT Serif Caption", Font.PLAIN, 15));
		btnconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0 ) {
				Connection con = null;
				Statement stmt = null;
				ResultSet rs = null;
				
                   try {
                	   if (btnCandidat.isSelected()) {
   					     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projetautoecole","root","siham123salma");
   						stmt=con.createStatement();
   							String  sql="select * from Candidats where 	NumCandidat='"+user.getText()
   							+"' and MdpCandidat='"+password.getText().toString()+"'";
   							 rs=stmt.executeQuery(sql);
   							if(rs.next()) {
   								JOptionPane.showMessageDialog(null,"Login Sucessfully ...");
   								//Login.dispose();
   								Candidat cd = new Candidat();
   								cd.setVisible(true);
   				    }
                	 }
                	   else if (btnAdmin.isSelected()) {
                		   String admin = "ADMINSima" ;
  							String adminmdp = "ima" ;
  							if(user.getText().toString().equals(admin) && (password.getText().toString().equals(adminmdp)))  {
 	                              Admin ad = new Admin();
 	                              ad.setVisible(true);
					}
             
   					}
                	   else if(btnMoniteur.isSelected()){
     					     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projetautoecole","root","siham123salma");
        						stmt=con.createStatement();
        							String  sql="select * from Moniteur where 	NumMoniteur='"+user.getText()
        							+"' and MdpMoniteur='"+password.getText().toString()+"'";
        							 rs=stmt.executeQuery(sql);
        							if(rs.next()) {
        								JOptionPane.showMessageDialog(null,"Login Sucessfully ...");
        								//Login.dispose();
        								Moniteur Mn = new Moniteur();
        								Mn.setVisible(true);
                	   }
                	   }
                	   
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null,"ERROR");
				}
					
					
			}
		});
	
		btnconnecter.setBounds(16, 422, 273, 39);
		contentPane.add(btnconnecter);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setBounds(320, -155, 793, 670);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/IMAGES/home.jpeg")));
		
		JLabel lblNewLabel_3 = new JLabel("AUTO ECOLE SINYORITA");
		lblNewLabel_3.setForeground(new Color(139, 0, 0));
		lblNewLabel_3.setFont(new Font("PT Serif Caption", Font.PLAIN, 20));
		lblNewLabel_3.setBackground(Color.GRAY);
		lblNewLabel_3.setBounds(20, 6, 313, 42);
		contentPane.add(lblNewLabel_3);
		



	}
}
