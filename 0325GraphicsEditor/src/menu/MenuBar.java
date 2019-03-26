package menu;
import javax.swing.JMenuBar;

import drawingPanel.DrawingPanel;
import global.Constants.EMenu;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	
	private FileMenu fileMenu; // 이 클래스내에서 다른 함수에서 쓰일 가능성이 있기 때문에 위로 올려 노출시킨 것
	
	// associations
	private DrawingPanel drawingPanel;
	public void associate(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}
	
	public MenuBar() {
		this.fileMenu = new FileMenu(EMenu.fileMenu.getText());
		this.add(this.fileMenu);
	}
}
