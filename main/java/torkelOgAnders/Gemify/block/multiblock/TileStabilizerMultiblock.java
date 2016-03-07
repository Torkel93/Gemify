package torkelOgAnders.Gemify.block.multiblock;


import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import torkelOgAnders.Gemify.Gemify;

public class TileStabilizerMultiblock extends TileMultiBlock {
    @Override
    public void doMultiBlockStuff() {
    	
    }

    @Override
    public boolean checkMultiBlockForm() {
        // Checks to see if surrounded by exynite
        int i = 0;
        for (int x = xCoord - 1; x < xCoord + 2; x++)
            for (int y = yCoord -1; y < yCoord + 2; y++)
                for (int z = zCoord - 1; z < zCoord + 2; z++) {
                    if (worldObj.getBlock(x, y, z) == Gemify.blockStabilizer)
                        i++;
                }
        return i == 26;
    }

    @Override
    public void setupStructure() {
        // replaces exynite with air and spawn GemReinforcer
        for (int x = xCoord - 1; x < xCoord + 2; x++)
            for (int y = yCoord -1; y < yCoord + 2; y++)
                for (int z = zCoord - 1; z < zCoord + 2; z++) {
                    if (worldObj.getBlock(x, y, z) == Gemify.blockStabilizer)
                        worldObj.setBlock(x, y, z, Blocks.air);
                }	
        worldObj.setBlock(xCoord, yCoord, zCoord, Gemify.machineGemReinforcer);
    }

    @Override
    public void resetStructure() {

    }

    @Override
    public void masterWriteToNBT(NBTTagCompound tag) {

    }

    @Override
    public void masterReadFromNBT(NBTTagCompound tag) {

    }
}