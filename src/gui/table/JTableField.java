package gui.table;

import javax.swing.JPanel;

public class JTableField {

	private JPanel panel;
	private int rows;
	private int cols;
	
	/** @author Jackson Philips (c) 2025. 
	 *  @deprecated Do not use the null constructor if unnecessary. It will likely cause an error.
	 **/
	public JTableField() {

		System.err.println("Undefined values. Will default to null values.");
		this.setPanel(null);
		this.setRows(0);
		this.setCols(0);
	}
	/** @author Jackson Philips (c) 2025. 
	 * 
	 * @param pane The selected table field.
	 * @param row The field's placed row.
	 * @param col The field's placed column.
	 */
	public JTableField(JPanel pane, int row, int col) {
		this.setPanel(pane);
		this.setRows(row);
		this.setCols(col);
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel pane) {
		this.panel = pane;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	

}
