package akki.mycollection.map;

import java.util.EnumMap;

public class EnumMapImpl {

    public static void main(String[] args) {
        EnumMap<DayOfWeek, String> activityMap = new EnumMap<>(DayOfWeek.class);
        activityMap.put(DayOfWeek.MONDAY, "Soccer");
        activityMap.put(DayOfWeek.TUESDAY, "Basketball");

        EnumMap<DayOfWeek, String> activityMapCopy = new EnumMap<>(activityMap);

    }
}

 enum DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
