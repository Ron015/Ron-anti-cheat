package ai.idealistic.vacan.functionality.server;

import ai.idealistic.vacan.Register;
import io.papermc.paper.threadedregions.scheduler.ScheduledTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

class d {
   static void j(Runnable var0) {
      if (Register.isPluginEnabled()) {
         if (!MultiVersion.jg) {
            Bukkit.getScheduler().runTask(Register.plugin, var0);
         } else {
            Bukkit.getGlobalRegionScheduler().run(Register.plugin, (var1) -> {
               var0.run();
            });
         }
      }

   }

   static void a(ai.idealistic.vacan.abstraction.f.c var0, Runnable var1, boolean var2) {
      if (!MultiVersion.jg) {
         if (var2 && !Bukkit.isPrimaryThread()) {
            if (Register.isPluginEnabled()) {
               Bukkit.getScheduler().runTask(Register.plugin, var1);
            }
         } else {
            var1.run();
         }
      } else if (var0 != null) {
         if (Register.isPluginEnabled()) {
            Location var3 = var0.getLocation();
            Bukkit.getRegionScheduler().execute(Register.plugin, var3.getWorld(), ai.idealistic.vacan.abstraction.g.b.j(var3.getBlockX()), ai.idealistic.vacan.abstraction.g.b.j(var3.getBlockZ()), var1);
         }
      } else {
         var1.run();
      }

   }

   static void a(World var0, int var1, int var2, Runnable var3, boolean var4) {
      if (!MultiVersion.jg) {
         if (var4 && !Bukkit.isPrimaryThread()) {
            if (Register.isPluginEnabled()) {
               Bukkit.getScheduler().runTask(Register.plugin, var3);
            }
         } else {
            var3.run();
         }
      } else if (Register.isPluginEnabled()) {
         Bukkit.getRegionScheduler().execute(Register.plugin, var0, var1, var2, var3);
      }

   }

   static Object b(ai.idealistic.vacan.abstraction.f.c var0, Runnable var1, long var2, long var4) {
      if (Register.isPluginEnabled()) {
         if (!MultiVersion.jg) {
            return var4 == -1L ? Bukkit.getScheduler().scheduleSyncDelayedTask(Register.plugin, var1, var2) : Bukkit.getScheduler().scheduleSyncRepeatingTask(Register.plugin, var1, var2, var4);
         } else {
            Location var6;
            if (var4 == -1L) {
               if (var0 != null) {
                  var6 = var0.getLocation();
                  return Bukkit.getRegionScheduler().runDelayed(Register.plugin, var6.getWorld(), ai.idealistic.vacan.abstraction.g.b.j(var6.getBlockX()), ai.idealistic.vacan.abstraction.g.b.j(var6.getBlockZ()), (var1x) -> {
                     var1.run();
                  }, var2);
               } else {
                  return Bukkit.getGlobalRegionScheduler().runDelayed(Register.plugin, (var1x) -> {
                     var1.run();
                  }, var2);
               }
            } else if (var0 != null) {
               var6 = var0.getLocation();
               return Bukkit.getRegionScheduler().runAtFixedRate(Register.plugin, var6.getWorld(), ai.idealistic.vacan.abstraction.g.b.j(var6.getBlockX()), ai.idealistic.vacan.abstraction.g.b.j(var6.getBlockZ()), (var1x) -> {
                  var1.run();
               }, var2, var4);
            } else {
               return Bukkit.getGlobalRegionScheduler().runAtFixedRate(Register.plugin, (var1x) -> {
                  var1.run();
               }, var2, var4);
            }
         }
      } else {
         return null;
      }
   }

   static void i(Object var0) {
      if (!MultiVersion.jg) {
         if (var0 instanceof Integer) {
            Bukkit.getScheduler().cancelTask((Integer)var0);
         }
      } else if (var0 instanceof ScheduledTask) {
         ((ScheduledTask)var0).cancel();
      }

   }
}
