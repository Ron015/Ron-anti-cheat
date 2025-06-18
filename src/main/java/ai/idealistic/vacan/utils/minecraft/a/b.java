package ai.idealistic.vacan.utils.minecraft.a;

import org.bukkit.enchantments.Enchantment;

public class b {
   public static final Enchantment lH;
   public static final Enchantment lI;
   public static final Enchantment lJ;
   public static final Enchantment lK;

   private static Enchantment at(String var0) {
      Enchantment[] var1 = Enchantment.values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Enchantment var4 = var1[var3];
         if (var4.getName().equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return null;
   }

   static {
      Enchantment var0 = at("ARROW_KNOCKBACK");
      if (var0 == null) {
         var0 = Enchantment.PUNCH;
      }

      lH = var0;
      var0 = at("DURABILITY");
      if (var0 == null) {
         var0 = Enchantment.UNBREAKING;
      }

      lI = var0;
      var0 = at("WATER_WORKER");
      if (var0 == null) {
         var0 = Enchantment.AQUA_AFFINITY;
      }

      lJ = var0;
      var0 = at("DIG_SPEED");
      if (var0 == null) {
         var0 = Enchantment.EFFICIENCY;
      }

      lK = var0;
   }
}
