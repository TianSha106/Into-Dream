package cn.autoforged.into_dream.capability;

import cn.autoforged.into_dream.IntoDream;
import net.minecraft.nbt.CompoundTag;

public class DreamEnergy implements IDreamEnergy {

    private int energy;
    private boolean dreaming;

    public DreamEnergy() {
        this(IntoDream.DEFAULT_ENERGY);
    }

    public DreamEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public void setEnergy(int value) {
        // 能量无储存上限，但下限仍不低于 0。
        this.energy = Math.max(0, value);
    }

    @Override
    public void addEnergy(int amount) {
        if (amount > 0) {
            this.energy += amount;
        }
    }

    @Override
    public void subtractEnergy(int amount) {
        if (amount > 0) {
            this.energy = Math.max(0, this.energy - amount);
        }
    }

    @Override
    public boolean isDreaming() {
        return this.dreaming;
    }

    @Override
    public void setDreaming(boolean dreaming) {
        this.dreaming = dreaming;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("energy", this.energy);
        tag.putBoolean("dreaming", this.dreaming);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        if (tag.contains("energy")) {
            this.energy = tag.getInt("energy");
        } else {
            this.energy = IntoDream.DEFAULT_ENERGY;
        }
        this.dreaming = tag.getBoolean("dreaming");
    }
}
