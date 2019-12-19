package MyApp.MyApp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// Create GUI components
    	JFrame frame = new JFrame();
    	JComboBox parentCombo = new JComboBox();
    	JComboBox childCombo = new JComboBox();
    	JTextArea textArea = new JTextArea();
    	JButton addButton = new JButton();
    	JButton saveButton = new JButton();
    	
    	// Create object that will track and build the JSON config object to write to file.
    	ConfigBuilder builder = new ConfigBuilder();
    	
    	// Get the base JSON config file.
    	JSONObject baseConfig = getConfigJSONObject();
    	
    	
    	// Create the ComboBox model from the base JSON config object and add it to the parent combo.
        ComboBoxModel parentModel = ComboBoxModel.BuildComboModel(baseConfig);
        parentCombo.setModel(parentModel);
    	
    	parentCombo.setBounds(100, 100, 200, 40);
    	childCombo.setBounds(100, 200, 200, 40);
    	textArea.setBounds(100, 400, 400, 400);
    	addButton.setBounds(100, 300, 100, 40);
    	saveButton.setBounds(100, 900, 100, 40);
    	
    	addButton.setText("Add");
    	saveButton.setText("Save");
    	
    	textArea.setLineWrap(true);
    	textArea.setWrapStyleWord(true);
    	
    	Combo1ActionListener combo1Listener = new Combo1ActionListener(parentModel, childCombo);
    	parentCombo.addActionListener(combo1Listener);
    	
    	AddButtonActionListener addButtonActionListener = 
    			new AddButtonActionListener(parentCombo, childCombo, builder, textArea);
    	addButton.addActionListener(addButtonActionListener);
    	
    	SaveButtonActionListener saveButtonActionListener = 
    			new SaveButtonActionListener(builder);
    	saveButton.addActionListener(saveButtonActionListener);
    	
    	frame.add(parentCombo);
    	frame.add(childCombo);
    	frame.add(textArea);
    	frame.add(addButton);
    	frame.add(saveButton);
    	
    	// Start the application by selecting the first item in the parent combo 
    	//	which triggers the event to build the child combo.
    	parentCombo.setSelectedIndex(0);
    	
    	// Set main window and show.
    	frame.setSize(600, 800);
    	frame.setLayout(null);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    }
    
    
    private static JSONObject getConfigJSONObject()
    {
    	String result = "";
    	
    	try
    	{
    		BufferedReader br = new BufferedReader(new FileReader("config.json"));
    		StringBuilder sb = new StringBuilder();
    		String line = br.readLine();
    		while(line != null)
    		{
    			sb.append(line);
    			line = br.readLine();
    		}
    		
    		result = sb.toString();
    		return new JSONObject(result);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	return new JSONObject();
    }
    
    

    
}
