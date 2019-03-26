package main;
import java.awt.BorderLayout;

import javax.swing.JFrame;

import drawingPanel.DrawingPanel;
import global.Constants.EMainFrame;
import menu.MenuBar;
import toolbar.ToolBar;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// components(new�ؾ� �ڽ��̴�)
	private MenuBar menuBar;
	private ToolBar toolBar;
	private DrawingPanel drawingPanel;
	
	public MainFrame() { //�Ӽ��� ������ �ȿ���
		// attributes(�Ӽ�)
		this.setLocation(EMainFrame.x.getValue(), EMainFrame.y.getValue());
		this.setSize(EMainFrame.w.getValue(), EMainFrame.h.getValue());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// components(�ڽĵ�)
		this.menuBar = new MenuBar();
		this.setJMenuBar(this.menuBar); //new�ؼ� ����� �ڽĵ��
		
		this.setLayout(new BorderLayout());
		this.toolBar = new ToolBar();
		this.add(toolBar, BorderLayout.NORTH);
		
		this.drawingPanel = new DrawingPanel();
		this.add(this.drawingPanel, BorderLayout.CENTER);
		
		// associations(�ڽĵ� ����) ����⿬���� �ϸ� �� �ȴ�(����Ŭ�� ����� �� �ȴ�)
		this.menuBar.associate(this.drawingPanel);
		this.toolBar.associate(this.drawingPanel);
	}
}
