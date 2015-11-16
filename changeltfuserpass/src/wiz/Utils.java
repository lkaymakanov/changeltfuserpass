package wiz;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Utils {
     public static String getEncryptedPass(String pass){
    	 if(pass == null)  return null;
 		return new Sha512().digest(pass);
     }
     
     
     public static void showErrMsg(Component c, String msg){
    	 JOptionPane.showMessageDialog(c,
					"Problem  ...   \n " + msg,
					"Ooppps...",
					JOptionPane.ERROR_MESSAGE);
     }
     
     
     public static void showSuccessMsg(Component c, String msg){
    	 JOptionPane.showMessageDialog(c,
					"Well done  ...   \n " + msg,
					"Sucsess...",
					JOptionPane.INFORMATION_MESSAGE);
     }
}

