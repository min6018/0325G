package Shape;

import java.awt.Graphics;

public class Select extends Shape {
	public void draw(Graphics graphics) {
		graphics.drawRect(x1, y1, x2-x1, y2-y1);
	}
}
