package com.github.powerprofile;

import com.github.dto.OffsetPowerPerPtu;

import static java.util.Objects.requireNonNull;

public sealed interface EarlyPowerProfile extends PowerProfile{

    record CongestionProfile(OffsetPowerPerPtu profile) implements EarlyPowerProfile {
        // could have safety assessment forecasts
        public CongestionProfile {
            requireNonNull(profile);
        }

        @Override
        public OffsetPowerPerPtu compose() {
            return new OffsetPowerPerPtu(profile.id());
        }
    }

    record DesiredControlProfile(OffsetPowerPerPtu profile) implements EarlyPowerProfile {
        // could have eg. applied controls or other data
        public DesiredControlProfile {
            requireNonNull(profile);
        }

        @Override
        public OffsetPowerPerPtu compose() {
            return new OffsetPowerPerPtu(profile.id());
        }
    }

    record AppliedProfile(OffsetPowerPerPtu profile) implements EarlyPowerProfile {
        // could have eg. applied controls or other data
        public AppliedProfile {
            requireNonNull(profile);
        }

        @Override
        public OffsetPowerPerPtu compose() {
            return new OffsetPowerPerPtu(profile.id());
        }
    }
}
