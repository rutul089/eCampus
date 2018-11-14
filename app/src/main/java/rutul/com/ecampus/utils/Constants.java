package rutul.com.ecampus.utils;

public class Constants {
    public static final String APPLICATION_OPENED_ONCE = "application_opened_once";
    public static final String NA = "N/A";

    public static final String TAG_CPNY_INFO = "Company Info";
    public static final String TAG_JOB_INFO = "Job Info";
    public static final String TAG_REVIEW = "Review";
    public static final String TAG_DASH_BOARD = "Dash Board";
    public static final String TAG_EVENT_NEWS = "Event & News";
    public static final String TAG_NOTIFICATION = "Notification";
    public static final String TAG_APPOINTMENT = "Appointment";

    public enum SCREEN {
        MYPROFILE("My Profile"),
        JOBFORYOU("Job For you"),
        APPOITMENT("Appointment"),
        ABOUTCOLLAGE ("About collage "),
        EVENTSANDNEWS("Events and News"),
        DOYOUKNOW("Do You Know"),
        NOTIFICATION("Notification"),
        TERMSOFUSER("Terms of User "),
        SETTINGS("Settings");

        private final String SCREEN;

        private SCREEN(String s) {
            SCREEN = s;
        }

        public boolean equalsName(String otherName) {
            // (otherName == null) check is not needed because notification_type.equals(null) returns false
            return SCREEN.equals(otherName);
        }

        public String toString() {
            return this.SCREEN;
        }
    }
}
