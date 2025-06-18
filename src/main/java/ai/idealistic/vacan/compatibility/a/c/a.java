package ai.idealistic.vacan.compatibility.a.c;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.compatibility.Compatibility;
import ai.idealistic.vacan.functionality.server.c;
import com.evill4mer.RealDualWield.Api.PlayerOffhandAnimationEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class a implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   private void a(PlayerOffhandAnimationEvent var1) {
      Compatibility.CompatibilityType var2 = Compatibility.CompatibilityType.REAL_DUAL_WIELD;
      if (var2.isFunctional()) {
         ai.idealistic.vacan.functionality.server.a.jc.a(c.i(var1.getPlayer()), var2, (CheckEnums.HackType[])(new CheckEnums.HackType[]{CheckEnums.HackType.KILL_AURA, CheckEnums.HackType.HIT_REACH, CheckEnums.HackType.CRITICALS}), 5);
      }

   }
}
