package polina.group.polina

import org.bukkit.plugin.java.JavaPlugin
import polina.group.polina.commands.PolinaCommand

class Polina : JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic
        logger.info("Hello, Polina!")

        getCommand("polina")?.setExecutor(PolinaCommand())
    }

    override fun onDisable() {
        // Plugin shutdown logic
        logger.info("Goodbye, Polina!")
    }
}
