package activity;

public class Report {

    private final ActivityType activityType;
    private final double distance;

    public Report(ActivityType activityType, double distance) {
        if (activityType == null) {
            throw new IllegalArgumentException("Parameter should not be null");
        }
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance should be greater then or equal to zero.");
        }
        this.activityType = activityType;
        this.distance = distance;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public double getDistance() {
        return distance;
    }
}
