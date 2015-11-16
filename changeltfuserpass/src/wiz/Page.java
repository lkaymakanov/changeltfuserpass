package wiz;

import javax.swing.JPanel;

public abstract class Page extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7316981366612917681L;

	public Page() {
		// TODO Auto-generated constructor stub
		
	}
	
	protected abstract void initPage();

}
