package vue;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModel2 extends AbstractTableModel {
	   private String [] labelColonne; //Les entêtes des colonnes
	   private ArrayList [] data; //Les données
	 
	   public TableModel2 (ArrayList [] data, String [] titres) {
	     labelColonne = titres;
	     this.data = data;
	   }
	 
	   //Fonctions qu'il est nécéssaire de surcharger
	 
	   public String  getColumnName  (int col)          {return labelColonne[col].toString();}
	   public int     getRowCount    ()                 {return data[0].size();}
	   public int     getColumnCount ()                 {return labelColonne.length;}
	   public Object  getValueAt     (int row, int col) {return data[col].get(row);}
	 
	   //On ajoute , on remplace ou on supprimer suivant les valeurs entrées...
	   public void setValueAt(Object value, int row, int col) {
	     if (value != null) {
	       if (row >= data[col].size())
	         data[col].add(row,value);
	       else
	         data[col].set(row,value);
	     } else 
	       for (int i = 0; i < getColumnCount(); i++) 
	         data[i].remove(row);
	     fireTableDataChanged();
	   }
	 
	   //Permet de tout éffacer
	   public void clear () {
	     for (int i = 0;i < labelColonne.length;i++)
	       data[i].clear();
	     fireTableDataChanged();
	   }
	   
	   public boolean isCellEditable(int row, int col){
			if(col>0)return true;
			return false;
	   }
	   
	   public void miseAjour(ArrayList [] data) {
		   this.data = data;
	   }
}