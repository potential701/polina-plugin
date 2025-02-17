package polina.group.polina.commands

import org.bukkit.Color
import org.bukkit.FireworkEffect
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.EntityType
import org.bukkit.entity.Firework
import org.bukkit.entity.Player
import org.bukkit.inventory.meta.FireworkMeta

class PolinaCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender !is Player){
            return false
        }

        createHeartRocket(sender)

        return true
    }

    private fun createHeartRocket(player: Player){
        val xOffsets = arrayOf(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 45, 45, 40, 35, 30, 25, 20, 15, 10, 5, 0, -5, -10, -15, -20, -25, -30, -35, -40, -45, -45, -45, -40, -35, -30, -25, -20, -15, -10, -5, 0)
        val yOffsets = arrayOf(0, 5, 10, 15, 15, 15, 15, 10, 5, 0, -5, -10, -15, -20, -25, -30, -35, -40, -45, -50, -55, 5, 10, 15, 15, 15, 15, 10, 5, 0, -5, -10, -15, -20, -25, -30, -35, -40, -45, -50, -55)

        for (i in xOffsets.indices) {
            detonateRocket(player, xOffsets[i], yOffsets[i])
        }
    }

    private fun detonateRocket(player: Player, x: Int, z: Int){
        val location: Location = player.location
        location.x += x
        location.z += z
        location.y += 50
        val firework: Firework = location.world?.spawnEntity(location, EntityType.FIREWORK_ROCKET) as Firework
        val fireworkMeta: FireworkMeta = firework.fireworkMeta

        fireworkMeta.power = 2
        fireworkMeta.addEffect(FireworkEffect.builder().withColor(Color.RED).flicker(true).build())

        firework.fireworkMeta = fireworkMeta
        firework.detonate()
    }
}