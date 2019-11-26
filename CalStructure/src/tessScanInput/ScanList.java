/**
 *ScanList
 *
 *Used in conjunction with the ScanToInput class to create
 *a LinkedList of ScannedTask with the dates scanned from
 *the file given. The user then gives an "act" for each
 *ScannedTask. Then with the inputList method all ScannedTask
 *in the List are added to the Calendar Structure.
 *
 * @author - Tristen Schuler - Leo Espinoza - Jameson Bergstedt
 */

 package tessScanInput;


import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class ScanList
{


    private LinkedList<ScannedTask> scanlist;
    // private int year = year given by user through app
    // private String cname = course name given by user through app 

    /**
     * scanTasks
     *
     * Sets "scanlist" to a list of ScannedTask where
     * for each date in file "filename" there is a ScannedTask
     * with a String date, int month, and int day that represents
     * that date.
     *
     * Note: the "act" in each of the ScannedTasks in the list will be "".
     */
    void scanTasks()
    {
        // scanlist = ScanToInput.scanTasks(filename,year) scanTasks should come from the ScanToInput Class.
    }





}
