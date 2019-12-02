/**
 * ScannedTask
 *
 * Holds an act and date as a String.
 * Also holds a month and day as an int.
 * Used in conjunction with the ScanList class to input into the Calendars Structure.
 *
 * @author Tristen Schuler
 */


package tessScanInput;

public class ScannedTask {
    private String act;
    private String date;
    private int month;
    private int day;



    /*
    -------------------------------------
    Constructors
    -------------------------------------
     */

    public ScannedTask()
    {
        act = date = "";
        month = day = 0;
    }

    public ScannedTask(int month, int day, int year)
    {
        this.month = month;
        this.day = day;
        date = month + "/" + day + "/" + year;
        act = "";
    }


    /*
    -------------------------------------
    Getters and Setters
    -------------------------------------
    */

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
