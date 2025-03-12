package com.github.powerprofile;

import com.github.dto.OffsetPowerPerPtu;

import static java.util.Objects.requireNonNull;

public record CongestionProfile(OffsetPowerPerPtu profile) implements EarlyPowerProfile {
    // could have safety assessment forecasts
    public CongestionProfile {
        requireNonNull(profile);
    }

    @Override
    public OffsetPowerPerPtu compose() {
        return new OffsetPowerPerPtu(profile.id());
    }
}