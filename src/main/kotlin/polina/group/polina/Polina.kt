package polina.group.polina

import org.bukkit.plugin.java.JavaPlugin

class Polina : JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic
        logger.info("Hello, Polina!")
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
