import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Ingredients extends JFrame
{
	JPanel contentPane;
	JList lstIngredients;
	static int intPercent;
	String strValues, strTableItem;
	Float fltValues;
	static JTable tblIngredients;
	DefaultListModel<String> dlmMix;
	int intColumn, intRow;
	public static ArrayList<Integer> objCount = new ArrayList<Integer>();

	public static int intCount;

	String[] tblColumns = {"Percentage","1-25%", "26-50%", "51-75%", "76-100%"};
	String[][] tblRows = { 	{"Espresso", "30", "35", "40","45"},
							{"Milk", "10", "15", "20", "25"},
							{"Water", "2", "4", "6", "8"},
							{"Milk Foam", "15", "20", "25", "30"},
							{"Liquor", "20", "25", "30", "35"},
							{"Lemon", "10", "15", "20", "25"},
							{"Whipped Cream", "15", "20", "25", "30"},
							{"Steamed Milk", "15", "20", "30", "35"},
							{"Chocolate", "10", "20", "30", "40"},
							{"Vanilla Sugar", "5", "10", "15", "20"},
							{"Honey", "10", "15", "20", "25"},
							{"Milk", "10", "15", "20", "25"},
							{"Whisky", "20", "25", "30", "35"},
							{"Ice Cream", "20", "30", "40", "50"},
							{"Cream", "15", "20", "25", "30"},
							{"Ice", "2", "4", "6", "8"},
							{"Caramel Cream", "15", "25", "30", "35"}};


	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Ingredients frmIngredients = new Ingredients();
					frmIngredients.setVisible(true);
				}

				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Ingredients()
	{
	//---------------------------------------------------------------------------------------------------------------//

		//CONTENT PANE
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0xad7c6d));
		contentPane.setBorder(new LineBorder(new Color(0x623627), 3));

		//FRAMES
		setContentPane(contentPane);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		setLocationRelativeTo(null);

		//CLOSE BUTTON
		JLabel lblCloseButton = new JLabel("x");
		lblCloseButton.setBounds(467, 0, 33, 31);
		lblCloseButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				Ingredients.this.dispose();
			}
		});
		contentPane.setLayout(null);

		lblCloseButton.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseButton.setForeground(Color.WHITE);
		contentPane.add(lblCloseButton);

		//BACK BUTTON
		JPanel pnlBack = new JPanel();
		pnlBack.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				Ingredients.this.dispose();
				CupChoice frmCupChoice = new CupChoice();
				frmCupChoice.setVisible(true);
			}
		});
		pnlBack.setLayout(null);
		pnlBack.setBackground(new Color(98, 54, 39));
		pnlBack.setBounds(10, 463, 42, 24);
		contentPane.add(pnlBack);

		JLabel lblBack = new JLabel("<< ");
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("Baskerville Old Face", Font.PLAIN, 11));
		lblBack.setBounds(0, 0, 41, 24);
		pnlBack.add(lblBack);

		//NEXT BUTTON
		JPanel pnlNext = new JPanel();
		pnlNext.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				objCount.add(intCount);
				Ingredients.this.dispose();
				Receipt frmReceipt = new Receipt();
				frmReceipt.setVisible(true);
			}
		});
		pnlNext.setLayout(null);
		pnlNext.setBackground(new Color(98, 54, 39));
		pnlNext.setBounds(448, 463, 42, 24);
		contentPane.add(pnlNext);

		JLabel lblNext = new JLabel(">>");
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNext.setForeground(Color.WHITE);
		lblNext.setFont(new Font("Baskerville Old Face", Font.PLAIN, 11));
		lblNext.setBounds(-13, 0, 66, 24);
		pnlNext.add(lblNext);

		//LOGO
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("D:\\My Folder\\School Documents\\PUP COLLEGE\\2ND YEAR\\Object Oriented Programming\\ModSim Project\\images\\Alternate Logo.png"));
		lblLogo.setBounds(107, 0, 260, 140);
		contentPane.add(lblLogo);

		//HEADINGS
		JLabel lblHeadings = new JLabel(" ");
		lblHeadings.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeadings.setIcon(new ImageIcon("D:\\My Folder\\School Documents\\PUP COLLEGE\\2ND YEAR\\Object Oriented Programming\\ModSim Project\\images\\Ingredients.png"));
		lblHeadings.setBounds(38, 94, 430, 55);
		contentPane.add(lblHeadings);

	//---------------------------------------------------------------------------------------------------------------//
		//SCROLLPANE
		JScrollPane scpIngredients = new JScrollPane();
		scpIngredients.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scpIngredients.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scpIngredients.setBounds(23, 160, 237, 272);
		contentPane.add(scpIngredients);

		//TITLE
		JPanel pnlTitle = new JPanel();
		pnlTitle.setBounds(23, 139, 237, 31);
		pnlTitle.setBackground(new Color(0x7d4b3b));
		contentPane.add(pnlTitle);
		pnlTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblTitle = new JLabel("     INGREDIENTS    25%    50%   75%  100%  ");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		pnlTitle.add(lblTitle);

		//TABLE

		tblIngredients = new JTable(tblRows, tblColumns);
		tblIngredients.getColumnModel().getColumn(0).setPreferredWidth(152);
		tblIngredients.setForeground(Color.WHITE);
		tblIngredients.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		tblIngredients.setBackground(new Color(0x8f6050));
		tblIngredients.setGridColor(Color.WHITE);
		tblIngredients.setTableHeader(null);

		//SELECT
		tblIngredients.setCellSelectionEnabled(true);
		tblIngredients.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tblIngredients.addMouseListener(new MouseAdapter()
		{
			float fltTotal  = 0;

			public void mouseClicked(MouseEvent e)
			{
				intColumn = tblIngredients.getSelectedColumn();
				intRow = tblIngredients.getSelectedRow();
				strValues = tblIngredients.getModel().getValueAt(intRow, intColumn).toString();

				fltValues = Float.parseFloat(strValues);
				fltTotal = fltValues + fltTotal;

				strTableItem = tblIngredients.getModel().getValueAt(intRow, 0).toString();
			}
		});

		JLabel lblOrder = new JLabel("Cups No. " + CupChoice.intCupNumber + " " + MainProgram.objCups.get(CupChoice.intIndexCup));
		lblOrder.setFont(new Font("Arial", Font.BOLD, 11));
		lblOrder.setBounds(280, 167, 187, 31);
		CupChoice.intIndexCup++;
		CupChoice.intCupNumber++;

		dlmMix = new DefaultListModel();
		lstIngredients = new JList(dlmMix);

		lstIngredients.setBounds(270, 195, 206, 235);
		contentPane.add(lblOrder);
		contentPane.add(lstIngredients);

		scpIngredients.setColumnHeaderView(tblIngredients);

		JPanel pnlAddIngredient = new JPanel();
		pnlAddIngredient.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				intPercent = 0;

				if(intColumn == 1)
					intPercent = 25;
				if(intColumn == 2)
					intPercent = 50;
				if(intColumn == 3)
					intPercent = 75;
				if(intColumn == 4)
					intPercent = 100;

				dlmMix.addElement(strTableItem + " ( "+ intPercent + " % )");

		        MainProgram.objIngredients.add(strTableItem);
		        MainProgram.objPercent.add(intPercent);
		        MainProgram.objIngrPrice.add(fltValues);
				MainProgram.objTotal.add(fltValues);

				intCount++;
			}
		});

		pnlAddIngredient.setBackground(new Color(0x7d4b3b));
		pnlAddIngredient.setBounds(62, 441, 172, 24);
		contentPane.add(pnlAddIngredient);

		JLabel lblAddIngredient = new JLabel("Add Ingredient");
		lblAddIngredient.setForeground(Color.WHITE);
		lblAddIngredient.setFont(new Font("Arial", Font.BOLD, 11));
		pnlAddIngredient.add(lblAddIngredient);

		JPanel pnlOrderSummary = new JPanel();
		pnlOrderSummary.setBackground(new Color(125, 75, 59));
		pnlOrderSummary.setBounds(270, 139, 206, 31);
		contentPane.add(pnlOrderSummary);
		pnlOrderSummary.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblOrderSummary = new JLabel("ORDER SUMMARY");
		lblOrderSummary.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrderSummary.setForeground(Color.WHITE);
		lblOrderSummary.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		pnlOrderSummary.add(lblOrderSummary);

		//NEXT CUP
		JPanel pnlNextCup = new JPanel();
		pnlNextCup.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				int intMax = MainProgram.objCups.size(), intIndex = CupChoice.intIndexCup;
				objCount.add(intCount);
				intCount = 0;

	            if (intIndex <= intMax)
	            {
	                Ingredients.this.dispose();
	                Ingredients frmIngredients = new Ingredients();
	                frmIngredients.setVisible(true);
	                intIndex++;
	            }
			}
		});

		pnlNextCup.setBackground(new Color(125, 75, 59));
		pnlNextCup.setBounds(298, 441, 147, 24);
		contentPane.add(pnlNextCup);

		JLabel lblNextCup = new JLabel("Next Cup");
		lblNextCup.setForeground(Color.WHITE);
		lblNextCup.setFont(new Font("Arial", Font.BOLD, 11));
		pnlNextCup.add(lblNextCup);

		JPanel pnlWhite = new JPanel();
		pnlWhite.setBackground(Color.WHITE);
		pnlWhite.setBounds(270, 160, 206, 166);
		contentPane.add(pnlWhite);

	//-----------------------------------------------------------------------------------------------------------//
	}
}
