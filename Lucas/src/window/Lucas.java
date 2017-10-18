package window;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import inteliigence.Response;

public class Lucas {
	public static GridLayout layout = new GridLayout(0, 1);
	public static JTextField input = new JTextField();
	public static JButton send = new JButton("Speak");
	public static JLabel output = new JLabel("");
	public static JFrame frame = new JFrame();
	public static Scanner lengthtext = new Scanner(System.in);
	
	public Lucas() {
		frame.setLayout(layout);
		
		frame.add(output);
		frame.add(input);
		frame.add(send);
		
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setVisible(true);
		
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.setText(Response.generate(input.getText()));
			}
		});
	}
	
	public static void main(String[] args) {
		new Lucas();
	}
}
