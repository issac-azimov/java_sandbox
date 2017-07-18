public class Planet {
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;

	public Planet( double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		this(p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);
	}

	public double calcDistance(Planet p2) {
		return Math.sqrt( (this.xxPos - p2.xxPos)*(this.xxPos - p2.xxPos) + (this.yyPos - p2.yyPos)*(this.yyPos - p2.yyPos));
	}

	public double calcForceExertedBy(Planet p2) {
		double gravity = 6.67e-11;

		return (gravity*this.mass*p2.mass)/(this.calcDistance(p2)*this.calcDistance(p2));
	}

	public double calcNetForceExertedByX(Planet[] pArray) {
		double xNetForce = 0;
		//F*dx/r
		for (int i = 0; i < pArray.length; i++) {
			if (!this.equals(pArray[i])) {
				double dx =  this.xxPos - pArray[i].xxPos;
				xNetForce += (this.calcForceExertedBy(pArray[i])*dx)/(this.calcDistance(pArray[i]));	
			} 
		}
		return xNetForce;
	}

	public double calcNetForceExertedByY(Planet[] pArray) {
		double yNetForce = 0;
		for (int i = 0; i < pArray.length; i++) {
			if (!this.equals(pArray[i])) {
				double dy = this.yyPos - pArray[i].yyPos;
				yNetForce += (this.calcForceExertedBy(pArray[i])*dy)/(this.calcDistance(pArray[i]));
			} 
		}
		return yNetForce;
	}

	public void update(double dt, double fX, double fY) {
		//aX = fX/m aY = FY/m
		
		double aX = fX/this.mass;
		double aY = fY/this.mass;
		this.xxVel = this.xxVel + dt*aX;
		this.yyVel = this.yyVel + dt*aY;
		this.xxPos = this.xxPos + dt*this.xxVel;
		this.yyPos = this.yyPos + dt*this.yyVel;
		

	}

	public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);
	}
}
