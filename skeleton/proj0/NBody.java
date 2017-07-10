public class NBody {
	public static double readRadius(String fileName) {
		In file = new In(fileName);
		double radius = 0;
		int i = 0;
		while(i < 2) {
			radius = file.readDouble();
			i++;
		}
		return radius;
	}

	public static Planet[] readPlanets(String fileName) {
		In file = new In(fileName);
		int numPlanets = file.readInt();
		double radius = file.readDouble();
		Planet[] pArray = new Planet[numPlanets];
		for (int i = 0; i < numPlanets; i++) {
			double xxPos = file.readDouble();
			// System.out.println(xxPos);
			double yyPos = file.readDouble();
			// System.out.println(yyPos);
			double xxVel = file.readDouble();
			// System.out.println(xxVel);
			double yyVel = file.readDouble();
			// System.out.println(yyVel);			
			double mass = file.readDouble();
			// System.out.println(mass);			
			String imgFileName = file.readString();
			// System.out.println(imgFileName);			
			pArray[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}
		return pArray;
	}

	public static void main(String[] args) {

	}
}