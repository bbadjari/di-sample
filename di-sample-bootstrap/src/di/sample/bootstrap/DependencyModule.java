package di.sample.bootstrap;

import com.google.inject.AbstractModule;
import di.sample.services.contracts.NumberService;
import di.sample.services.contracts.Randomizer;
import di.sample.services.impl.RandomizerImpl;

/**
 * Google Guice dependency module.
 */
public class DependencyModule extends AbstractModule
{
	/**
	 * Configure module.
	 */
	@Override
	protected void configure()
	{
		bind(NumberService.class).toProvider(NumberServiceProvider.class);
		bind(Randomizer.class).to(RandomizerImpl.class);
	}
}
