import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class DessertOrder extends JFrame
{
	JPanel contentPane;
	JFrame frmDessert;
    JPanel pnlTop, pnlLeft, pnlRight, pnlBottom;
    JLabel lblTitle, lblAmount, lblOrder, lblError;
    JTextField txtQuantity;
    JButton btnEnter, btnNext;
    JList lstList;
    JComboBox<String> cmbDessert;
    DefaultListModel dlmDessert;

    static String[] objDessert = {"Cookies & Cream Cupcake", "Chocolate Cupcake", "Vanilla Cupcake", "Extreme Cupcake", "Toppers Cupcake", "Honey Pecan Cupcake", "Toffee Nut Cupcake",
				  "Cheesecake Cake Bite", "Strawberry Cake Bite", "Bon Buns Cake Bite", "12 MN Cake Bite", "Berry Topped Cake Bite", "Chocolate Cake Bite",
				  "Chocolate Raisin Muffin", "Vanilla Milkshake Muffin", "Vanilla Choco Muffin", "Dark Chocolate Muffin", "Cheese with Nuts Muffin",
				  "Banoffee Tiramisu Cake", "Chocolate Fudge Cake", "Carrot Cheesecake", "Blueberry Buckle Cake", "Hazelnut Cheesecake",
				  "Red Velvet Cake", "Butter Pecan Cake", "Lime with Chocolate Cake", "Strawberry Applesauce Cake", "Angel Food Cake", "German Chocolate Cake",
                                  "Raspberry Duet Special", "Coconut Milk Special", "Grape Ice Special", " Grape NutSpecial", "Green Tea Special", "Peanut Butter Special",
                                  "Mocha Tea Special", "Strawberry Banana Special", "Banana Split Special", "Cookies and Cream Special","Blueberry Special"};

    static Float objPrices[] = {150f, 100f, 100f, 130f, 120f, 110f, 140f,
                                120f, 100f, 90f, 90f, 110f, 100f,
                                110f, 100f, 100f, 120f, 120f,
                                700f, 600f, 500f, 750f, 600f, 750f,
                                500f, 650f, 700f, 600f, 550f, 700f,
                                100f, 110f, 95f, 95f, 90f, 90f,
                                100f, 110f, 120f, 120f, 110f};


	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					DessertOrder frmDessertOrder = new DessertOrder();
					frmDessertOrder.setVisible(true);
				}

				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public DessertOrder()
	{
		//CONTENT PANE
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0xad7c6d));
		contentPane.setBorder(new LineBorder(new Color(0x623627), 3));
		contentPane.setLayout(null);

		//FRAMES
		setContentPane(contentPane);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);

		//CLOSE BUTTON
		JLabel lblCloseButton = new JLabel("x");
		lblCloseButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				DessertOrder.this.dispose();
			}
		});
		lblCloseButton.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseButton.setForeground(Color.WHITE);
		lblCloseButton.setBounds(467, 0, 33, 31);
		contentPane.add(lblCloseButton);

		//LOGO
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("D:\\My Folder\\School Documents\\PUP COLLEGE\\2ND YEAR\\Object Oriented Programming\\ModSim Project\\images\\Alternate Logo.png"));
		lblLogo.setBounds(107, 11, 260, 140);
		contentPane.add(lblLogo);

		//DESSERT HEADINGS
		JLabel lblHeadings = new JLabel(" ");
		lblHeadings.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadings.setIcon(new ImageIcon("D:\\My Folder\\School Documents\\PUP COLLEGE\\2ND YEAR\\Object Oriented Programming\\ModSim Project\\images\\Desserts.png"));
		lblHeadings.setBounds(34, 119, 430, 80);
		contentPane.add(lblHeadings);

		//---------------------------------------------------------------------------------------------------------------//

		//SELECT DESSERT
		JLabel lblSelectDessert = new JLabel("Select a Dessert");
		lblSelectDessert.setForeground(Color.WHITE);
		lblSelectDessert.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectDessert.setFont(new Font("Arial", Font.BOLD, 12));
		lblSelectDessert.setBounds(32, 197, 153, 31);
		contentPane.add(lblSelectDessert);

		//COMBOBOX DESSERT CHOICES
		DefaultComboBoxModel<String> cmbModel = new DefaultComboBoxModel<String>(objDessert);
		cmbDessert = new JComboBox<String> (cmbModel);
		cmbDessert.setForeground(Color.WHITE);
		cmbDessert.setToolTipText("");
		cmbDessert.setMaximumRowCount(12);
		cmbDessert.setBackground(new Color(0x8f6050));
		cmbDessert.setBounds(32, 224, 153, 38);
		contentPane.add(cmbDessert);

		//ENTER QUANTITY
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity.setFont(new Font("Arial", Font.BOLD, 12));
		lblQuantity.setBounds(67, 273, 59, 21);
		contentPane.add(lblQuantity);

		txtQuantity = new JTextField();
		txtQuantity.setBounds(30, 295, 152, 45);
		contentPane.add(txtQuantity);


		//LIST OF DESSERT ORDERS
		dlmDessert = new DefaultListModel();
		JList lstList = new JList(dlmDessert);
		lstList.setPreferredSize(new Dimension(250,147));
		lstList.setBackground(Color.WHITE);
		lstList.setBounds(214, 224, 250, 116);
		lstList.setVisible(true);
		contentPane.add(lstList);

		JLabel lblListofDesserts = new JLabel("List of Desserts");
		lblListofDesserts.setHorizontalAlignment(SwingConstants.CENTER);
		lblListofDesserts.setForeground(Color.WHITE);
		lblListofDesserts.setFont(new Font("Arial", Font.BOLD, 12));
		lblListofDesserts.setBounds(270, 197, 167, 31);
		contentPane.add(lblListofDesserts);

		//---------------------------------------------------------------------------------------------------------------//

		//ADD DESSERTS
		JPanel pnlAddPreMade = new JPanel();

		pnlAddPreMade.setLayout(null);
		pnlAddPreMade.setBackground(new Color(98, 54, 39));
		pnlAddPreMade.setBounds(30, 376, 153, 36);
		pnlAddPreMade.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(txtQuantity.getText().isEmpty())
				{
					JLabel lblError = new JLabel();
					lblError.setText("Please enter amount");
				}
            	else
				{
					int intIndex = cmbDessert.getSelectedIndex();
					int intAmount = Integer.parseInt(txtQuantity.getText());
					Float fltPrice = objPrices[intIndex];
					Float fltTotal = fltPrice * intAmount;
					JLabel lblError = new JLabel();
					lblError.setText("");

					dlmDessert.addElement(objDessert[intIndex] + " (" + intAmount + " orders) = PHP " + fltTotal + "0");

					MainProgram.objItem.add(objDessert[intIndex]);
					MainProgram.objQuantity.add(Integer.parseInt(txtQuantity.getText()));
					MainProgram.objPrice.add(objPrices[intIndex]);
					MainProgram.objTotal.add(fltTotal);
				}
			}
		});
		contentPane.add(pnlAddPreMade);

		JLabel lblAddPreMade = new JLabel("Add Dessert");
		lblAddPreMade.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddPreMade.setForeground(Color.WHITE);
		lblAddPreMade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddPreMade.setBounds(10, 11, 133, 14);
		pnlAddPreMade.add(lblAddPreMade);

		//---------------------------------------------------------------------------------------------------------------//
		//NEXT
		JPanel pnlNext = new JPanel();
		pnlNext.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				DessertOrder.this.dispose();
				Receipt frmReceipt = new Receipt();
				frmReceipt.setVisible(true);
	        }
		});

		pnlNext.setBounds(237, 376, 227, 36);
		pnlNext.setBackground(new Color(0x623627));
		contentPane.add(pnlNext);
		pnlNext.setLayout(null);

		JLabel lblNext = new JLabel("Next");
		lblNext.setBounds(20, 11, 185, 14);
		pnlNext.add(lblNext);
		lblNext.setForeground(Color.WHITE);
		lblNext.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);

		setLocationRelativeTo(null);
	}
}
