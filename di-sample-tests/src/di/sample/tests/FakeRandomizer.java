package di.sample.tests;

import di.sample.services.contracts.Randomizer;

/**
 * Fake randomizer implementation used for testing purposes.
 */
public class FakeRandomizer implements Randomizer
{
	private final int intValue;

	/**
	 * Constructor.
	 *
	 * @param  intValue  Integer representing integer value to always return.
	 */
	public FakeRandomizer(int intValue)
	{
		this.intValue = intValue;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int nextInt()
	{
		return intValue;
	}
}
