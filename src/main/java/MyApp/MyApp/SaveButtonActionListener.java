package MyApp.MyApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class SaveButtonActionListener implements ActionListener
{

	private ConfigBuilder config;
	
	public SaveButtonActionListener(ConfigBuilder config)
	{
		this.config = config;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String contents = config.toString();
		
		try 
		{
			FileWriter writer = new FileWriter("output.json");
			writer.write(contents);
			writer.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
