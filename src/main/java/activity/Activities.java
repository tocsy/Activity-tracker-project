package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {
    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = new ArrayList<>(activities);
    }

    public void addActivity(Activity activity){
        activities.add(activity);
    }

    public List<Report> distancesByType() {
        List<Report> reports = new ArrayList<>();
        double bikingSum = 0;
        double hikingSum = 0;
        double runningSum = 0;

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
                    a.getDistance();
                    break;
            }
        }
        Report biking = new Report(ActivityType.BIKING, bikingSum);
        Report hiking = new Report(ActivityType.HIKING, hikingSum);
        Report running= new Report(ActivityType.RUNNING, runningSum);
        Report basketball = new Report(ActivityType.BASKETBALL, 0);

        reports.add(biking);
        reports.add(hiking);
        reports.add(running);
        reports.add(basketball);

        return reports;
    }

    public int numberOfTrackActivities() {
        int count = 0;

        return count;
    }

    public int numberOfWithoutTrackActivities() {
        int count = 0;

        return count;
    }
}
