package vue;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;


public class CellRenderAera extends JTextArea implements TableCellRenderer {
	private static final long serialVersionUID = -4420451995172087643L;

	public CellRenderAera() {
		setLineWrap(true);
		setWrapStyleWord(true);
	}

	public Component getTableCellRendererComponent(JTable jTable, Object obj,
			boolean isSelected, boolean hasFocus, int row, int column) {
		setText((String) obj);
		return this;
	}
}
