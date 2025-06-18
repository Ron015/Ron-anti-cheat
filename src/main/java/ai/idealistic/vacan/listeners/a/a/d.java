package ai.idealistic.vacan.listeners.a.a;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

public class d implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   private void a(EntityToggleGlideEvent var1) {
      Entity var2 = var1.getEntity();
      if (var2 instanceof Player) {
         ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i((Player)var2);
         var3.b(var1.isCancelled(), var1);
      }

   }
}
