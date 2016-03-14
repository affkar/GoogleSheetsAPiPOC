import com.google.gdata.client.authn.oauth.*;
import com.google.gdata.client.spreadsheet.*;
import com.google.gdata.data.*;
import com.google.gdata.data.batch.*;
import com.google.gdata.data.spreadsheet.*;
import com.google.gdata.util.*;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class MySpreadsheetIntegration2 {
  public static void main(String[] args)
      throws AuthenticationException, MalformedURLException, IOException, ServiceException {
	  //https://spreadsheets.google.com/feeds/cells/1GYc-orkVvMHvZ23tpLnUo6XRmqLMwB4FKO0bnZlhkUA/GeoChart/public/full
    // Application code here
	  
	  SpreadsheetService service =
		        new SpreadsheetService("MySpreadsheetIntegration-v2");

		    // TODO: Authorize the service object for a specific user (see other sections)

		    // Define the URL to request.  This should never change.
		    URL SPREADSHEET_FEED_URL = null;
		    SPREADSHEET_FEED_URL = new URL("https://spreadsheets.google.com/feeds/worksheets/1GYc-orkVvMHvZ23tpLnUo6XRmqLMwB4FKO0bnZlhkUA/public/full");
		    //SPREADSHEET_FEED_URL = new URL("https://spreadsheets.google.com/feeds/cells/1GYc-orkVvMHvZ23tpLnUo6XRmqLMwB4FKO0bnZlhkUA/GeoChart/public/full");
		    
		    // Make a request to the API and get all spreadsheets.
		    WorksheetFeed feed = service.getFeed(SPREADSHEET_FEED_URL, WorksheetFeed.class);
		    List<WorksheetEntry> worksheets = feed.getEntries();
		    System.out.println("Printing all worksheets?. This was supposed to be all spreadsheets");

		    // Iterate through each worksheet in the spreadsheet.
		    for (WorksheetEntry worksheet : worksheets) {
		      // Get the worksheet's title, row count, and column count.
		      String title = worksheet.getTitle().getPlainText();
		      int rowCount = worksheet.getRowCount();
		      int colCount = worksheet.getColCount();
		      //worksheet.

		      // Print the fetched information to the screen for this worksheet.
		      System.out.println("\t" + title + "- rows:" + rowCount + " cols: " + colCount);
		    }



  }
}
