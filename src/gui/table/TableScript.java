package gui.table;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.Application;

public class TableScript 
{
	GridBagConstraints table = new GridBagConstraints();
	public TableScript(JPanel t, int rows, int columns) {
		table.insets = new Insets(0,0,0,0);
		table.gridx = 0;
		table.gridy = 0;
		table.ipadx = 0;
		table.ipady = 8;
		for (int r = 0; r < rows; r++) {
			table.gridx = r;
			for (int c = 0; c < columns; c++) {
				table.gridy = c;
				System.out.println("Row " + r+", Col "+c);
				JTableField newOne = new JTableField(new JPanel(), r, c);
				newOne.getPanel().setMinimumSize(new Dimension(50, 20));
				newOne.getPanel().setMaximumSize(new Dimension(50, 20));
				newOne.getPanel().setPreferredSize(new Dimension(50, 20));
				t.add(newOne.getPanel(), table);
				JLabel l = new JLabel("id-"+r+":"+c);
				t.setBorder(BorderFactory.createLineBorder(Color.black, 1));
				newOne.getPanel().setBorder(BorderFactory.createLineBorder(Color.black, 1));
				newOne.getPanel().add(l);
				
				System.out.println("Working? "+table.gridx+" : "+table.gridy);
			}
		}
	}
}
