package marumasa.config_name;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Map;
import java.util.logging.Logger;

public class Event implements Listener {
    private final Map<String, String> playerList;
    private final Logger logger = Bukkit.getLogger();

    public Event(Config config) {
        playerList = config.playerList;
    }

    @EventHandler
    public void onLogin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        final String UUID = player.getUniqueId().toString().replaceAll("-", "");
        String name = playerList.get(UUID);
        if (name != null) {
            logger.info(
                    String.format("%s -> %s", player.getDisplayName(), name)
            );
            player.setDisplayName(name);
        }
    }
}