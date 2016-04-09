package com.lothrazar.cyclicmagic.util;

import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;


public class UtilSearchWorld{


	public static ArrayList<IInventory> findTileEntityInventories(EntityPlayer player, int RADIUS) {
		// function imported
		// https://github.com/PrinceOfAmber/SamsPowerups/blob/master/Commands/src/main/java/com/lothrazar/samscommands/ModCommands.java#L193
		ArrayList<IInventory> found = new ArrayList<IInventory>();
		int xMin = (int) player.posX - RADIUS;
		int xMax = (int) player.posX + RADIUS;

		int yMin = (int) player.posY - RADIUS;
		int yMax = (int) player.posY + RADIUS;

		int zMin = (int) player.posZ - RADIUS;
		int zMax = (int) player.posZ + RADIUS;

		BlockPos posCurrent = null;
		for (int xLoop = xMin; xLoop <= xMax; xLoop++) {
			for (int yLoop = yMin; yLoop <= yMax; yLoop++) {
				for (int zLoop = zMin; zLoop <= zMax; zLoop++) {
					posCurrent = new BlockPos(xLoop, yLoop, zLoop);
					if (player.worldObj.getTileEntity(posCurrent) instanceof IInventory) {
						found.add((IInventory) player.worldObj.getTileEntity(posCurrent));
					}
				}
			}
		}

		return found;
	}

	
	public static int searchTileInventory(String search, IInventory inventory) 
	{
		int foundQty;
		foundQty = 0; 
		
		for (int slot = 0; slot < inventory.getSizeInventory(); slot++)//a break; will cancel this loop
		{
			ItemStack invItem = inventory.getStackInSlot(slot);
			if(invItem == null){continue;} //empty slot in chest (or container)
			 
			String invItemName = invItem.getDisplayName().toLowerCase(); 
			
			//find any overlap: so if x ==y , or if x substring of y, or y substring of x 
			if(search.equals(invItemName) 
				|| search.contains(invItemName)
				|| invItemName.contains(search))
			{  
				foundQty += invItem.stackSize; 
			} 
		} //end loop on current tile entity
		return foundQty;
	}
	//TODO: find TileEntities, find IInventories
	
	public static BlockPos findClosestBlock(EntityPlayer player, Block blockHunt, int RADIUS){

		BlockPos found = null;
		int xMin = (int) player.posX - RADIUS;
		int xMax = (int) player.posX + RADIUS;

		int yMin = (int) player.posY - RADIUS;
		int yMax = (int) player.posY + RADIUS;

		int zMin = (int) player.posZ - RADIUS;
		int zMax = (int) player.posZ + RADIUS;

		int distance = 0, distanceClosest = RADIUS * RADIUS;

		BlockPos posCurrent = null;
		for(int xLoop = xMin; xLoop <= xMax; xLoop++){
			for(int yLoop = yMin; yLoop <= yMax; yLoop++){
				for(int zLoop = zMin; zLoop <= zMax; zLoop++){
					posCurrent = new BlockPos(xLoop, yLoop, zLoop);

					if(player.worldObj.getBlockState(posCurrent).getBlock().equals(blockHunt)){
						// find closest?

						if(found == null){
							found = posCurrent;
						}
						else{
							distance = (int) distanceBetweenHorizontal(player.getPosition(), posCurrent);

							if(distance < distanceClosest){
								found = posCurrent;

								distanceClosest = distance;
							}
						}
					}
				}
			}
		}

		return found;
	}
	

	public static ArrayList<BlockPos> findBlocks(EntityPlayer player, Block blockHunt, int RADIUS ) 
	{        
		ArrayList<BlockPos> found = new ArrayList<BlockPos>();
		int xMin = (int) player.posX - RADIUS;
		int xMax = (int) player.posX + RADIUS;

		int yMin = (int) player.posY - RADIUS;
		int yMax = (int) player.posY + RADIUS;

		int zMin = (int) player.posZ - RADIUS;
		int zMax = (int) player.posZ + RADIUS;
		 
		BlockPos posCurrent = null; 
		for (int xLoop = xMin; xLoop <= xMax; xLoop++)
		{
			for (int yLoop = yMin; yLoop <= yMax; yLoop++)
			{
				for (int zLoop = zMin; zLoop <= zMax; zLoop++)
				{  
					posCurrent = new BlockPos(xLoop, yLoop, zLoop);
					if(player.worldObj.getBlockState(posCurrent).getBlock().equals(blockHunt))
					{ 
						found.add(posCurrent);
					} 
				}
			}
		}
		
		return found; 
	}
	
	
	public static double distanceBetweenHorizontal(BlockPos start, BlockPos end){

		int xDistance = Math.abs(start.getX() - end.getX());
		int zDistance = Math.abs(start.getZ() - end.getZ());
		// ye olde pythagoras
		return Math.sqrt(xDistance * xDistance + zDistance * zDistance);
	}
}
