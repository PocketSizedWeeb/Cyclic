package com.lothrazar.cyclic.block;

import com.lothrazar.cyclic.registry.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class DoorbellButton extends ButtonBlock implements SimpleWaterloggedBlock {

  public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
  public static final int LIGHTLVL = 4;
  public static final int POWERLVL = 1;

  public DoorbellButton(Properties properties) {
    super(properties.strength(0.5F).lightLevel(s -> s.getValue(POWERED) ? LIGHTLVL : 0), BlockSetType.STONE, 30, true);
    registerDefaultState(defaultBlockState().setValue(WATERLOGGED, false));
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    super.createBlockStateDefinition(builder);
    builder.add(WATERLOGGED);
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    BlockState stateForPlacement = super.getStateForPlacement(context);
    if (stateForPlacement == null) {
      return null;
    }
    return stateForPlacement.setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER);
  }

  @SuppressWarnings("deprecation")
  @Override
  public FluidState getFluidState(BlockState state) {
    return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
  }

  @Override
  public int getSignal(BlockState blockState, BlockGetter blockAccess, BlockPos pos, Direction side) {
    return blockState.getValue(POWERED) ? POWERLVL : 0;
  }

  @Override
  public int getDirectSignal(BlockState blockState, BlockGetter blockAccess, BlockPos pos, Direction side) {
    return blockState.getValue(POWERED) && getConnectedDirection(blockState) == side ? POWERLVL : 0;
  }

  @Override
  public boolean isSignalSource(BlockState state) {
    return true;
  }

  @Override
  protected void playSound(Player p, LevelAccessor level, BlockPos pos, boolean isOn) {
    if (isOn) {
      level.playSound(p, pos, this.getSound(isOn), SoundSource.BLOCKS);
    }
  }

  @Override
  protected SoundEvent getSound(boolean isOn) {
    return SoundRegistry.DOORBELL_MIKEKOENIG.get();
  }
}
