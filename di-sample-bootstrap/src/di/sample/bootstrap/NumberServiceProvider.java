package di.sample.bootstrap;

import com.google.inject.Provider;
import di.sample.services.contracts.NumberService;
import di.sample.services.impl.AdvancedNumberService;
import di.sample.services.impl.BasicNumberService;
import di.sample.services.impl.RandomizerImpl;

import java.util.Objects;

/**
 * Google Guice provider for NumberService instances.
 */
public class NumberServiceProvider implements Provider<NumberService>
{
	/**
	 * Environment variable storing NumberService implementation to provide.
	 */
	private static final String NUMBER_SERVICE_ENVIRONMENT_VARIABLE = "NUMBER_SERVICE_IMPL";

	/**
	 * Get number service.
	 *
	 * @return NumberService representing number service.
	 */
	@Override
	public NumberService get()
	{
		NumberService service = new BasicNumberService();

		String implementationClassName = System.getenv(NUMBER_SERVICE_ENVIRONMENT_VARIABLE);

		if (isAdvancedNumberService(implementationClassName))
			service = new AdvancedNumberService(new RandomizerImpl());

		return service;
	}

	/**
	 * Determine whether given implementation class name is for AdvancedNumberService class.
	 *
	 * @param  implementationClassName  String representing implementation class name.
	 * @return True if given implementation class name is for AdvancedNumberService class, false otherwise.
	 */
	private static boolean isAdvancedNumberService(String implementationClassName)
	{
		return Objects.nonNull(implementationClassName) && implementationClassName.equals(AdvancedNumberService.class.getSimpleName());
	}
}
