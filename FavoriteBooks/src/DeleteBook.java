import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class DeleteBook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteBook frame = new DeleteBook();
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
	public DeleteBook() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(323, 32, 151, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter the ID");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(176, 30, 162, 37);
		contentPane.add(lblNewLabel);
		
		JButton deleteButton = new JButton("Delete");
	
		deleteButton.setFont(new Font("Arial", Font.BOLD, 18));
		deleteButton.setBounds(243, 95, 121, 44);
		contentPane.add(deleteButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(78, 209, 664, 265);
		contentPane.add(textArea);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				setVisible(false);
			}
		});
		btnClose.setFont(new Font("Arial", Font.BOLD, 18));
		btnClose.setBounds(408, 95, 121, 44);
		contentPane.add(btnClose);
		
		
		
		JButton btnNewButton_1 = new JButton("List the books");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedReader br = new BufferedReader(new FileReader("books.txt"));
					textArea.read( br, null );
                    br.close();
                    textArea.requestFocus();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		btnNewButton_1.setBounds(78, 181, 126, 23);
		contentPane.add(btnNewButton_1);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File inputFile = new File("books.txt");
				File tempFile = new File("myTempFile.txt");
			    BufferedReader reader = null;
				
				BufferedWriter writer = null;
				try {
					reader = new BufferedReader(new FileReader(inputFile));
					writer = new BufferedWriter(new FileWriter(tempFile));
					
					String lineToRemove = textField.getText();
					String currentLine;

				
						while((currentLine = reader.readLine()) != null) {
						    String trimmedLine = currentLine.trim();      
						    if(trimmedLine.startsWith(lineToRemove)) continue;
						    writer.write(currentLine + System.getProperty("line.separator"));
						}
						//writer.flush();
						writer.close(); 
						reader.close(); 
						
						if( inputFile.delete())                      //returns Boolean value  
						{  
						System.out.println(" deleted");   //getting and printing the file name  
						JOptionPane.showMessageDialog(null,"Deleted ");
						}  
						
						else  
						{  
						System.out.println("failed");  
						}
						tempFile.renameTo(inputFile);
				}
				catch (FileNotFoundException e1) {
				      e1.printStackTrace();
				    }
				catch (IOException e1) {
					
					e1.printStackTrace();
				}
		
				
			}
		});
	}
}
