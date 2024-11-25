import java.time.LocalDate;
public class DayTester{   
    public static void main(String[] args){
        Day birthday = new Day(2003, 5, 31); // May 31, 2003
        Day today = new Day(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
        int daysElapsed = today.daysFrom(birthday);
        System.out.println("Days elapsed since " + birthday.getYear() + "-" + birthday.getMonth() + "-" + birthday.getDate() + ": " + daysElapsed);
        }
}



