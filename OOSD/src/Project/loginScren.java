package Project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginScren implements ActionListener {
	
	 public static void main(String[] args) {  
         EventQueue.invokeLater(new Runnable() {  
              public void run() {  
                   try {  
                	   loginScren window = new loginScren(logininfo);  
                        window.frame.setVisible(true);  
                   } catch (Exception e) {  
                        e.printStackTrace();  
                   }  
              }  
         });  
    } 
	
	
	JFrame frame=new JFrame();
	JButton loginBtn=new JButton("Log In");
	JButton clearBtn=new JButton("Reset");
	JTextField userIDTF =new JTextField ();
	JPasswordField passwordTF =new JPasswordField ();
	JLabel userIDLbl=new JLabel("User Name");
	JLabel userPasswordLbl=new JLabel("Passsword");
	JLabel messageLbl=new JLabel();

 static HashMap<String,String> logininfo=new HashMap<String,String>();
	
	loginScren(HashMap<String,String> loginInfooriginal){
		
		logininfo=loginInfooriginal;
		
		userIDLbl.setBounds(50,100,75,25);
		userPasswordLbl.setBounds(50,150,75,25);
		
		messageLbl.setBounds(125,250,250,35);
		messageLbl.setFont(new Font(null,Font.ITALIC,25));
		
		userIDTF.setBounds(125,100,200,25);
		passwordTF.setBounds(125,150,200,25);
		
		loginBtn.setBounds(125,200,100,25);
		loginBtn.setFocusable(false);
		loginBtn.addActionListener(this);
		
		clearBtn.setBounds(225,200,100,25);
		clearBtn.setFocusable(false);
		clearBtn.addActionListener(this);
		
		frame.add(loginBtn);
		frame.add(clearBtn);
		frame.add(userIDTF);
		frame.add(passwordTF);
		frame.add(messageLbl);
		frame.add(userIDLbl);
		frame.add(userPasswordLbl);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==clearBtn) {
			userIDTF.setText("");
			passwordTF.setText("");
			
		}
		
		if(e.getSource()==loginBtn) {
			String userID=userIDTF.getText();
			String password=String.valueOf(passwordTF.getPassword());
			
			if(logininfo.containsKey(userID)) {
				
				if(logininfo.get(userID).equals(password)) {
					messageLbl.setForeground(Color.GREEN);
					messageLbl.setText("Login Succesful");
					
					frame.dispose();
					
					Menu menu=new Menu();
					
					
				}
			}
			
		}
		
		
		
		
	}
	
}
