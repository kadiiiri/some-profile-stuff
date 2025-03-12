package com.github;

import com.github.dto.OffsetPowerPerPtu;
import com.github.powerprofile.AppliedProfile;
import com.github.powerprofile.CompleteProfile;
import com.github.powerprofile.CongestionProfile;
import com.github.powerprofile.DesiredControlProfile;

public class Main {
    public static void main(String[] args) {
        var congestionProfileData = new OffsetPowerPerPtu("CongestionProfileData");
        var desiredControlProfileData = new OffsetPowerPerPtu("DesiredControlProfileData");
        var appliedControlProfileData = new OffsetPowerPerPtu("AppliedControlProfileData");

        var congestionProfile = new CongestionProfile(congestionProfileData);
        var desiredControlProfile = new DesiredControlProfile(desiredControlProfileData);
        var appliedControlProfile = new AppliedProfile(appliedControlProfileData);

        var completeProfile = new CompleteProfile(
                congestionProfile,
                desiredControlProfile,
                appliedControlProfile
        );

        var result = completeProfile.compose();

        var earlyPowerProfiles = completeProfile.decompose();

        System.out.println("Decomposed early profiles: " + earlyPowerProfiles);
        System.out.println("Composed profile: " + result);

        // Output 1:
        // OffsetPowerPerPtu[id=CongestionProfileData-DesiredControlProfileData-AppliedControlProfileData]
        //
        // Output 2:
        // [CongestionProfile[profile=OffsetPowerPerPtu[id=CongestionProfileData]],
        // DesiredControlProfile[profile=OffsetPowerPerPtu[id=DesiredControlProfileData]],
        // AppliedProfile[profile=OffsetPowerPerPtu[id=AppliedControlProfileData]]]

        switch (earlyPowerProfiles.getFirst()) {
            case AppliedProfile appliedProfile -> System.out.println("First profile: " + appliedProfile);
            case CongestionProfile profile -> System.out.println("First profile: " + profile);
            case DesiredControlProfile controlProfile -> System.out.println("First profile: " + controlProfile);
        }

        // Output 3:
        // CongestionProfile[profile=OffsetPowerPerPtu[id=CongestionProfileData]


        // Get only the congestionProfiles
        var congestionProfiles = earlyPowerProfiles.stream()
                .filter(CongestionProfile.class::isInstance)
                .toList();

        // Get only the DesiredControlProfiles
        var desiredControlProfiles = earlyPowerProfiles.stream()
                .filter(DesiredControlProfile.class::isInstance)
                .toList();

        // We can now make a new profile with these or use them for other unique operations

        System.out.println("Congestion Profiles: " + congestionProfiles);
        System.out.println("Desired Control Profiles: " + desiredControlProfiles);
    }
}