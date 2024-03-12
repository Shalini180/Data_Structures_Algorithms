class Meeting{
    int start;
    int end;
    int pos;
    public Meeting(int start, int end, int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class MeetingComparator implements Comparator<Meeting>{
    @Override
    public int compare(Meeting m1, Meeting m2){
        if(m1.end < m2.end) return -1;
        else if(m1.end > m2.end) return 1;
        else if(m1.pos < m2.pos) return -1;
        return 1;
    }
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<Meeting> ans = new ArrayList<>();
        for(int i = 0;i<start.length;i++){
            ans.add(new Meeting(start[i], end[i], i + 1));
        }
        
        MeetingComparator mc = new MeetingComparator();
        Collections.sort(ans, mc);
        
        int limit = ans.get(0).end;
        int noOfRooms = 1;
        
        for(int i = 1;i<start.length;i++){
            if(ans.get(i).start > limit){
                limit = ans.get(i).end;
                noOfRooms += 1;
            }
        }
        
        return noOfRooms;
    }
}
