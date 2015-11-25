
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


public class ExampleWindow extends JFrame implements ActionListener {
	
	// PRIVATE INSTANCE VARIABLES +++++++++++++++++++++++++++++++
	private JPanel _contentPane; // JPanel Container
	private JLabel _Label;
	private JLabel _nameLabel;
	private JTextField _nameTextField;
	private JButton _enterBtn;
	private JLabel _ageLabel;
	private JTextField _ageTextField;
	private JComboBox _todoComboBox;
	
	private Border _redBorder, _blackBorder;
	
	
	//private NameTextFieldHandler _nameTextFieldHandler;
	
	// PUBLIC PROPERTIES +++++++++++++++++++++++++++++++++++++++++
	public JLabel getLabel() {
		return this._Label;
	}

	public void setLabel(JLabel label) {
		this._contentPane.remove(this._Label);
		this._Label = label;
		this._addLabel();
	}

	// CONSTRUCTOR METHOD +++++++++++++++++++++++++++++++++++++++
	public ExampleWindow() {
		this._initialize();
		this._setupBorders();
		this._addUIComponents();
		
		// Register event handler for Action Listeners
		this._nameTextField.addActionListener(this);
		
		this._enterBtn.addActionListener(this);
		
		this._ageTextField.addActionListener(this);
		
		this._todoComboBox.addActionListener(this);
	}
	
	// PRIVATE METHODS +++++++++++++++++++++++++++++++++++++++++++
	private void _initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 303);
		this._contentPane = new JPanel();
		this._contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this._contentPane);
		
	}
	
	private void _setupBorders() {
		this._blackBorder = BorderFactory.createLineBorder(Color.black);
		this._redBorder = BorderFactory.createLineBorder(Color.red);
	}
	
	private void _addLabel() {
		this._Label.setBounds(5, 6, 225, 23);
		this._contentPane.add(this._Label);
	}

	private void _addUIComponents() {
		// Use Absolute Layout
		this._contentPane.setLayout(null);
		
		// Hello Label
		this._Label = new JLabel("New label");
		this._addLabel();
		
		// Name Label
		this._nameLabel = new JLabel("Enter Name:");
		this._nameLabel.setBounds(5, 41, 96, 23);
		this._contentPane.add(_nameLabel);
		
		// Name Text Field
		this._nameTextField = new JTextField();
		this._nameTextField.setBounds(99, 35, 131, 29);
		this._nameTextField.setText("");
		this._nameTextField.setBorder(this._blackBorder);
		this._contentPane.add(this._nameTextField);
		
		this._enterBtn = new JButton("Click Me!");
		this._enterBtn.setBounds(115, 223, 117, 29);
		this._contentPane.add(this._enterBtn);
		
		this._ageLabel = new JLabel("Enter Age:");
		this._ageLabel.setBounds(5, 82, 76, 16);
		this._contentPane.add(this._ageLabel);
		
		this._ageTextField = new JTextField();
		this._ageTextField.setBounds(99, 76, 131, 28);
		this._ageTextField.setBorder(this._blackBorder);
		this._contentPane.add(this._ageTextField);
		
		this._todoComboBox = new JComboBox();
		this._todoComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		this._todoComboBox.setSelectedIndex(0);
		this._todoComboBox.setBounds(178, 116, 64, 38);
		this._contentPane.add(this._todoComboBox);
		
	}

	

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == this._nameTextField) {
			
			this._Label.setText(this._nameTextField.getText());
		}
		
		if(event.getSource() == this._enterBtn) {
			this._Label.setText("goodbyeButton - clicked");
		}
		
		if(event.getSource() == this._ageTextField) {
			
			try {
				int ageDifference = 46 - Integer.parseInt(this._ageTextField.getText());
				this._Label.setText(Integer.toString(ageDifference));
				this._ageTextField.setBorder(this._blackBorder);
			
				
			} catch (Exception e) {
				this._Label.setText("Hey that was just wrong");
				this._ageTextField.selectAll();
				this._ageTextField.setBorder(this._redBorder);
			}
		}
		
		if(event.getSource() == this._todoComboBox) {
			ArrayList<JTextField> textFieldArrayList = new ArrayList<JTextField>();
			for(int index = 0; index <= this._todoComboBox.getSelectedIndex(); index++) {
				textFieldArrayList.add(new JTextField());
				textFieldArrayList.get(index).setBounds(99, 76 + (index*30), 131, 28);
				this._contentPane.add(textFieldArrayList.get(index));
				
			}
		}
		
	}
}
