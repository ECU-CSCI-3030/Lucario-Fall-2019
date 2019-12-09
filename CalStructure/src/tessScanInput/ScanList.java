package tessScanInput;

import java.util.Iterator;
import cal.*;
import java.util.LinkedList;

public class ScanList
{


    private LinkedList<ScannedTask> scanlist;
    private int year = 2019; //year given by user through app *2019 is temporary*
    private String cname = "CSCI 3030"; //course name given by user through app *CSCI 3030 is temporary


    // CONSTRUCTORS

    //THIS CONSTRUCTOR SHOULD ONLY BE USED FOR TESTING PURPOSES.
    public ScanList()
    {
        scanlist = new LinkedList<ScannedTask>();
    }

    public ScanList(int year, String cname)
    {
        scanlist = new LinkedList<ScannedTask>();
        this.year = year;
        this.cname = cname;
    }



    // METHODS


    /**
     * addScannedTask(month,day)
     *
     * Adds a ScannedTask to the scanlist with the given month and day.
     *
     */
    public void addScannedTask(int month, int day)
    {
        ScannedTask added = new ScannedTask(month,day,year);
        scanlist.add(added);
    }


    /**
     * inputList(callist)
     *
     * Inputs all of the ScannedTask in "scanlist" with
     * acts that arent null into "callist".
     *
     */
    public void inputList(CalendarList callist)
    {
        Iterator<ScannedTask> iter = scanlist.iterator();
        Calendar newcal = new Calendar(year);
        callist.addCalendar(newcal);

        while(iter.hasNext())
        {
            ScannedTask st = iter.next();
            String act = st.getAct();

            if(!act.equalsIgnoreCase(""))
            {
                Task added = new Task(act, cname);
                callist.addTask(st.getMonth(), st.getDay(), year, added);
            }
        }

    }

    /**
     * setAct(act,date)
     *
     * Sets the act of the first ScannedTask with the date "date" to "act" whose act
     * is empty("");
     *
     * Note: If there is no ScannedTask in the scanlist with date "date" with an empty act, the act will not be set.
     *
     * @return True if an act was set to that date. False if no act was set.
     */
    public boolean setAct(String act, String date)
    {
        Iterator<ScannedTask> iter = scanlist.iterator();
        while(iter.hasNext())
        {
            ScannedTask st = iter.next();
            if(isEqual(st,date)&& st.getAct().equals(""))
            {
                st.setAct(act);
                return true;
            }
        }
        return false;
    }

    /**
     * isEqual(st,date)
     *
     * Determines whether the given date matches the given ScannedTask's date.
     *
     * @return True if the dates match. False if not.
     */
    private boolean isEqual(ScannedTask st, String date)
    {
        return st.getDate().equalsIgnoreCase(date);
    }

    /**
     * clearScanList()
     *
     * Empties the scanlist that calls this method.
     *
     * Should be called whenever finished using a scanlist.
     * (Usually after you use scanlist.inputList())
     */
    public void clearScanList()
    {
        scanlist.clear();
    }


    /**
     * getYear()
     * @return The year of the ScanList
     */
    public int getYear()
    {
        return this.year;
    }

    /**
     * getCname()
     * @return The course name of the ScanList
     */
    public String getCname() {
        return cname;
    }
}

