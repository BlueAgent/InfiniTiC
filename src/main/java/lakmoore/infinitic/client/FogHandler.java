package lakmoore.infinitic.client;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ActiveRenderInfo;

import net.minecraftforge.client.event.EntityViewRenderEvent.FogColors;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.smeltery.block.BlockTinkerFluid;

public class FogHandler {

	public static FogHandler INSTANCE = new FogHandler();

	private FogHandler() {
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onFogColors(FogColors event) {
		
		final IBlockState iblockstate = ActiveRenderInfo.getBlockStateAtEntityViewpoint(event.getEntity().world,
				event.getEntity(), (float) event.getRenderPartialTicks());
		
        if (iblockstate.getBlock() instanceof BlockTinkerFluid) {
        	BlockTinkerFluid fluidBlock = (BlockTinkerFluid) iblockstate.getBlock();
    		if (fluidBlock != null) {
    			int color = fluidBlock.getFluid().getColor();
    			event.setRed((color >> 16 & 255) / 255.0F);
    			event.setGreen((color >> 8 & 255) / 255.0F);
    	        event.setBlue((color & 255) / 255.0F);
    		}	
        }

	}
				
}