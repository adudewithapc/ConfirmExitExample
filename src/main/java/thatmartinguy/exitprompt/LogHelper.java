package thatmartinguy.exitprompt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper
{
    private static final Logger LOGGER = LogManager.getLogger("exitprompt");
    public static void info(String string)
    {
        LOGGER.info(string);
    }
}
