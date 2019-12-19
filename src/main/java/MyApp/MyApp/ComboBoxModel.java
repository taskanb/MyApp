package MyApp.MyApp;

import javax.swing.DefaultComboBoxModel;

import org.json.JSONArray;
import org.json.JSONObject;

public class ComboBoxModel extends DefaultComboBoxModel<ComboEntry>
{
	public ComboBoxModel(ComboEntry[] items)
	{
		super(items);
	}
	
	@Override
	public ComboEntry getSelectedItem() 
	{
		// TODO Auto-generated method stub
		return (ComboEntry)super.getSelectedItem();
	}
	
	public static ComboBoxModel BuildComboModel(JSONObject base)
    {
    	JSONArray names = base.names();
    	ComboEntry[] items = new ComboEntry[names.length()];
    	
    	for(int index=0; index < names.length(); index++)
    	{
    		String name = names.getString(index);
    		JSONObject obj = base.getJSONObject(name);
    		items[index] = new ComboEntry(name, obj);
    	}
    	
    	return new ComboBoxModel(items);
    }
}
