package ai.idealistic.vacan.listeners.a.a;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class h implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(PlayerQuitEvent var1) {
      ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.j(var1.getPlayer());
      if (var2 != null) {
         ai.idealistic.vacan.functionality.c.c.x(var2);
      }
   }
}
