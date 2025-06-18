package ai.idealistic.vacan.listeners.a;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.abstraction.d.i;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class a implements Listener {
   private static final CheckEnums.HackType[] jN;

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void c(EntityDamageByEntityEvent var1) {
      a(var1, false);
   }

   public static void a(EntityDamageByEntityEvent var0, boolean var1) {
      Entity var2 = var0.getDamager();
      Entity var3 = var0.getEntity();
      boolean var4 = var2 instanceof Player;
      boolean var5 = var3 instanceof Player;
      boolean var6 = var0.getCause() == DamageCause.ENTITY_ATTACK;
      Player var7;
      ai.idealistic.vacan.abstraction.f.c var8;
      boolean var9;
      if (var4) {
         var7 = (Player)var2;
         var8 = ai.idealistic.vacan.functionality.server.c.a(var7, true);
         if (var8.bW() == var1 && var6 && (var5 || var3 instanceof LivingEntity)) {
            var9 = var0.isCancelled();
            ai.idealistic.vacan.abstraction.d.e var10 = new ai.idealistic.vacan.abstraction.d.e(var7, (LivingEntity)var3, var9);
            var8.b(var9, var10);
            CheckEnums.HackType[] var11 = jN;
            int var12 = var11.length;

            for(int var13 = 0; var13 < var12; ++var13) {
               CheckEnums.HackType var14 = var11[var13];
               if (var8.a(var14).j()) {
                  var0.setCancelled(true);
               }
            }
         }
      }

      if (var5) {
         var7 = (Player)var3;
         var8 = ai.idealistic.vacan.functionality.server.c.a(var7, true);
         if (var8.bW() == var1 && var6 && (var4 || var2 instanceof LivingEntity)) {
            var9 = var0.isCancelled();
            var8.b(var9, new ai.idealistic.vacan.abstraction.d.d(var7, (LivingEntity)var2, var9));
         }
      }

   }

   public static void a(i var0) {
      ai.idealistic.vacan.abstraction.f.c var1 = ai.idealistic.vacan.functionality.server.c.a(var0.fd, true);
      var1.b(false, new ai.idealistic.vacan.abstraction.d.e(var0.fd, var0.fz, false));
   }

   static {
      jN = new CheckEnums.HackType[]{CheckEnums.HackType.KILL_AURA, CheckEnums.HackType.HIT_REACH, CheckEnums.HackType.NO_SWING, CheckEnums.HackType.CRITICALS, CheckEnums.HackType.FAST_CLICKS};
   }
}
