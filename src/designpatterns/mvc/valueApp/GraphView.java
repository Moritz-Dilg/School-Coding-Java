package designpatterns.mvc.valueApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GraphView extends JComponent {

	// constants for drawing
	private static final int TEXT_ADJ = 5;
	private static final int PREF_HEIGHT = 200;
	private static final int PREF_WIDTH = 70;
	private static final int MAJOR_TICK_LENGTH = 4;
	private static final int MINOR_TICK_LENGTH = 2;
	private static final int Y_BORDER = 10;
	private static final int X_POS = 26;
	private static final int ARR_LENGTH = 20;
	private static final int ARR_HEIGHT = 4;

	private final ValueModel model;

	// bounds and ticks
	private int bound;
	private int nMajorTicks;
	private int nMinorTicks;

	// variables for dragging
	private boolean dragging;
	private int draggedValue;

	public GraphView(ValueModel model) {
		this.model = model;
		model.addValueChangeListener(valueListener);

		this.addMouseListener(mouseHandler);
		this.addMouseMotionListener(mouseHandler);

		// Initialize the calculated bound fields.
		calcBounds();

		setPreferredSize(new Dimension(PREF_WIDTH, PREF_HEIGHT));
		setBorder(BorderFactory.createEtchedBorder());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// The middle point
		int m = getHeight() / 2;
		// The height that we want to use for the positive and negative half
		int h = m - Y_BORDER;

		// Draw main line
		g.drawLine(X_POS, m - h, X_POS, m + h);

		// Draw main ticks
		drawTicks(g, m, h, nMajorTicks, MAJOR_TICK_LENGTH);

		// Draw small ticks
		drawTicks(g, m, h, nMinorTicks, MINOR_TICK_LENGTH);

		// Draw numbers
		int xText = X_POS + 2 * MAJOR_TICK_LENGTH;
		g.drawString(Integer.toString(bound), xText, m - h + TEXT_ADJ);
		g.drawString(Integer.toString(-bound), xText, m + h + TEXT_ADJ);
		g.drawString("0", xText, m + TEXT_ADJ);

		// Draw value arrow
		int y = getPosFromValue(model.getValue());
		g.drawLine(X_POS - ARR_LENGTH, y, X_POS - MAJOR_TICK_LENGTH, y);
		g.drawLine(X_POS - MAJOR_TICK_LENGTH - ARR_HEIGHT, y - ARR_HEIGHT, X_POS - MAJOR_TICK_LENGTH, y);
		g.drawLine(X_POS - MAJOR_TICK_LENGTH - ARR_HEIGHT, y + ARR_HEIGHT, X_POS - MAJOR_TICK_LENGTH, y);

		// Draw dragged value
		if (dragging) {
			y = getPosFromValue(draggedValue);
			Color prev = g.getColor();
			g.drawString(Integer.toString(draggedValue), xText, y + TEXT_ADJ);
			g.setColor(Color.GRAY);
			g.drawLine(X_POS - ARR_LENGTH, y, X_POS - MAJOR_TICK_LENGTH, y);
			g.drawLine(X_POS - MAJOR_TICK_LENGTH - ARR_HEIGHT, y - ARR_HEIGHT, X_POS - MAJOR_TICK_LENGTH, y);
			g.drawLine(X_POS - MAJOR_TICK_LENGTH - ARR_HEIGHT, y + ARR_HEIGHT, X_POS - MAJOR_TICK_LENGTH, y);
			g.setColor(prev);
		}
	}

	private void drawTicks(Graphics g, int m, int h, int nMajorTicks, int majorTickLength) {
		for (int i = 0; i <= nMajorTicks; i++) {
			int o = h * i / nMajorTicks;
			g.drawLine(X_POS - majorTickLength, m + o, X_POS + majorTickLength, m + o);
			g.drawLine(X_POS - majorTickLength, m - o, X_POS + majorTickLength, m - o);
		}
	}

	private int getPosFromValue(int value) {
		int m = getHeight() / 2;
		int h = m - Y_BORDER;
		return m - h * value / bound;
	}

	private int getValueFromPos(int y) {
		int m = getHeight() / 2;
		int h = m - Y_BORDER;
		int yNorm = - (y - m);
		double valD = bound * yNorm / (double) h;
		return (int)Math.round(valD);
	}

	private void calcBounds() {
		// Use absolute value because drawing is always symmetric.
		int val = Math.abs(model.getValue());

		if (val < 10) {
			bound = 10;
			nMajorTicks = 10;
			nMinorTicks = 10;
		} else {
			int log10 = (int) Math.log10(val);
			int pow10 = (int) Math.pow(10, log10);
			int firstDigit = val / pow10;

			if (firstDigit < 2) {
				bound = pow10 * 2;
				nMajorTicks = 4;
				nMinorTicks = 20;
			} else if (firstDigit < 5) {
				bound = pow10 * 5;
				nMajorTicks = 5;
				nMinorTicks = 25;
			} else {
				bound = pow10 * 10;
				nMajorTicks = 10;
				nMinorTicks = 20;
			}
		}
	}

	private ValueChangeListener valueListener = new ValueChangeListener() {
		@Override
		public void valueChanged(ValueChangeEvent e) {
			calcBounds();
			repaint();
		}
	};

	private MouseAdapter mouseHandler = new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent me) {
		}

		@Override
		public void mousePressed(MouseEvent me) {
			System.out.println("Pressed");
			dragging = true;
			draggedValue = getValueFromPos(me.getY());
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent me) {
			System.out.println("Released");
			int value = getValueFromPos(me.getY());
			model.setValue(value);
			dragging = false;
		}

		@Override
		public void mouseDragged(MouseEvent me) {
			System.out.println("Dragged");
			draggedValue = getValueFromPos(me.getY());
			repaint();
		}

	};
}
