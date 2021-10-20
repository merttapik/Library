import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class BookCover extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookCover frame = new BookCover();
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
	public BookCover() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 15));
		textField.setBounds(57, 144, 161, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter the book ID");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setBounds(57, 87, 161, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(168, 215, 119, 50);
		contentPane.add(btnNewButton);
		
		JLabel CoverLabel = new JLabel("");
		CoverLabel.setLabelFor(this);
		CoverLabel.setToolTipText("BookCover");
		CoverLabel.setBounds(356, 49, 377, 352);
		contentPane.add(CoverLabel);
		
		JButton btnFindCover = new JButton("Find Cover");
		btnFindCover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               BufferedReader in = null;
				
	            try {
	            	String[] splited = null;
					in = new BufferedReader(new FileReader("books.txt"));
					String read ;
		            while( (read = in.readLine() )!= null) {
		                splited = read.split(",");
		               if(textField.getText().equals(splited[0])) {
		            	   if((Integer.parseInt(splited[0]))==1) {
		            		   CoverLabel.setIcon(new ImageIcon("Book1Cover.jpg"));
		            	   }
		            	  break;
		               }
		            }
		            in.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
	
			
			}});
		btnFindCover.setFont(new Font("Arial", Font.BOLD, 15));
		btnFindCover.setBounds(22, 215, 119, 50);
		contentPane.add(btnFindCover);
		
		
	}
}
