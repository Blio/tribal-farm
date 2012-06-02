package farmer.tw.connection.url;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class tUrl extends TestCase
{

	// --------------------//
	public static Test suite()
	{
		return new TestSuite(tUrl.class);
	}

	@Override
	protected void setUp()
	{
		URL url = new URL(
				"http://pl60.plemiona.pl/game.php?village=164595&screen=overview");
	}

	// -------------------//

	public void testParamsToUrl()
	{
		URL url = new URL();
		url.addParam("village", "12345");
		System.out.println(url.getUrlString());
	}

	public void testURLToParams()
	{
		URL url = new URL(
				"http://pl60.plemiona.pl/game.php?village=164595&screen=report&mode=all&view=44425311");

		assertEquals(
				"http://pl60.plemiona.pl/game.php?village=164595&screen=report&mode=all&view=44425311",
				url.getUrlString());
	}

}
