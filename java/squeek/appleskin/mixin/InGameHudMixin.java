package squeek.appleskin.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import squeek.appleskin.client.HUDOverlayHandler;

@Mixin(InGameHud.class)
public class InGameHudMixin
{
	@Inject(at = @At("HEAD"), method = "renderFood")
	private void renderFoodPre(DrawContext context, PlayerEntity player, int top, int right, CallbackInfo info)
	{
		if (HUDOverlayHandler.INSTANCE != null)
			HUDOverlayHandler.INSTANCE.onPreRender(context, player, top, right);
	}

	@Inject(at = @At("RETURN"), method = "renderFood")
	private void renderFoodPost(DrawContext context, PlayerEntity player, int top, int right, CallbackInfo info)
	{
		if (HUDOverlayHandler.INSTANCE != null)
			HUDOverlayHandler.INSTANCE.onRender(context, player, top, right);
	}
}
