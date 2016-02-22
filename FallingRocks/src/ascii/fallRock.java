package ascii;

import java.util.TimerTask;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class fallRock extends TimerTask {

	// Generate random number btwn 0-40 for rock location
	Random randomInt = new Random();
	int xpos = randomInt.nextInt(40);
	
	

	// Create new rock with xpos
	Rock rock = new Rock(xpos * 2, 1);

	@Override
	public void run() {

		Person myPerson = ASCIIScreen.person;
		// Create new timer to drop the rock

		while (rock.getY() < 30) {
			try {
				if (!ASCIIScreen.getIsTerminated()){
					rock.updateYPosition();
					rock.updatePosition();
				}
				TimeUnit.MILLISECONDS.sleep(100);        //Change to make rock go faster/slower

				if ((rock.getY() == 22 || rock.getY() == 23 || rock.getY() == 21)
						&& (rock.getX() == myPerson.getX() || rock.getX() + 1 == myPerson.getX())) {
					ASCIIScreen.terminate();
				}

			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}

}
