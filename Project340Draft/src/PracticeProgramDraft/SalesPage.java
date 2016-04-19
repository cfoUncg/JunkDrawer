package PracticeProgramDraft;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class SalesPage extends JFrame {

	private final String TRANSACTIONS = "Transaction";
        private JPanel productPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	private JButton backTransactions = new JButton("Back");
	DefaultListModel<String> transactionList = new DefaultListModel<String>();
	private JList<String> messageList = new JList<String>(transactionList);
	private JScrollPane scrollPane = new JScrollPane();
	private JButton finalize = new JButton("Finalize Order");
	private JButton checkout = new JButton("Check Out");
	//generates 25 product buttons
        private JButton[] productButton = createJButtonArray(25); // <<<changed*
        //button = new JButton(new ImageIcon(buttonIcon));
        //productButton[0] = new JButton(new ImageIcon(buttonIcon));
        private JPanel leftPanel = new JPanel();
	private JLabel transaction = new JLabel("Transaction");
	private JPanel rightButtons = new JPanel();
        public SalesPage() {
		final Transaction TransactionIP = new Transaction();
		final Item PJ = new Item("WonderFILE", 10, 10, 10, null, 0);
		
		// Parameters of Class Set
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(0, 32, 1366, 720);
		setVisible(true);
		setLayout(new GridLayout(1, 2, 5, 5));

		// SetParameters of Panels Used
		productPanel.setLayout(new GridLayout(5, 5, 5, 5));
		rightPanel.setLayout(new BorderLayout());
		leftPanel.setLayout(new BorderLayout());

		Color steelBlue = new Color(112, 128, 144);
		messageList.setBackground(steelBlue);

		// Add Panels to Frame
		add(leftPanel);
		add(rightPanel);

		// Add Secondary Panels to Primary Panels
		leftPanel.add(productPanel, BorderLayout.CENTER);
                /* the following for loop REPLACES the temporary JButtons with JButtons that display an image.
                 * Do not make any changes to the JButtons before this loop runs (such as giving it an action listener)
                 * or they will make no difference.
                 * 3 lines marked below have been added to remove the error message when unable to find pictures for products 2-25.
                 * in order to allow this loop to change JButtons 2-25 remove or comment out the three lines.
                 * in order to add a picture to a button insert a photo named product with the number of the product following
                 * into the folder marked "Pictures", for example, product 24's image will be named "product24.png".
                 * The dimensions of all pictures are roughly 125 pixels wide and high.
                 */
                for(int i = 0; i<productButton.length; i++)
                {
                    //if (i == 0) //REMOVE ME WHEN TESTING FOR MORE THAN 1 PICTURE
                    //{ //REMOVE ME WHEN TESTING FOR MORE THAN 1 PICTURE
                    // IF RUNNING ON SOMEONE ELSES COMPUTER BESIDES CANDICE PLEASE EDIT THE PATH BELOW
                    String fileName = "C:\\Users\\candice\\Documents\\NetBeansProjects\\Project340Draft\\Pictures\\product" + (i+1) + ".png";
                    try
                    {
                        BufferedImage buttonIcon = ImageIO.read(new File(fileName));
                        productButton[i] = new JButton(new ImageIcon(buttonIcon));
                        productButton[i].setBorder(BorderFactory.createEmptyBorder());
                        productButton[i].setContentAreaFilled(false);
                    }
                    catch(IOException e)
                    {
                        JOptionPane.showMessageDialog(null,"Could not find file: " + fileName,"FILE UNFOUND",JOptionPane.WARNING_MESSAGE);
                    }
                    //}//REMOVE ME WHEN TESTING FOR MORE THAN 1 PICTURE
                }
                
                
                // Add Components to productPanel
                for(int i = 0; i < productButton.length; i++)
                {
                    productPanel.add(productButton[i]);
                }
		// Add Components to transaction Panel
		rightPanel.add(rightButtons, BorderLayout.SOUTH);
		rightPanel.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(messageList);
		rightPanel.add(transaction, BorderLayout.NORTH);
		rightButtons.setLayout(new GridLayout(1,2,5,5));
		rightButtons.add(finalize);
		rightButtons.add(checkout);

		// Set alignment of label
		transaction.setText(transaction.getText() + " ID: " + TransactionIP.getTransactionID());
		transaction.setHorizontalAlignment(SwingConstants.CENTER);

		// Add Components to the Buttons Panel
		leftPanel.add(backTransactions, BorderLayout.SOUTH);

		checkout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//saves the transaction to the completed transactions file.
			}
		});
		productButton[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransactionIP.addItem(PJ);
				transactionList.addElement(PJ.toString());
				//transactionList.addElement("Subtotal: " + TransactionIP.viewSubTotal());
				//transactionList.addElement("Tax: " + TransactionIP.viewTax());
				//transactionList.addElement("Total: " + TransactionIP.viewTotal());
			}
		});
		finalize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				transactionList.addElement("Subtotal: " + TransactionIP.viewSubTotal());
				transactionList.addElement("Tax: " + TransactionIP.viewTax());
				transactionList.addElement("Total: " + TransactionIP.viewTotal());
				for(int i = 0; i < productButton.length; i++)
                                {
                                   productButton[i].setEnabled(false); 
                                }
                                /*Product1.setEnabled(false);
				Product2.setEnabled(false);
				Product3.setEnabled(false);
				Product4.setEnabled(false);
				Product5.setEnabled(false);
				Product6.setEnabled(false);
				Product7.setEnabled(false);
				Product8.setEnabled(false);*/
			}
		});
		backTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
    /*public JButton createImageButton(String fileName) throws IOException
    {
        try
        {
            BufferedImage imageFile = ImageIO.read(new File(fileName)); 
            JButton temp = new JButton(fileName);
            return temp;
        }
        catch(IOException exception)
        {
            System.out.println (exception.toString());
            System.out.println("Could not find file " + fileName);
        }
    }*/
    
    public JButton[] createJButtonArray(int size)
    {
        JButton[] array = new JButton[size];
        for(int i = 0; i < array.length; i++)
        {
            String temp = "TempButton" + (i+1) +"";
            array[i] = new JButton(temp);
        }
        return array;
    }
}

    
