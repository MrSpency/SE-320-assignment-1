import java.time.LocalDate;

public class Day {
    private int year;
    private int month;
    private int day;

    /**Constructs a day with a given year, month, and day
    of the Julian/Gregorian calendar. The Julian calendar
    is used for all days before October 15, 1582.
    @param year a year != 0
    @param month a month between 1 and 12
    @param day a date between 1 and 31 */
    public Day(int aYear, int aMonth, int aDay) {
        year = aYear;
        month = aMonth;
        day = aDay;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return day;
    }

    /**
    Returns a day that is a certain number of days away from
    this day.
    @param n the number of days, can be negative
    @return a day that is n days away from this one
    */
    public Day addDays(int n){
            Day result = this;
            while (n > 0){
                result = result.nextDay();
                n--;
            }
            while (n < 0){
                result = result.previousDay();
                n++;
            }
            return result;
        }


    /** Returns the number of days between this day and another
    day.
    @param other the other day
    @return the number of days that this day is away from
    the other (> 0 if this day comes later)
    */
    public int daysFrom(Day other){
            int n = 0;
            Day d = this;
            while (d.compareTo(other) > 0){
                d = d.previousDay();
                n++;
            }
            while (d.compareTo(other) < 0){
            d = d.nextDay();
            n--;
            }           
            return n;
        }

/** compares day to other day
    @param other the other day
    @return the difference between day,month,year from other day,month,year.
    */
    public int compareTo(Day other) {
        if (year != other.year) {
            return Integer.compare(year, other.year);
        } else if (month != other.month) {
            return Integer.compare(month, other.month);
        } else {
            return Integer.compare(day, other.day);
        }
    }

    //add one day
    public Day nextDay() {
        LocalDate date = LocalDate.of(year, month, day).plusDays(1);
        return new Day(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
    }
    
    //subtract one day
    public Day previousDay() {
        LocalDate date = LocalDate.of(year, month, day).minusDays(1);
        return new Day(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
    }

}
