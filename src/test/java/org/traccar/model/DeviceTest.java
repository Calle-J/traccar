package org.traccar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeviceTest {

    private Device createDevice() {
        Device device = new Device();
        device.setUniqueId("ID-1");
        device.setName("Test Device");
        return device;
    }

    @ParameterizedTest
    @DisplayName("Throws exception when unique ID is invalid format")
    @ValueSource(strings = {"/iphone-device", "12345/67890", "invalid/device/id", "Iphone\\mobile"})
    void throwsExceptionWhenUniqueIdIsInvalidFormat(String uniqueId) {
        assertThrows(IllegalArgumentException.class, () -> new Device().setUniqueId(uniqueId));
    }
}
