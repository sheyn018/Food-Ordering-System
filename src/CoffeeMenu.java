import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class CoffeeMenu extends JFrame
{
	private JPanel contentPane;
	static JPanel pnlMixing, pnlPreMade;
	static String strItems;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					CoffeeMenu frmCoffeeMenu= new CoffeeMenu();
					frmCoffeeMenu.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public CoffeeMenu()
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
				CoffeeMenu.this.dispose();
			}
		});
		lblCloseButton.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseButton.setForeground(Color.WHITE);
		lblCloseButton.setBounds(467, 0, 33, 31);
		contentPane.add(lblCloseButton);

		//BACK BUTTON
		JPanel pnlBack = new JPanel();
		pnlBack.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				CoffeeMenu.this.dispose();
				MainMenu frmMainMenu = new MainMenu();
				frmMainMenu.setVisible(true);
			}
		});
		pnlBack.setLayout(null);
		pnlBack.setBackground(new Color(98, 54, 39));
		pnlBack.setBounds(10, 463, 109, 24);
		contentPane.add(pnlBack);

		JLabel lblBack = new JLabel("<<  BACK");
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("Baskerville Old Face", Font.PLAIN, 13));
		lblBack.setBounds(21, 0, 66, 24);
		pnlBack.add(lblBack);

		//NEXT BUTTON
		JPanel pnlNext = new JPanel();
		pnlNext.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				CoffeeMenu.this.dispose();
				DessertMenu frmDessertMenu = new DessertMenu();
				frmDessertMenu.setVisible(true);
			}
		});
		pnlNext.setLayout(null);
		pnlNext.setBackground(new Color(98, 54, 39));
		pnlNext.setBounds(381, 463, 109, 24);
		contentPane.add(pnlNext);

		JLabel lblNext = new JLabel("NEXT >>");
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNext.setForeground(Color.WHITE);
		lblNext.setFont(new Font("Baskerville Old Face", Font.PLAIN, 13));
		lblNext.setBounds(21, 0, 66, 24);
		pnlNext.add(lblNext);

	//---------------------------------------------------------------------------------------------------------------//

		//COFFEE MENU
		JLabel lblCoffeeMenu = new JLabel("");
		lblCoffeeMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoffeeMenu.setBounds(38, 28, 412, 400);
		lblCoffeeMenu.setSize(420, 380);
		lblCoffeeMenu.setIcon(new ImageIcon("D:\\My Folder\\School Documents\\PUP COLLEGE\\2ND YEAR\\Object Oriented Programming\\ModSim Project\\images\\Coffee Menu.png"));
		contentPane.add(lblCoffeeMenu);

	//---------------------------------------------------------------------------------------------------------------//

		//CREATE YOUR OWN
		pnlMixing = new JPanel();
		pnlMixing.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				CoffeeMenu.this.dispose();
				CupChoice frmCupChoice = new CupChoice();
				frmCupChoice.setVisible(true);
			}
		});

		pnlMixing.setBounds(48, 408, 196, 44);
		pnlMixing.setBackground(new Color(0x7d4b3b));
		contentPane.add(pnlMixing);
		pnlMixing.setLayout(null);

		JLabel lblMixing = new JLabel("Create Your Own ");
		lblMixing.setHorizontalAlignment(SwingConstants.CENTER);
		lblMixing.setBounds(20, 11, 154, 25);
		lblMixing.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblMixing.setForeground(Color.WHITE);
		pnlMixing.add(lblMixing);

	//---------------------------------------------------------------------------------------------------------------//

		//PRE-MADE ORDER
		pnlPreMade = new JPanel();
		pnlPreMade.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				CoffeeMenu.this.dispose();
				PreMadeOrder frmPremadeOrder = new PreMadeOrder();
				frmPremadeOrder.setVisible(true);
			}
		});
		pnlPreMade.setLayout(null);
		pnlPreMade.setBackground(new Color(0x7d4b3b));
		pnlPreMade.setBounds(262, 408, 196, 44);
		contentPane.add(pnlPreMade);

		JLabel lblPreMade = new JLabel("Select a Premade");
		lblPreMade.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreMade.setForeground(Color.WHITE);
		lblPreMade.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblPreMade.setBounds(20, 11, 154, 25);
		pnlPreMade.add(lblPreMade);

	//---------------------------------------------------------------------------------------------------------------//

	}
}
