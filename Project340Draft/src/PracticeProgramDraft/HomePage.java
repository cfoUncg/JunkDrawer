package PracticeProgramDraft;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class HomePage extends JFrame {

	private JPanel Cards = new JPanel(new CardLayout());

	// HomePage UI Elements
	private final String HOMEPAGE = "HomePage";
	private JButton Exit = new JButton("Exit");
	private JButton Return = new JButton("Return to Login Menu");
	private JPanel homePanel = new JPanel();
	private JPanel managerPanel = new JPanel();
	private JButton Manager = new JButton("Manager's Section");
	private int xWidth = 200;
	private int yHeight = 60;
	private JButton Transaction = new JButton("New Transaction");

	// Manager Panel UI Elements
	private final String MANAGER = "ManagerPanel";
	private JPanel inventoryPanel = new JPanel();
	private JButton Inventory = new JButton("Inventory");
	private JButton Sales = new JButton("Sales");
	private JButton Users = new JButton("User Manager");
	private JButton backManager = new JButton("Back");
	private JButton transactions = new JButton("Transactions");

	// Inventory Panel UI Elements
	private final String INVENTORY = "Inventory";
	private JLabel Product1 = new JLabel("Slushy Magic: 0/0");
	private JLabel Product2 = new JLabel("Flipeez: 0/0");
	private JLabel Product3 = new JLabel("Sham-wow: 0/0");
	private JLabel Product4 = new JLabel("Toucan: 0/0");
	private JLabel Product5 = new JLabel("GyroBowl: 0/0");
	private JLabel Product6 = new JLabel("EZCracker: 0/0");
	private JLabel Product7 = new JLabel("WonderFILE: 0/0");
	private JLabel Product8 = new JLabel("SliceOMatic: 0/0");
	private JButton updateStock = new JButton("Update Stock");
	private JButton backInventory = new JButton("Back");
	private JPanel BottomInventoryPanel = new JPanel(new GridLayout(1,2));

	// Transaction Panel UI Elements
	private final String TRANSACTIONS = "Transaction";
	private JPanel productPanel = new JPanel();
	private JButton backTransactions = new JButton("Back");
	DefaultListModel transactionList = new DefaultListModel();
	private JList messageList = new JList(transactionList);

	// User Manager Panel UI Elements
	private final String USERMANAGER = "UserManager";
	private JPanel userManagerPanel = new JPanel();
	private JButton backUserManager = new JButton("Back");
	private JButton newUser = new JButton("New User");
	private JLabel userLabel = new JLabel("Users:");
	private JLabel userHours = new JLabel("Hours:");
	private JLabel userManager = new JLabel("Manager?:");
	private JLabel lastName = new JLabel("Last:");
	private JLabel firstName = new JLabel("First:");
	private JPanel topPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	
	// Sales Manager Panel UI Elements
	private final String SALESMANAGER = "SalesManager";
	private JPanel salesManagerPanel = new JPanel();
	private JButton backSalesManager = new JButton("Back");
	private JLabel sales = new JLabel("Sales:");
	private JPanel topSalePanel = new JPanel(new GridLayout(1,2));
	private JPanel bottomSalePanel = new JPanel(new GridLayout(1,2));
	private JPanel leftSalePanel = new JPanel(new GridLayout(26,1,5,5));
	private JPanel rightSalePanel = new JPanel(new GridLayout(8,1,5,5));

	public HomePage() {

		super("Home Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(70, 70, 800, 600);
		setVisible(true);

		// Panel Layout Manager:
		homePanel.setLayout(null);
		managerPanel.setLayout(null);
		inventoryPanel.setLayout(new GridLayout(15, 2));
		productPanel.setLayout(new BorderLayout());
		userManagerPanel.setLayout(new BorderLayout());

		// Cards.add(Panel2, TRANSACTION);
		Cards.add(homePanel, HOMEPAGE);
		Cards.add(managerPanel, MANAGER);
		Cards.add(inventoryPanel, INVENTORY);
		Cards.add(productPanel, TRANSACTIONS);
		Cards.add(userManagerPanel, USERMANAGER);
		Cards.add(salesManagerPanel, SALESMANAGER);
		add(Cards);

		// Set Bounds and Location of elements
		Manager.setBounds(300, 150, xWidth, yHeight);
		Transaction.setBounds(300, Manager.getY() + yHeight + 5, xWidth, yHeight);
		Return.setBounds(300, Transaction.getY() + yHeight + 5, xWidth, yHeight);
		Exit.setBounds(300, Return.getY() + yHeight + 5, xWidth, yHeight);

		// Add items to panel
		homePanel.add(Manager);
		homePanel.add(Transaction);
		homePanel.add(Exit);
		homePanel.add(Return);

		// Format items for Panel2
		Inventory.setBounds(5, 5, xWidth, yHeight);
		Sales.setBounds(5, Inventory.getY() + yHeight + 5, xWidth, yHeight);
		Users.setBounds(5, Sales.getY() + yHeight + 5, xWidth, yHeight);
		backManager.setBounds(5, Users.getY() + yHeight + 5, xWidth, yHeight);

		// Add items to Panel2
		managerPanel.add(Inventory);
		managerPanel.add(Sales);
		managerPanel.add(Users);
		managerPanel.add(backManager);

		// Panel3 Inventory Add items
		inventoryPanel.add(Product1);
		inventoryPanel.add(Product2);
		inventoryPanel.add(Product3);
		inventoryPanel.add(Product4);
		inventoryPanel.add(Product5);
		inventoryPanel.add(Product6);
		inventoryPanel.add(Product7);
		inventoryPanel.add(Product8);
		for (int i = 0; i < 6; i++) {
			inventoryPanel.add(new JLabel());
		}
		
		inventoryPanel.add(BottomInventoryPanel);
		BottomInventoryPanel.add(backInventory);
		BottomInventoryPanel.add(updateStock);
		

		// Add items to the Transaction Panel
		productPanel.add(messageList, BorderLayout.CENTER);
		productPanel.add(backTransactions, BorderLayout.SOUTH);

		// Add Items to the UserMangePanel
		userManagerPanel.add(topPanel, BorderLayout.NORTH);
		userManagerPanel.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new GridLayout(1,2));
		topPanel.setLayout(new GridLayout(1, 5));
		topPanel.add(userLabel);
		topPanel.add(firstName);
		topPanel.add(lastName);
		topPanel.add(userHours);
		topPanel.add(userManager);
		bottomPanel.add(backUserManager);
		bottomPanel.add(newUser);
		
		
		// Add Items to the SalesManagerPanael
		salesManagerPanel.setLayout(new BorderLayout());
		salesManagerPanel.add(topSalePanel, BorderLayout.NORTH);
		salesManagerPanel.add(bottomSalePanel, BorderLayout.SOUTH);
		bottomSalePanel.add(backSalesManager);
		leftSalePanel.add(sales);
		for(int i = 0; i <25; i++){
			leftSalePanel.add(new JLabel("Product " + Integer.toString(i + 1) + ":")); 
		}
		topSalePanel.add(leftSalePanel);
		topSalePanel.add(rightSalePanel);
		rightSalePanel.add(new JLabel("Transactions Completed:"));
		rightSalePanel.add(new JLabel("Gross Revenue:"));
		rightSalePanel.add(new JLabel("Revenue dedicated to Employees:"));
		rightSalePanel.add(new JLabel("Revenue dedicated to Property Costs:"));
		rightSalePanel.add(new JLabel("Revenue dedicated to taxes:"));
		rightSalePanel.add(new JLabel("Net Revenue:"));
		rightSalePanel.add(new JLabel("Revenue in Account:"));

		// Button Functionality
		Sales.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout c1 = (CardLayout) Cards.getLayout();
				c1.show(Cards, SALESMANAGER);
			}
		});
		backSalesManager.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout c1 = (CardLayout) Cards.getLayout();
				c1.show(Cards, MANAGER);
			}
		});
		Users.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) (Cards.getLayout());
				c1.show(Cards, USERMANAGER);
			}
		});
		backUserManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) (Cards.getLayout());
				c1.show(Cards, MANAGER);
			}
		});
		backManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) (Cards.getLayout());
				c1.show(Cards, HOMEPAGE);
			}
		});
		Manager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) (Cards.getLayout());
				c1.show(Cards, MANAGER);
			}
		});
		Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginPage();
			}
		});
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Inventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) (Cards.getLayout());
				c1.show(Cards, INVENTORY);
			}
		});
		backInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) (Cards.getLayout());
				c1.show(Cards, MANAGER);
			}
		});
		Transaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// CardLayout c1 = (CardLayout) (Cards.getLayout());
				// c1.show(Cards, TRANSACTIONS);
				new SalesPage();
			}
		});
		backTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c1 = (CardLayout) (Cards.getLayout());
				c1.show(Cards, HOMEPAGE);
			}
		});

	}
}
