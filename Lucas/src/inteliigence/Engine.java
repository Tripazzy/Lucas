package inteliigence;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Engine {

	public static int random(int min, int max) {
		return (int) (Math.random() * (max + min));
	}
	
	public static void waitUntil(boolean waituntil) {
		while (!waituntil) {};
	}
	
	public static void showframe(JFrame frame) {
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	public static int power(int number, int powers) {
		while (powers > 1) {
			number = number * number;
			powers--;
		}
		return number;
	}
	
	public static void textOut(String text) {
		System.out.println(text);
	}
	
	public static void intOut(int text) {
		System.out.println(Integer.toString(text));
	}
	
	public static boolean ifIn(String text, String inside) {
		return text.replace(inside.toLowerCase(), "") != text;
	}
	
	public static void addNull(JFrame frame) {
		frame.add(new JPanel());
	}
	
	public static boolean divisable(int is, int div) {
		return (is / div) * div == is;
	}
	
	public static void exit(JFrame frame) {
		frame.dispose();
	}
	
}
