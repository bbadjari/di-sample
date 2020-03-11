package di.sample.services.impl;

import com.google.inject.Inject;
import di.sample.services.contracts.NumberService;
import di.sample.services.contracts.Randomizer;

import java.util.Objects;

/**
 * Advanced number service implementation.
 */
public class AdvancedNumberService implements NumberService
{
	private final Randomizer randomizer;

	/**
	 * Constructor.
	 *
	 * @param  randomizer  Randomizer representing randomizer.
	 */
	@Inject
	public AdvancedNumberService(Randomizer randomizer)
	{
		this.randomizer = Objects.requireNonNull(randomizer);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getRandomInteger()
	{
		return randomizer.nextInt();
	}
}
