import java.util.*;
class Job {
    int time;
    int deadline;
    public Job(int time, int deadline){
        this.time = time;
        this.deadline = deadline;
    }
};
public class Main
{
	public static void main(String[] args) {
		int[] time = {2, 1, 2, 5};
		int[] deadline = {4, 10, 2, 8};
		List<Job> ans = new ArrayList<>();
		for(int i = 0;i<time.length;i++){
		    ans.add(new Job(time[i], deadline[i]));
		}
		
		Collections.sort(ans, new Comparator<Job>(){
		    public int compare(Job j1, Job j2){
		        return j1.deadline - j2.deadline;
		    }
		});
		
		int minAns = 0;
		int currTime = 0;
		for(int i = 0;i<ans.size();i++){
		    currTime = currTime + ans.get(i).time;
		    int endTime = ans.get(i).deadline;
		    minAns = Math.max(Math.max(currTime - endTime, 0), minAns);
		}
		
		System.out.println("Minimum of Max Lateness " + minAns);
	}
}
