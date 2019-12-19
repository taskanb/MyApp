package MyApp.MyApp;

import org.json.JSONObject;

public class ConfigBuilder 
{
	private JSONObject configJSON;
	
	public ConfigBuilder()
	{
		configJSON = new JSONObject();
	}
	
	public void Clear()
	{
		configJSON = new JSONObject();
	}

	public void Add(String parentName, String childName, JSONObject child)
	{
		if(!configJSON.has(parentName))
		{
			configJSON.put(parentName, new JSONObject());
		}
		
		JSONObject parent = configJSON.getJSONObject(parentName);
		
		if(parent.has(childName))
		{
			return;
		}
		
		parent.put(childName, child);
	}
	
	@Override
	public String toString() 
	{
		return configJSON.toString(4);
	}
}
