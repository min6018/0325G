package drawingPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import Shape.Shape;
import global.Constants.EToolBar;
//������ ��纰�� �������Ѵ�, �����̶�� �������� ���ս��Ѿ� ��
public class DrawingPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private MouseHandler mouseHandler;
	
	private Shape currentTool;
	public void setCurrentTool(EToolBar currentTool) {
		this.currentTool = currentTool.getShape();
	}

	public DrawingPanel() {
		this.setBackground(Color.WHITE);
		this.mouseHandler = new MouseHandler();
		this.addMouseListener(this.mouseHandler);
		this.addMouseMotionListener(this.mouseHandler);
		
		currentTool = EToolBar.rectangle.getShape();
	}

	private void drawShape() { // Graphics : �ü���� ������ �ִ� ���ձ׸�����, �ü���� ���� ���� �״�� �޾ƿͼ� ���.
		Graphics graphics = this.getGraphics(); // mainframe���� �޾ƿ� �׸������� �ҷ����� ��
		graphics.setXORMode(getBackground());
		this.currentTool.draw(graphics); //���� �׸���
	}
	
	private void initDrawing(int x, int y) {
		this.currentTool.setOrigin(x, y);
		this.drawShape();
	}
	
	private void keepDrawing(int x, int y) { // n-1 ~ n������ ���� �̾��ִ� 
		this.drawShape();
		this.currentTool.setPoint(x, y); //��ǥ�̵�(�����̰�)
		this.drawShape();
	}
	
	private void continueDrawing(int x, int y) { // n�� �����ִ�
		this.currentTool.addPoint(x, y); //�߰� �� ��� 
	}
	
	private void finishDrawing(int x, int y) {
		this.drawShape();
		this.currentTool.setPoint(x, y); //setPoint : ������ �� ��� ��
		this.drawShape();
	}// �������� ������ ���� �����̴� (���� ����)

	private class MouseHandler implements MouseListener, MouseMotionListener { // �巡�� : ���� ���� ����ϱ� (������ �������� ����)
		// ���콺�ڵ鷯�� ���������� �ϴ� ������ ���̳� ������ �־ ����ϰ� �ϸ� ���� ���� �ڵ��̴�
		//private int x0, y0, x1, y1; //Shape�� ����ϴ� ��ǥ�̹Ƿ� Shape�� ������ ����ִ� ���� ����

		@Override
		public void mouseClicked(MouseEvent e) { // Pressed�� Released�� ���� ��ġ���� �߻��� ��
			if(e.getClickCount() == 1) {
				initDrawing(e.getX(), e.getY()); //ó�����̸� �̴�, �ι�°���� ��Ƽ�� ȣ���ϱ�
			} else if(e.getClickCount() == 2) {
				finishDrawing(e.getX(), e.getY());
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {
			initDrawing(e.getX(), e.getY());
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			finishDrawing(e.getX(), e.getY());
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			keepDrawing(e.getX(), e.getY());
		}
			// ����ٴ� ���� �� ���� ����� �ٽ� �׸��� ���̴�, ����� �׷��� ���ִ� ������ ĥ�ϴ� ���� �ƴϴ� (��׶���(���)�� ������ �ٽ�
			// �׷���)

		@Override
		public void mouseMoved(MouseEvent e) {
			// ŵ������ϱ�
		}
	}
}
//