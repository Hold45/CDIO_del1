import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;


/**
 * Test the Throw class
 */
public class ThrowTest {
	public Throw aThrow;

	@Before
	public void setup() throws Exception{
		this.aThrow = new Throw();
	}

	@After
	public void after() throws Exception{
		this.aThrow = null;
	}

	/**
	 * Test if the sum of dice is even when the dice are the same.
	 *
	 * @throws Exception
	 */
	@Test
	public void testIsSame() throws Exception{
		for (int i = 0; i < 100000; i++) {
			aThrow = new Throw();
			if(aThrow.isSame()){
				assertThat(aThrow.sum() %2).isEqualTo(0);
			}
		}
	}

	/**
	 * Test whether the sum is between 2 and 12 for the dice.
	 *
	 * @throws Exception
	 */
	@Test
	public void testSum() throws Exception {
		for (int i = 0; i < 100000; i++) {
			aThrow = new Throw();
			assertThat(aThrow.sum()).isBetween(2,12);
		}
	}
}