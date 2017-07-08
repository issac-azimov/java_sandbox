public class drawTriangleN {
	static String starter = "*";

	public static void draw(String starter, int N) {
		String pstart = "*";
		for (int i = 0; i < N; i ++) {
			System.out.print(pstart + "\n");
			pstart = pstart + starter;
		}
	}

	public static void main(String[] args) {
		draw(drawTriangle.starter, Integer.parseInt(args[0]));
	}
}