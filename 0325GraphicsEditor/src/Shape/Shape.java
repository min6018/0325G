package Shape;

import java.awt.Graphics;

public abstract class Shape {
	protected int x1, y1, x2, y2;
	
	public void setOrigin(int x, int y) { //���� ����
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
	}
	public void setPoint(int x, int y) { //�����̴� ��ǥ ����
		this.x2 = x;
		this.y2 = y;
	}
	public void addPoint(int x, int y) { 
		
	}
	abstract public void draw(Graphics graphics);
}
