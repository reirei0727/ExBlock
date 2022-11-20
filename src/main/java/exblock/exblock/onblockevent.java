package exblock.exblock;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class onblockevent implements Listener {


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        Player player = e.getPlayer(); // イベントを起こしたプレイヤー
        Location toLocation = e.getTo(); // イベントを起こしたプレイヤーの進んだ先
        World w = player.getWorld();

        Block underBlockType = toLocation.getBlock().getRelative(BlockFace.DOWN); // 進んだ先の真下のブロックのMaterial
        if (underBlockType.getType() == Material.COBBLESTONE || underBlockType.getType() == Material.STONE || underBlockType.getType() == Material.DEEPSLATE||underBlockType.getType() == Material.MOSSY_COBBLESTONE) {
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                // 全プレイヤー対象
                onlinePlayer.sendMessage(ChatColor.RED + player.getName() + " が禁止ブロックを踏みました!");
                Location l = onlinePlayer.getLocation();
                l.setY(l.getY() + 2);
                w.createExplosion(l,100F,true,true);
            }
        }
    }

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,100000,1,false,false));
    }

    @EventHandler
    @Deprecated
    public void onSpawnEvent(PlayerRespawnEvent e){
        Bukkit.getScheduler().runTaskLater(Exblock.getInstance(), task ->{
            Player p = e.getPlayer();
            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,100000,1,false,false));
        },5L);

    }
}

