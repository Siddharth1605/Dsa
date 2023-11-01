import java.util.*;
class meeting 
{
    int start;
    int end;
    int pos;
    meeting(int start, int end, int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
class meetingComparator implements Comparator<meeting>
{
     @Override
    public int compare(meeting o1, meeting o2) 
    {
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if(o1.pos < o2.pos)
            return -1;
        return 1; 
    }
}
public class Solution {
    public static int maximumMeetings(int []start, int []end) {
        // Write your code here.
        ArrayList<meeting> items = new ArrayList<>();
        int n = start.length;
        for(int i=0;i<n;i++)
        {
            items.add(new meeting(start[i], end[i], i+1));
        }

        meetingComparator mc = new meetingComparator();
        Collections.sort(items, mc);

        int limit = items.get(0).end;

        int count = 0;
        for(int i=1;i<n;i++)
        {
            if(items.get(i).start > limit)
            {
                count++;
                limit = items.get(i).end;
            }
        }
        count++;
        return count;
    }
}
