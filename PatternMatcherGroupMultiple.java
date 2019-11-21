package tess4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Demonstrates how to extract multiple "groups" from a given string
 * using regular expressions and the Pattern and Matcher classes.
 * 
 * Note: "\\S" means "A non-whitespace character".
 * @see http://java.sun.com/j2se/1.5.0/docs/api/java/util/regex/Pattern.html
 */
public class PatternMatcherGroupMultiple
{
  public static void main(String[] args)
  {
    String stringToSearch = "This is a tes Jan 6th";

    // specify that we want to search for two groups in the string
    Pattern p = Pattern.compile("([sS]unday?|[mM]onday?|[tT]uesday?|[wW]ednesday?|[tT]hursday?|[fF]riday?|[sS]aturday?),? .*((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?)) .*([0-2]\\\\d|3[0-1]|[1-9]).*");
    Matcher m = p.matcher(stringToSearch);
    //([sS]unday|[mM]onday|[tT]uesday|[wW]ednesday|[tT]hursday|[fF]riday|[sS]aturday) .* ([jJ]anuary|[fF]ebruary|[mM]arch|[aA]pril|[mM]ay|[jJ]une|[jJ]uly|[aA]ugust|[sS]eptember|[oO]ctober|[nN]ovember|[dD]ecember) .* ([0-2]\\d|3[0-1]|[1-9])
    //(\\S+or\\S+) .* (\\S+the\\S+).*
    
    
    //THIS WORKS
    //([sS]unday|[mM]onday|[tT]uesday|[wW]ednesday|[tT]hursday|[fF]riday|[sS]aturday),? .*([jJ]anuary|[fF]ebruary|[mM]arch|[aA]pril|[mM]ay|[jJ]une|[jJ]uly|[aA]ugust|[sS]eptember|[oO]ctober|[nN]ovember|[dD]ecember) .*([0-2]\\\\d|3[0-1]|[1-9]).*
    
    
//  ((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?))
    
    

    // if our pattern matches the string, we can try to extract our groups
    if (m.find())
    {
      // get the two groups we were looking for
      String group1 = m.group(1);
      String group2 = m.group(2);
      String group3 = m.group(3);
      
      // print the groups, with a wee bit of formatting
      System.out.format("'%s','%s', '%s'\n", group1, group2, group3);
    }
    else
    	System.out.println("Nothing Found");

  }
}