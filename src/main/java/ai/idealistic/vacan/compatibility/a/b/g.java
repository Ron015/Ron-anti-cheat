package ai.idealistic.vacan.compatibility.a.b;

import ai.idealistic.vacan.Register;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.compatibility.Compatibility;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import wtf.choco.veinminer.api.event.player.PlayerClientActivateVeinMinerEvent;
import wtf.choco.veinminer.api.event.player.PlayerVeinMineEvent;

public class g implements Listener {
   public static void eq() {
      Register.enable(new g());
   }

   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   private void a(PlayerVeinMineEvent var1) {
      if (Compatibility.CompatibilityType.VEIN_MINER.isFunctional()) {
         ai.idealistic.vacan.functionality.server.a.jc.a(ai.idealistic.vacan.functionality.server.c.i(var1.getPlayer()), Compatibility.CompatibilityType.VEIN_MINER, new CheckEnums.HackType[]{CheckEnums.HackType.NO_SWING, CheckEnums.HackType.FAST_BREAK, CheckEnums.HackType.GHOST_HAND, CheckEnums.HackType.BLOCK_REACH, CheckEnums.HackType.FAST_PLACE}, ai.idealistic.vacan.utils.b.a.A(20.0D));
      }

   }

   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   private void a(PlayerClientActivateVeinMinerEvent var1) {
      if (Compatibility.CompatibilityType.VEIN_MINER.isFunctional()) {
         ai.idealistic.vacan.functionality.server.a.jc.a(ai.idealistic.vacan.functionality.server.c.i(var1.getPlayer()), Compatibility.CompatibilityType.VEIN_MINER, new CheckEnums.HackType[]{CheckEnums.HackType.NO_SWING, CheckEnums.HackType.FAST_BREAK, CheckEnums.HackType.GHOST_HAND, CheckEnums.HackType.BLOCK_REACH, CheckEnums.HackType.FAST_PLACE}, ai.idealistic.vacan.utils.b.a.A(20.0D));
      }

   }
}
