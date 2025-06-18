package ai.idealistic.vacan.functionality.c;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;

public class a {
   private static final Map<UUID, Map<String, Long>> iP = new LinkedHashMap();
   private static final String iQ;
   public static final UUID iR;

   public static void clear() {
      iP.clear();
   }

   public static void eI() {
      iP.remove(iR);
   }

   private static boolean eO() {
      return ai.idealistic.vacan.functionality.server.a.iZ.i("Notifications.awareness_notifications");
   }

   public static boolean a(UUID var0, String var1, int var2) {
      Map var3 = (Map)iP.get(var0);
      boolean var4;
      if (var3 != null) {
         Long var5 = (Long)var3.get(var1);
         if (var5 == null) {
            var3.put(var1, System.currentTimeMillis() + (long)var2 * 1000L);
            var4 = true;
         } else if (var5 == 0L) {
            var4 = false;
         } else {
            long var6 = System.currentTimeMillis();
            if (var6 >= var5) {
               var3.put(var1, var6 + (long)var2 * 1000L);
               var4 = true;
            } else {
               var4 = false;
            }
         }
      } else {
         LinkedHashMap var8 = new LinkedHashMap();
         var8.put(var1, System.currentTimeMillis() + (long)var2 * 1000L);
         iP.put(var0, var8);
         var4 = true;
      }

      return var4;
   }

   private static String c(String var0, boolean var1) {
      return ai.idealistic.vacan.functionality.server.a.jb.m("awareness_notification").replace(":", "§8:§7").replace("{info}", var0) + (var1 ? iQ : "");
   }

   public static String K(String var0) {
      return c(var0, false);
   }

   public static String L(String var0) {
      return eO() && var0 != null ? c(var0, true) : null;
   }

   public static void a(ai.idealistic.vacan.abstraction.f.c var0, String var1, boolean var2) {
      var1 = K(var1);
      if (var0 != null) {
         var0.bC().sendMessage(var1);
         if (var2) {
            Bukkit.getConsoleSender().sendMessage("(" + var0.bC().getName() + ") " + var1);
         }
      } else if (var2) {
         Bukkit.getConsoleSender().sendMessage(var1);
      }

   }

   public static void M(String var0) {
      Bukkit.getConsoleSender().sendMessage(K(var0));
   }

   public static void N(String var0) {
      var0 = L(var0);
      if (var0 != null) {
         Bukkit.getConsoleSender().sendMessage(var0);
      }

   }

   static {
      iQ = " You can disable Awareness Notifications via " + ai.idealistic.vacan.functionality.server.a.iZ.ax().getName() + ".";
      iR = UUID.randomUUID();
   }
}
