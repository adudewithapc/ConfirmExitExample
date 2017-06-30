package thatmartinguy.exitprompt;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import thatmartinguy.exitprompt.proxy.IProxy;

@Mod(modid = "exitprompt", name = "Exit Prompt", version = "1.0")
public class ExitPrompt
{
    @SidedProxy(clientSide = "thatmartinguy.exitprompt.proxy.ClientProxy", serverSide = "thatmartinguy.exitprompt.proxy.ServerProxy")
    public static IProxy proxy;
}
