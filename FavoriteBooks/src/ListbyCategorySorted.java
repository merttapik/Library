import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;

public class ListbyCategorySorted extends JFrame {

	private static ArrayList<String> answers= new ArrayList<>();

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListbyCategorySorted frame = new ListbyCategorySorted();
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
	public ListbyCategorySorted() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(261, 95, 152, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Category:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(134, 98, 95, 39);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(206, 235, 391, 150);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Sorted by rating ");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(28, 236, 149, 48);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("List the books ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 BufferedReader in = null;
					
		            try {
		            	String[] splited = null;
						in = new BufferedReader(new FileReader("books.txt"));
						String read ;
						
			            while( (read = in.readLine() )!= null) {
			            	            splited = read.split(",");    
			               if(textField.getText().equals(splited[2])) {
			            	
			            	  answers.add(splited[5]+","+splited[1]); 
			               }
			            }
			            Collections.sort(answers);
			            String name="";
	                    for (String string : answers) {
							
							 name = name+ string.substring(string.indexOf(",")+1);
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
		btnNewButton.setBounds(462, 95, 161, 48);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setFont(new Font("Arial", Font.BOLD, 18));
		btnClose.setBounds(490, 164, 107, 39);
		contentPane.add(btnClose);
	}

}
