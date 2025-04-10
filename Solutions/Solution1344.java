class Solution {
    public double angleClock(int hour, int minutes) {
        double hourDouble = (double) hour;
        double minutesDouble = (double) minutes;

        // Calculate hour hand distance from 0
        double hourDegree = (hourDouble / 12 * 360) % 360;
        hourDegree += minutesDouble / 60 * 30;

        // Calculate minute hand distance from 0
        double minuteDegree = minutesDouble / 60 * 360;

        double clockwiseDistance = Math.abs(hourDegree - minuteDegree);
        return clockwiseDistance > 180 ? 360 - clockwiseDistance : clockwiseDistance;
    }
}