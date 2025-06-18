package ai.idealistic.vacan.compatibility.a.e;

import ai.idealistic.vacan.compatibility.Compatibility;
import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;

public class a {
   private static double hy = -1.0D;

   public static void er() {
      hy = -1.0D;
   }

   public static double es() {
      if (hy != -1.0D) {
         return hy;
      } else {
         if (Compatibility.CompatibilityType.CRAFT_BOOK.isFunctional()) {
            File var0 = new File("plugins/CraftBook/mechanisms.yml");
            if (var0.exists()) {
               YamlConfiguration var1 = YamlConfiguration.loadConfiguration(var0);
               double var2 = var1.getDouble("mechanics.BoatSpeedModifiers.max-speed");
               if (var2 < 0.0D) {
                  var2 = 0.1D;
               } else {
                  var2 += 0.1D;
               }

               hy = var2;
               return var2;
            }
         }

         hy = 0.0D;
         return 0.0D;
      }
   }
}
