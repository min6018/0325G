package toolbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JToolBar;

import drawingPanel.DrawingPanel;
import global.Constants.EToolBar;

public class ToolBar extends JToolBar {
	private static final long serialVersionUID = 1L;

	// Components
	private Vector<JButton> buttons;

	// associations(친구, 형제 : 자식아님)
	private DrawingPanel drawingPanel;

	public void associate(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public ToolBar() {
		ActionHandler actionHandler = new ActionHandler();

		this.buttons = new Vector<JButton>();
		for (EToolBar eToolBar: EToolBar.values()) { //values : object하나하나의 array
			JButton button = new JButton(eToolBar.getText());
			button.setActionCommand(eToolBar.name());
			button.addActionListener(actionHandler);
			this.buttons.add(button);
			this.add(button); //부모한테 자기를 등록시킨 것
		}
	}

	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) { 
			drawingPanel.setCurrentTool(EToolBar.valueOf(event.getActionCommand())); //()안의 값을 찾아서 실행해라
		}
	}
}
//어떤 버튼이 눌렸는지만 알려주는 코드로 바꾸자