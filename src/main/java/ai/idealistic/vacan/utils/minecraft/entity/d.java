package ai.idealistic.vacan.utils.minecraft.entity;

import ai.idealistic.vacan.functionality.server.MultiVersion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.potion.PotionEffectType;

public class d {
   public static final boolean kT;
   public static final boolean kU;
   public static final boolean kV;
   public static final boolean kW;
   public static final boolean kX;
   public static final boolean dl;
   private static final Material kY;
   private static final Material kZ;
   private static final Material la;
   private static final Material lb;
   private static final Material lc;
   private static final Material ld;
   private static final Material le;
   private static final Material lf;
   private static final Material lg;
   private static final Material lh;
   private static final Material li;
   public static final double lj;
   public static final double lk;
   public static final double ll;
   public static final double lm = 0.5D;
   public static final double ln;
   public static final double lo = 0.08D;
   public static final double lp;
   public static final double lq = 0.01D;
   public static final double lr = 0.02D;
   public static final double ls = 16.0D;
   public static final double lt;
   public static final double lu;
   public static final double lv;
   public static final double lw;
   public static final double lx;
   public static final int ly = 46;
   public static final int lz;
   public static final int lA = 3;
   private static final Map<Byte, List<Double>> lB;
   private static final Map<PotionEffectType, Long> lC;

   public static boolean a(double var0, int var2, double var3) {
      if (var0 > 0.0D) {
         Iterator var5 = ((List)lB.get((byte)var2)).iterator();

         while(var5.hasNext()) {
            double var6 = (Double)var5.next();
            if (Math.abs(var6 - var0) < var3) {
               return true;
            }
         }
      }

      return false;
   }

   public static boolean b(double var0, int var2, double var3) {
      if (var0 > 0.0D) {
         Iterator var5 = ((List)lB.get((byte)var2)).iterator();

         while(var5.hasNext()) {
            double var6 = (Double)var5.next();
            if (Math.abs(var6 - var0) < var3) {
               return true;
            }
         }
      }

      return false;
   }

   public static List<Double> v(int var0) {
      return (List)lB.get((byte)var0);
   }

   public static double w(int var0) {
      return ((List)lB.get((byte)var0)).stream().mapToDouble(Double::doubleValue).sum();
   }

   public static double l(int var0, int var1) {
      return (Double)((List)lB.get((byte)var0)).get(var1);
   }

   public static int x(int var0) {
      return v(var0).size();
   }

   public static double p(double var0, double var2) {
      return 1.0D / (1.0D - var0) * var2;
   }

   public static double o(double var0, double var2, double var4) {
      double var6 = p(var2, var4);
      return var0 >= -var6 ? (var0 + var2) * var4 : Double.MIN_VALUE;
   }

   public static boolean d(Material var0) {
      return var0 == le || var0 == lf || var0 == lg || var0 == lh || var0 == li || MultiVersion.c(MultiVersion.MCVersion.V1_16) && var0 == Material.NETHERITE_HOE;
   }

   public static boolean e(Material var0) {
      return var0 == Material.DIAMOND_PICKAXE || var0 == Material.IRON_PICKAXE || var0 == Material.STONE_PICKAXE || var0 == lc || var0 == ld || MultiVersion.c(MultiVersion.MCVersion.V1_16) && var0 == Material.NETHERITE_PICKAXE;
   }

   public static boolean f(Material var0) {
      return var0 == Material.DIAMOND_AXE || var0 == Material.IRON_AXE || var0 == Material.STONE_AXE || var0 == la || var0 == lb || MultiVersion.c(MultiVersion.MCVersion.V1_16) && var0 == Material.NETHERITE_AXE;
   }

   public static boolean g(Material var0) {
      return var0 == Material.DIAMOND_SWORD || var0 == kY || var0 == Material.IRON_SWORD || var0 == Material.STONE_SWORD || var0 == kZ || MultiVersion.c(MultiVersion.MCVersion.V1_16) && var0 == Material.NETHERITE_SWORD;
   }

   public static int a(ai.idealistic.vacan.abstraction.f.c var0, PotionEffectType var1) {
      ai.idealistic.vacan.abstraction.f.b var2 = var0.a(var1, (Long)lC.getOrDefault(var1, 0L));
      return var2 != null ? var2.gf.getAmplifier() : -1;
   }

