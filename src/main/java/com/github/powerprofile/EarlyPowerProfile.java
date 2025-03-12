package com.github.powerprofile;

public sealed interface EarlyPowerProfile
        extends PowerProfile
        permits CongestionProfile, DesiredControlProfile, AppliedProfile {

}
