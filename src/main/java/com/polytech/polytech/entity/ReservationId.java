package com.polytech.polytech.entity;

import java.io.Serializable;
import java.util.Objects;

public class ReservationId implements Serializable {
    private Long utilisateurId;
    private Long jeuxId;

    public ReservationId() {}

    public ReservationId(Long utilisateurId, Long jeuxId) {
        this.utilisateurId = utilisateurId;
        this.jeuxId = jeuxId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationId that = (ReservationId) o;
        return Objects.equals(utilisateurId, that.utilisateurId) &&
                Objects.equals(jeuxId, that.jeuxId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilisateurId, jeuxId);
    }
}