   static {
      kT = MultiVersion.c(MultiVersion.MCVersion.V1_13);
      kU = MultiVersion.c(MultiVersion.MCVersion.V1_13);
      kV = MultiVersion.c(MultiVersion.MCVersion.V1_16);
      kW = MultiVersion.c(MultiVersion.MCVersion.V1_9);
      kX = MultiVersion.c(MultiVersion.MCVersion.V1_9);
      dl = MultiVersion.c(MultiVersion.MCVersion.V1_13);
      kY = ai.idealistic.vacan.utils.minecraft.a.d.au("gold_sword");
      kZ = ai.idealistic.vacan.utils.minecraft.a.d.au("wood_sword");
      la = ai.idealistic.vacan.utils.minecraft.a.d.au("gold_axe");
      lb = ai.idealistic.vacan.utils.minecraft.a.d.au("wood_axe");
      lc = ai.idealistic.vacan.utils.minecraft.a.d.au("gold_pickaxe");
      ld = ai.idealistic.vacan.utils.minecraft.a.d.au("wood_pickaxe");
      le = ai.idealistic.vacan.utils.minecraft.a.d.au("diamond_spade");
      lf = ai.idealistic.vacan.utils.minecraft.a.d.au("iron_spade");
      lg = ai.idealistic.vacan.utils.minecraft.a.d.au("gold_spade");
      lh = ai.idealistic.vacan.utils.minecraft.a.d.au("stone_spade");
      li = ai.idealistic.vacan.utils.minecraft.a.d.au("wood_spade");
      lj = MultiVersion.c(MultiVersion.MCVersion.V1_9) ? 0.005D : 0.003D;
      lk = ai.idealistic.vacan.utils.b.a.F(0.98D);
      ll = ai.idealistic.vacan.utils.b.a.F(0.8D);
      ln = ai.idealistic.vacan.utils.b.a.F(0.42D);
      lp = ai.idealistic.vacan.utils.b.a.F(0.098D);
      lt = 0.12D * lk;
      lu = ai.idealistic.vacan.utils.b.a.F(0.15D);
      lv = ai.idealistic.vacan.utils.b.a.F(0.13D) * lk;
      lw = ai.idealistic.vacan.utils.b.a.F(0.64D) * lk;
      lB = new LinkedHashMap();
      lC = new LinkedHashMap();
      lC.put(e.lD, (long)ai.idealistic.vacan.utils.b.a.A(100.0D) * 50L);
      lC.put(PotionEffectType.SPEED, (long)ai.idealistic.vacan.utils.b.a.A(40.0D) * 50L);
      if (kU) {
         lC.put(PotionEffectType.DOLPHINS_GRACE, (long)ai.idealistic.vacan.utils.b.a.A(20.0D) * 50L);
      }

      if (kT) {
         lC.put(PotionEffectType.SLOW_FALLING, 500L);
      }

      if (kW) {
         lC.put(PotionEffectType.LEVITATION, 500L);
      }

      for(int var0 = 0; var0 < 256; ++var0) {
         ArrayList var1 = new ArrayList();

         for(double var2 = ln + (double)var0 * 0.1D; var2 > 0.0D; var2 = (var2 - 0.08D) * lk) {
            var1.add(var2);
         }

         lB.put((byte)var0, var1);
      }

      Iterator var9 = ((List)lB.get((byte)0)).iterator();
      double var10 = Double.MIN_VALUE;

      double var5;
      for(double var3 = (Double)var9.next(); var9.hasNext(); var3 = var5) {
         var5 = (Double)var9.next();
         var10 = Math.max(var3 - var5, var10);
      }

      lx = var10;
      if (MultiVersion.c(MultiVersion.MCVersion.V1_17)) {
         List var11 = Bukkit.getWorlds();
         if (!var11.isEmpty()) {
            int var6 = 256;

            World var8;
            for(Iterator var7 = var11.iterator(); var7.hasNext(); var6 = Math.max(var8.getMaxHeight(), var6)) {
               var8 = (World)var7.next();
            }

            lz = var6;
         } else {
            lz = 256;
         }
      } else {
         lz = 256;
      }

   }
}
