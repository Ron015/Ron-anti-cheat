package ai.idealistic.vacan.functionality.server;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.api.Permission;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.bukkit.entity.Player;

public class b {
   private static final String jh = "vacan.*";
   private static final Permission[] ji;

   public static boolean g(Player var0) {
      Permission[] var1 = Permission.values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Permission var4 = var1[var3];
         if (a(var0, var4)) {
            return true;
         }
      }

      return false;
   }

   public static boolean a(Player var0, Permission var1) {
      if (ai.idealistic.vacan.compatibility.b.a.b.c(var0, var1.getKey())) {
         return true;
      } else {
         return var1 != Permission.ADMIN ? ai.idealistic.vacan.compatibility.b.a.b.c(var0, Permission.ADMIN.getKey()) || ai.idealistic.vacan.compatibility.b.a.b.c(var0, "vacan.*") : ai.idealistic.vacan.compatibility.b.a.b.c(var0, "vacan.*");
      }
   }

   public static boolean b(Player var0, Permission var1) {
      return ai.idealistic.vacan.compatibility.b.a.b.c(var0, var1.getKey());
   }

   public static boolean isBypassing(Player var0, CheckEnums.HackType var1) {
      if (var0.isOp()) {
         return a.iZ.i("Important.op_bypass");
      } else {
         String var2 = Permission.BYPASS.getKey();
         if (ai.idealistic.vacan.compatibility.b.a.b.c(var0, var2)) {
            return true;
         } else {
            return var1 != null ? ai.idealistic.vacan.compatibility.b.a.b.c(var0, var2 + "." + var1.toString().toLowerCase()) : false;
         }
      }
   }

   public static boolean h(Player var0) {
      if (var0.isOp()) {
         return true;
      } else {
         Permission[] var1 = ji;
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            Permission var4 = var1[var3];
            if (a(var0, var4)) {
               return true;
            }
         }

         return false;
      }
   }

   public static List<ai.idealistic.vacan.abstraction.f.c> eZ() {
      Collection var0 = c.fc();
      int var1 = var0.size();
      if (var1 > 0) {
         ArrayList var2 = new ArrayList(var1);
         Iterator var3 = var0.iterator();

         while(var3.hasNext()) {
            ai.idealistic.vacan.abstraction.f.c var4 = (ai.idealistic.vacan.abstraction.f.c)var3.next();
            if (h(var4.bC())) {
               var2.add(var4);
            }
         }

         return var2;
      } else {
         return new ArrayList(0);
      }
   }

   static {
      ji = new Permission[]{Permission.WAVE, Permission.WARN, Permission.ADMIN, Permission.KICK, Permission.NOTIFICATIONS, Permission.USE_BYPASS, Permission.MANAGE, Permission.INFO};
   }
}
