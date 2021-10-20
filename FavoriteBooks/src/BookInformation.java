import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class BookInformation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookInformation frame = new BookInformation();
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
	public BookInformation() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Title");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(124, 59, 124, 40);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(169, 252, 496, 153);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Get Description");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BufferedReader in = null;
				
	            try {
	            	String[] splited = null;
					in = new BufferedReader(new FileReader("books.txt"));
					String read ;
		            while( (read = in.readLine() )!= null) {
		            	
		             //   read = in.readLine();
		                splited = read.split(",");
		               if(textField.getText().equals(splited[1])) {
		            	  textArea.setText(splited[8]);
		            	  break;
		               }
		               
		            }
		            in.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(169, 139, 153, 45);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(258, 62, 218, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setBounds(378, 140, 129, 45);
		contentPane.add(btnNewButton_1);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Arial", Font.BOLD, 18));
		lblDescription.setBounds(25, 254, 124, 40);
		contentPane.add(lblDescription);
	}
}
