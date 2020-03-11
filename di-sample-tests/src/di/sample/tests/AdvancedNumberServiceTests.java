package di.sample.tests;

import di.sample.services.contracts.NumberService;
import di.sample.services.impl.AdvancedNumberService;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for AdvancedNumberService class.
 */
public class AdvancedNumberServiceTests
{
	private static final int INTEGER_VALUE = 42;

	/**
	 * Test getRandomInteger() method.
	 */
	@Test
	public void getRandomInteger()
	{
		NumberService numberService = new AdvancedNumberService(new FakeRandomizer(INTEGER_VALUE));

		int integerValue = numberService.getRandomInteger();

		Assert.assertEquals(INTEGER_VALUE, integerValue);
	}
}
