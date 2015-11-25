
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
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


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
	private JScrollPane _todoScrollPane;
	
	private Border _redBorder, _blackBorder;
	private JLabel lblMyToDo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	
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
		setBounds(100, 100, 400, 400);
		this._contentPane = new JPanel();
		this._contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this._contentPane);
		
	}
	
	private void _setupBorders() {
		this._blackBorder = BorderFactory.createLineBorder(Color.black);
		this._redBorder = BorderFactory.createLineBorder(Color.red);
	}
	
	private void _addLabel() {
		this._Label.setBounds(5, 10, 300, 30);
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
		this._nameLabel.setBounds(5, 45, 100, 30);
		this._contentPane.add(_nameLabel);
		
		// Name Text Field
		this._nameTextField = new JTextField();
		this._nameTextField.setBounds(110, 45, 200, 30);
		this._nameTextField.setText("");
		this._nameTextField.setBorder(this._blackBorder);
		this._contentPane.add(this._nameTextField);
		
		// Enter button
		this._enterBtn = new JButton("Click Me!");
		this._enterBtn.setBounds(5, 300, 100, 30);
		this._contentPane.add(this._enterBtn);
		
		// Age label
		this._ageLabel = new JLabel("Enter Age:");
		this._ageLabel.setBounds(5, 80, 100, 30);
		this._contentPane.add(this._ageLabel);
		
		// Age text field
		this._ageTextField = new JTextField();
		this._ageTextField.setBounds(110, 80, 200, 30);
		this._ageTextField.setBorder(this._blackBorder);
		this._contentPane.add(this._ageTextField);
		
		// Combo box
		this._todoComboBox = new JComboBox();
		this._todoComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		this._todoComboBox.setSelectedIndex(0);
		this._todoComboBox.setBounds(5, 130, 70, 30);
		this._contentPane.add(this._todoComboBox);
		
		// ScrollPane
		this._todoScrollPane = new JScrollPane();
		_todoScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		_todoScrollPane.setAutoscrolls(true);
		this._todoScrollPane.setBounds(110, 120, 250, 210);
		this._contentPane.add(this._todoScrollPane);
		
		lblMyToDo = new JLabel("My to do List:");
		lblMyToDo.setHorizontalAlignment(SwingConstants.CENTER);
		_todoScrollPane.setColumnHeaderView(lblMyToDo);
		
		JPanel panel = new JPanel();
		_todoScrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(122, 5, 4, 22);
		panel.add(textArea);
		
		textField = new JTextField();
		textField.setBounds(50, 10, 146, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(50, 40, 146, 25);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(50, 70, 146, 25);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(50, 100, 146, 25);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(50, 130, 146, 25);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(50, 160, 146, 25);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(50, 190, 146, 25);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
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
				textFieldArrayList.get(index).setBounds(110, 80 + (index*40), 200, 30);
				this._contentPane.add(textFieldArrayList.get(index));
				
			}
		}
		
	}
}
