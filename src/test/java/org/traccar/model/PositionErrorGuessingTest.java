package org.traccar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionErrorGuessingTest {
    private final Position position = new Position();

    @Test
    @DisplayName("Null element in geofence list throws NullPointerException")
    void geofenceIdsNullElementThrows() {
        List<Long> ids = Arrays.asList(1L, null, 3L);
        assertThrows(NullPointerException.class, () -> position.setGeofenceIds(ids));
    }

    @Test
    @DisplayName("Decimal geofence ids are silently cut off")
    void geofenceIdsDecimalSilentlyCutOff() {
        position.setGeofenceIds(List.of(1.9, 2.5));
        assertEquals(List.of(1L, 2L), position.getGeofenceIds());
    }

    @Test
    @DisplayName("NaN geofence id is silently converted to 0")
    void geofenceIdsNaNSilentlyConvertedToZero() {
        position.setGeofenceIds(List.of(1.9, Double.NaN, 3.5));
        assertEquals(List.of(1L, 0L, 3L), position.getGeofenceIds());
    }
}
