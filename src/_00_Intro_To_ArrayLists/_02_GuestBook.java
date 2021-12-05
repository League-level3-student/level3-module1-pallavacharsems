package _00_Intro_To_ArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
    /*
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     */
	public static void main(String[] args) {
		new _02_GuestBook().run();
	}
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	 ArrayList<String> names = new ArrayList<String>();
	 
private void run() {
		// TODO Auto-generated method stub
		frame.setVisible(true);
		button1.setText("Add Name");
		button2.setText("View Names");
		button1.addActionListener(this);
		button2.addActionListener(this);
		panel.add(button1);
		panel.add(button2);
		frame.add(panel);
		frame.pack();
		
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() == button1) {
		String addN = JOptionPane.showInputDialog("Please enter a name to add to the Guestbook!");
		names.add(addN);
	}
	if(e.getSource() == button2) {
		String s = "";
		for (int i = 0; i < names.size(); i++) {
			s += "Guest " + (i+1) + ": " + names.get(i) + "\n";
		}
		JOptionPane.showMessageDialog(null, s);
}




}
}
