package ai.idealistic.vacan.utils.minecraft.entity;

import org.bukkit.potion.PotionEffectType;

public class e {
   public static final PotionEffectType lD;
   public static final PotionEffectType lE;
   public static final PotionEffectType lF;

   static {
      PotionEffectType var0 = PotionEffectType.getByName("JUMP");
      if (var0 == null) {
         var0 = PotionEffectType.JUMP_BOOST;
      }

      lD = var0;
      var0 = PotionEffectType.getByName("FAST_DIGGING");
      if (var0 == null) {
         var0 = PotionEffectType.HASTE;
      }

      lE = var0;
      var0 = PotionEffectType.getByName("SLOW_DIGGING");
      if (var0 == null) {
         var0 = PotionEffectType.MINING_FATIGUE;
      }

      lF = var0;
   }
}
