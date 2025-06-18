package ai.idealistic.vacan.listeners.a;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class d implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public static void a(BlockPlaceEvent var0) {
      ai.idealistic.vacan.abstraction.f.c var1 = ai.idealistic.vacan.functionality.server.c.a(var0.getPlayer(), true);
      if (a(var1, var0.getBlock(), var0.getBlockAgainst(), var0, false)) {
         var0.setCancelled(true);
      }

   }

   public static boolean a(ai.idealistic.vacan.abstraction.f.c var0, Block var1, Block var2, Object var3, boolean var4) {
      if (var0.bW() == var4) {
         if (var0.bV() != var1.getWorld()) {
            return false;
         }

         var0.b((Object)null, var3);
         if (!ai.idealistic.vacan.compatibility.a.a.d.e(var1)) {
            var0.b(var3, new ai.idealistic.vacan.abstraction.d.a(var0.bC(), var1, var2, var3 instanceof Cancellable && ((Cancellable)var3).isCancelled()));
         }
      }

      return var0.a(CheckEnums.HackType.FAST_PLACE).j() || var0.a(CheckEnums.HackType.BLOCK_REACH).j() || var0.a(CheckEnums.HackType.IMPOSSIBLE_ACTIONS).j();
   }
}
