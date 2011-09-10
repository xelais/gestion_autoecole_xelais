package vue;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class ButtonEditor extends DefaultCellEditor {
		  
		private static final long serialVersionUID = 1L;
		protected JButton button;
		private ButtonListener bListener = new ButtonListener();

		public ButtonEditor(JCheckBox checkBox) {
			super(checkBox);
		    button = new JButton();
		    button.setOpaque(true);
		    button.addActionListener(bListener);
		}
		
		public Component getTableCellEditorComponent(JTable table, Object value,
		                   boolean isSelected, int row, int column) { 
			bListener.setRow(row);
			bListener.setColumn(column);
			bListener.setTable(table);
			
			button.setText( (value ==null) ? "" : value.toString() );
			return button;
		}
		
		class ButtonListener implements ActionListener{
			  
			  private int column, row;
			  private JTable table;
			  private int nbre = 0;
			  private JButton button;
			  
			  public void setColumn(int col){this.column = col;}
			  public void setRow(int row){this.row = row;}
			  public void setTable(JTable table){this.table = table;}
			  
			  public JButton getButton(){return this.button;}
			  
			  public void actionPerformed(ActionEvent event) {
				System.out.println("coucou du bouton : " + ((JButton)event.getSource()).getText() );
				((AbstractTableModel)table.getModel()).setValueAt("New Value " + (++nbre), this.row, (this.column -1));	
				((AbstractTableModel)table.getModel()).fireTableCellUpdated(this.row, this.column - 1);
				this.button = ((JButton)event.getSource());
			  }
		  }
		  
}
