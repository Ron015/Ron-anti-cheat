package ai.idealistic.vacan.compatibility.b.a;

import ai.idealistic.vacan.abstraction.f.c;
import ai.idealistic.vacan.utils.a.e;
import com.comphenix.protocol.injector.temporary.TemporaryPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class b {
   private static boolean ia = false;
   private static boolean ib = false;

   public static boolean F(String var0) {
      return a.F(var0);
   }

   private static void eu() {
      ia = e.aa("com.comphenix.protocol.injector.temporary.TemporaryPlayer");
   }

   public static void run() {
      eu();
      if (!ib) {
         a.run();
      }

   }

   public static void ev() {
      eu();
      ib = true;
      String var0 = ai.idealistic.vacan.functionality.c.a.L("Anti-Cheat checks work significantly better with ProtocolLib installed as it allows the use of packets which helps identify information earlier and more accurately.");
      if (var0 != null) {
         List var1 = ai.idealistic.vacan.functionality.server.b.eZ();
         if (!var1.isEmpty()) {
            Iterator var2 = var1.iterator();

            while(var2.hasNext()) {
               c var3 = (c)var2.next();
               if (ai.idealistic.vacan.functionality.c.a.a(var3.bT(), "protocol-lib", 0)) {
                  var3.bC().sendMessage(var0);
               }
            }
         }
      }

   }

   public static boolean a(OfflinePlayer var0) {
      return ia && var0 instanceof TemporaryPlayer;
   }

   public static UUID d(Entity var0) {
      if (var0 instanceof Player) {
         return a((Player)var0) ? UUID.randomUUID() : var0.getUniqueId();
      } else {
         return var0.getUniqueId();
      }
   }

   public static int e(Entity var0) {
      if (var0 instanceof Player) {
         return a((Player)var0) ? (new Random()).nextInt() : var0.getEntityId();
      } else {
         return var0.getEntityId();
      }
   }

   public static Location f(Entity var0) {
      if (var0 instanceof Player) {
         return e((Player)var0);
      } else {
         return var0 == null ? null : var0.getLocation();
      }
   }

   public static Location e(Player var0) {
      if (a(var0)) {
         return null;
      } else {
         return var0 == null ? null : var0.getLocation();
      }
   }

   public static Entity g(Entity var0) {
      if (var0 instanceof Player) {
         return a((Player)var0) ? null : var0.getVehicle();
      } else {
         return var0.getVehicle();
      }
   }

   public static double h(Entity var0) {
      if (var0 instanceof Player) {
         return a((Player)var0) ? 0.0D : ((Player)var0).getEyeHeight();
      } else {
         return var0 instanceof LivingEntity ? ((LivingEntity)var0).getEyeHeight() : 0.0D;
      }
   }

   public static World i(Entity var0) {
      if (var0 instanceof Player) {
         return a((Player)var0) ? (World)Bukkit.getWorlds().get(0) : var0.getWorld();
      } else {
         return var0.getWorld();
      }
   }

   public static boolean c(CommandSender var0, String var1) {
      if (!(var0 instanceof Player)) {
         return var0.hasPermission(var1);
      } else {
         Player var2 = (Player)var0;
         return !a(var2) && var2.hasPermission(var1);
      }
   }
}
