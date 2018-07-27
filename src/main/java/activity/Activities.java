package activity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Activities {
    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        if(activities == null || activities.size() == 0) {
            throw new IllegalArgumentException();
        }
        this.activities = new ArrayList<>(activities);
    }

    public void addActivity(Activity activity){
        if(activity == null){
            throw new IllegalArgumentException();
        }
        activities.add(activity);
    }

    public List<Report> distancesByTypes() {
        List<Report> reports = new LinkedList<>();
        double bikingSum = 0;
        double hikingSum = 0;
        double runningSum = 0;
        double basketballSum = 0;

        for (Activity a : activities) {
            switch (a.getType()) {
                case BIKING:
                    bikingSum += a.getDistance();
                    break;
                case HIKING:
                    hikingSum += a.getDistance();
                    break;
                case RUNNING:
                    runningSum += a.getDistance();
                    break;
                case BASKETBALL:
                    basketballSum += a.getDistance();
                    break;
            }
        }
        Report basketball = new Report(ActivityType.BASKETBALL, basketballSum);
        Report biking = new Report(ActivityType.BIKING, bikingSum);
        Report hiking = new Report(ActivityType.HIKING, hikingSum);
        Report running= new Report(ActivityType.RUNNING, runningSum);

        reports.add(basketball);
        reports.add(biking);
        reports.add(hiking);
        reports.add(running);

        return reports;
    }

    public int numberOfTrackActivities() {
        int count = 0;

        for (Activity a : activities) {
            if(a.getType() == ActivityType.RUNNING
                    || a.getType() == ActivityType.HIKING
                    || a.getType() == ActivityType.BIKING){
                count++;
            }
        }

        return count;
    }

    public int numberOfWithoutTrackActivities() {
        int count = 0;
        for(Activity a : activities){
            if(a.getType() == ActivityType.BASKETBALL){
                count++;
            }
        }

        return count;
    }
}
