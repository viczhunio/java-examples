public class Date212 {
    // store the year, month and day as integers/three private instance variables
    private int year, month, day; 

    // take a String to represent the date in yyyymmdd format. 
    public Date212 (String date) {
        this.year = Integer.parseInt(date.substring(0,4));
        this.month = Integer.parseInt(date.substring(4,6));
        this.day= Integer.parseInt(date.substring(6,8));
    }

    //getters
    public int getYear() {
        return this.year; 
    }
    public int getMonth() {
        return this.month; 
    }
    public int getDay() {
        return this.day; 
    }

    //setters
    public void setYear(int y) {
        this.year = y; 
    }
    public void setMonth(int m) {
        this.month = m; 
    }
    public void setDay(int d) {
        this.day = d; 
    }
        
    //equals
    public boolean equals (Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Date212 otherDate = (Date212) other;
        return (this.year == otherDate.year) && (this.month == otherDate.month) && (this.day == otherDate.day);
    }

    public String toString() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return months[month - 1] + " " + day + ", " + year;
    }

    //compare 
    public int compareTo(Date212 other) {
        int cmp = Integer.compare (this.year, other.year);
        if (cmp !=0) return cmp; 
        cmp = Integer.compare (this.month, other.month);
        if(cmp != 0) return cmp; 
        return Integer.compare(this.day, other.day); 
    }
}
    

