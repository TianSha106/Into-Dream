package cn.autoforged.into_dream.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;
import net.minecraftforge.common.util.INBTSerializable;

/**
 * 玩家能量值与入梦状态。
 *
 * <p>能量无储存上限（可为任意非负值），新玩家开局能量为 {@code IntoDream#DEFAULT_ENERGY}。
 * 能量瓶回复 / 死亡扣除（每次 20）通过该接口完成，入梦本身不消耗能量。
 * 入梦状态 {@link #isDreaming()} 是服务端权威的瞬态标记，随玩家存档持久化，客户端通过同步包获知。
 */
@AutoRegisterCapability
public interface IDreamEnergy extends INBTSerializable<CompoundTag> {

    int getEnergy();

    void setEnergy(int value);

    /** 增加能量（无上限）。 */
    void addEnergy(int amount);

    /** 扣除能量，不低于 0。 */
    void subtractEnergy(int amount);

    boolean isDreaming();

    void setDreaming(boolean dreaming);
}
