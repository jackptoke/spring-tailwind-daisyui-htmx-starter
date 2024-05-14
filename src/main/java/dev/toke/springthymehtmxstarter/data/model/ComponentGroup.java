package dev.toke.springthymehtmxstarter.data.model;

public enum ComponentGroup {
    COMPONENT("COMPONENT"),
    ADAPTOR("ADAPTOR"),
    HARNESS("HARNESS"),
    ASSEMBLY("ASSEMBLY"),
    BATTERY_HARNESS("BATTERY_HARNESS"),
    BACKSHELL("BACKSHELL"),
    BOLT("BOLT"),
    BOOT("BOOT"),
    BRAID("BRAID"),
    CABLE("CABLE"),
    CAP("CAP"),
    CAPACITOR("CAPACITOR"),
    CAVITY_GROUP("CAVITY_GROUP"),
    CONNECTOR("CONNECTOR"),
    CONSUMABLE("CONSUMABLE"),
    COVER("COVER"),
    CIRCUIT_BREAKER("CIRCUIT_BREAKER"),
    DECAL("DECAL"),
    DIODE("DIODE"),
    ELECTRONIC("ELECTRONIC"),
    ENCLOSURE("ENCLOSURE"),
    END_SLEEVE("END_SLEEVE"),
    FUSE("FUSE"),
    GLAND("GLAND"),
    GLOBE("GLOBE"),
    GRANULES("GRANULES"),
    GROMMET("GROMMET"),
    HEAT_SHRINK("HEAT_SHRINK"),
    INSULATOR("INSULATOR"),
    LIGHT_ASSEMBLY("LIGHT_ASSEMBLY"),
    L_NUT("L_NUT"),
    LP_TERMINAL("LP_TERMINAL"),
    METAL("METAL"),
    MISCELLANEOUS("MISCELLANEOUS"),
    MULTICORE("MULTICORE"),
    NUT("NUT"),
    O_RING("O_RING"),
    PLUG("PLUG"),
    R_BUSH("R_BUSH"),
    REDUNDANT("REDUNDANT"),
    RELAYS("RELAYS"),
    RESISTOR("RESISTOR"),
    SCREW("SCREW"),
    SEAL("SEAL"),
    SPLICE("SPLICE"),
    SWITCH("SWITCH"),
    TAPE("TAPE"),
    TERMINAL("TERMINAL"),
    TEST("TEST"),
    TIES("TIES"),
    TOOLING("TOOLING"),
    TOOLS("TOOLS"),
    TPA("TPA"),
    T_PIECE("T_PIECE"),
    TUBE("TUBE"),
    TUBE_GAL("TUBE_GAL"),
    TUBE_PIN("TUBE_PIN"),
    TUBE_PPA("TUBE_PPA"),
    WASHER("WASHER");

    private final String value;
    ComponentGroup(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
