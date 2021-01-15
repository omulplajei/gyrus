package com.gyrus;

import java.util.Objects;

public class Health {

    public static final Health UP = new Health("UP");

    private String status;

    public Health() {
    }

    public Health(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Health health = (Health) o;

        return Objects.equals(status, health.status);
    }

    @Override
    public int hashCode() {
        return status != null ? status.hashCode() : 0;
    }
}
