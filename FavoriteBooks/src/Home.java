import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setMinimumSize(new Dimension(1366, 7680));
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 492);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBook().setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(0, 100, 0));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(1302, 120, 203, 50);
		contentPane.add(btnNewButton);
		
		JButton btnDeleteBook = new JButton("Delete Book");
		btnDeleteBook.setForeground(new Color(0, 102, 0));
		btnDeleteBook.setFont(new Font("Arial", Font.BOLD, 12));
		btnDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new DeleteBook().setVisible(true);
				
			}
		});
		btnDeleteBook.setBounds(1302, 229, 203, 50);
		contentPane.add(btnDeleteBook);
		
		JButton btnSeeBookInformation = new JButton("Book \u0130nformation");
		btnSeeBookInformation.setForeground(new Color(0, 102, 0));
		btnSeeBookInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookInformation().setVisible(true);
			}
		});
		btnSeeBookInformation.setFont(new Font("Arial", Font.BOLD, 12));
		btnSeeBookInformation.setBounds(1578, 355, 203, 50);
		contentPane.add(btnSeeBookInformation);
		
		JButton btnFindBookCover = new JButton("Find Book Cover");
		btnFindBookCover.setForeground(new Color(0, 102, 51));
		btnFindBookCover.setFont(new Font("Arial", Font.BOLD, 12));
		btnFindBookCover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookCover().setVisible(true);
			}
		});
		btnFindBookCover.setBounds(1307, 476, 198, 50);
		contentPane.add(btnFindBookCover);
		
		JButton btnListBooksBy = new JButton("List Books by Author");
		btnListBooksBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListAuthor().setVisible(true);
			}
		});
		btnListBooksBy.setForeground(new Color(0, 102, 102));
		btnListBooksBy.setFont(new Font("Arial", Font.BOLD, 11));
		btnListBooksBy.setBounds(1578, 120, 203, 50);
		contentPane.add(btnListBooksBy);
		
		JButton btnNewButton_4_1 = new JButton("List Books by Category");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListbyCategory().setVisible(true);
			}
		});
		btnNewButton_4_1.setForeground(new Color(0, 102, 102));
		btnNewButton_4_1.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton_4_1.setBounds(1578, 229, 206, 50);
		contentPane.add(btnNewButton_4_1);
		
		JButton btnNewButton_4_1_1 = new JButton("List Books by Category Sorted");
		btnNewButton_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListbyCategorySorted().setVisible(true);
			}
		});
		btnNewButton_4_1_1.setForeground(new Color(0, 102, 102));
		btnNewButton_4_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_4_1_1.setBounds(1302, 589, 203, 50);
		contentPane.add(btnNewButton_4_1_1);
		
		JButton btnNewButton_4_1_2 = new JButton("Finished Book");
		btnNewButton_4_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FinishedBook().setVisible(true);
			}
		});
		btnNewButton_4_1_2.setForeground(new Color(0, 102, 102));
		btnNewButton_4_1_2.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_4_1_2.setBounds(1307, 357, 198, 47);
		contentPane.add(btnNewButton_4_1_2);
		
		JLabel lblNewLabel = new JLabel("MY LIBRARY");
		lblNewLabel.setForeground(new Color(153, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(566, 11, 167, 27);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_4_1_3 = new JButton("Logout");
		btnNewButton_4_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_4_1_3.setForeground(new Color(204, 51, 0));
		btnNewButton_4_1_3.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_4_1_3.setBounds(1647, 476, 134, 50);
		contentPane.add(btnNewButton_4_1_3);
	}
}
