package exam;

/*
	문제) 태양계 행성을 나타내는 enum Planet을 이용하여 구하시오.
	(단, enum 객체 생성시 반지름을 이용하도록 정의하시오.) 
	
	예) 행성의 반지름(KM):
	수성(2439), 
	금성(6052), 
	지구(6371), 
	화성(3390), 
	목성(69911), 
	토성(58232), 
	천왕성(25362), 
	해왕성(24622)
 */



/**
 * @author PC-01
 * 행성의 반지름을 받아와서 표면적을 구하는 클래스
 */
class Surface {
	
	public double Surface(int radius) {
		double surface = 4*(Math.PI)* radius*radius;
		return surface;
	}
}


/**
 * @author PC-01
 * 행성의 반지름을 받아와서 부피를 구하는 클래스
 */
class Volume{
	public double Volume(int radius) {
		double volume = 4/3*(Math.PI)* radius*radius*radius;
		return volume;
		
	}
}

public class PlanetTest {
	public enum Planet{
		수성(2439), 
		금성(6052), 
		지구(6371), 
		화성(3390), 
		목성(69911), 
		토성(58232), 
		천왕성(25362), 
		해왕성(24622);
		
		private int num;
		
		private Planet(int num) {
			this.num = num;
		}
		
		public int getR(){
			return num;
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("태양계 행성 순서별 이름과 반지름, 그리고 표면적과 부피");
		System.out.println("------------------------------");
		System.out.println("검색해보슈");
		Surface sur = new Surface();
		Volume vol = new Volume();
		
		Planet[] planet = Planet.values();
		for (int i = 0; i < planet.length; i++) {
		
			System.out.println(planet[i].ordinal()+1 + "."+ planet[i].name());
			System.out.print("반지름 : ");
			System.out.println(planet[i].getR());
			System.out.print("표면적 : ");
			System.out.printf("%f\n",sur.Surface(planet[i].getR()));
			System.out.print("부피 : ");
			System.out.printf("%f\n",vol.Volume(planet[i].getR()));
			System.out.println("------------------------------");
			
		}
	}
}

