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

	// associations(ģ��, ���� : �ڽľƴ�)
	private DrawingPanel drawingPanel;

	public void associate(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public ToolBar() {
		ActionHandler actionHandler = new ActionHandler();

		this.buttons = new Vector<JButton>();
		for (EToolBar eToolBar: EToolBar.values()) { //values : object�ϳ��ϳ��� array
			JButton button = new JButton(eToolBar.getText());
			button.setActionCommand(eToolBar.name());
			button.addActionListener(actionHandler);
			this.buttons.add(button);
			this.add(button); //�θ����� �ڱ⸦ ��Ͻ�Ų ��
		}
	}

	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) { 
			drawingPanel.setCurrentTool(EToolBar.valueOf(event.getActionCommand())); //()���� ���� ã�Ƽ� �����ض�
		}
	}
}
//� ��ư�� ���ȴ����� �˷��ִ� �ڵ�� �ٲ���