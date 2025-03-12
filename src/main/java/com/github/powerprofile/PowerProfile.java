package com.github.powerprofile;

import com.github.dto.OffsetPowerPerPtu;

public sealed interface PowerProfile permits EarlyPowerProfile, LatePowerProfile {
    OffsetPowerPerPtu compose();
}
