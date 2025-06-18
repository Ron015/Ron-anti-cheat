package ai.idealistic.vacan.listeners.a;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class c implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void c(PlayerMoveEvent var1) {
      a(var1, false);
   }

   public static void a(PlayerMoveEvent var0, boolean var1) {
      ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.i(var0.getPlayer());
      if (var2.bW() == var1) {
         Location var3 = var0.getTo();
         if (var3 == null) {
            return;
         }

         Location var4 = var2.bN();
         ai.idealistic.vacan.abstraction.g.b var5 = var4 != null ? new ai.idealistic.vacan.abstraction.g.b(var4) : new ai.idealistic.vacan.abstraction.g.b(var3);
         if (!var2.a(var3, var4, var5, var0.getFrom(), var1)) {
            return;
         }

         var2.b(var0.isCancelled(), var0);
      }

   }

   public static void a(ai.idealistic.vacan.abstraction.d.g var0) {
      ai.idealistic.vacan.abstraction.f.c var1 = var0.ac;
      var1.gM = var0;
      var1.gL.a(var0);
      var1.gH.b(var0);
      var1.b(false, var0);
   }

   public static void a(ai.idealistic.vacan.abstraction.d.h var0) {
      ai.idealistic.vacan.abstraction.f.c var1 = var0.ac;
      var1.b(false, var0);
   }
}
