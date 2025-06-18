package ai.idealistic.vacan.compatibility.a.b;

import ai.idealistic.vacan.compatibility.Compatibility;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;

public class a {
   private static final Set<Material> hw = new HashSet();

   public static void eq() {
      hw.clear();
   }

   public static boolean i(ai.idealistic.vacan.abstraction.f.c var0) {
      if (Compatibility.CompatibilityType.MINE_BOMB.isFunctional()) {
         if (l(var0)) {
            return true;
         }

         File var1 = new File("plugins/MineBomb/config.yml");
         if (var1.exists()) {
            boolean var2 = false;
            YamlConfiguration var3 = YamlConfiguration.loadConfiguration(var1);
            Iterator var4 = var3.getKeys(true).iterator();

            while(var4.hasNext()) {
               String var5 = (String)var4.next();
               if (var5.endsWith(".item")) {
                  Material var6 = Material.getMaterial(var3.getString(var5));
                  if (var6 != null) {
                     hw.add(var6);
                     var2 = true;
                  }
               }
            }

            return var2;
         }
      }

      return false;
   }

   private static boolean l(ai.idealistic.vacan.abstraction.f.c var0) {
      Iterator var1 = hw.iterator();

      Material var2;
      do {
         if (!var1.hasNext()) {
            return false;
         }

         var2 = (Material)var1.next();
      } while(var0.getItemInHand().getType() != var2);

      return true;
   }
}
