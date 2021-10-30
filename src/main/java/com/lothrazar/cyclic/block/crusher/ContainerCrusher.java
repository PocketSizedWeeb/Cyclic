package com.lothrazar.cyclic.block.crusher;

import com.lothrazar.cyclic.base.ContainerBase;
import com.lothrazar.cyclic.registry.BlockRegistry;
import com.lothrazar.cyclic.registry.ContainerScreenRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerCrusher extends ContainerBase {

  TileCrusher tile;

  public ContainerCrusher(int windowId, Level world, BlockPos pos, Inventory playerInventory, Player player) {
    super(ContainerScreenRegistry.CRUSHER, windowId);
    tile = (TileCrusher) world.getBlockEntity(pos);
    this.playerEntity = player;
    this.playerInventory = playerInventory;
    addSlot(new SlotItemHandler(tile.inputSlots, 0, 53, 35));
    addSlot(new SlotItemHandler(tile.outputSlots, 0, 105 + 4, 21 + 4));
    addSlot(new SlotItemHandler(tile.outputSlots, 1, 109, 55));
    this.endInv = 3;
    layoutPlayerInventorySlots(8, 84);
    this.trackAllIntFields(tile, TileCrusher.Fields.values().length);
    trackEnergy(tile);
  }

  @Override
  public boolean stillValid(Player playerIn) {
    return stillValid(ContainerLevelAccess.create(tile.getLevel(), tile.getBlockPos()), playerEntity, BlockRegistry.CRUSHER.get());
  }
}