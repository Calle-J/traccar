package org.traccar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermissionTest {

    @Test
    @DisplayName("Static: User + Device returns tc_user_device")
    public void testStaticGetStorageNameNoPrefixUserDevice() {
        final Class<? extends BaseModel> ownerClass = User.class;
        final Class<? extends BaseModel> propertyClass = Device.class;

        String storageName = Permission.getStorageName(ownerClass, propertyClass);

        assertEquals("tc_user_device", storageName);
    }

    @Test
    @DisplayName("Static: Managed prefix stripped, User + ManagedUser returns tc_user_user")
    public void testStaticGetStorageNameManagedPrefixUserManagedUser() {
        final Class<? extends BaseModel> ownerClass = User.class;
        final Class<? extends BaseModel> propertyClass = ManagedUser.class;

        String storageName = Permission.getStorageName(ownerClass, propertyClass);

        assertEquals("tc_user_user", storageName);
    }

    @Test
    @DisplayName("Static: Linked prefix stripped, Device + LinkedDevice returns tc_device_device")
    public void testStaticGetStorageNameLinkedPrefixDeviceLinkedDevice() {
        final Class<? extends BaseModel> ownerClass = Device.class;
        final Class<? extends BaseModel> propertyClass = LinkedDevice.class;

        String storageName = Permission.getStorageName(ownerClass, propertyClass);

        assertEquals("tc_device_device", storageName);
    }

    @Test
    @DisplayName("Instance: User + Device returns tc_user_device")
    public void testInstanceGetStorageNameUserDevice() {
        final Class<? extends BaseModel> ownerClass = User.class;
        final Class<? extends BaseModel> propertyClass = Device.class;
        final Permission permission = new Permission(ownerClass, 1, propertyClass, 2);

        String storageName = permission.getStorageName();

        assertEquals("tc_user_device", storageName);
    }

    @Test
    @DisplayName("Static: Group + Attribute returns tc_group_attribute")
    public void testStaticGetStorageNameGroupAttribute() {
        final Class<? extends BaseModel> ownerClass = Group.class;
        final Class<? extends BaseModel> propertyClass = Attribute.class;

        String storageName = Permission.getStorageName(ownerClass, propertyClass);

        assertEquals("tc_group_attribute", storageName);
    }

    @Test
    @DisplayName("Static: Group + Geofence returns tc_group_geofence")
    public void testStaticGetStorageNameGroupGeofence() {
        final Class<? extends BaseModel> ownerClass = Group.class;
        final Class<? extends BaseModel> propertyClass = Geofence.class;

        String storageName = Permission.getStorageName(ownerClass, propertyClass);

        assertEquals("tc_group_geofence", storageName);
    }
}
