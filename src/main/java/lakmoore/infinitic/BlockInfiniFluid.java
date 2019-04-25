package lakmoore.infinitic;

import java.lang.reflect.Field;

import lakmoore.infinitic.lib.helpers.MapColorHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.smeltery.block.BlockTinkerFluid;

public class BlockInfiniFluid extends BlockTinkerFluid {

	public BlockInfiniFluid(Fluid fluid) {
		super(fluid, Material.LAVA);

		//force the map color to something other than TNT(Lava)
		try {
			Field c = Block.class.getDeclaredField("blockMapColor");
			c.setAccessible(true);
			c.set(this, MapColorHelper.GetMapColor(fluid.getColor()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
}
