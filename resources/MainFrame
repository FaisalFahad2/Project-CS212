import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Search Engine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 833, 463);
		contentPane.add(tabbedPane);
		
		    String a[] = new String[0];
    prepare p = new prepare(50);
    try {
      p.fillStop();
      a = p.filterDocs();

    } catch (IOException e) {
      System.out.println("err");
    }
    Index ind = new Index();
    ind.fillIndex(a);
    
    InvertedIndex ivner = new InvertedIndex();
    ivner.fillIndex(a);
    
    InvertedIndexBST BST = new InvertedIndexBST();
    BST.fillBST(a);

    hashMap hash = new hashMap(26);
    hash.fillTableHash(a);

	ranking r = new ranking(ind, ivner, BST, hash);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Index", null, panel, null);
		panel.setLayout(null);
		
		textField = new JTextField(); //Index
		textField.setBounds(10, 38, 227, 19);
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Query: Index");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 2, 279, 26);
		panel.add(lblNewLabel);
		
		JLabel errorIndex = new JLabel("");
		errorIndex.setForeground(new Color(255, 0, 0));
		errorIndex.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorIndex.setBounds(10, 67, 200, 13);
		panel.add(errorIndex);

		JButton btnNewButton = new JButton("Boolean Retrieval"); //Index
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(247, 37, 147, 21);
		panel.add(btnNewButton);
		
		JTextArea textArea = new JTextArea(); //Index
		textArea.setBounds(10, 91, 808, 335);
		panel.add(textArea);
		
		JButton btnNewButton_1 = new JButton("Clear All"); //Index
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textArea.setText("");
				
			}
		});
		btnNewButton_1.setBounds(733, 37, 85, 21);
		panel.add(btnNewButton_1);
		
		JButton btnRankedRetrieval = new JButton("Ranked Retrieval"); //Index
		btnRankedRetrieval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String indexString = textField.getText().toLowerCase().trim();
				if(!indexString.isBlank()){
					textArea.setText(r.rank(indexString, ranking.structure.index));
				}
				else
				errorIndex.setText("Please provide a nonempty input");
			}
		});
		btnRankedRetrieval.setBounds(404, 37, 147, 21);
		panel.add(btnRankedRetrieval);
		
		JButton btnNewButton_2 = new JButton("Single Term Search"); //Index
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String indexString = textField.getText().toLowerCase().trim();
				if(!indexString.isBlank()){
					textArea.setText(ind.search(indexString));
				}
				else
				errorIndex.setText("Please provide a nonempty input");
			}
		});
		btnNewButton_2.setBounds(561, 37, 147, 21);
		panel.add(btnNewButton_2);
		

		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Inverted Index", null, panel_1, null);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField(); //Inv Index
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setColumns(10);
		textField_1.setBounds(10, 41, 227, 19);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Query: Inverted Index");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 5, 640, 26);
		panel_1.add(lblNewLabel_1);
		
		JLabel errorInverted = new JLabel("");
		errorInverted.setForeground(Color.RED);
		errorInverted.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorInverted.setBounds(10, 70, 200, 13);
		panel_1.add(errorInverted);

		JButton btnSearchWithInverted = new JButton("Boolean Retrieval"); //Inv Index
		btnSearchWithInverted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearchWithInverted.setBounds(243, 40, 164, 21);
		panel_1.add(btnSearchWithInverted);
		
		JTextArea textArea_1 = new JTextArea(); //Inv Index
		textArea_1.setBounds(10, 91, 808, 335);
		panel_1.add(textArea_1);
		
		JButton btnNewButton_1_1 = new JButton("Clear All"); //Inv Index
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textArea_1.setText("");
			}
		});
		btnNewButton_1_1.setBounds(733, 40, 85, 21);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnRankedRetrieval_1 = new JButton("Ranked Retrieval"); //Inv Index
		btnRankedRetrieval_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String InvindexString = textField_1.getText().toLowerCase().trim();
				if(!InvindexString.isBlank()){
					textArea_1.setText(r.rank(InvindexString, ranking.structure.invertedIndex));
				}
				else
				errorInverted.setText("Please provide a nonempty input");
			}
		});
		btnRankedRetrieval_1.setBounds(417, 40, 147, 21);
		panel_1.add(btnRankedRetrieval_1);
		
		JButton btnNewButton_2_1 = new JButton("Single Term Search"); //Inv Index
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String InvindexString = textField_1.getText().toLowerCase().trim();
				if(!InvindexString.isBlank()){
					textArea_1.setText(ivner.search(InvindexString));
				}
				else
				errorInverted.setText("Please provide a nonempty input");
			}
		});
		btnNewButton_2_1.setBounds(574, 40, 147, 21);
		panel_1.add(btnNewButton_2_1);
		

		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Inverted Index BST", null, panel_2, null);
		panel_2.setLayout(null);
		
		textField_2 = new JTextField(); //IIBST
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setColumns(10);
		textField_2.setBounds(10, 38, 227, 19);
		panel_2.add(textField_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter Query Inverted Index BST");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(10, 10, 493, 26);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel errorBST = new JLabel("");
		errorBST.setForeground(Color.RED);
		errorBST.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorBST.setBounds(10, 67, 200, 13);
		panel_2.add(errorBST);

		JTextArea textArea_2 = new JTextArea(); //IIBST
		textArea_2.setBounds(10, 91, 808, 335);
		panel_2.add(textArea_2);

		JButton btnSearchWithInverted_1 = new JButton("Boolean Retrieval"); //IIBST
		btnSearchWithInverted_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSearchWithInverted_1.setBounds(247, 37, 147, 21);
		panel_2.add(btnSearchWithInverted_1);
		

		
		JButton btnNewButton_1_2 = new JButton("Clear All"); //IIBST
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText("");
				textArea_2.setText("");
			}
		});
		btnNewButton_1_2.setBounds(733, 37, 85, 21);
		panel_2.add(btnNewButton_1_2);
		
		JButton btnRankedRetrieval_2 = new JButton("Ranked Retrieval"); //IIBST
		btnRankedRetrieval_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String BSTString = textField_2.getText().toLowerCase().trim();
				if(!BSTString.isBlank()){
					textArea_2.setText(r.rank(BSTString,ranking.structure.invertedIndexBST));
				}
				else
				errorBST.setText("Please provide a nonempty input");
			}
		});
		btnRankedRetrieval_2.setBounds(404, 37, 147, 21);
		panel_2.add(btnRankedRetrieval_2);
		
		JButton btnNewButton_2_2 = new JButton("Single Term Search"); //IIBST
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String BSTString = textField_2.getText().toLowerCase().trim();
				if(!BSTString.isBlank()){
					textArea_2.setText(BST.search(BSTString));
				}
				else
				errorBST.setText("Please provide a nonempty input");
			}
		});
		btnNewButton_2_2.setBounds(561, 37, 147, 21);
		panel_2.add(btnNewButton_2_2);
		

		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Hashing", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblEnterQueryHashing = new JLabel("Enter Query: Hashing");
		lblEnterQueryHashing.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterQueryHashing.setBounds(10, 10, 279, 26);
		panel_4.add(lblEnterQueryHashing);
		
		textField_4 = new JTextField(); //HASHING
		textField_4.setHorizontalAlignment(SwingConstants.LEFT);
		textField_4.setColumns(10);
		textField_4.setBounds(10, 46, 227, 19);
		panel_4.add(textField_4);
		
		JLabel errorHASHING = new JLabel("");
		errorHASHING.setForeground(Color.RED);
		errorHASHING.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorHASHING.setBounds(10, 75, 200, 13);
		panel_4.add(errorHASHING);

		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(10, 91, 808, 335);
		panel_4.add(textArea_4);

		JButton btnNewButton_3 = new JButton("Boolean Retrieval"); //HASHING
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(262, 46, 147, 21);
		panel_4.add(btnNewButton_3);
		
		JButton btnRankedRetrieval_3 = new JButton("Ranked Retrieval"); //HASHING
		btnRankedRetrieval_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String HString = textField_4.getText().toLowerCase().trim();
				if(!HString.isBlank()){
					textArea_4.setText(r.rank(HString,ranking.structure.hashMap));
				}
				else
				errorHASHING.setText("Please provide a nonempty input");
			}
		});
		btnRankedRetrieval_3.setBounds(419, 45, 147, 21);
		panel_4.add(btnRankedRetrieval_3);
		

		
		JButton btnNewButton_1_3 = new JButton("Clear All"); //HASHING
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_4.setText("");
				textArea_4.setText("");
				
			}
		});
		btnNewButton_1_3.setBounds(733, 45, 85, 21);
		panel_4.add(btnNewButton_1_3);
		
		JButton btnNewButton_2_3 = new JButton("Single Term Search"); //HASHING
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String HString = textField_4.getText().toLowerCase().trim();
				if(!HString.isBlank()){
					textArea_4.setText(hash.search(HString));
				}
				else
				errorHASHING.setText("Please provide a nonempty input");
			}
		});
		btnNewButton_2_3.setBounds(576, 45, 147, 21);
		panel_4.add(btnNewButton_2_3);
		

	}
}
