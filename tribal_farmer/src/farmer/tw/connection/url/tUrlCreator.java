package farmer.tw.connection.url;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import android.os.Bundle;

public class tUrlCreator extends TestCase
{

	public static Test suite()
	{
		return new TestSuite(tUrlCreator.class);
	}

	@Override
	protected void setUp()
	{
		URL url = new URL(
				"http://pl60.plemiona.pl/game.php?village=164595&screen=overview");
	}

	public void testCreateUrl1() throws UrlParamException
	{
		Bundle paramBundle = new Bundle();
		paramBundle.putString("village", "164595");
		paramBundle.putString("screen", "overview");

		URL url = URLCreator.create(URLType.OVERVIEW_VILLAGE, paramBundle);
		assertEquals(
				"http://pl60.plemiona.pl/game.php?village=164595&screen=overview",
				url.toString());

	}

}
