package com.github.powerprofile;

import java.util.List;

public sealed interface LatePowerProfile extends PowerProfile permits CompleteProfile {
    List<EarlyPowerProfile> decompose();
}
