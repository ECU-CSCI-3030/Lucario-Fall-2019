package tessScanInput;

public class ScannedTask
{
    String act;
    String cname; //cname represents the coursename
    String date;


    /*
    -------------------------------------
    Constructors
    -------------------------------------
     */

    public ScannedTask ()
    {
        act = date = cname = "";
    }

    public ScannedTask(String date, String cname)
    {
        this.date = date;
        this.cname = cname;
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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    /**
     * toString()
     *
     * Returns a string of containing this.act , this.cname, and this.date.
     *
     * In the following format:
     *
     * act
     * cname
     * date
     *
     * Example:
     *
     * Final
     * CSCI 3700
     * 12/2/2019
     *
     *
     * @return
     */
    @Override
    public String toString()
    {
        return act + "\n" + cname + "\n" + date;
    }
}
