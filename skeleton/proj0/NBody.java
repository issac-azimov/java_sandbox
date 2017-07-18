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
			// System.out.println(xxVearl);
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
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet planetArray[] =  readPlanets(filename);
		double radius = readRadius(filename);
		
		//universe
		StdDraw.setScale(-radius, radius);
		StdAudio.play("./audio/2001.mid");
		

		double[] xForces = new double[planetArray.length];
		double[] yForces = new double[planetArray.length];
		

		double time = 0;
		while (time < T) {
			
			StdDraw.picture(0,0,"./images/starfield.jpg");

			
			for (int i = 0; i < planetArray.length; i++) {
				
				xForces[i] = planetArray[i].calcNetForceExertedByX(planetArray);
				yForces[i] = planetArray[i].calcNetForceExertedByY(planetArray);

			}
			for (int i = 0; i < planetArray.length; i++) {
				planetArray[i].update(dt, -xForces[i], -yForces[i]);
			}

			for (Planet planet : planetArray) {
				planet.draw();
			}

			StdDraw.show(10);
			time = time + dt;
		}
	}
}