import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class MM {

	public static final int TIMEOUT = 120_000;
	public static final int MIN = -1;
	public static final int MAX = 1;

	public static void main(String[] args) throws Exception {

		if (args[0].equals("start")) {

			System.out.println("started!");
			
			Robot robot = new Robot();
			Point mouseLocation;
			Point lastLocation = new Point(0, 0);

			while (true) {

				mouseLocation = MouseInfo.getPointerInfo().getLocation();

				int xLocation = (int) mouseLocation.getX();
				int yLocation = (int) mouseLocation.getY();

				int xMove = getRandomFromRange(MIN, MAX);
				int yMove = getRandomFromRange(MIN, MAX);

				int xTarget = xLocation + xMove;
				int yTarget = yLocation + yMove;

				boolean shouldMove = Objects
						.equals(mouseLocation, lastLocation);

				/*
				 * System.out.println("mouseLocation = " + mouseLocation );
				 * System.out.println("lastLocation = " + lastLocation);
				 */

				if (shouldMove) {
					robot.mouseMove(xTarget, yTarget);

					System.out.println(LocalDateTime.now().toString() + " mm: "
							+ "(" + xMove + ", " + yMove + "); " + "mm to: ("
							+ xTarget + ", " + yTarget + ")");
				}

				lastLocation = mouseLocation;

				Thread.sleep(TIMEOUT);

			}
		}else{
			System.out.println("Wrong argument: " + args[0]+"; expected: start");
		}
	}

	private static int getRandomFromRange(int min, int max) {
		int random = new Random().nextInt(max - min + 1) + min;
		return random == 0 ? 1 : random;
		// return random;
	}

}
