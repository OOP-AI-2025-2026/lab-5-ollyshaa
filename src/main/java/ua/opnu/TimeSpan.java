package ua.opnu;
public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    public TimeSpan(int minutes) {
        if (minutes < 0) return;
        this.hours = minutes / 60;
        this.minutes = minutes % 60;
    }

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            return;
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    public TimeSpan(TimeSpan timeSpan) {
        this.hours = timeSpan.hours;
        this.minutes = timeSpan.minutes;
    }

    public void add(int hours, int minutes) {
        if (hours >= 0 && minutes >= 0) {
            this.hours += hours;
            int totalMinutes = this.minutes + minutes;
            this.hours += totalMinutes / 60;
            this.minutes = totalMinutes % 60;
        }
    }

    public void add(int minutes) {
        if (minutes >= 0) {
            int totalMinutes = this.minutes + minutes;
            this.hours += totalMinutes / 60;
            this.minutes = totalMinutes % 60;
        }
    }

    public void add(TimeSpan timeSpan) {
        add(timeSpan.hours, timeSpan.minutes);
    }

    public void subtract(int hours, int minutes) {
        if (hours < 0 || minutes < 0) return;

        int totalThis = this.hours * 60 + this.minutes;
        int totalOther = hours * 60 + minutes;

        if (totalOther > totalThis) return;

        int resultMinutes = this.minutes - minutes;
        int resultHours = this.hours - hours;

        if (resultMinutes < 0) {
            resultMinutes += 60;
            resultHours -= 1;
        }
        this.hours = resultHours;
        this.minutes = resultMinutes;
    }

    public void subtract(int minutes) {
        if (minutes < 0) return;
        subtract(minutes / 60, minutes % 60);
    }

    public void subtract(TimeSpan timeSpan) {
        subtract(timeSpan.hours, timeSpan.minutes);
    }

    int getHours() {
        return this.hours;
    }

    int getMinutes() {
        return this.minutes;
    }

    double getTotalHours() {
        return getHours() + getMinutes()/60.0;
    }

    int getTotalMinutes() {
        return getHours()*60 + getMinutes();
    }

    public void scale(int factor) {
        if (factor <= 0) {
            return;
        }
        int totalMinutes = (this.hours * 60 + this.minutes) * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }
}