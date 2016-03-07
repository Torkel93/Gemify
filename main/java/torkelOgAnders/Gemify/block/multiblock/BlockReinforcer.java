package torkelOgAnders.Gemify.block.multiblock;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockReinforcer extends BlockMultiBlock {
    public BlockReinforcer() {
        super(Material.rock);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileStabilizerMultiblock();
    }
}
