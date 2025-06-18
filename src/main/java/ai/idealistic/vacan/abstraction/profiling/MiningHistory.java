package ai.idealistic.vacan.abstraction.profiling;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.abstraction.f.c;
import ai.idealistic.vacan.api.PlayerFoundOreEvent;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import ai.idealistic.vacan.utils.minecraft.entity.d;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;

public class MiningHistory {
   public static final String fQ = "Environment: ";
   public static final String fR = "Amount: ";
   public static final String fS = "Ore: ";
   private final a fT;
   public final MiningHistory.MiningOre fU;
   private final int[] fV;

   public static void a(c var0, Block var1, boolean var2) {
      if (var0.cl() == GameMode.SURVIVAL && d.e(var0.getItemInHand().getType())) {
         MiningHistory.MiningOre var3 = b(var1.getType());
         if (var3 != null) {
            Environment var4 = var1.getWorld().getEnvironment();
            int var5 = var1.getX();
            int var6 = var1.getY();
            int var7 = var1.getZ();
            byte var8 = 1;
            String var9 = var3.toString();
            String var10 = "(Player:" + var0.bC().getName() + "), (" + "Amount: " + var8 + "), (" + "Ore: " + var9 + "), (" + "Environment: " + ai.idealistic.vacan.utils.minecraft.world.c.b(var4) + "), (W-XYZ: " + var1.getWorld().getName() + " " + var5 + " " + var6 + " " + var7 + ")";
            PlayerFoundOreEvent var11;
            if (ai.idealistic.vacan.functionality.server.a.iZ.i("Important.enable_developer_api")) {
               var11 = new PlayerFoundOreEvent(var0.bC(), var10, var1.getLocation(), var1.getType());
               Bukkit.getPluginManager().callEvent(var11);
            } else {
               var11 = null;
            }

            if (var11 == null || !var11.isCancelled()) {
               ai.idealistic.vacan.functionality.d.a.a(var0, (String)null, var10, false, var1.getType(), (CheckEnums.HackType)null, System.currentTimeMillis());
               MiningHistory var12 = var0.bU().a(var3);
               if (var12 != null) {
                  String var13 = var9.endsWith("s") ? var9 + "es" : var9 + "s";
                  var12.a(var4, var8);
                  var0.a(CheckEnums.HackType.X_RAY).a((Object)var2, (Object)(new Object[]{var4, var12, var3, var13}));
               }
            }
         }
      }

   }

   public static MiningHistory.MiningOre b(Material var0) {
      if (MultiVersion.c(MultiVersion.MCVersion.V1_16)) {
         if (var0 == Material.ANCIENT_DEBRIS) {
            return MiningHistory.MiningOre.ANCIENT_DEBRIS;
         }

         if (var0 == Material.GILDED_BLACKSTONE || var0 == Material.NETHER_GOLD_ORE) {
            return MiningHistory.MiningOre.GOLD;
         }

         if (MultiVersion.c(MultiVersion.MCVersion.V1_17)) {
            if (var0 == Material.DEEPSLATE_DIAMOND_ORE) {
               return MiningHistory.MiningOre.DIAMOND;
            }

            if (var0 == Material.DEEPSLATE_EMERALD_ORE) {
               return MiningHistory.MiningOre.EMERALD;
            }

            if (var0 == Material.DEEPSLATE_GOLD_ORE) {
               return MiningHistory.MiningOre.GOLD;
            }
         }
      }

      switch(var0) {
      case DIAMOND_ORE:
         return MiningHistory.MiningOre.DIAMOND;
      case EMERALD_ORE:
         return MiningHistory.MiningOre.EMERALD;
      case GOLD_ORE:
         return MiningHistory.MiningOre.GOLD;
      default:
         return null;
      }
   }

   MiningHistory(a var1, MiningHistory.MiningOre var2) {
      Environment[] var3 = Environment.values();
      this.fT = var1;
      this.fU = var2;
      this.fV = new int[var3.length];

      for(int var4 = 0; var4 < var3.length; ++var4) {
         this.fV[var4] = 0;
      }

   }

   public double a(Environment var1) {
      int var2 = this.fV[var1.ordinal()];
      if (var2 > 0) {
         long var3 = this.fT.bw().by();
         if (var3 > 0L) {
            var3 /= 1000L;
            return (double)var2 / (double)var3;
         } else {
            return 0.0D;
         }
      } else {
         return 0.0D;
      }
   }

   public void a(Environment var1, int var2) {
      int[] var10000 = this.fV;
      int var10001 = var1.ordinal();
      var10000[var10001] += var2;
   }

   public static enum MiningOre {
      ANCIENT_DEBRIS,
      DIAMOND,
      EMERALD,
      GOLD;

      private final String string = this.name().toLowerCase().replace("_", "-");

      public String toString() {
         return this.string;
      }

      // $FF: synthetic method
      private static MiningHistory.MiningOre[] $values() {
         return new MiningHistory.MiningOre[]{ANCIENT_DEBRIS, DIAMOND, EMERALD, GOLD};
      }
   }
}
