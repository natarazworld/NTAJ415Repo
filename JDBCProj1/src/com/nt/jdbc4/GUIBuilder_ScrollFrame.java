package com.nt.jdbc4;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUIBuilder_ScrollFrame {
  private static final String SELECT_STUDENT_QUERY="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_3;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIBuilder_ScrollFrame window = new GUIBuilder_ScrollFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIBuilder_ScrollFrame() {
		initialize();
		initializeJDBC();
	}
	
	private void initializeJDBC() {
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			ps=con.prepareStatement(SELECT_STUDENT_QUERY,
					                                       ResultSet.TYPE_SCROLL_SENSITIVE,
					                                       ResultSet.CONCUR_READ_ONLY);
			rs=ps.executeQuery();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//initializeJDBC()

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println("GUIBuilder_ScrollFrame.initialize()");
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("GUIBuilder_ScrollFrame.initialize().new WindowAdapter() {...}.windowClosing()");
				try {
					if(rs!=null)
						rs.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
				try {
					if(ps!=null)
						ps.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
				try {
					if(con!=null)
						con.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}


			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(206, 21, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SNO ::");
		lblNewLabel.setBounds(66, 24, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SNANE");
		lblNewLabel_1.setBounds(66, 76, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(206, 120, 86, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_2 = new JLabel("SADD");
		lblNewLabel_2.setBounds(66, 123, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(206, 73, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("AVG");
		lblNewLabel_3.setBounds(66, 180, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(206, 177, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("first");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs.first();
					textField.setText(rs.getString(1));
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(3));
					textField_3.setText(rs.getString(4));
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(23, 208, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("next");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!rs.isLast()) {
						rs.next();
						textField.setText(rs.getString(1));
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(3));
						textField_3.setText(rs.getString(4));
					}//of
				}//try
				catch(SQLException se) {
					se.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(122, 208, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("previus");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(221, 208, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("last");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(320, 208, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
	}
}
