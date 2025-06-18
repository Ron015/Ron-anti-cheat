package ai.idealistic.vacan.utils.minecraft.world;

import ai.idealistic.vacan.functionality.server.MultiVersion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lombok.Generated;
import org.bukkit.Material;

public class e {
   private static final List<Double> nx = new ArrayList();
   private static final List<Double> ny = new ArrayList();
   private static final Set<Material> nz = new HashSet();
   private static final boolean cF;
   private static final boolean nA;
   public static final double nB = 0.9375D;
   public static final double nC = 0.015625D;
   public static final double nD = 0.5625D;
   public static final double nE;
   public static final int nF;

   public static Collection<Double> fW() {
      return nx;
   }

   public static boolean af(Material var0) {
      return nz.contains(var0);
   }

   public static boolean U(double var0) {
      return nx.contains(var0);
   }

   public static boolean V(double var0) {
      return ny.contains(var0);
   }

   @Generated
   public static Set<Material> fX() {
      return nz;
   }

   static {
      cF = MultiVersion.c(MultiVersion.MCVersion.V1_9);
      nA = MultiVersion.c(MultiVersion.MCVersion.V1_15);
      nx.add(0.9375D);
      nx.add(0.015625D);
      nx.add(0.5625D);
      nx.add(0.0D);
      nx.add(0.6625D);
      nx.add(0.1875D);
      nx.add(0.8125D);
      nx.add(0.375D);
      nx.add(0.0625D);
      nx.add(0.125D);
      nx.add(0.4375D);
      nx.add(0.875D);
      nx.add(0.6875D);
      nx.add(0.09375D);
      nx.add(0.3125D);
      nx.add(0.625D);
      nx.add(0.25D);
      nx.add(0.75D);
      nx.add(0.5D);
      double var0 = Math.ceil(ai.idealistic.vacan.utils.minecraft.entity.b.kM[1]);
      Iterator var2 = nx.iterator();

      while(var2.hasNext()) {
         double var3 = (Double)var2.next();
         ny.add(var0 + (var3 == 0.0D ? 1.0D : var3) - ai.idealistic.vacan.utils.minecraft.entity.b.kM[1]);
      }

      Material[] var6 = Material.values();
      int var8 = var6.length;

      for(int var4 = 0; var4 < var8; ++var4) {
         Material var5 = var6[var4];
         if (var5 == Material.SNOW || c.N(var5) || c.b((ai.idealistic.vacan.abstraction.f.c)null, var5) || cF && var5 == Material.END_ROD || nA && var5 == Material.HONEY_BLOCK || MultiVersion.c(MultiVersion.MCVersion.V1_19) && var5 == Material.MUD) {
            nz.add(var5);
         }
      }

      int var7 = 0;

      double var10;
      for(Iterator var9 = nx.iterator(); var9.hasNext(); var7 = Math.max(var7, Double.toString(var10).length() - 2)) {
         var10 = (Double)var9.next();
      }

      nF = var7;
      nE = 1.0D / Math.pow(10.0D, (double)nF);
   }
}
