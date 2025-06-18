package ai.idealistic.vacan.listeners.a;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerVelocityEvent;

public class h implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(PlayerVelocityEvent var1) {
      a(new ai.idealistic.vacan.abstraction.d.c(var1.getPlayer(), var1.getVelocity()), false);
   }

   public static void a(ai.idealistic.vacan.abstraction.d.c var0, boolean var1) {
      ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.i(var0.getPlayer());
      if (var2.bW() == var1) {
         var2.gC = var0;
         var2.gD.add(var0);
         if (var2.gD.size() > 2) {
            var2.gD.remove(0);
         }

         var2.gE.add(var0);
         if (var2.gE.size() > 2) {
            var2.gE.remove(0);
         }

         var2.b(var0.isCancelled(), var0);
      }

   }
}
