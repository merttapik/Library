import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ListbyCategory extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListbyCategory frame = new ListbyCategory();
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
	public ListbyCategory() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(303, 99, 161, 51);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(180, 282, 391, 151);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("List Books");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 BufferedReader in = null;
					
		            try {
		            	String[] splited = null;
						in = new BufferedReader(new FileReader("books.txt"));
						String read ;
						ArrayList<String> answers= new ArrayList<>();
			            while( (read = in.readLine() )!= null) {
			            	            splited = read.split(",");    
			               if(textField.getText().equals(splited[2])) {
			            	
			            	  answers.add(splited[1]);
			               }
			            }
			            String name="";
	                    for (String string : answers) {
							
							 name = name+ string;
							 name= name+"\n";
						}
	                    textArea.setText(name);
			            in.close();
					} catch (FileNotFoundException e1) {
					
						e1.printStackTrace();
					} catch (IOException e1) {
					
						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(520, 99, 145, 51);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel(" Category :");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(180, 96, 117, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("List of books title");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(121, 245, 150, 26);
		contentPane.add(lblNewLabel_1);
		
		
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setBounds(549, 161, 104, 51);
		contentPane.add(btnNewButton_1);
	}
}
