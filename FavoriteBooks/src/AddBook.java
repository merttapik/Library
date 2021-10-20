//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Point;

public class AddBook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
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
	public AddBook() {
		setLocation(new Point(800, 125));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(43, 11, 82, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Arial", Font.BOLD, 18));
		lblCategory.setBounds(29, 61, 96, 39);
		contentPane.add(lblCategory);
		
		JLabel lblNewLabel_1_1 = new JLabel("Author");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(29, 111, 150, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Award");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(29, 161, 82, 39);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Rating");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(29, 211, 82, 39);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Year");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(29, 261, 150, 39);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Pages");
		lblNewLabel_1_5.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_5.setBounds(29, 311, 82, 39);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel(" Short Description");
		lblNewLabel_1_6.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_6.setBounds(10, 361, 169, 39);
		contentPane.add(lblNewLabel_1_6);
		
		textField = new JTextField();
		textField.setBounds(215, 11, 261, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(215, 68, 261, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(215, 111, 261, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(215, 153, 261, 28);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(215, 256, 261, 28);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(215, 311, 261, 28);
		contentPane.add(textField_5);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(215, 374, 382, 84);
		contentPane.add(textArea);
		
		
		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		comboBox.setBounds(215, 209, 261, 22);
		contentPane.add(comboBox);
		comboBox.addItem(1);
		comboBox.addItem(2);
		comboBox.addItem(3);
		comboBox.addItem(4);
		comboBox.addItem(5);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				 ArrayList<String> idCounter= new ArrayList<>();
				String title=textField.getText();
			    String category=textField_1.getText();
			    String author=textField_2.getText();
			    String award=textField_3.getText();
			    int rating= (int) comboBox.getSelectedItem();
			    int year=Integer.parseInt(textField_4.getText());
			    int pages=Integer.parseInt(textField_5.getText());
			    String description=textArea.getText();
			    
			    File file=new File("books.txt");
			    if(!file.exists()) {
					try {
						file.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
    
			   BufferedReader in = null;
			  
			    int count = 0;
			   
		        try {
		            String[] splited = null;
		            
		            in = new BufferedReader(new FileReader("books.txt"));
		            String read =null;
		            while ((read = in.readLine()) != null) {
		            	
		            	splited = read.split(",");
			                idCounter.add(splited[0]+","+splited[1]+","+splited[2]+","+splited[3]+","+splited[4]+","+splited[5]+","+splited[6]+","+splited[7]+","+splited[8] );
			                count=Integer.parseInt(splited[0])+1;      
		           }
		            
		            in.close();

		            Book book=new Book(count, title, category, author,award, rating, year, pages, description );
		            BufferedWriter b2=new BufferedWriter(new FileWriter(file,false));
                    idCounter.add(book.toString());
				 
                    for (String string : idCounter) {
                    	b2.write(string);
				    	b2.write("\n");
					}
					b2.close();
					
		        }catch (IOException e1) {
					
					e1.printStackTrace();
				}

			  }
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(610, 72, 119, 47);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setFont(new Font("Arial", Font.BOLD, 18));
		btnClose.setBounds(610, 221, 119, 47);
		contentPane.add(btnClose);
	}
}

    
	 // Book book=new Book((Integer.parseInt(splited[0])),splited[1],splited[2],splited[3],splited[4],(Integer.parseInt(splited[5])),(Integer.parseInt(splited[6])),(Integer.parseInt(splited[7])),splited[8] );
