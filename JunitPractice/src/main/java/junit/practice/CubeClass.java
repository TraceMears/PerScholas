package junit.practice;

public class CubeClass {
	
	private Integer cubeLength;
	private Integer cubeWidth;
	private Integer cubeHeight;
	
	public CubeClass() {
		
	}
	public CubeClass(Integer l, Integer w, Integer h) {
		this.cubeLength = l;
		this.cubeWidth = w;
		this.cubeHeight = h;
	}
	
	public Integer calculateVolume() {
		return this.cubeHeight * this.cubeLength * this.cubeWidth;
	}
	
}
