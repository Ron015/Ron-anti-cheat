package ai.idealistic.vacan.functionality.a;

import ai.idealistic.vacan.api.Permission;
import ai.idealistic.vacan.functionality.server.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class b implements TabCompleter {
   private static final Map<String, Permission[]> ie = new LinkedHashMap(18);

   public List<String> onTabComplete(CommandSender var1, Command var2, String var3, String[] var4) {
      ArrayList var5 = new ArrayList();
      int var6 = var4.length;
      String var22;
      if (var6 == 1) {
         boolean var7 = var1 instanceof Player;
         Player var8 = var7 ? (Player)var1 : null;
         String var9 = var4[0].toLowerCase();
         Iterator var10 = ie.entrySet().iterator();

         while(var10.hasNext()) {
            Entry var11 = (Entry)var10.next();
            boolean var12;
            if (!var7) {
               var12 = true;
            } else {
               var12 = false;
               if (((Permission[])var11.getValue()).length > 0) {
                  Permission[] var13 = (Permission[])var11.getValue();
                  int var14 = var13.length;

                  for(int var15 = 0; var15 < var14; ++var15) {
                     Permission var16 = var13[var15];
                     if (ai.idealistic.vacan.functionality.server.b.a(var8, var16)) {
                        var12 = true;
                        break;
                     }
                  }
               } else {
                  var12 = ai.idealistic.vacan.functionality.server.b.a(var8, Permission.ADMIN);
               }
            }

            if (var12) {
               var22 = (String)var11.getKey();
               if (var22.contains(var9)) {
                  var5.add(var22);
               }
            }
         }
      } else if (var6 > 1) {
         Collection var17 = c.fc();
         if (!var17.isEmpty()) {
            String var18 = var4[var6 - 1].toLowerCase();
            boolean var19 = var1 instanceof Player;
            ai.idealistic.vacan.abstraction.f.c var20 = var19 ? c.i((Player)var1) : null;
            var19 &= var20 != null;
            Iterator var21 = var17.iterator();

            while(true) {
               ai.idealistic.vacan.abstraction.f.c var23;
               do {
                  if (!var21.hasNext()) {
                     return var5;
                  }

                  var23 = (ai.idealistic.vacan.abstraction.f.c)var21.next();
               } while(var19 && !var20.bC().canSee(var23.bC()));

               var22 = var23.bC().getName();
               if (var22.toLowerCase().contains(var18)) {
                  var5.add(var22);
               }
            }
         }
      }

      return var5;
   }

   static {
      ie.put("panic", new Permission[]{Permission.MANAGE});
      ie.put("toggle", new Permission[]{Permission.MANAGE});
      ie.put("rl", new Permission[]{Permission.RELOAD});
      ie.put("reload", new Permission[]{Permission.RELOAD});
      ie.put("notifications", new Permission[]{Permission.NOTIFICATIONS});
      ie.put("verbose", new Permission[]{Permission.NOTIFICATIONS});
      ie.put("info", new Permission[]{Permission.INFO});
      ie.put("kick", new Permission[]{Permission.KICK});
      ie.put("warn", new Permission[]{Permission.WARN});
      ie.put("bypass", new Permission[]{Permission.USE_BYPASS});
      ie.put("conditions", new Permission[]{Permission.CONDITION});
      ie.put("moderation", new Permission[]{Permission.KICK, Permission.WARN, Permission.USE_BYPASS, Permission.WAVE});
      ie.put("proxy-command", new Permission[0]);
      ie.put("wave add", new Permission[]{Permission.WAVE});
      ie.put("wave remove", new Permission[]{Permission.WAVE});
      ie.put("wave clear", new Permission[]{Permission.WAVE});
      ie.put("wave run", new Permission[]{Permission.WAVE});
      ie.put("wave list", new Permission[]{Permission.WAVE});
   }
}
