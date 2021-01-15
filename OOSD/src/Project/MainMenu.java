package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MainMenu extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JLabel welcomeLbl = new JLabel("Welcome");
	private final JButton ExitBtn = new JButton("Exit");
	private final JButton invoiceBtn = new JButton("Invoices");
	private final JButton productBtn = new JButton("Product");
	private final JButton CusBtn = new JButton("Customers");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1053, 573);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel.setBackground(new Color(0, 206, 209));
		panel.setBorder(null);
		panel.setBounds(0, 0, 286, 536);
		contentPane.add(panel);
		panel.setLayout(null);
		
		welcomeLbl.setForeground(new Color(255, 0, 0));
		welcomeLbl.setFont(new Font("Tahoma", Font.BOLD, 40));
		welcomeLbl.setBounds(48, 10, 193, 68);
		panel.add(welcomeLbl);
		
		ExitBtn.setForeground(new Color(255, 0, 0));
		ExitBtn.setBackground(new Color(255, 255, 255));
		ExitBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ExitBtn.setBounds(0, 491, 286, 45);
		ExitBtn.addActionListener(this);
		
		panel.add(ExitBtn);
		invoiceBtn.setBackground(new Color(255, 255, 255));
		invoiceBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		invoiceBtn.setBounds(0, 239, 286, 45);
		invoiceBtn.addActionListener(this);
		
		panel.add(invoiceBtn);
		productBtn.setBackground(new Color(255, 255, 255));
		productBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		productBtn.setBounds(0, 184, 286, 45);
		productBtn.addActionListener(this);
		
		panel.add(productBtn);
		CusBtn.setBackground(new Color(255, 255, 255));
		CusBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CusBtn.setBounds(0, 129, 286, 45);
		CusBtn.addActionListener(this);
		
		panel.add(CusBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==CusBtn) {
			//panel.dispose();
			AddCusGUI addcus =new AddCusGUI();
		}
		if(e.getSource()==productBtn) {
			Products p=new Products();
		}
		
		
		if(e.getSource()==ExitBtn) {
			System.exit(0);
		}
		
		
	}
	
}
