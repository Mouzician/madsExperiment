package mob;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Receipt;
import model.Store;
import model.Watch;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.Dialog;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JFrame {

	private JPanel contentPane;
	Store store;
	private JTextField email;
	private JTextField name;
	private JTextField address;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		store = new Store();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		DefaultListModel listModel = new DefaultListModel<>();
		for (String brand : store.getBrands()) {
			listModel.addElement(brand);
		}

		final JList list = new JList(listModel);
		final JList listModels = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				DefaultListModel listWatchs = new DefaultListModel<>();
				for (Watch watch : store.getWatchs()) {
					if (watch.getBrand().equals(store.getBrands().get(list.getSelectedIndex()))) {
						listWatchs.addElement(watch.getModel() + " " + watch.getPrice() + "€");
					}
				}
				listModels.setModel(listWatchs);
			}
		});
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		contentPane.add(list);
		contentPane.add(listModels);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		final Choice choice = new Choice();
		choice.add("EUR");
		choice.add("GBP");
		choice.add("USD");
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.add(choice);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblEmail = new JLabel("Email");
		panel_2.add(lblEmail);
		
		email = new JTextField();
		panel_2.add(email);
		email.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblName = new JLabel("Name");
		panel_3.add(lblName);
		
		name = new JTextField();
		name.setColumns(10);
		panel_3.add(name);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblAddress = new JLabel("Address");
		panel_4.add(lblAddress);
		
		address = new JTextField();
		address.setColumns(10);
		panel_4.add(address);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int brandID = list.getSelectedIndex();
				int modelID = listModels.getSelectedIndex();
				String cliName = name.getText();
				String cliEmail = email.getText();
				String cliAddress = address.getText();
								
				if(brandID==-1){
					JOptionPane.showMessageDialog(GUI.this, "Select brand, please!", "Error",
						    JOptionPane.ERROR_MESSAGE);
				}else if(modelID==-1){
					JOptionPane.showMessageDialog(GUI.this, "Select model, please!", "Error",
						    JOptionPane.ERROR_MESSAGE);
				}else if(cliName.isEmpty()){
					JOptionPane.showMessageDialog(GUI.this, "Insert name, please!", "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				else if(cliAddress.isEmpty()){
					JOptionPane.showMessageDialog(GUI.this, "Insert address, please!", "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				else if(cliEmail.isEmpty()){
					JOptionPane.showMessageDialog(GUI.this, "Insert email, please!", "Error",
						    JOptionPane.ERROR_MESSAGE);
				}else{
					int acc=0;
					for(Watch watch : store.getWatchs()){
						if(watch.getBrand().equals(store.getBrands().get(brandID))){
							break;
						}else{
							acc++;
						}
					}
					JOptionPane.showMessageDialog(GUI.this, "You bought one watch from "+store.getBrands().get(brandID)
							+"-"+store.getWatchs().get(modelID+acc).getModel()+" for "+
							Extensos.numExt((int)Receipt.convertPrice(store.getWatchs().get(modelID+acc).getPrice(), choice.getSelectedItem()))
							+" "+choice.getSelectedItem());
				}
				
			}
		});
		panel_1.add(btnBuy);
	}
}
