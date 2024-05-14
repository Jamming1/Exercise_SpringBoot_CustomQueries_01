package co.develhope.Exercise_SpringBoot_CustomQueries_01;

public enum FlightStatus {
    ON_TIME,
    DELAYED,
    CANCELLED;


    public static FlightStatus toString(String status) {
        return switch (status.toLowerCase()) {
            case "delayed" -> FlightStatus.DELAYED;
            case "cancelled" -> FlightStatus.CANCELLED;
            default -> FlightStatus.ON_TIME;
        };


    }
}

