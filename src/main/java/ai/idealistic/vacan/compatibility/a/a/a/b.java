package ai.idealistic.vacan.compatibility.a.a.a;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.compatibility.Compatibility;
import ai.idealistic.vacan.utils.a.c;
import java.util.LinkedHashMap;
import me.DeeCaaD.CrackShotPlus.Events.WeaponSecondScopeEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class b implements Listener {
   private static final ai.idealistic.vacan.abstraction.b.a hv = new ai.idealistic.vacan.abstraction.b.a(new c(new LinkedHashMap(), 512));

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(WeaponSecondScopeEvent var1) {
      if (Compatibility.CompatibilityType.CRACK_SHOT_PLUS.isFunctional()) {
         ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.i(var1.getPlayer());
         if (!var1.isCancelled()) {
            ai.idealistic.vacan.functionality.server.a.jc.a(var2, Compatibility.CompatibilityType.CRACK_SHOT_PLUS, (CheckEnums.HackCategoryType[])(new CheckEnums.HackCategoryType[]{CheckEnums.HackCategoryType.MOVEMENT, CheckEnums.HackCategoryType.COMBAT}), 20);
            if (var1.isZoomIn()) {
               hv.b(var2.bT() + "=crackshotplus=compatibility=scope", 1);
            } else {
               hv.u(var2.bT() + "=crackshotplus=compatibility=scope");
            }
         } else {
            hv.u(var2.bT() + "=crackshotplus=compatibility=scope");
         }
      }

   }

   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   private void a(EntityDamageEvent var1) {
      if (Compatibility.CompatibilityType.CRACK_SHOT_PLUS.isFunctional()) {
         Entity var2 = var1.getEntity();
         if (var2 instanceof Player) {
            ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i((Player)var2);
            if (k(var3)) {
               ai.idealistic.vacan.functionality.server.a.jc.a(var3, Compatibility.CompatibilityType.CRACK_SHOT_PLUS, (CheckEnums.HackCategoryType[])(new CheckEnums.HackCategoryType[]{CheckEnums.HackCategoryType.MOVEMENT, CheckEnums.HackCategoryType.COMBAT}), 60);
            }
         }
      }

   }

   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   private void a(EntityDamageByEntityEvent var1) {
      if (Compatibility.CompatibilityType.CRACK_SHOT_PLUS.isFunctional()) {
         Entity var2 = var1.getDamager();
         if (var2 instanceof Player) {
            ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i((Player)var2);
            if (k(var3)) {
               ai.idealistic.vacan.functionality.server.a.jc.a(var3, Compatibility.CompatibilityType.CRACK_SHOT_PLUS, (CheckEnums.HackCategoryType[])(new CheckEnums.HackCategoryType[]{CheckEnums.HackCategoryType.MOVEMENT, CheckEnums.HackCategoryType.COMBAT}), 30);
            }
         }
      }

   }

   static boolean k(ai.idealistic.vacan.abstraction.f.c var0) {
      return Compatibility.CompatibilityType.CRACK_SHOT_PLUS.isFunctional() && hv.s(var0.bT() + "=crackshotplus=compatibility=scope") != 0.0D;
   }
}
