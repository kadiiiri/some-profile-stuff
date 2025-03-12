package com.github.powerprofile;

import com.github.dto.OffsetPowerPerPtu;

import static java.util.Objects.requireNonNull;

public record DesiredControlProfile(OffsetPowerPerPtu profile) implements EarlyPowerProfile {
    // could have eg. applied controls or other data
    public DesiredControlProfile {
        requireNonNull(profile);
    }

    @Override
    public OffsetPowerPerPtu compose() {
        return new OffsetPowerPerPtu(profile.id());
    }
}