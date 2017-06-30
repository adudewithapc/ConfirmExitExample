package thatmartinguy.exitprompt.event;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.event.ApplicationCloseEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.server.FMLServerHandler;
import thatmartinguy.exitprompt.LogHelper;
import thatmartinguy.exitprompt.client.gui.GuiClientPrompt;

@Mod.EventBusSubscriber
public class CloseEventHandler
{
    private static boolean listenServer;
    @SubscribeEvent
    public static void promptClient(ApplicationCloseEvent event)
    {
        if(event.isClient())
        {
            if(FMLClientHandler.instance().isGUIOpen(GuiMainMenu.class))
            {
                event.setCanceled(true);
                FMLClientHandler.instance().showGuiScreen(new GuiClientPrompt());
            }
        }
        else
        {
            LogHelper.info("Are you sure you would like to stop the server? (Y/N)");
            listenServer = true;
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void getServerResponse(ServerChatEvent event)
    {
        if(event.getMessage().toLowerCase().equals("y") && listenServer)
        {
            FMLServerHandler.instance().getServer().initiateShutdown(true);
        }
        else if(event.getMessage().toLowerCase().equals("n") && listenServer)
        {
            listenServer = false;
        }
    }
}
