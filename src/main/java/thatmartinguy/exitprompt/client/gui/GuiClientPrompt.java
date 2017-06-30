package thatmartinguy.exitprompt.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.fml.client.FMLClientHandler;

import java.io.IOException;

public class GuiClientPrompt extends GuiMainMenu
{
    private final GuiButton yesButton = new GuiButton(20, this.width / 4, this.height / 4, "Yes");
    private final GuiButton noButton = new GuiButton(21, this.width / 4, this.height / 4 + 100, "No");

    @Override
    public void initGui()
    {
        super.initGui();
        this.buttonList.removeAll(buttonList);
        this.buttonList.add(yesButton);
        this.buttonList.add(noButton);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if(button.id == 20)
        {
            Minecraft.getMinecraft().shutdown(true);
        }
        else
        {
            FMLClientHandler.instance().showGuiScreen(new GuiMainMenu());
        }
    }
}
