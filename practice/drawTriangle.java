public class drawTriangle {
	static String starter = "*";

	public static void draw(String starter) {
		String pstart = "*";
		for (int i = 1; i < 6; i ++) {
			System.out.print(pstart + "\n");
			pstart = pstart + starter;
		}
	}

	public static void main(String[] args) {
		draw(drawTriangle.starter);
	}
}