package drawingPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import Shape.Shape;
import global.Constants.EToolBar;
//구조를 모양별로 나눠야한다, 도형이라는 개념으로 통합시켜야 함
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

	private void drawShape() { // Graphics : 운영체제가 가지고 있는 종합그림도구, 운영체제가 가진 것을 그대로 받아와서 사용.
		Graphics graphics = this.getGraphics(); // mainframe에서 받아온 그림도구를 불러오는 것
		graphics.setXORMode(getBackground());
		this.currentTool.draw(graphics); //원점 그리기
	}
	
	private void initDrawing(int x, int y) {
		this.currentTool.setOrigin(x, y);
		this.drawShape();
	}
	
	private void keepDrawing(int x, int y) { // n-1 ~ n까지의 점을 이어주는 
		this.drawShape();
		this.currentTool.setPoint(x, y); //좌표이동(움직이고)
		this.drawShape();
	}
	
	private void continueDrawing(int x, int y) { // n을 정해주는
		this.currentTool.addPoint(x, y); //중간 점 찍는 
	}
	
	private void finishDrawing(int x, int y) {
		this.drawShape();
		this.currentTool.setPoint(x, y); //setPoint : 마지막 점 찍는 거
		this.drawShape();
	}// 폴리건은 마지막 점이 원점이다 (닫힌 도형)

	private class MouseHandler implements MouseListener, MouseMotionListener { // 드래그 : 넓이 높이 계산하기 (끝점과 시작점의 차이)
		// 마우스핸들러는 교통정리를 하는 것이지 값이나 로직을 넣어서 계산하게 하면 좋지 않은 코드이다
		//private int x0, y0, x1, y1; //Shape이 사용하는 좌표이므로 Shape안 쪽으로 집어넣는 것이 좋다

		@Override
		public void mouseClicked(MouseEvent e) { // Pressed와 Released가 같은 위치에서 발생한 것
			if(e.getClickCount() == 1) {
				initDrawing(e.getX(), e.getY()); //처음점이면 이닛, 두번째부턴 컨티뉴 호출하기
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
			// 지운다는 것은 그 위에 배경을 다시 그리는 것이다, 배경을 그려서 없애는 것이지 칠하는 것이 아니다 (백그라운드(배경)의 색으로 다시
			// 그려라)

		@Override
		public void mouseMoved(MouseEvent e) {
			// 킵드로잉하기
		}
	}
}
//