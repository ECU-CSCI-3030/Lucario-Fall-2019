package tess4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherGroupMultiple
{
  public static void main(String[] args)
  {
    String stringToSearch = "There is a test on Sunday, Jan 6th ... 01/06/2019 ... 1/6 ... January 6th";
    
    
	String pat1 = "(?:0[1-9]|1[0-2])/(?:[0-2]\\d|3[0-1])/(?:19\\d{2}|2\\d{3})";
	String pat2 = "(?:0[1-9]|1[0-2])/(?:[0-2]\\d|3[0-1])";
	//String pat3 = "((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?)) .*([0-2]\\d|3[0-1]|[1-9]).*";
	String pat3 = "((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?)) ([0-2][0-9]|3[0-1]|[1-9])";
	String pat4 = "([sS]unday|[mM]onday|[tT]uesday|[wW]ednesday|[tT]hursday|[fF]riday|[sS]aturday),? .*((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?)) .*([0-2]\\d|3[0-1]|[1-9]).*";

    Pattern p = Pattern.compile(pat2);
   
    Matcher m = p.matcher(stringToSearch);

    if (m.find())
    {
      //String group1 = m.group(1);
      //String group2 = m.group(2);
      //String group3 = m.group(3);
      
      System.out.println(m.group());
      //System.out.format("'%s','%s'\n", group1, group2 );
      //System.out.format("'%s','%s','%s'\n", group1, group2, group3);
    }
    else
    	System.out.println("Nothing Found");

  }
}













//([sS]unday|[mM]onday|[tT]uesday|[wW]ednesday|[tT]hursday|[fF]riday|[sS]aturday) .* ([jJ]anuary|[fF]ebruary|[mM]arch|[aA]pril|[mM]ay|[jJ]une|[jJ]uly|[aA]ugust|[sS]eptember|[oO]ctober|[nN]ovember|[dD]ecember) .* ([0-2]\\d|3[0-1]|[1-9])


//THIS WORKS
//([sS]unday|[mM]onday|[tT]uesday|[wW]ednesday|[tT]hursday|[fF]riday|[sS]aturday),? .*([jJ]anuary|[fF]ebruary|[mM]arch|[aA]pril|[mM]ay|[jJ]une|[jJ]uly|[aA]ugust|[sS]eptember|[oO]ctober|[nN]ovember|[dD]ecember) .*([0-2]\\\\d|3[0-1]|[1-9]).*





//((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?))


//Pattern p = Pattern.compile("((?:[jJ]an(?:uary)?|[fF]eb(?:ruary)?|[mM]ar(?:ch)?|[aA]pr(?:il)?|[mM]ay?|[jJ]un(?:e)?|[jJ]ul(?:y)?|[aA]ug(?:ust)?|[sS]ep(?:t(?:ember)?)?|[oO]ct(?:ober)?|[nN]ov(?:ember)?|[dD]ec(?:ember)?)) .*([0-2]\\\\d|3[0-1]|[1-9]).*");


// if our pattern matches the string, we can try to extract our groups