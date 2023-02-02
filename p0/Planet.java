import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

/**
 * CS 121 Project 0: Traffic Animation
 *
 * Declares the Planet class for use in Traffic Animation.
 *
 * @author Isaac Denny
 */

public class Planet {
  private Point _anchor;
  private Graphics _g;
  private int _size;
  private Color _color;
  private Boolean _hasRing;
  int _ringSizeY;
  int _ringSizeX;

  public Planet(Graphics g, Point anchor, int size, Color color, Boolean hasRing) {
    _anchor = anchor;
    _g = g;
    _size = size;
    _color = color;
    _hasRing = hasRing;
    _ringSizeX = size * 2;
    _ringSizeY = size / 2;
  }
  
  public Point GetPosition() {
    return _anchor;
  }

  public Color GetColor() {
    return _color;
  }

  public Point GetRingSize() {
    return new Point(_ringSizeX, _ringSizeY);
  }

  public Boolean GetHasRing() {
    return _hasRing;
  }

  public int GetSize() {
    return _size;
  }

  public void Draw() {
    _g.setColor(_color);
		_g.fillOval(_anchor.x, _anchor.y, _size, _size);
		if (_hasRing) {
			_g.setColor(Color.WHITE);
			_g.drawOval(_anchor.x - _size / 2, _anchor.y + _ringSizeY / 2, _ringSizeX, _ringSizeY);
			_g.setColor(_color);
			_g.fillArc(_anchor.x, _anchor.y, _size, _size, 0, 180);
		}
  }
}
