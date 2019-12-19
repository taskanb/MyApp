package MyApp.MyApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;


public class Combo1ActionListener implements ActionListener
{
	private ComboBoxModel parentComboModel;
	private JComboBox childCombo;
	
	public Combo1ActionListener(ComboBoxModel parentComboModel, 
			JComboBox childCombo)
	{
		this.parentComboModel = parentComboModel;
		this.childCombo = childCombo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand() == "comboBoxChanged")
		{
			ComboEntry entry = parentComboModel.getSelectedItem();			
			ComboBoxModel model = ComboBoxModel.BuildComboModel(entry.getValue());
			childCombo.setModel(model);
		}
	}

}
