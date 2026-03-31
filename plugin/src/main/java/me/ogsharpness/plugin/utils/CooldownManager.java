package me.ogsharpness.plugin.utils;

import java.util.*;

import org.bukkit.entity.Player;

public class CooldownManager {

    private final Map<UUID, Map<String, Long>> cooldowns = new HashMap<>();

    public boolean isOnCooldown(Player player, String key) {
        if (!cooldowns.containsKey(player.getUniqueId())) return false;

        long time = cooldowns.get(player.getUniqueId()).getOrDefault(key, 0L);
        return System.currentTimeMillis() < time;
    }

    public void setCooldown(Player player, String key, long cooldown) {
        cooldowns
                .computeIfAbsent(player.getUniqueId(), k -> new HashMap<>())
                .put(key, System.currentTimeMillis() + cooldown);
    }
}