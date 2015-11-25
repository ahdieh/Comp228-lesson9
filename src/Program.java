import javax.swing.JLabel;

// DRIVER CLASS +++++++++++++++++++++++++++++++++++++++++++++++
public class Program {

	//MAIN STATIC 
	public static void main(String[] args) {

		try {
			// Example windows lives and dies here +++++++++++

			ExampleWindow frame = new ExampleWindow();
			frame.setVisible(true);
			
			JLabel myLabel = new JLabel("GoodBye!!!");
			
			//frame.getLabel().setText("Hello World");
			frame.setLabel(myLabel);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
