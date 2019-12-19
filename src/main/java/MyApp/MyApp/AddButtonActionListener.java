package MyApp.MyApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class AddButtonActionListener implements ActionListener
{
	private JComboBox parentCombo;
	private JComboBox childCombo;
	private ConfigBuilder builder;
	private JTextArea textArea;
	
	public AddButtonActionListener(JComboBox parentCombo, JComboBox childCombo, 
			ConfigBuilder builder, JTextArea textArea)
	{
		this.parentCombo = parentCombo;
		this.childCombo = childCombo;
		this.builder = builder;
		this.textArea = textArea;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		ComboEntry parent = (ComboEntry)parentCombo.getSelectedItem();
		ComboEntry child = (ComboEntry)childCombo.getSelectedItem();
		
		builder.Add(parent.getName(), child.getName(), child.getValue());
		textArea.setText(builder.toString());
		
	}

}
