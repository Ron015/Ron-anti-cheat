package ai.idealistic.vacan.compatibility.a.a;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.compatibility.Compatibility;
import com.projectkorra.projectkorra.event.AbilityDamageEntityEvent;
import com.projectkorra.projectkorra.event.AbilityProgressEvent;
import com.projectkorra.projectkorra.event.AbilityStartEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class g implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   private void a(AbilityStartEvent var1) {
      if (Compatibility.CompatibilityType.PROJECT_KORRA.isFunctional()) {
         b(ai.idealistic.vacan.functionality.server.c.i(var1.getAbility().getPlayer()), 60);
      }

   }

   @EventHandler
   private void a(AbilityProgressEvent var1) {
      if (Compatibility.CompatibilityType.PROJECT_KORRA.isFunctional()) {
         b(ai.idealistic.vacan.functionality.server.c.i(var1.getAbility().getPlayer()), 40);
      }

   }

   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   private void a(AbilityDamageEntityEvent var1) {
      if (Compatibility.CompatibilityType.PROJECT_KORRA.isFunctional()) {
         Entity var2 = var1.getEntity();
         if (var2 instanceof Player) {
            b(ai.idealistic.vacan.functionality.server.c.i((Player)var2), 60);
         }
      }

   }

   private static void b(ai.idealistic.vacan.abstraction.f.c var0, int var1) {
      Compatibility.CompatibilityType var2 = Compatibility.CompatibilityType.PROJECT_KORRA;
      ai.idealistic.vacan.functionality.server.a.jc.a(var0, var2, new CheckEnums.HackCategoryType[]{CheckEnums.HackCategoryType.MOVEMENT, CheckEnums.HackCategoryType.COMBAT}, var1);
      ai.idealistic.vacan.functionality.server.a.jc.a(var0, var2, CheckEnums.HackType.NO_SWING, var1);
   }
}
