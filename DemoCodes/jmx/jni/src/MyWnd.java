import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class MyWnd
{
	public native void popupMessage();
	MyWnd()
	{
		JFrame frm = new JFrame("My First JNI Application");
		frm.getContentPane().setLayout(new FlowLayout());
		JButton btn = new JButton("Click Me!");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				popupMessage();
			}
		});
		frm.getContentPane().add(btn);
		frm.setSize(300, 100);
		frm.setVisible(true);
	}
 
	public static void main(String args[])
	{
		new MyWnd();
	}
 
	static {
		System.loadLibrary("dll");
	}
};