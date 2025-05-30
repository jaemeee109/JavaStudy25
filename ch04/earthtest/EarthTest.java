package ch04.earthtest;

public class EarthTest {

	static final double PI = 3.14159;
	static final double EARTH_RADIUS = 6400;
	static final double EARTH_SURFACE_AREA ;
	
	static {
		EARTH_SURFACE_AREA = 4* PI * EARTH_RADIUS * EARTH_RADIUS ;
		//생성자를 통해 final에 값을 넣음
	}
}
