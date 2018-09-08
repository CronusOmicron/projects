package stockParse;

import java.net.URLEncoder;
import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;



/* 
 * 
 * xpath references: 	https://www.w3.org/TR/xpath/all/
 * 						http://www.baeldung.com/java-xpath
 * 
 */

public class parser{
	
	public static void homePage() throws Exception
	{
		try (final WebClient webClient = new WebClient())
		{
			final HtmlPage page = webClient.getPage("https://www.investopedia.com/markets/stocks/aapl/");
			final String pageAsXml = page.asXml();
			final String pageAsText = page.asText();
			//System.out.println(pageAsXml);
		}
		
	}
	public static void main(String[] args) throws Exception
	{
		homePage();
	}
	
}
	
