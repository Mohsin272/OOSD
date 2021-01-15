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
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Products extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JLabel welcomeLbl = new JLabel("Products");
	private final JButton ExitBtn = new JButton("Back");
	private final JPanel panel_1 = new JPanel();
	private final JLabel ProductLbl = new JLabel("Product");
	private final JLabel ProductNameLbl = new JLabel("Product Name");
	private final JPanel panel_2 = new JPanel();
	private JTextField ProductNameTF;
	private JTextField quantityTF;
	private JTextField PriceTF;
	private final JButton clearBtn = new JButton("Clear");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Products frame = new Products();
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
	public Products() {
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
		welcomeLbl.setBounds(45, 10, 193, 68);
		panel.add(welcomeLbl);
		
		ExitBtn.setForeground(new Color(255, 0, 0));
		ExitBtn.setBackground(new Color(255, 255, 255));
		ExitBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ExitBtn.setBounds(0, 491, 286, 45);
		ExitBtn.addActionListener(this);
		
		panel.add(ExitBtn);
		panel_1.setBounds(0, 111, 286, 45);
		
		panel.add(panel_1);
		panel_1.setLayout(null);
		ProductLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ProductLbl.setBounds(10, 10, 99, 25);
		panel_1.add(ProductLbl);
		panel_2.setBounds(296, 10, 733, 516);
		
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		ProductNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ProductNameLbl.setBounds(10, 62, 95, 13);
		panel_2.add(ProductNameLbl);
		
		ProductNameTF = new JTextField();
		ProductNameTF.setBounds(139, 61, 146, 19);
		panel_2.add(ProductNameTF);
		ProductNameTF.setColumns(10);
		
		JLabel quantityLbl = new JLabel("Product Quantity");
		quantityLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		quantityLbl.setBounds(10, 103, 129, 19);
		panel_2.add(quantityLbl);
		
		quantityTF = new JTextField();
		quantityTF.setBounds(139, 105, 146, 19);
		panel_2.add(quantityTF);
		quantityTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Price");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 147, 106, 19);
		panel_2.add(lblNewLabel);
		
		PriceTF = new JTextField();
		PriceTF.setBounds(139, 149, 146, 19);
		panel_2.add(PriceTF);
		PriceTF.setColumns(10);
		
		JButton addBtn = new JButton("Add");
		addBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addBtn.addActionListener(this);
		addBtn.setBounds(20, 485, 85, 21);
		panel_2.add(addBtn);
		
		
		JButton updateBtn = new JButton("Update");
		updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		updateBtn.setBounds(117, 485, 85, 21);
		panel_2.add(updateBtn);
		updateBtn.addActionListener(this);
		
		JButton delBtn = new JButton("Delete");
		delBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delBtn.setBounds(222, 485, 85, 21);
		panel_2.add(delBtn);
		delBtn.addActionListener(this);
		clearBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		clearBtn.setBounds(328, 487, 85, 21);
		clearBtn.addActionListener(this);
		
		panel_2.add(clearBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==clearBtn) {
			ProductNameTF.setText("");
			quantityTF.setText("");
			PriceTF.setText("");

			
		}
		
		
		
		if(e.getSource()==ExitBtn) {
			MainMenu menu=new MainMenu();
			//System.exit(0);
		}
		
		
	}
}
