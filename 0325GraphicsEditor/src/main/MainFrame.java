package main;
import java.awt.BorderLayout;

import javax.swing.JFrame;

import drawingPanel.DrawingPanel;
import global.Constants.EMainFrame;
import menu.MenuBar;
import toolbar.ToolBar;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// components(new해야 자식이다)
	private MenuBar menuBar;
	private ToolBar toolBar;
	private DrawingPanel drawingPanel;
	
	public MainFrame() { //속성은 무조건 안에서
		// attributes(속성)
		this.setLocation(EMainFrame.x.getValue(), EMainFrame.y.getValue());
		this.setSize(EMainFrame.w.getValue(), EMainFrame.h.getValue());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// components(자식들)
		this.menuBar = new MenuBar();
		this.setJMenuBar(this.menuBar); //new해서 만들고 자식등록
		
		this.setLayout(new BorderLayout());
		this.toolBar = new ToolBar();
		this.add(toolBar, BorderLayout.NORTH);
		
		this.drawingPanel = new DrawingPanel();
		this.add(this.drawingPanel, BorderLayout.CENTER);
		
		// associations(자식들 연결) 양방향연결은 하면 안 된다(사이클이 생기면 안 된다)
		this.menuBar.associate(this.drawingPanel);
		this.toolBar.associate(this.drawingPanel);
	}
}
