package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import preJar.RemindersView;

public class TextEditorSwingApp {

	private JFrame frame;
	private JTextField saveField;
	private JTextArea textArea;
	private JTextField loadField;
	private static RemindersView remView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextEditorSwingApp window = new TextEditorSwingApp();
					window.frame.setVisible(true);
					remView = new RemindersView();
					remView.createReminder(1, "Save Reminder", "Designed to help remind Users to save so they don't yell at us");

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
		
		readWrite rw = new readWrite();		
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
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				Boolean isItTime = remView.isDue();
				if(isItTime) {
					JOptionPane.showMessageDialog(null, " It's been a while since you last saved.\nSave now or lose your work forever!");
					remView.createReminder(1, "Save Reminder", "Designed to help remind Users to save so they don't yell at us");
				}
			}
		});
		scrollPane.setViewportView(textArea);
		
		saveField = new JTextField();
		saveField.setBounds(663, 108, 149, 20);
		frame.getContentPane().add(saveField);
		saveField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					rw.createFile(saveField.getText(), textArea.getText());
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, saveField.getText() + " file saved successfully.");
				saveField.setText("");
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
				String text = rw.readFile(loadField.getText());
				textArea.setText(text);
				JOptionPane.showMessageDialog(null, loadField.getText() + " file loaded successfully.");
				loadField.setText("");
				System.out.println(loadField.getText());
			}
		});
		btnLoad.setBounds(90, 74, 89, 23);
		frame.getContentPane().add(btnLoad);
	}
}
