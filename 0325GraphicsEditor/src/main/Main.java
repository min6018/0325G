package main;

public class Main {

	static private MainFrame mainFrame;
	
	public static void main(String[] args) {
		mainFrame = new MainFrame();
		mainFrame.setVisible(true); //코드시작 루핑(polling)돈다, paint라는 이벤트
	}
}
