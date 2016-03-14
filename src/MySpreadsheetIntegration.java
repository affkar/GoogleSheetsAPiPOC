import com.google.gdata.client.authn.oauth.*;
import com.google.gdata.client.spreadsheet.*;
import com.google.gdata.data.*;
import com.google.gdata.data.batch.*;
import com.google.gdata.data.spreadsheet.*;
import com.google.gdata.util.*;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class MySpreadsheetIntegration {
  public static void main(String[] args)
      throws AuthenticationException, MalformedURLException, IOException, ServiceException {
	  //https://spreadsheets.google.com/feeds/cells/1GYc-orkVvMHvZ23tpLnUo6XRmqLMwB4FKO0bnZlhkUA/GeoChart/public/full
    // Application code here
	  
	  SpreadsheetService service =
		        new SpreadsheetService("MySpreadsheetIntegration-v1");

		    // TODO: Authorize the service object for a specific user (see other sections)

		    // Define the URL to request.  This should never change.
		    URL SPREADSHEET_FEED_URL = null;
		    SPREADSHEET_FEED_URL = new URL("https://spreadsheets.google.com/feeds/worksheets/1GYc-orkVvMHvZ23tpLnUo6XRmqLMwB4FKO0bnZlhkUA/public/full");
		    //SPREADSHEET_FEED_URL = new URL("https://spreadsheets.google.com/feeds/cells/1GYc-orkVvMHvZ23tpLnUo6XRmqLMwB4FKO0bnZlhkUA/GeoChart/public/full");
		    
		    // Make a request to the API and get all spreadsheets.
		    SpreadsheetFeed feed = service.getFeed(SPREADSHEET_FEED_URL, SpreadsheetFeed.class);
		    List<SpreadsheetEntry> spreadsheets = feed.getEntries();
		    System.out.println("Printing all worksheets?. This was supposed to be all spreadsheets");
		    // Iterate through all of the spreadsheets returned
		    for (SpreadsheetEntry spreadsheet : spreadsheets) {
		      // Print the title of this spreadsheet to the screen
		      System.out.println(spreadsheet.getTitle().getPlainText());
		    }


  }
}
