package com.github;

import com.github.powerprofile.EarlyPowerProfile.AppliedProfile;
import com.github.powerprofile.EarlyPowerProfile.DesiredControlProfile;
import com.github.powerprofile.LatePowerProfile.CompleteProfile;
import com.github.dto.OffsetPowerPerPtu;
import com.github.powerprofile.EarlyPowerProfile.CongestionProfile;

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
        System.out.println(result);
        System.out.println(earlyPowerProfiles);

        // Output 1:
        // OffsetPowerPerPtu[id=CongestionProfileData-DesiredControlProfileData-AppliedControlProfileData]
        //
        // Output 2:
        // [CongestionProfile[profile=OffsetPowerPerPtu[id=CongestionProfileData]],
        // DesiredControlProfile[profile=OffsetPowerPerPtu[id=DesiredControlProfileData]],
        // AppliedProfile[profile=OffsetPowerPerPtu[id=AppliedControlProfileData]]]
    }
}