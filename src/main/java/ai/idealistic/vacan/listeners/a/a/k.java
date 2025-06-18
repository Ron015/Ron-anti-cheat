package ai.idealistic.vacan.listeners.a.a;

import ai.idealistic.vacan.abstraction.profiling.MiningHistory;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class k implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(BlockBreakEvent var1) {
      ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.a(var1.getPlayer(), true);
      Block var3 = var1.getBlock();
      boolean var4 = var1.isCancelled();
      var2.b(var1.isCancelled(), var1);
      MiningHistory.a(var2, var3, var4);
   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(SignChangeEvent var1) {
      ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.a(var1.getPlayer(), true);
      var2.b(var1.isCancelled(), var1);
   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(PlayerAnimationEvent var1) {
      ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.a(var1.getPlayer(), true);
      var2.b(var1.isCancelled(), var1);
   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(PlayerInteractEvent var1) {
      ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.a(var1.getPlayer(), true);
      var2.b(false, var1);
   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(BlockPistonExtendEvent var1) {
      if (!var1.isCancelled()) {
         ai.idealistic.vacan.functionality.d.c.a(var1.getBlock(), var1.getBlocks());
      }

   }
}
