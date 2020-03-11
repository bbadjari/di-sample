package di.sample.services.impl;

import di.sample.services.contracts.NumberService;

import java.util.Random;

/**
 * Basic number service implementation.
 */
public class BasicNumberService implements NumberService
{
	private final Random random;

	/**
	 * Constructor.
	 */
	public BasicNumberService()
	{
		random = new Random();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getRandomInteger()
	{
		return random.nextInt();
	}
}
