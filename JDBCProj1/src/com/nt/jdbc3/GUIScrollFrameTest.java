package com.nt.jdbc3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUIScrollFrameTest extends JFrame implements ActionListener,WindowListener {
	private static final  String  GET_STUDENTS_QUERY="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";
	private JLabel lsno,lsname,laddrs,lavg;
	private JTextField tsno,tsname,taddrs,tavg;
	private JButton  bFirst,bLast,bPrevious,bNext;
	private Connection con;
	private PreparedStatement ps;
	private  ResultSet rs;
	
	//constructor
	public GUIScrollFrameTest() {
		System.out.println("GUIScrollFrameTest:: 0-param constructor(start)");
	  setTitle("GUIFrontEnd-Scroll Frame");
	  setSize(300,300);
	  setLayout(new FlowLayout());
	  
	  //add comps
	   lsno=new JLabel("sno");
	  add(lsno);
	  tsno=new JTextField(10);
			add(tsno);
	  
	   lsname=new JLabel("sname");
	  add(lsname);
	   tsname=new JTextField(10);
		add(tsname);
			
		 laddrs=new JLabel("sadd");
		  add(laddrs);
		 taddrs=new JTextField(10);
			add(taddrs);
		
		  
		 lavg=new JLabel("student avg");
		  add(lavg);
		 tavg=new JTextField(10);
		add(tavg);
		
		 bFirst=new JButton("First");
		 bNext=new JButton("next");
		 bPrevious=new JButton("previous");
		 bLast=new JButton("Last");
		add(bFirst); add(bNext); add(bPrevious); add(bLast);
		
		//register and activate ActionListener for all the 4 buttons
		  bFirst.addActionListener(this);
		  bNext.addActionListener(this);
		  bPrevious.addActionListener(this);
		  bLast.addActionListener(this);
		  //add WindowListener to frame
		  this.addWindowListener(this);
		  
		  //disable editing on Text boxes
		  tsno.setEditable(false);
		  tsname.setEditable(false);
		  taddrs.setEditable(false);
		  tavg.setEditable(false);
		  
	  setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			   // the closing of  frame window will terminates Application . 
            initializeJDBC();
     System.out.println("GUIScrollFrameTest:: 0-param constructor(end)");           
	}
	
	private  void  initializeJDBC() {
		System.out.println("GUIScrollFrameTest.initializeJDBC()");
		try {
			//establis the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create PreparedStatement obj
			PreparedStatement ps=con.prepareStatement(GET_STUDENTS_QUERY,
					                                                                         ResultSet.TYPE_SCROLL_INSENSITIVE,
					                                                                         ResultSet.CONCUR_UPDATABLE);
			//prepare Scrollable RS obj
			rs=ps.executeQuery();
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//initializeJDBC
	
	
	public static void main(String[] args) {
		System.out.println("GUIScrollFrameTest.main() (Stat)");
		  new GUIScrollFrameTest();  //anonymous object
		  System.out.println("end of mind metod");
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("GUIScrollFrameTest.actionPerformed()");
		boolean flag=false;
		if(ae.getSource()==bFirst) {
			try {
			rs.first();
			flag=true;
			System.out.println("First button is clicked");
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		else if(ae.getSource()==bNext) {
			System.out.println("next button is clicked");

		try {
			 if(!rs.isLast()) {
				rs.next();
			 flag=true;
			 }
				
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
		}
		else if(ae.getSource()==bPrevious) {
			System.out.println("Previous button is clicked");
			try {
			if(!rs.isFirst()) {
				rs.previous();
				flag=true;
			  }
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		else {
			System.out.println("Last button is clicked");
			try {
				rs.last();
				flag=true;
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//else
		
		if(flag==true) {
			try {
			tsno.setText(rs.getString(1));
			tsname.setText(rs.getString(2));
			taddrs.setText(rs.getString(3));
			tavg.setText(rs.getString(4));
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//if
		
		
	}//acton peformed

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
	 System.out.println("GUIScrollFrameTest.windowClosing()");
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
		 if(con!=null) {
			 con.close();
			 System.out.println("GUIScrollFrameTest.windowClosing() :: JDBC con is closed");
		 }
	 }
	 catch(SQLException se) {
		 se.printStackTrace();
	 }
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}//class
