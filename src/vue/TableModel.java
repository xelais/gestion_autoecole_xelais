package vue;
import javax.swing.table.AbstractTableModel;

class TableModel extends AbstractTableModel{

		private Object[][] data;
		private String[] title;
		/**
		 * Constructeur
		 * @param data
		 * @param title
		 */
		public TableModel(Object[][] data, String[] title){
			this.data = data;
			this.title = title;
		}
		/**
		* Retourne le titre de la colonne e l'indice specife
		*/
		public String getColumnName(int col) {
		  return this.title[col];
		}

		/**
		 * Retourne le nombre de colonnes
		 */
		public int getColumnCount() {
			return this.title.length;
		}
		
		/**
		 * Retourne le nombre de lignes
		 */
		public int getRowCount() {
			return this.data.length;
		}
		
		/**
		 * Retourne la valeur e l'emplacement specifie
		 */
		public Object getValueAt(int row, int col) {
			return this.data[row][col];
		}
		
		/**
		 * Defini la valeur e l'emplacement specifie
		 */
		public void setValueAt(Object value, int row, int col) {
			//On interdit la modification sur certaine colonne !
			if(!this.getColumnName(col).equals("Age") && !this.getColumnName(col).equals("Suppression"))
				this.data[row][col] = value;
		}
				
		/**
		* Retourne la classe de la donnee de la colonne
		* @param col
		*/
		public boolean isCellEditable(int row, int col){
			if(col>0)return true;
			return false;
		}
	}