package vue;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellEditor;


public class CellEditorAera extends AbstractCellEditor implements
		TableCellEditor, KeyListener {
	private static final long serialVersionUID = 1L;
	JComponent component = new JTextArea();

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int rowIndex, int vColIndex) {

		((JTextArea) component).setLineWrap(true);
		((JTextArea) component).setWrapStyleWord(true);

		((JTextArea) component).setText((String) value);
		((JTextArea) component).addKeyListener(this);
		return new JScrollPane(component);
	}

	public Object getCellEditorValue() {

		return ((JTextArea) component).getText();
	}

	@Override
	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			this.stopCellEditing();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
