package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TextEditorSwingApp {

	private JFrame frame;
	private JTextField saveField;
	private JTextArea textArea;
	private JTextField loadField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextEditorSwingApp window = new TextEditorSwingApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TextEditorSwingApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTheTextEditor = new JLabel("The Text Editor");
		lblTheTextEditor.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTheTextEditor.setBounds(276, 11, 338, 49);
		frame.getContentPane().add(lblTheTextEditor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 149, 814, 635);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		saveField = new JTextField();
		saveField.setBounds(663, 108, 149, 20);
		frame.getContentPane().add(saveField);
		saveField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(saveField.getText());
				System.out.println(textArea.getText());
				textArea.setText("");
			}
		});
		btnSave.setBounds(693, 74, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(607, 111, 46, 14);
		frame.getContentPane().add(lblName);
		
		loadField = new JTextField();
		loadField.setBounds(66, 108, 149, 20);
		frame.getContentPane().add(loadField);
		loadField.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(10, 111, 46, 14);
		frame.getContentPane().add(lblName_1);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(loadField.getText());
			}
		});
		btnLoad.setBounds(90, 74, 89, 23);
		frame.getContentPane().add(btnLoad);
	}
}
