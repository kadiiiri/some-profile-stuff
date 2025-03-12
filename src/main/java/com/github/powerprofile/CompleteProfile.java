package com.github.powerprofile;

import com.github.dto.OffsetPowerPerPtu;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.joining;

public record CompleteProfile(EarlyPowerProfile ...earlyPowerProfiles) implements LatePowerProfile {

    public CompleteProfile {
        requireNonNull(earlyPowerProfiles);
    }

    public OffsetPowerPerPtu compose() {
        return Arrays.stream(earlyPowerProfiles)
                .map(EarlyPowerProfile::compose)
                .map(OffsetPowerPerPtu::id)
                .collect(
                        collectingAndThen(
                                joining("-"),
                                OffsetPowerPerPtu::new
                        )
                );
    }

    public List<EarlyPowerProfile> decompose() {
        return asList(earlyPowerProfiles);
    }
}
