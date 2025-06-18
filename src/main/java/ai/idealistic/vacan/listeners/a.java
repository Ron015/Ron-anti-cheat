package ai.idealistic.vacan.listeners;

import ai.idealistic.vacan.abstraction.f.c;
import ai.idealistic.vacan.abstraction.g.b;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class a implements Listener {
   public static final boolean jL;
   private static final List<ai.idealistic.vacan.abstraction.c.a> jM;

   public static void clear() {
      if (!jM.isEmpty()) {
         synchronized(jM) {
            Iterator var1 = jM.iterator();

            while(var1.hasNext()) {
               ai.idealistic.vacan.abstraction.c.a var2 = (ai.idealistic.vacan.abstraction.c.a)var1.next();
               var2.bm();
            }

            jM.clear();
         }
      }

   }

   public static void a(World var0) {
      if (!jM.isEmpty()) {
         synchronized(jM) {
            Iterator var2 = jM.iterator();

            while(var2.hasNext()) {
               ai.idealistic.vacan.abstraction.c.a var3 = (ai.idealistic.vacan.abstraction.c.a)var2.next();
               if (var0.equals(var3.fr.getWorld())) {
                  var3.bm();
               }
            }

            jM.clear();
         }
      }

   }

   public static void A(c var0) {
      if (jL) {
         Location var1 = var0.bO();
         if (!jM.isEmpty()) {
            synchronized(jM) {
               Iterator var3 = jM.iterator();

               while(var3.hasNext()) {
                  ai.idealistic.vacan.abstraction.c.a var4 = (ai.idealistic.vacan.abstraction.c.a)var3.next();
                  if (b.b(var4.W, var1) <= 16.0D) {
                     var0.l(var4.W);
                     return;
                  }
               }

               jM.add(new ai.idealistic.vacan.abstraction.c.a(var1));
            }
         } else {
            synchronized(jM) {
               jM.add(new ai.idealistic.vacan.abstraction.c.a(var1));
            }
         }
      }

   }

   @EventHandler
   public void a(PlayerInteractAtEntityEvent var1) {
      Entity var2 = var1.getRightClicked();
      if (var2 instanceof ArmorStand) {
         UUID var3 = var2.getUniqueId();
         if (!jM.isEmpty()) {
            synchronized(jM) {
               Iterator var5 = jM.iterator();

               while(var5.hasNext()) {
                  ai.idealistic.vacan.abstraction.c.a var6 = (ai.idealistic.vacan.abstraction.c.a)var5.next();
                  if (var6.bn().equals(var3)) {
                     var1.setCancelled(true);
                     var6.bl();
                     c var7 = ai.idealistic.vacan.functionality.server.c.i(var1.getPlayer());
                     ai.idealistic.vacan.functionality.server.c.jm.a(var7, var7.bC().getName());
                     break;
                  }
               }
            }
         }
      }

   }

   @EventHandler
   public void b(EntityDamageByEntityEvent var1) {
      Entity var2 = var1.getEntity();
      if (var2 instanceof ArmorStand) {
         UUID var3 = var2.getUniqueId();
         if (!jM.isEmpty()) {
            synchronized(jM) {
               Iterator var5 = jM.iterator();

               while(var5.hasNext()) {
                  ai.idealistic.vacan.abstraction.c.a var6 = (ai.idealistic.vacan.abstraction.c.a)var5.next();
                  if (var6.bn().equals(var3)) {
                     var1.setCancelled(true);
                     var6.bl();
                     Entity var7 = var1.getDamager();
                     if (var7 instanceof Player) {
                        c var8 = ai.idealistic.vacan.functionality.server.c.i((Player)var7);
                        ai.idealistic.vacan.functionality.server.c.jm.a(var8, var8.bC().getName());
                     }
                     break;
                  }
               }
            }
         }
      }

   }

   static {
      jL = MultiVersion.c(MultiVersion.MCVersion.V1_8);
      jM = Collections.synchronizedList(new ArrayList());
      ai.idealistic.vacan.functionality.server.c.a(() -> {
         if (!jM.isEmpty()) {
            List var0 = ai.idealistic.vacan.functionality.server.b.eZ();
            if (var0.isEmpty()) {
               clear();
            } else {
               synchronized(jM) {
                  Iterator var2 = jM.iterator();

                  while(var2.hasNext()) {
                     ai.idealistic.vacan.abstraction.c.a var3 = (ai.idealistic.vacan.abstraction.c.a)var2.next();
                     boolean var4 = false;
                     Iterator var5 = var0.iterator();

                     while(var5.hasNext()) {
                        c var6 = (c)var5.next();
                        if (b.b(var3.W, var6.bO()) <= 16.0D) {
                           var4 = true;
                           break;
                        }
                     }

                     if (var4) {
                        if (!var3.a(var0)) {
                           var2.remove();
                        }
                     } else {
                        var3.bm();
                        var2.remove();
                     }
                  }
               }
            }
         }

      }, 1L, 1L);
   }
}
