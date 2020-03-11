package di.sample.services.impl;

import di.sample.services.contracts.Randomizer;

import java.util.Random;

/**
 * Randomizer implementation.
 */
public class RandomizerImpl implements Randomizer
{
	private final Random random;

	/**
	 * Constructor.
	 */
	public RandomizerImpl()
	{
		random = new Random();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int nextInt()
	{
		return random.nextInt();
	}
}
