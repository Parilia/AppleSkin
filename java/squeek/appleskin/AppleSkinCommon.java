package squeek.appleskin;

import net.fabricmc.api.ModInitializer;
import squeek.appleskin.network.SyncHandler;

public class AppleSkinCommon implements ModInitializer
{
	@Override
	public void onInitialize()
	{
		SyncHandler.init();
	}
}
