package squeek.appleskin.api.event;

import net.fabricmc.fabric.api.event.Event;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.ItemStack;
import squeek.appleskin.api.handler.EventHandler;

public class TooltipOverlayEvent
{
	/**
	 * If cancelled, will stop all rendering from happening.
	 */
	public static class Pre extends TooltipOverlayEvent
	{
		public Pre(ItemStack itemStack, FoodComponent defaultFood, FoodComponent modifiedFood)
		{
			super(itemStack, defaultFood, modifiedFood);
		}

		public static Event<EventHandler<Pre>> EVENT = EventHandler.createArrayBacked();
	}

	/**
	 * If cancelled, will reserve space for the food values, but will not
	 * render them.
	 */
	public static class Render extends TooltipOverlayEvent
	{
		public Render(ItemStack itemStack, int x, int y, DrawContext context, FoodComponent defaultFood, FoodComponent modifiedFood)
		{
			super(itemStack, defaultFood, modifiedFood);
			this.context = context;
			this.x = x;
			this.y = y;
		}

		public int x;
		public int y;
		public DrawContext context;

		public static Event<EventHandler<Render>> EVENT = EventHandler.createArrayBacked();
	}

	private TooltipOverlayEvent(ItemStack itemStack, FoodComponent defaultFood, FoodComponent modifiedFood)
	{
		this.itemStack = itemStack;
		this.defaultFood = defaultFood;
		this.modifiedFood = modifiedFood;
	}

	public final FoodComponent defaultFood;
	public final FoodComponent modifiedFood;

	public final ItemStack itemStack;

	public boolean isCanceled = false;
}
