package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons.
	 * 
	 * Button 1: Add Entry When this button is clicked, use an input dialog to ask
	 * the user to enter an ID number. After an ID is entered, use another input
	 * dialog to ask the user to enter a name. Add this information as a new entry
	 * to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 */

	HashMap<Integer, String> hash = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addEntry = new JButton();
	JButton searchByID = new JButton();
	JButton viewList = new JButton();
	JButton removeEntry = new JButton();
	String list = "";

	void setup() {
		frame.setVisible(true);
		addEntry.addActionListener(this);
		searchByID.addActionListener(this);
		viewList.addActionListener(this);
		removeEntry.addActionListener(this);
		panel.add(addEntry);
		panel.add(searchByID);
		panel.add(viewList);
		panel.add(removeEntry);
		frame.add(panel);
		addEntry.setText("Add Entry");
		searchByID.setText("Search By ID");
		viewList.setText("View List");
		removeEntry.setText("Remove Entry");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == addEntry) {
		String IDNum = JOptionPane.showInputDialog("Enter an ID Number");
		int id = Integer.parseInt(IDNum);
		String name = JOptionPane.showInputDialog("Enter a Name!");
		hash.put(id, name);
		}
		else if(arg0.getSource() == searchByID) {
			String iD = JOptionPane.showInputDialog("Enter an ID Number to check if it is there!");
			int Id = Integer.parseInt(iD);
			if(hash.get(Id) == null) {
				JOptionPane.showMessageDialog(null, "Sorry that ID does not exist.");
				
			} else {
				JOptionPane.showMessageDialog(null, Id + " is the ID and " + hash.get(Id) + " is the name!");
			}
			
		}
		else if(arg0.getSource() == viewList) {
			list = "";
			for (Integer i : hash.keySet()) {
				list += "ID: " + i + " Name: " + hash.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, list);
		}
		else if(arg0.getSource() == removeEntry) {
			String remove = JOptionPane.showInputDialog("Enter an ID number you want to remove!");
			int rem = Integer.parseInt(remove);
			if(hash.get(rem) == null) {
				JOptionPane.showMessageDialog(null, "Sorry that ID does not exist.");
			} else {
				hash.remove(rem);
			}
		}
		
		
		
		
		
	}
}
