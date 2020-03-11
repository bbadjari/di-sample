package di.sample.console;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;
import di.sample.bootstrap.DependencyModule;
import di.sample.services.contracts.NumberService;

import java.util.Objects;

/**
 * Console application for testing services made available via Google Guice.
 */
public class Console
{
	/**
	 * Main entry into application.
	 *
	 * @param  args  Array of String instances representing command-line arguments.
	 */
	public static void main(String[] args)
	{
		NumberService numberService = getNumberService();

		int randomInteger = numberService.getRandomInteger();

		System.out.println("Random integer: " + randomInteger);
	}

	/**
	 * Get number service.
	 *
	 * @return  NumberService representing number service.
	 */
	private static NumberService getNumberService()
	{
		// Create Guice injector using dependency module.
		Injector injector = Guice.createInjector(new DependencyModule());

		return getNumberServiceDirectly(injector);
	}

	/**
	 * Get number service directly via given injector.
	 *
	 * @param  injector  Injector representing Google Guice injector.
	 * @return NumberService representing number service.
	 */
	private static NumberService getNumberServiceDirectly(Injector injector)
	{
		Objects.requireNonNull(injector);

		return injector.getInstance(NumberService.class);
	}

	/**
	 * Get number service via related provider.
	 *
	 * @param  injector  Injector representing Google Guice injector.
	 * @return NumberService representing number service.
	 */
	private static NumberService getNumberServiceViaProvider(Injector injector)
	{
		Objects.requireNonNull(injector);

		Provider<NumberService> provider = injector.getProvider(NumberService.class);

		return provider.get();
	}
}
