class Solution {
    public int daysBetweenDates(String date1, String date2) {
        // Since we know that there is an earliest date, we can use that
        // to our advantage calculate the days between both dates and that
        // earliest date. That makes the problem much simpler
        return Math.abs(daysFrom1971(date1) - daysFrom1971(date2));
    }

    private int daysFrom1971(String date) {
        int numDays = 0;

        int dateYear = Integer.valueOf(date.substring(0, 4));
        int dateMonth = Integer.valueOf(date.substring(5, 7));
        int dateDay = Integer.valueOf(date.substring(8, 10));

        for (int year = 1971; year < dateYear; year++) {
            // If the year is a leapyear, add an extra day.
            numDays += isLeapYear(year) ? 366 : 365;
        }

        for (int month = 1; month < dateMonth; month++) {
            numDays += daysInMonth(dateYear, month);
        }

        numDays += dateDay;

        return numDays;
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    private int daysInMonth(int year, int month) {
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 31;
        }
    }
}