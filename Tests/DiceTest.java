import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;


/**
 * Check if the die class works correctly.
 */
public class DiceTest {
	Dice dice;

    @Before
    public void setup() throws Exception{
	    this.dice = new Dice();
    }

	@After
	public void after() throws Exception{
		this.dice = null;
	}

    /**
     * Test if roll is between 1 and 6.
     *
     * @throws Exception
     */
    @Test
    public void testRollBetween1To6() throws Exception {
	    for (int i = 0; i < 10000; i++)
		    assertThat(this.dice.roll()).isBetween(1,6);
    }


	/**
	 * Test if the occurrences of 1-6 on the d6 is truly random
	 *
	 * @throws Exception
	 */
	@Test
	public void testRollOccurrences() throws Exception {
		int rolls = 60000;
		int[] num = {0,0,0,0,0,0};

		for (int i = 0; i < rolls; i++)
			num[this.dice.roll()-1]++;

		for (int i = 0; i < num.length; i++)
			assertThat(num[i]).as("%s = %s",i,num[i]).isBetween(9600, 10400);
	}


	/**
	 * Test if two dice are equal.
	 * @throws Exception
	 */
	@Test
	public void testEquals() throws Exception{
		Dice dice2 = new Dice();
		dice.roll();
		if(dice.getValue() == dice2.getValue())
			assertThat(dice).isEqualTo(dice2);
		else
			assertThat(dice).isNotEqualTo(dice2);
	}

}