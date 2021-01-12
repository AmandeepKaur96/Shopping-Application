package shopping.Views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import shopping.Models.Cart;

public class CartPanel extends JFrame {
	private JPanel contentPane;
	private JLabel cartLabel;
	private JTable cartTable;
	private Cart cart;
	private JScrollPane sp;
	private JButton emptyCartButton;
	private JButton makePurchaseButton;
	private JLabel totalLabel;
	
	public CartPanel(Cart cart) {
		super("Cart View");
		
		this.cart = cart;
		
		this.setupContentPane();
		this.setupBasicComponents();
		this.addBasicComponentsToContentPane();
		this.addListeners();
		
		this.setMinimumSize(new Dimension(225, this.getMinimumSize().height));
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	private void setupContentPane() {
		this.contentPane = (JPanel) getContentPane();
		this.contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		this.contentPane.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
	}
	
	private void setupBasicComponents() {
		this.cartLabel = new JLabel("Cart");
		this.cartLabel.setAlignmentX(1.0f);
		
//		Setting up cart table....
		String[] columnHeaders = {"Name", "Category", "Description", "Price", "Quantity"};
		String[][] cartItems = null;
		cartItems = this.cart.getProductListArray();
		this.cartTable = new JTable(cartItems, columnHeaders) {
			public boolean isCellEditable(int cartItems, int columnHeaders) {
				return false;
			}
		};
		this.cartTable.setFillsViewportHeight(true);
		this.cartTable.setPreferredScrollableViewportSize(new Dimension(500, 100));
		this.sp = new JScrollPane(this.cartTable);
		
		
		this.emptyCartButton = new JButton("Empty Cart");
		this.makePurchaseButton = new JButton("Make Purchase");
		this.totalLabel = new JLabel("Total => " + this.cart.getTotalPrice().toString() + "$");
		
	}
	
	private void addBasicComponentsToContentPane() {
		this.contentPane.add(this.cartLabel);
		this.contentPane.add(sp);
		this.contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		this.contentPane.add(this.totalLabel);
		this.contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		this.contentPane.add(this.emptyCartButton);
		this.contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		this.contentPane.add(this.makePurchaseButton);
	}
	
	private void addListeners() {
		this.emptyCartButton.addActionListener((ActionEvent e) -> {
			this.cart.emptyCart();
			this.setVisible(false);
			MasterPanel mainWindow = new MasterPanel();
			mainWindow.setVisible(true);
		});
		
		this.makePurchaseButton.addActionListener((ActionEvent e) -> {
			JOptionPane.showMessageDialog(this, "Purchase Successful", "Alert", JOptionPane.WARNING_MESSAGE);
			this.setVisible(false);
			MasterPanel mainWindow = new MasterPanel();
			mainWindow.setVisible(true);
		});
	}
	
}
