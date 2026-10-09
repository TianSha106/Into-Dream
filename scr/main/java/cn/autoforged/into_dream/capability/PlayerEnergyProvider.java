package cn.autoforged.into_dream.capability;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nullable;

public class PlayerEnergyProvider implements ICapabilitySerializable<CompoundTag> {

    private final DreamEnergy backing = new DreamEnergy();
    private final LazyOptional<IDreamEnergy> optional = LazyOptional.of(() -> backing);

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction side) {
        return ModCapabilities.DREAM_ENERGY.orEmpty(capability, optional);
    }

    @Override
    public CompoundTag serializeNBT() {
        return backing.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        backing.deserializeNBT(tag);
    }
}
