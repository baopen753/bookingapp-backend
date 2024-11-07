package org.baopen753.bookingappbackend.enums;

public enum Role {
    MANAGER,
    CUSTOMER,
    VETERINARIAN,
    STAFF;

    public enum Role {
        MANAGER(1),
        CUSTOMER(2),
        VETERINARIAN(3),
        STAFF(4);


        private int value;

        Role(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
