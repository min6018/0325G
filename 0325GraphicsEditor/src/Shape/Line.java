package Shape;

import java.awt.Graphics;

public class Line extends Shape {
	public void draw(Graphics graphics) {
		graphics.drawLine(x1, y1, x1+x2, y1+y2);

	}
}