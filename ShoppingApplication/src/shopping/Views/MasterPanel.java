package shopping.Views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import shopping.Models.Cart;
import shopping.Models.Inventory;
import shopping.Models.Product;

public class MasterPanel extends JFrame{
	private JPanel contentPane;
	private JTable inventoryTable;
	private JScrollPane sp;
	private JButton addToCart;
	private JButton purchaseButton;
	private JButton checkoutButton;
	private JLabel inventoryLabel;
	private Inventory inventory;
	private Cart cart;
	private JButton logoutButton;
	
	public MasterPanel() {
		super("Shopping Application");
		
		this.inventory = new Inventory();
		this.cart = new Cart();
		
		this.inventory.addToList(new Product("Jordans", "Shoes", "Very cool basketball shoes.", 400, 6));
		this.inventory.addToList(new Product("Pilot Smooth-Flow", "Pen", "A very smooth writing ink pen. ", 200, 10));
		this.inventory.addToList(new Product("Google Pixel 4", "Electronics", "A Google product.", 800, 4));
		this.inventory.addToList(new Product("Regular-Fit Pants", "Clothing", "Grey colored regular fit pants.", 400, 2));
		
		this.setupBasicComponents();
		this.setupContentPane();
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
		this.contentPane.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
	}
	
	private void setupBasicComponents() {
		
		this.inventoryLabel = new JLabel("Inventory");
		this.inventoryLabel.setAlignmentX(2.0f);
		
//		Setting up inventory table....
		String[] columnHeaders = {"Name", "Category", "Description", "Price", "Quantity"};
		String[][] inventoryItems = null;
		inventoryItems = this.inventory.getProductListArray();
		this.inventoryTable = new JTable(inventoryItems, columnHeaders) {
			public boolean isCellEditable(int intentoryItems, int columnHeaders) {
				return false;
			}
		};
		this.inventoryTable.setFillsViewportHeight(true);
		this.inventoryTable.setPreferredScrollableViewportSize(new Dimension(500, 100));
		this.sp = new JScrollPane(this.inventoryTable);
		
		this.addToCart = new JButton("Add to Cart");
		this.purchaseButton = new JButton("Make Purchase");
		this.checkoutButton = new JButton("Proceed to Checkout");
		this.logoutButton = new JButton("Logout");
	}
	
	private void addBasicComponentsToContentPane() {
		this.contentPane.add(this.inventoryLabel);
		this.contentPane.add(sp);
		this.contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		this.contentPane.add(this.addToCart);
		this.contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		this.contentPane.add(this.checkoutButton);
		this.contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		this.contentPane.add(this.logoutButton);
	}
	
	private void addListeners() {
		this.addToCart.addActionListener((ActionEvent e) -> {
			System.out.println(this.inventoryTable.getSelectedRow());
			int index = this.inventoryTable.getSelectedRow();
			
			if(index >= 0)
				this.cart.addToList(this.inventory.getProductAtIndex(index));
		});
		
		this.checkoutButton.addActionListener((ActionEvent e) -> {
			this.proceedToCheckout();
		});
		
		this.logoutButton.addActionListener((ActionEvent e) -> {
			this.setVisible(false);
			AuthenticationPanel authWindow = new AuthenticationPanel();
			authWindow.setVisible(true);
		});
	}
	
	private void proceedToCheckout() {
		this.setVisible(false);
		CartPanel cartWindow = new CartPanel(this.cart);
		cartWindow.setVisible(true);
	}
}
