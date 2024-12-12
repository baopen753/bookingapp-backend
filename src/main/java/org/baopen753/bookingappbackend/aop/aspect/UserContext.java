package org.baopen753.bookingappbackend.aop.aspect;

public class UserContext {

    private static final ThreadLocal<String> authenticatedUsername = new ThreadLocal<>();

    public static void setAuthenticatedUsername(String username) {
        authenticatedUsername.set(username);
    }

    public static String getAuthenticatedUsername() {
        return authenticatedUsername.get();
    }

    public static void clear() {
        authenticatedUsername.remove();
    }
}
