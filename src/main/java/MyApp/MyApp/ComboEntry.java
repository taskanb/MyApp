package MyApp.MyApp;

import org.json.JSONObject;

public class ComboEntry 
{
	private String name;
	
	private JSONObject value;
	
	public ComboEntry(String name, JSONObject value)
	{
		this.name = name;
		this.value = value;
	}

	@Override
	public String toString() 
	{
		return this.name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public JSONObject getValue()
	{
		return value;
	}
}
