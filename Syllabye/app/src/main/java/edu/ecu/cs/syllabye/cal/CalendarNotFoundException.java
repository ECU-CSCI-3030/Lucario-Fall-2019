/**
 * CalendarNotFoundException
 *
 * Throws when a calendar is not found in the calendar list.
 * @author Tristen Schuler
 */

package edu.ecu.cs.syllabye.cal;

@SuppressWarnings("serial")
public class CalendarNotFoundException extends Exception
{
    public CalendarNotFoundException ()
    {
        super("ERROR: CALENDAR NOT FOUND");
    }

}
