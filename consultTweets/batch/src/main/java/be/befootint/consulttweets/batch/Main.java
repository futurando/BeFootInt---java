/**
 * 
 */
package be.befootint.consulttweets.batch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cazamundo
 *
 */
public class Main {

	/**
	 * The core of the batch. This starts-up the batch process
	 * @param args
	 */
	public static void main(String[] args) {

		String springConfig = "classpath:spring/batch/root-config.xml";

		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

	}

}
