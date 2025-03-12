package com.github.powerprofile;

import com.github.dto.OffsetPowerPerPtu;

import static java.util.Objects.requireNonNull;

public record AppliedProfile(OffsetPowerPerPtu profile) implements EarlyPowerProfile {
    public AppliedProfile {
        requireNonNull(profile);
    }

    @Override
    public OffsetPowerPerPtu compose() {
        return new OffsetPowerPerPtu(profile.id());
    }
}