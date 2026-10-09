package cn.autoforged.into_dream.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public final class ModCapabilities {

    /** 玩家能量 + 入梦状态。接口带 {@link net.minecraftforge.common.capabilities.AutoRegisterCapability}，自动注册。 */
    public static final Capability<IDreamEnergy> DREAM_ENERGY =
            CapabilityManager.get(new CapabilityToken<>() {
            });

    private ModCapabilities() {
    }
}
