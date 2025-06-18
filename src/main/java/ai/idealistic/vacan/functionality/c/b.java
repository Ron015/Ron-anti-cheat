package ai.idealistic.vacan.functionality.c;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b {
   private static final int iS = CheckEnums.HackType.values().length;
   private static final Map<Long, Boolean> iT;

   private static void b(List<ai.idealistic.vacan.abstraction.f.c> var0) {
      try {
         ResultSet var1 = ai.idealistic.vacan.functionality.server.a.ja.p("SELECT id, player_name, server_name, notification, information, functionality FROM " + ai.idealistic.vacan.functionality.server.a.ja.aD() + " WHERE notification IS NOT NULL ORDER BY id DESC LIMIT " + iS + ";");

         try {
            if (var1 != null) {
               while(true) {
                  while(true) {
                     long var2;
                     String var4;
                     String var5;
                     do {
                        do {
                           if (!var1.next()) {
                              return;
                           }

                           var2 = var1.getLong("id");
                        } while(iT.containsKey(var2));

                        var4 = var1.getString("functionality");
                        var5 = var1.getString("player_name");
                     } while(var5 == null);

                     CheckEnums.HackType[] var6 = CheckEnums.HackType.values();
                     int var7 = var6.length;

                     for(int var8 = 0; var8 < var7; ++var8) {
                        CheckEnums.HackType var9 = var6[var8];
                        if (var9.toString().equals(var4)) {
                           String var10 = var1.getString("notification");
                           String var11 = var1.getString("server_name");
                           String var12 = ai.idealistic.vacan.functionality.d.d.b(var1.getString("information"), "Detection:");
                           String var13 = ai.idealistic.vacan.functionality.d.d.b(var1.getString("information"), "Level:");
                           String var14 = ai.idealistic.vacan.functionality.d.d.b(var1.getString("information"), "Notification-Level:");
                           if (var13 != null && var14 != null) {
                              var10 = "§l[" + var11 + "]§r " + var10;
                              Iterator var15 = var0.iterator();

                              while(var15.hasNext()) {
                                 ai.idealistic.vacan.abstraction.f.c var16 = (ai.idealistic.vacan.abstraction.f.c)var15.next();
                                 ai.idealistic.vacan.abstraction.check.b var17 = var16.a(var9).e(var12);
                                 if (var17 != null && var17.a(System.currentTimeMillis(), Integer.parseInt(var13), Integer.parseInt(var14))) {
                                    var16.bC().sendMessage(var10);
                                    iT.put(var2, true);
                                 }
                              }
                              break;
                           }
                        }
                     }
                  }
               }
            }
         } finally {
            if (Collections.singletonList(var1).get(0) != null) {
               var1.close();
            }

         }

      } catch (Throwable var22) {
         throw var22;
      }
   }

   public static String eP() {
      return ai.idealistic.vacan.functionality.server.a.iZ.l("Important.server_name");
   }

   static {
      iT = new ai.idealistic.vacan.utils.a.c(new ConcurrentHashMap(), iS);
      ai.idealistic.vacan.functionality.server.c.a(() -> {
         ai.idealistic.vacan.functionality.server.c.jj.e(() -> {
            if (ai.idealistic.vacan.functionality.server.a.ja.isEnabled()) {
               List var0 = c.eR();
               if (!var0.isEmpty()) {
                  b(var0);
               }
            }

         });
      }, 1L, 1L);
   }
}
