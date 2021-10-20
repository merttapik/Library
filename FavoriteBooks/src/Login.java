import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	
	private static List<Book> books = new ArrayList<Book>();
	public static List<Book> getBooks() {
		return books;
	}

	public static void setBooks(List<Book> books) {
		Login.books = books;
	}

	private JPanel contentPane;
	private JTextField loginTextField;

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
	public Login()  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File file=new File("users.txt");
				if(!file.exists()) {
					try {
						file.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				try {
					BufferedWriter bw=new BufferedWriter(new FileWriter(file,false));
					bw.write("mert");
					bw.write("\n");
					bw.write("gizer");
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String[] users = new String[2];
				try {
					BufferedReader br= new BufferedReader(new FileReader(file));
					
					
					for( int i=0; i<2;i++) {
						
						users[i]=br.readLine();
						
					}
					br.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				if(loginTextField.getText().equals(users[0]) || loginTextField.getText().equals(users[1])) {
					setVisible(false);
					new Home().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Incorrect username");
				}
				
				
			}
		});
		btnNewButton.setBounds(124, 177, 111, 48);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(78, 102, 96, 31);
		contentPane.add(lblNewLabel);
		
		loginTextField = new JTextField();
		loginTextField.setToolTipText("text your username");
		loginTextField.setFont(new Font("Arial", Font.BOLD, 18));
		loginTextField.setBounds(195, 104, 152, 31);
		contentPane.add(loginTextField);
		loginTextField.setColumns(10);
		
		JButton btnClose = new JButton(" Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setFont(new Font("Arial", Font.BOLD, 18));
		btnClose.setBounds(280, 177, 111, 48);
		contentPane.add(btnClose);
	}
}
