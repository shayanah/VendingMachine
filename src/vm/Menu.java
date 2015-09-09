package vm;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.swing.JButton;

public class Menu extends JFrame {

	private JPanel mainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	private JPanel vendingMachine1UI;
	private JPanel vendingMachine2UI;
	private JPanel vmConstrols1;
	private JPanel vmConstrols2;
	private GridBagConstraints gbc ;
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		mainMenu = new JPanel();
		mainMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		mainMenu.setLayout(new GridLayout(2,0));
		gbc = new GridBagConstraints();
		
		//mainMenu.setLayout(new GridLayout(2,2));
		setContentPane(mainMenu);
		
		//initializing vm 1
		vendingMachine1UI = new JPanel();
		mainMenu.add(vendingMachine1UI);
		vm1loadingDesign(20);
		
		vmConstrols1 = new JPanel();
		mainMenu.add(vmConstrols1);
		vmControls1Design();
		
		//initializing vm 2 
		vendingMachine2UI = new JPanel();
		mainMenu.add(vendingMachine2UI);
		vm2loadingDesign(20);
		
		vmConstrols2 = new JPanel();
		mainMenu.add(vmConstrols2);
		vmControls2Design();
	}
	public void vm1loadingDesign(int dispenserSize)
	{
		
		vendingMachine1UI.setLayout(new GridLayout(10,2,10,10));
		vendingMachine1UI.setBackground(Color.white);
		for(int i = 0 ; i < dispenserSize; i++ )
		{
			vendingMachine1UI.add(new JButton(new Integer(i).toString()));
		}
		
		
		
	}
	public void vm2loadingDesign(int dispenserSize)
	{
		vendingMachine2UI.setLayout(new GridLayout(10,2,10,10));
		vendingMachine2UI.setBackground(Color.DARK_GRAY);
		for(int i = 0 ; i < dispenserSize; i++ )
		{
			vendingMachine2UI.add(new JButton(new Integer(i).toString()));
		}
	}
	public void vmControls1Design()
	{
		vmConstrols1.setBackground(Color.gray);
	}
	public void vmControls2Design()
	{
		vmConstrols2.setBackground(Color.WHITE);
	}
	public void clientMoney(int money)
	{
		
		
	}
}
