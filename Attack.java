import engine.Actor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Attack extends Actor {
	private double width, height;
	private long birthTime = -1;
	public Attack (double x, double y, double width, double height, boolean flip, boolean down)
	{
		setX(x);
		setY(y);
		this.width = width;
		this.height = height;
		String thing = flip ? "rsword" : "sword";
		if (down)
			thing = "dsword";
		String path = getClass().getClassLoader().getResource("resources/"+thing+".png").toString();
		Image img = new Image(path);
		this.setImage(img);
		this.setFitWidth(width);
		this.setFitHeight(height);
	}
	public double getWidth()
	{
		return width;
	}
	public double getHeight()
	{
		return height;
	}
	@Override
	public void act(long now) {
		if (birthTime == -1)
			birthTime = now;
		if (now - birthTime > 1e5)
			getWorld().remove(this);
	}
}