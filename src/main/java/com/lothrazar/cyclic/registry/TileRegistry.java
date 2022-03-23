package com.lothrazar.cyclic.registry;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.block.anvil.TileAnvilAuto;
import com.lothrazar.cyclic.block.anvilmagma.TileAnvilMagma;
import com.lothrazar.cyclic.block.anvilvoid.TileAnvilVoid;
import com.lothrazar.cyclic.block.battery.TileBattery;
import com.lothrazar.cyclic.block.battery.TileClayBattery;
import com.lothrazar.cyclic.block.beaconpotion.TilePotion;
import com.lothrazar.cyclic.block.bedrock.UnbreakablePoweredTile;
import com.lothrazar.cyclic.block.breaker.TileBreaker;
import com.lothrazar.cyclic.block.cable.energy.TileCableEnergy;
import com.lothrazar.cyclic.block.cable.fluid.TileCableFluid;
import com.lothrazar.cyclic.block.cable.item.TileCableItem;
import com.lothrazar.cyclic.block.clock.TileRedstoneClock;
import com.lothrazar.cyclic.block.collectfluid.TileFluidCollect;
import com.lothrazar.cyclic.block.collectitem.TileItemCollector;
import com.lothrazar.cyclic.block.conveyor.TileConveyor;
import com.lothrazar.cyclic.block.crafter.TileCrafter;
import com.lothrazar.cyclic.block.crate.TileCrate;
import com.lothrazar.cyclic.block.creativebattery.TileBatteryInfinite;
import com.lothrazar.cyclic.block.creativeitem.TileItemInfinite;
import com.lothrazar.cyclic.block.crusher.TileCrusher;
import com.lothrazar.cyclic.block.detectmoon.TileMoon;
import com.lothrazar.cyclic.block.detectorentity.TileDetector;
import com.lothrazar.cyclic.block.detectoritem.TileDetectorItem;
import com.lothrazar.cyclic.block.detectweather.TileWeather;
import com.lothrazar.cyclic.block.dice.TileDice;
import com.lothrazar.cyclic.block.disenchant.TileDisenchant;
import com.lothrazar.cyclic.block.dropper.TileDropper;
import com.lothrazar.cyclic.block.enderctrl.TileEnderCtrl;
import com.lothrazar.cyclic.block.enderitemshelf.TileItemShelf;
import com.lothrazar.cyclic.block.endershelf.TileEnderShelf;
import com.lothrazar.cyclic.block.expcollect.TileExpPylon;
import com.lothrazar.cyclic.block.eye.TileEye;
import com.lothrazar.cyclic.block.eyetp.TileEyeTp;
import com.lothrazar.cyclic.block.fan.TileFan;
import com.lothrazar.cyclic.block.fanslab.TileFanSlab;
import com.lothrazar.cyclic.block.fishing.TileFisher;
import com.lothrazar.cyclic.block.forester.TileForester;
import com.lothrazar.cyclic.block.generatorfluid.TileGeneratorFluid;
import com.lothrazar.cyclic.block.generatorfood.TileGeneratorFood;
import com.lothrazar.cyclic.block.generatorfuel.TileGeneratorFuel;
import com.lothrazar.cyclic.block.generatoritem.TileGeneratorDrops;
import com.lothrazar.cyclic.block.harvester.TileHarvester;
import com.lothrazar.cyclic.block.hopper.TileSimpleHopper;
import com.lothrazar.cyclic.block.hopperfluid.TileFluidHopper;
import com.lothrazar.cyclic.block.hoppergold.TileGoldHopper;
import com.lothrazar.cyclic.block.laser.TileLaser;
import com.lothrazar.cyclic.block.lightcompr.TileLightCamo;
import com.lothrazar.cyclic.block.magnet.TileInsertingMagnet;
import com.lothrazar.cyclic.block.melter.TileMelter;
import com.lothrazar.cyclic.block.miner.TileMiner;
import com.lothrazar.cyclic.block.packager.TilePackager;
import com.lothrazar.cyclic.block.peatfarm.TilePeatFarm;
import com.lothrazar.cyclic.block.phantom.MembraneLampTile;
import com.lothrazar.cyclic.block.phantom.SoilTile;
import com.lothrazar.cyclic.block.placer.TilePlacer;
import com.lothrazar.cyclic.block.placerfluid.TilePlacerFluid;
import com.lothrazar.cyclic.block.rotator.TileRotator;
import com.lothrazar.cyclic.block.screen.TileScreentext;
import com.lothrazar.cyclic.block.shapebuilder.TileStructure;
import com.lothrazar.cyclic.block.shapedata.TileShapedata;
import com.lothrazar.cyclic.block.solidifier.TileSolidifier;
import com.lothrazar.cyclic.block.soundmuff.ghost.SoundmuffTile;
import com.lothrazar.cyclic.block.soundplay.TileSoundPlayer;
import com.lothrazar.cyclic.block.soundrecord.TileSoundRecorder;
import com.lothrazar.cyclic.block.spikes.TileDiamondSpikes;
import com.lothrazar.cyclic.block.sprinkler.TileSprinkler;
import com.lothrazar.cyclic.block.tank.TileTank;
import com.lothrazar.cyclic.block.tankcask.TileCask;
import com.lothrazar.cyclic.block.terraglass.TileTerraGlass;
import com.lothrazar.cyclic.block.terrasoil.TileTerraPreta;
import com.lothrazar.cyclic.block.tp.TileTeleport;
import com.lothrazar.cyclic.block.trash.TileTrash;
import com.lothrazar.cyclic.block.uncrafter.TileUncraft;
import com.lothrazar.cyclic.block.user.TileUser;
import com.lothrazar.cyclic.block.wireless.energy.TileWirelessEnergy;
import com.lothrazar.cyclic.block.wireless.fluid.TileWirelessFluid;
import com.lothrazar.cyclic.block.wireless.item.TileWirelessItem;
import com.lothrazar.cyclic.block.wireless.redstone.TileWirelessRec;
import com.lothrazar.cyclic.block.wireless.redstone.TileWirelessTransmit;
import com.lothrazar.cyclic.block.workbench.TileWorkbench;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TileRegistry {

  public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ModCyclic.MODID);
  public static final RegistryObject<BlockEntityType<TileFluidHopper>> FLUIDHOPPER = TILES.register("hopper_fluid", () -> BlockEntityType.Builder.of(TileFluidHopper::new, BlockRegistry.FLUIDHOPPER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileSimpleHopper>> HOPPER = TILES.register("hopper", () -> BlockEntityType.Builder.of(TileSimpleHopper::new, BlockRegistry.HOPPER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileGoldHopper>> HOPPERGOLD = TILES.register("hopper_gold", () -> BlockEntityType.Builder.of(TileGoldHopper::new, BlockRegistry.HOPPERGOLD.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileAnvilVoid>> ANVILVOID = TILES.register("anvil_void", () -> BlockEntityType.Builder.of(TileAnvilVoid::new, BlockRegistry.ANVILVOID.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileFanSlab>> FANSLAB = TILES.register("fan_slab", () -> BlockEntityType.Builder.of(TileFanSlab::new, BlockRegistry.FANSLAB.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileRotator>> ROTATOR = TILES.register("rotator", () -> BlockEntityType.Builder.of(TileRotator::new, BlockRegistry.ROTATOR.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileMoon>> DETECTORMOON = TILES.register("detector_moon", () -> BlockEntityType.Builder.of(TileMoon::new, BlockRegistry.DETECTORMOON.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileWeather>> DETECTORWEATHER = TILES.register("detector_weather", () -> BlockEntityType.Builder.of(TileWeather::new, BlockRegistry.DETECTORWEATHER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileTerraGlass>> TERRAGLASS = TILES.register("terra_glass", () -> BlockEntityType.Builder.of(TileTerraGlass::new, BlockRegistry.TERRAGLASS.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileSprinkler>> SPRINKLER = TILES.register("sprinkler", () -> BlockEntityType.Builder.of(TileSprinkler::new, BlockRegistry.SPRINKLER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileItemShelf>> ENDER_ITEM_SHELF = TILES.register("ender_item_shelf", () -> BlockEntityType.Builder.of(TileItemShelf::new, BlockRegistry.ENDER_ITEM_SHELF.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileWirelessEnergy>> WIRELESS_ENERGY = TILES.register("wireless_energy", () -> BlockEntityType.Builder.of(TileWirelessEnergy::new, BlockRegistry.WIRELESS_ENERGY.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileWirelessItem>> WIRELESS_ITEM = TILES.register("wireless_item", () -> BlockEntityType.Builder.of(TileWirelessItem::new, BlockRegistry.WIRELESS_ITEM.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileWirelessFluid>> WIRELESS_FLUID = TILES.register("wireless_fluid", () -> BlockEntityType.Builder.of(TileWirelessFluid::new, BlockRegistry.WIRELESS_FLUID.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileSoundRecorder>> SOUND_RECORDER = TILES.register("sound_recorder", () -> BlockEntityType.Builder.of(TileSoundRecorder::new, BlockRegistry.SOUND_RECORDER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileSoundPlayer>> SOUND_PLAYER = TILES.register("sound_player", () -> BlockEntityType.Builder.of(TileSoundPlayer::new, BlockRegistry.SOUND_PLAYER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileGeneratorFuel>> GENERATOR_FUEL = TILES.register("generator_fuel", () -> BlockEntityType.Builder.of(TileGeneratorFuel::new, BlockRegistry.GENERATOR_FUEL.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileGeneratorFood>> GENERATOR_FOOD = TILES.register("generator_food", () -> BlockEntityType.Builder.of(TileGeneratorFood::new, BlockRegistry.GENERATOR_FOOD.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileGeneratorDrops>> GENERATOR_ITEM = TILES.register("generator_item", () -> BlockEntityType.Builder.of(TileGeneratorDrops::new, BlockRegistry.GENERATOR_ITEM.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileGeneratorFluid>> GENERATOR_FLUID = TILES.register("generator_fluid", () -> BlockEntityType.Builder.of(TileGeneratorFluid::new, BlockRegistry.GENERATOR_FLUID.get()).build(null));
  public static final RegistryObject<BlockEntityType<TilePackager>> PACKAGER = TILES.register("packager", () -> BlockEntityType.Builder.of(TilePackager::new, BlockRegistry.PACKAGER.get()).build(null));
  public static final RegistryObject<BlockEntityType<MembraneLampTile>> LAMP = TILES.register("lamp", () -> BlockEntityType.Builder.of(MembraneLampTile::new, BlockRegistry.LAMP.get()).build(null));
  public static final RegistryObject<BlockEntityType<SoilTile>> SOIL = TILES.register("soil", () -> BlockEntityType.Builder.of(SoilTile::new, BlockRegistry.SOIL.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileCrusher>> CRUSHER = TILES.register("crusher", () -> BlockEntityType.Builder.of(TileCrusher::new, BlockRegistry.CRUSHER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileTeleport>> TELEPORT = TILES.register("teleport", () -> BlockEntityType.Builder.of(TileTeleport::new, BlockRegistry.TELEPORT.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileDiamondSpikes>> SPIKES_DIAMOND = TILES.register("spikes_diamond", () -> BlockEntityType.Builder.of(TileDiamondSpikes::new, BlockRegistry.SPIKES_DIAMOND.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileLightCamo>> LIGHT_CAMO = TILES.register("light_camo", () -> BlockEntityType.Builder.of(TileLightCamo::new, BlockRegistry.LIGHT_CAMO.get()).build(null));
  public static final RegistryObject<BlockEntityType<SoundmuffTile>> SOUNDPROOFING_GHOST = TILES.register("soundproofing_ghost", () -> BlockEntityType.Builder.of(SoundmuffTile::new, BlockRegistry.SOUNDPROOFING_GHOST.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileTerraPreta>> TERRA_PRETA = TILES.register("terra_preta", () -> BlockEntityType.Builder.of(TileTerraPreta::new, BlockRegistry.TERRA_PRETA.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileEye>> EYE_REDSTONE = TILES.register("eye_redstone", () -> BlockEntityType.Builder.of(TileEye::new, BlockRegistry.EYE_REDSTONE.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileEyeTp>> EYE_TELEPORT = TILES.register("eye_teleport", () -> BlockEntityType.Builder.of(TileEyeTp::new, BlockRegistry.EYE_TELEPORT.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileAnvilMagma>> ANVIL_MAGMA = TILES.register("anvil_magma", () -> BlockEntityType.Builder.of(TileAnvilMagma::new, BlockRegistry.ANVIL_MAGMA.get()).build(null));
  public static final RegistryObject<BlockEntityType<TilePotion>> BEACON = TILES.register("beacon", () -> BlockEntityType.Builder.of(TilePotion::new, BlockRegistry.BEACON.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileBatteryInfinite>> BATTERY_INFINITE = TILES.register("battery_infinite", () -> BlockEntityType.Builder.of(TileBatteryInfinite::new, BlockRegistry.BATTERY_INFINITE.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileItemInfinite>> ITEM_INFINITE = TILES.register("item_infinite", () -> BlockEntityType.Builder.of(TileItemInfinite::new, BlockRegistry.ITEM_INFINITE.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileDice>> DICE = TILES.register("dice", () -> BlockEntityType.Builder.of(TileDice::new, BlockRegistry.DICE.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileDropper>> DROPPER = TILES.register("dropper", () -> BlockEntityType.Builder.of(TileDropper::new, BlockRegistry.DROPPER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileForester>> FORESTER = TILES.register("forester", () -> BlockEntityType.Builder.of(TileForester::new, BlockRegistry.FORESTER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileMiner>> MINER = TILES.register("miner", () -> BlockEntityType.Builder.of(TileMiner::new, BlockRegistry.MINER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileScreentext>> SCREEN = TILES.register("screen", () -> BlockEntityType.Builder.of(TileScreentext::new, BlockRegistry.SCREEN.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileUncraft>> UNCRAFTER = TILES.register("uncrafter", () -> BlockEntityType.Builder.of(TileUncraft::new, BlockRegistry.UNCRAFTER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TilePlacerFluid>> PLACER_FLUID = TILES.register("placer_fluid", () -> BlockEntityType.Builder.of(TilePlacerFluid::new, BlockRegistry.PLACER_FLUID.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileCask>> CASK = TILES.register("cask", () -> BlockEntityType.Builder.of(TileCask::new, BlockRegistry.CASK.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileCrate>> CRATE = TILES.register("crate", () -> BlockEntityType.Builder.of(TileCrate::new, BlockRegistry.CRATE.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileRedstoneClock>> CLOCK = TILES.register("clock", () -> BlockEntityType.Builder.of(TileRedstoneClock::new, BlockRegistry.CLOCK.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileWirelessRec>> WIRELESS_RECEIVER = TILES.register("wireless_receiver", () -> BlockEntityType.Builder.of(TileWirelessRec::new, BlockRegistry.WIRELESS_RECEIVER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileWirelessTransmit>> WIRELESS_TRANSMITTER = TILES.register("wireless_transmitter", () -> BlockEntityType.Builder.of(TileWirelessTransmit::new, BlockRegistry.WIRELESS_TRANSMITTER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileFluidCollect>> COLLECTOR_FLUID = TILES.register("collector_fluid", () -> BlockEntityType.Builder.of(TileFluidCollect::new, BlockRegistry.COLLECTOR_FLUID.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileDisenchant>> DISENCHANTER = TILES.register("disenchanter", () -> BlockEntityType.Builder.of(TileDisenchant::new, BlockRegistry.DISENCHANTER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileDetectorItem>> DETECTOR_ITEM = TILES.register("detector_item", () -> BlockEntityType.Builder.of(TileDetectorItem::new, BlockRegistry.DETECTOR_ITEM.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileDetector>> DETECTOR_ENTITY = TILES.register("detector_entity", () -> BlockEntityType.Builder.of(TileDetector::new, BlockRegistry.DETECTOR_ENTITY.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileSolidifier>> SOLIDIFIER = TILES.register("solidifier", () -> BlockEntityType.Builder.of(TileSolidifier::new, BlockRegistry.SOLIDIFIER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileMelter>> MELTER = TILES.register("melter", () -> BlockEntityType.Builder.of(TileMelter::new, BlockRegistry.MELTER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileTank>> TANK = TILES.register("tank", () -> BlockEntityType.Builder.of(TileTank::new, BlockRegistry.TANK.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileBreaker>> BREAKER = TILES.register("breaker", () -> BlockEntityType.Builder.of(TileBreaker::new, BlockRegistry.BREAKER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileItemCollector>> COLLECTOR = TILES.register("collector", () -> BlockEntityType.Builder.of(TileItemCollector::new, BlockRegistry.COLLECTOR.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileFan>> FAN = TILES.register("fan", () -> BlockEntityType.Builder.of(TileFan::new, BlockRegistry.FAN.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileExpPylon>> EXPERIENCE_PYLON = TILES.register("experience_pylon", () -> BlockEntityType.Builder.of(TileExpPylon::new, BlockRegistry.EXPERIENCE_PYLON.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileTrash>> TRASH = TILES.register("trash", () -> BlockEntityType.Builder.of(TileTrash::new, BlockRegistry.TRASH.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileInsertingMagnet>> MAGNET = TILES.register("magnet", () -> BlockEntityType.Builder.of(TileInsertingMagnet::new, BlockRegistry.MAGNET_BLOCK.get()).build(null));
  public static final RegistryObject<BlockEntityType<TilePeatFarm>> PEAT_FARM = TILES.register("peat_farm", () -> BlockEntityType.Builder.of(TilePeatFarm::new, BlockRegistry.PEAT_FARM.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileBattery>> BATTERY = TILES.register("battery", () -> BlockEntityType.Builder.of(TileBattery::new, BlockRegistry.BATTERY.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileClayBattery>> BATTERY_CLAY = TILES.register("battery_clay", () -> BlockEntityType.Builder.of(TileClayBattery::new, BlockRegistry.BATTERY_CLAY.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileCableEnergy>> ENERGY_PIPE = TILES.register("energy_pipe", () -> BlockEntityType.Builder.of(TileCableEnergy::new, BlockRegistry.ENERGY_PIPE.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileCableItem>> ITEM_PIPE = TILES.register("item_pipe", () -> BlockEntityType.Builder.of(TileCableItem::new, BlockRegistry.ITEM_PIPE.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileCableFluid>> FLUID_PIPE = TILES.register("fluid_pipe", () -> BlockEntityType.Builder.of(TileCableFluid::new, BlockRegistry.FLUID_PIPE.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileHarvester>> HARVESTER = TILES.register("harvester", () -> BlockEntityType.Builder.of(TileHarvester::new, BlockRegistry.HARVESTER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileAnvilAuto>> ANVIL = TILES.register("anvil", () -> BlockEntityType.Builder.of(TileAnvilAuto::new, BlockRegistry.ANVIL.get()).build(null));
  public static final RegistryObject<BlockEntityType<TilePlacer>> PLACER = TILES.register("placer", () -> BlockEntityType.Builder.of(TilePlacer::new, BlockRegistry.PLACER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileStructure>> STRUCTURE = TILES.register("structure", () -> BlockEntityType.Builder.of(TileStructure::new, BlockRegistry.STRUCTURE.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileFisher>> FISHER = TILES.register("fisher", () -> BlockEntityType.Builder.of(TileFisher::new, BlockRegistry.FISHER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileUser>> USER = TILES.register("user", () -> BlockEntityType.Builder.of(TileUser::new, BlockRegistry.USER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileCrafter>> CRAFTER = TILES.register("crafter", () -> BlockEntityType.Builder.of(TileCrafter::new, BlockRegistry.CRAFTER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileShapedata>> COMPUTER_SHAPE = TILES.register("computer_shape", () -> BlockEntityType.Builder.of(TileShapedata::new, BlockRegistry.COMPUTER_SHAPE.get()).build(null));
  public static final RegistryObject<BlockEntityType<UnbreakablePoweredTile>> UNBREAKABLE_REACTIVE = TILES.register("unbreakable_reactive", () -> BlockEntityType.Builder.of(UnbreakablePoweredTile::new, BlockRegistry.UNBREAKABLE_REACTIVE.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileLaser>> LASER = TILES.register("laser", () -> BlockEntityType.Builder.of(TileLaser::new, BlockRegistry.LASER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileConveyor>> CONVEYOR = TILES.register("conveyor", () -> BlockEntityType.Builder.of(TileConveyor::new, BlockRegistry.CONVEYOR.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileEnderShelf>> ENDER_SHELF = TILES.register("ender_shelf", () -> BlockEntityType.Builder.of(TileEnderShelf::new, BlockRegistry.ENDER_SHELF.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileEnderCtrl>> ENDER_CONTROLLER = TILES.register("ender_controller", () -> BlockEntityType.Builder.of(TileEnderCtrl::new, BlockRegistry.ENDER_CONTROLLER.get()).build(null));
  public static final RegistryObject<BlockEntityType<TileWorkbench>> WORKBENCH = TILES.register("workbench", () -> BlockEntityType.Builder.of(TileWorkbench::new, BlockRegistry.WORKBENCH.get()).build(null));
}
