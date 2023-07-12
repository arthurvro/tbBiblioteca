package view.paineis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class TelaAlerta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnNewButton;
	private JLabel lblAlerta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaAlerta dialog = new TelaAlerta("");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaAlerta(String mensagem) {
		setTitle("ATENÇÃO !");
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 128, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setModal(true);		
		setResizable(false);
		setLocationRelativeTo(null);
		
		lblAlerta = new JLabel(mensagem);
		lblAlerta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblAlerta.setBounds(10, 101, 414, 77);
		contentPanel.add(lblAlerta);
		
		btnNewButton = new JButton("OK");
		btnNewButton.setBackground(new Color(0, 221, 221));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAlerta.this.dispose();
			}
		});
		btnNewButton.setBounds(174, 214, 89, 23);
		contentPanel.add(btnNewButton);
		
		JLabel lblIconAlerta = new JLabel("New label");
		lblIconAlerta.setIcon(new ImageIcon(TelaAlerta.class.getResource("/icons/iconAlerta.png")));
		lblIconAlerta.setBounds(190, 11, 65, 52);
		contentPanel.add(lblIconAlerta);
		
		JLabel lblNewLabel = new JLabel("ATENÇÃO !");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(174, 74, 108, 34);
		contentPanel.add(lblNewLabel);
	}
}
