package ai.idealistic.vacan.listeners.a.b;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class a implements Listener {
   @EventHandler
   public void b(BlockPlaceEvent var1) {
      var1.setCancelled(true);
   }

   @EventHandler
   public void b(BlockBreakEvent var1) {
      var1.setCancelled(true);
   }
}
