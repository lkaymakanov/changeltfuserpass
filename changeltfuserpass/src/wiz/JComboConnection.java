package wiz;

import java.awt.Component;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import net.is_bg.ltf.db.common.ConnectionProperties;


public class JComboConnection extends JComboBox{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4628440556939630517L;
	List<ConnectionProperties> prop;
	ComboBoxRenderer render = new ComboBoxRenderer();
	int selindex = -1;
	
	
	public JComboConnection() {
		// TODO Auto-generated constructor stubn
		addItem(-1);
		setRenderer(render);
	}
	
	//init combo from connections
	public void initCombo(List<ConnectionProperties> pr){
		
		removeAllItems();
		prop  = pr;
		if(prop!=null && prop.size() > 0){
	        for (int i = 0; i < prop.size(); i++) {
	            addItem(i);
	        }
		}
		else{
			addItem(-1);
		}
	}
	
	
	
	public int getSelindex() {
		return selindex;
	}


	
	
//the renderer to show connections in combo box
	class  ComboBoxRenderer extends JLabel implements ListCellRenderer {
		
		private static final long serialVersionUID = 2897297403981058928L;

		public ComboBoxRenderer() {
			// TODO Auto-generated constructor stub
			setOpaque(true);
		}
		
		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			//return this;
			// TODO Auto-generated method stub
			
			int selectedIndex = ((Integer)value).intValue();
			selindex = selectedIndex;
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
 
            if(selectedIndex == -1) { setText("No items ..."); return this;}
            String pet = prop.get(selectedIndex).getName_to_display();
           
            setText(pet);
            setFont(list.getFont());
            
            return this;
		
		}
	
	}
}
