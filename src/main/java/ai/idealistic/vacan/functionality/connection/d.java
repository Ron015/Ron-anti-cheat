package ai.idealistic.vacan.functionality.connection;

import ai.idealistic.vacan.utils.a.f;
import ai.idealistic.vacan.utils.a.g;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class d {
   static final String iz = "aHR0cHM6Ly93d3cudmFnZGVkZXMuY29tL21pbmVjcmFmdC9jbG91ZC8=";
   private static boolean iA = true;

   public static void a(Plugin var0) {
      if (!IDs.enabled) {
         ai.idealistic.vacan.functionality.server.c.jj.f(() -> {
            int var0 = b.eJ();
            if (var0 <= 0) {
               iA = false;
            }

         });
      }

      if (IDs.enabled) {
         if (b(var0)) {
            e.eI();
         } else {
            Bukkit.getPluginManager().disablePlugin(var0);
         }
      } else {
         e.eI();
         if (!b(var0)) {
            String var1 = "This version of " + var0.getName() + " does not have a license. If this download is pirated, please consider purchasing the plugin when your server starts making enough money. We also sell on BuiltByBit which supports many payment methods for all countries including yours.";
            List var2 = ai.idealistic.vacan.functionality.server.b.eZ();
            if (!var2.isEmpty()) {
               Iterator var3 = var2.iterator();

               while(var3.hasNext()) {
                  ai.idealistic.vacan.abstraction.f.c var4 = (ai.idealistic.vacan.abstraction.f.c)var3.next();
                  var4.C(ai.idealistic.vacan.functionality.c.a.K(var1));
               }
            }

            ai.idealistic.vacan.functionality.c.a.M(var1);
         }
      }

   }

   private static boolean b(Plugin var0) {
      boolean var1 = iA && var0.getDescription().getAuthors().toString().startsWith("[Evangelos Dedes @Vagdedes");

      try {
         String[] var2 = f.ab(g.ac("aHR0cHM6Ly93d3cudmFnZGVkZXMuY29tL21pbmVjcmFmdC9jbG91ZC8=") + "?" + a.eH() + "&action=add&data=userVerification");
         if (var2.length > 0) {
            String var3 = var2[0];
            if (var3.equalsIgnoreCase(String.valueOf(false))) {
               iA = false;
               return false;
            }
         }
      } catch (Exception var4) {
         if (IDs.canAdvertise()) {
            ai.idealistic.vacan.functionality.c.a.M(var4.getMessage());
         }
      }

      return var1;
   }
}
