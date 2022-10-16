import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class CupChoice extends JFrame
{

	JPanel contentPane;
	DefaultListModel dlmList;
	JTextField txtQuantity;
	JComboBox<String> cmbOptions;

	String[] objOptions = {	"Espresso Cup", "Espresso Doppio Cup", "Cafe Creme Cup", "Latte Macchiato Cup",
							"Cafe Au Laitza Cup", "Irish Coffee", "Cocktail Mug", "Mug",
							"Maxi Mug", "Sublimation Mug", "Coffee Mug", "Coffee Latte Mug" };

	static int intIndexCup = 0, intCupNumber = 1;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					CupChoice frmCupChoice = new CupChoice();
					frmCupChoice.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}


	public CupChoice()
	{
	//---------------------------------------------------------------------------------------------------------------//
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
		setLocationRelativeTo(null);

		//CLOSE BUTTON
		JLabel lblCloseButton = new JLabel("x");
		lblCloseButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				CupChoice.this.dispose();
			}
		});
		lblCloseButton.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseButton.setForeground(Color.WHITE);
		lblCloseButton.setBounds(467, 0, 33, 31);
		contentPane.add(lblCloseButton);

		//BACK BUTTON
		JPanel pnlBack = new JPanel();
		pnlBack.setBorder(new LineBorder(Color.WHITE));
		pnlBack.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				CupChoice.this.dispose();
				MainMenu frmMainMenu = new MainMenu();
				frmMainMenu.setVisible(true);
			}
		});
		pnlBack.setLayout(null);
		pnlBack.setBackground(new Color(98, 54, 39));
		pnlBack.setBounds(151, 445, 186, 25);
		contentPane.add(pnlBack);

		JLabel lblBack = new JLabel("BACK TO MAIN MENU");
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 13));
		lblBack.setBounds(10, 0, 166, 31);
		pnlBack.add(lblBack);
		//LOGO
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("D:\\My Folder\\School Documents\\PUP COLLEGE\\2ND YEAR\\Object Oriented Programming\\ModSim Project\\images\\Alternate Logo.png"));
		lblLogo.setBounds(107, 11, 260, 140);
		contentPane.add(lblLogo);

		//CUP CHOICE HEADINGS
		JLabel lblHeadings = new JLabel(" ");
		lblHeadings.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadings.setIcon(new ImageIcon("D:\\My Folder\\School Documents\\PUP COLLEGE\\2ND YEAR\\Object Oriented Programming\\ModSim Project\\images\\Cup Choice.png"));
		lblHeadings.setBounds(34, 119, 430, 80);
		contentPane.add(lblHeadings);

	//---------------------------------------------------------------------------------------------------------------//

		//SELECT CUP CHOICE
		JLabel lblSelectCup = new JLabel("Select your Choice of Cup");
		lblSelectCup.setForeground(Color.WHITE);
		lblSelectCup.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectCup.setFont(new Font("Arial", Font.BOLD, 12));
		lblSelectCup.setBounds(44, 197, 216, 31);
		contentPane.add(lblSelectCup);

		//COMBOBOX CUP CHOICES
		DefaultComboBoxModel<String> cmbModel = new DefaultComboBoxModel<String>(objOptions);
		cmbOptions = new JComboBox<String> (cmbModel);
		cmbOptions.setForeground(Color.WHITE);
		cmbOptions.setToolTipText("");
		cmbOptions.setMaximumRowCount(12);
		cmbOptions.setBackground(new Color(0x8f6050));
		cmbOptions.setBounds(32, 224, 241, 38);
		contentPane.add(cmbOptions);

	//---------------------------------------------------------------------------------------------------------------//

		//ENTER QUANTITY
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity.setFont(new Font("Arial", Font.BOLD, 12));
		lblQuantity.setBounds(117, 273, 59, 21);
		contentPane.add(lblQuantity);

		txtQuantity = new JTextField();
		txtQuantity.setBounds(30, 295, 241, 45);
		contentPane.add(txtQuantity);

	//---------------------------------------------------------------------------------------------------------------//

		//LIST OF CUP ORDERS
		dlmList = new DefaultListModel();
		JList lstList = new JList(dlmList);
		lstList.setPreferredSize(new Dimension(250,147));
		lstList.setBackground(Color.WHITE);
		lstList.setBounds(289, 224, 175, 116);
		lstList.setVisible(true);
		contentPane.add(lstList);

		JLabel lblListOfCup = new JLabel("List of Cup Orders");
		lblListOfCup.setHorizontalAlignment(SwingConstants.CENTER);
		lblListOfCup.setForeground(Color.WHITE);
		lblListOfCup.setFont(new Font("Arial", Font.BOLD, 12));
		lblListOfCup.setBounds(297, 197, 167, 31);
		contentPane.add(lblListOfCup);

	//---------------------------------------------------------------------------------------------------------------//

		//ADD CUPS
		JPanel pnlAddCups = new JPanel();

		pnlAddCups.setLayout(null);
		pnlAddCups.setBackground(new Color(0x7d4b3b));
		pnlAddCups.setBorder(new LineBorder(new Color(98, 54, 39)));
		pnlAddCups.setBounds(44, 386, 196, 44);
		pnlAddCups.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				  int intIndex = cmbOptions.getSelectedIndex();
				  String strQuantity = txtQuantity.getText().toString();
				  int intQuantity = Integer.parseInt(strQuantity);

				  int intTempQty = intQuantity;

		          if(intTempQty > 1);
		          {
		        	  while(intTempQty != 0)
		        	  {
		        		  MainProgram.objCups.add(objOptions[intIndex]);
		        		  intTempQty--;
		        	  }
		          }

		          if(intTempQty == 1)
		          {
		        	  MainProgram.objCups.add(objOptions[intIndex]);
		          }

				  dlmList.addElement(objOptions[intIndex] + " (" + strQuantity + " orders)");

		          MainProgram.objIngrQuantity.add(intQuantity);
			}
		});
		contentPane.add(pnlAddCups);

		JLabel lblAddCups = new JLabel("Add Cup");
		lblAddCups.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddCups.setForeground(Color.WHITE);
		lblAddCups.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblAddCups.setBounds(21, 11, 152, 22);
		pnlAddCups.add(lblAddCups);

	//---------------------------------------------------------------------------------------------------------------//

		//MIX INGREDIENTS
		JPanel pnlMixIngredients = new JPanel();
		pnlMixIngredients.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				CupChoice.this.dispose();
				Ingredients frmIngredients = new Ingredients();
				frmIngredients.setVisible(true);
                        }
		});

		pnlMixIngredients.setBounds(258, 386, 196, 44);
		pnlMixIngredients.setBackground(new Color(0x7d4b3b));
		pnlMixIngredients.setBorder(new LineBorder(new Color(98, 54, 39)));
		contentPane.add(pnlMixIngredients);
		pnlMixIngredients.setLayout(null);

		JLabel lblMixIngredients = new JLabel("Mix Ingredients");
		lblMixIngredients.setBounds(0, 11, 196, 22);
		pnlMixIngredients.add(lblMixIngredients);
		lblMixIngredients.setForeground(Color.WHITE);
		lblMixIngredients.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblMixIngredients.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
