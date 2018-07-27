package activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Track {

    List<TrackPoint> trackPoints = new ArrayList();

    public void addTrackPoint(TrackPoint tp) {
        trackPoints.add(tp);
    }

    public Coordinate findMaximumCoordinate() {
        double maxlat = trackPoints.get(0).getCoordinate().getLatitude();
        double maxlon = trackPoints.get(0).getCoordinate().getLongitude();
        for (TrackPoint tp : trackPoints) {
            if (tp.getCoordinate().getLatitude() > maxlat) {
                maxlat = tp.getCoordinate().getLatitude();
            }
            if (tp.getCoordinate().getLongitude() > maxlon) {
                maxlon = tp.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(maxlat, maxlon);
    }

    public Coordinate findMinimumCoordinate() {
        double minlat = trackPoints.get(0).getCoordinate().getLatitude();
        double minlon = trackPoints.get(0).getCoordinate().getLongitude();
        for (TrackPoint tp : trackPoints) {
            if (tp.getCoordinate().getLatitude() < minlat) {
                minlat = tp.getCoordinate().getLatitude();
            }
            if (tp.getCoordinate().getLongitude() < minlon) {
                minlon = tp.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minlat, minlon);
    }

    public double getDistance() {
        double sum = 0.0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            sum += trackPoints.get(i + 1).getDistanceFrom(trackPoints.get(i));
        }
        return sum;
    }

    public double getFullDecrease() {
        double sum = 0.0;
        for (int i = 0; i < trackPoints.size(); i++) {
            if (trackPoints.get(i).getElevation() > trackPoints.get(i + 1).getElevation()) {
                sum += (trackPoints.get(i).getElevation() - trackPoints.get(i + 1).getElevation());
            }
        }
        return sum;
    }

    public double getFullElevation() {
        double sum = 0.0;
        for (int i = 0; i < trackPoints.size(); i++) {
            if (trackPoints.get(i).getElevation() < trackPoints.get(i + 1).getElevation()) {
                sum += (trackPoints.get(i + 1).getElevation() - trackPoints.get(i).getElevation());
            }
        }
        return sum;
    }

    public double getRectangleArea() {
        double a = findMaximumCoordinate().getLatitude() - findMinimumCoordinate().getLatitude();
        double b = findMaximumCoordinate().getLongitude() - findMinimumCoordinate().getLongitude();
        return a * b;
    }

    public List getTrackPoints() {
        return trackPoints;
    }
}
