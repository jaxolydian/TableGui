package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import gui.table.TableScript;

public class Gui implements ActionListener {

	
	JFrame frame = new JFrame();
	JPanel hostPanel = new JPanel();
	JPanel mainContentPanel = new JPanel(new GridBagLayout());
	JPanel interactivePanel = new JPanel(new GridBagLayout());
	JPanel tablePanel = new JPanel(new GridBagLayout());
	JButton confirm = new JButton("Create");
	JPanel rowsPanel = new JPanel(new GridBagLayout());
	JPanel colsPanel = new JPanel(new GridBagLayout());
	JLabel rowsLabel = new JLabel("<html><b>Rows</b> <i>(max 11):</i></html>");
	JLabel colsLabel = new JLabel("<html><b>Columns</b> <i>(max 20):</i></html>");
	JTextField rowsAmt = new JTextField("Enter here...");
	JTextField colsAmt = new JTextField("Enter here...");
	GridBagConstraints a = new GridBagConstraints();
	GridBagConstraints a2 = new GridBagConstraints();
	GridBagConstraints b = new GridBagConstraints();
	GridBagConstraints c = new GridBagConstraints();
	GridBagConstraints d = new GridBagConstraints();
	GridBagConstraints table = new GridBagConstraints();
	
	public Gui() {
		a.insets = new Insets(0,0,0,0);
		a.gridx = 0;
		a.gridy = 0;
		a.ipadx = 0;
		a.ipady = 0;
		a2.insets = new Insets(5,5,5,5);
		a2.gridx = 0;
		a2.gridy = 0;
		a2.ipadx = 0;
		a2.ipady = 0;
		mainContentPanel.add(interactivePanel, a2);
		interactivePanel.setMaximumSize(new Dimension(560,125));
		interactivePanel.setMinimumSize(new Dimension(560,125));
		interactivePanel.setPreferredSize(new Dimension(560,125));
		interactivePanel.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white.darker().darker().darker().darker()));
		hostPanel.add(mainContentPanel, a);
		b.insets = new Insets(5,5,5,5);
		b.gridx = 0;
		b.gridy = 0;
		b.ipadx = 0;
		b.ipady = 0;
		c.insets = new Insets(0,0,0,0);
		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 5;
		c.ipady = 5;
		rowsPanel.add(rowsLabel, c);
		c.gridx = 1;
		rowsPanel.add(rowsAmt, c);
		interactivePanel.add(rowsPanel, b);
		rowsLabel.setMaximumSize(new Dimension(110,20));
		rowsLabel.setMinimumSize(new Dimension(110,20));
		rowsLabel.setPreferredSize(new Dimension(110,20));
		rowsLabel.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white.darker().darker().darker().darker()));
		rowsAmt.setMaximumSize(new Dimension(100,20));
		rowsAmt.setMinimumSize(new Dimension(100,20));
		rowsAmt.setPreferredSize(new Dimension(100,20));
		b.gridy = 1;
		d.insets = new Insets(0,0,0,0);
		d.gridx = 0;
		d.gridy = 0;
		d.ipadx = 5;
		d.ipady = 5;
		colsPanel.add(colsLabel, d);
		d.gridx = 1;
		colsPanel.add(colsAmt, d);
		interactivePanel.add(colsPanel, b);
		colsLabel.setMaximumSize(new Dimension(110,20));
		colsLabel.setMinimumSize(new Dimension(110,20));
		colsLabel.setPreferredSize(new Dimension(110,20));
		colsLabel.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white.darker().darker().darker().darker()));
		colsAmt.setMaximumSize(new Dimension(100,20));
		colsAmt.setMinimumSize(new Dimension(100,20));
		colsAmt.setPreferredSize(new Dimension(100,20));
		b.gridy = 2;
		interactivePanel.add(confirm, b);
		confirm.setMaximumSize(new Dimension(220,40));
		confirm.setMinimumSize(new Dimension(220,40));
		confirm.setPreferredSize(new Dimension(220,40));
		b.gridy = 3;
		a2.insets = new Insets(0,5,5,5);
		a2.gridy = 1;
		mainContentPanel.add(tablePanel, a2);
		tablePanel.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white.darker().darker().darker().darker()));
		tablePanel.setMaximumSize(new Dimension(560,575));
		tablePanel.setMinimumSize(new Dimension(560,575));
		tablePanel.setPreferredSize(new Dimension(560,575));
		frame.add(hostPanel);
		
		frame.setTitle("Application");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setMaximumSize(new Dimension(595, 765));
		frame.setMinimumSize(new Dimension(595, 765));
		frame.setSize(595, 765);
		hostPanel.setBackground(Color.black);
		
		confirm.addActionListener(this);
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(confirm)) {
			if (Integer.parseInt(rowsAmt.getText().toString()) <= 11 && Integer.parseInt(rowsAmt.getText().toString()) > 0) {
				if (Integer.parseInt(colsAmt.getText().toString()) <= 20 && Integer.parseInt(colsAmt.getText().toString()) > 0) {
					tablePanel.removeAll();
					new TableScript(tablePanel, Integer.parseInt(rowsAmt.getText().toString()), Integer.parseInt(colsAmt.getText().toString()));
				}
				else if (Integer.parseInt(colsAmt.getText().toString()) > 20 || Integer.parseInt(colsAmt.getText().toString()) <= 0) {
					JOptionPane.showMessageDialog(null, "Remember to insert a value from 1-20", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Unidentifiable error; please insert a value from 1-20", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if (Integer.parseInt(rowsAmt.getText().toString()) > 11 || Integer.parseInt(rowsAmt.getText().toString()) <= 0) {
				JOptionPane.showMessageDialog(null, "Remember to insert a value from 1-11", "Warning", JOptionPane.WARNING_MESSAGE);	
		}
			else {
				JOptionPane.showMessageDialog(null, "Unidentifiable error; please insert a value from 1-11", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
