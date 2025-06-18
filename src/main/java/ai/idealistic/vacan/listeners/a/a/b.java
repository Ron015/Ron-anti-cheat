package ai.idealistic.vacan.listeners.a.a;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class b implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(AsyncPlayerChatEvent var1) {
      ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.i(var1.getPlayer());
      var2.b(var1.isCancelled(), var1);
   }
}
