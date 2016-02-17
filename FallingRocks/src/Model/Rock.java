package Model;

public class Rock {
	
	private int x;
	private int y;
	private int rockSize;
	
	public Rock(int x, int rockSize) {
		y = 0;
		this.x = x;
		this.rockSize = rockSize;		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRockSize() {
		return rockSize;
	}
	
	public void updatePosition() {
		y += 1;		
	}
	
	
	
	

}
