package marumasa.config_name;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Config {
    public final Map<String, String> playerList = new HashMap<>();

    public Config(minecraft plugin) {
        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();

        final List<Map<?, ?>> items = config.getMapList("player");
        for (Map<?, ?> item : items) {
            playerList.put(
                    ((String) item.get("UUID")).replaceAll("-", ""),
                    (String) item.get("name")
            );
        }
    }
}
