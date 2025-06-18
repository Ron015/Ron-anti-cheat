package ai.idealistic.vacan.utils.b.a;

import java.util.Collection;
import java.util.Iterator;

public class a {
   public final double kz;
   public final double kA;
   public final double kB;
   public final double kC;
   public final int kD;

   private static <E> double[] b(Collection<E> var0) {
      double[] var1 = new double[var0.size()];
      int var2 = 0;

      for(Iterator var3 = var0.iterator(); var3.hasNext(); ++var2) {
         Object var4 = var3.next();
         var1[var2] = (Double)var4;
      }

      return var1;
   }

   public a(double[] var1, double[] var2) {
      int var3 = var1.length;
      if (var3 != var2.length) {
         throw new IllegalArgumentException("Array lengths must be equal to each other");
      } else {
         this.kD = var3;
         double var4 = 0.0D;
         double var6 = 0.0D;

         for(int var8 = 0; var8 < var3; ++var8) {
            var4 += var2[var8];
            var6 += var1[var8];
         }

         var4 /= (double)var3;
         var6 /= (double)var3;
         double var29 = 0.0D;
         double var10 = 0.0D;

         for(int var12 = 0; var12 < var3; ++var12) {
            double var13 = var2[var12] - var4;
            double var15 = var1[var12] - var6;
            var10 += var13 * var15;
            var29 += var15 * var15;
         }

         this.kA = var10 / var29;
         this.kz = var4 - this.kA * var6;
         double var30 = 0.0D;
         double var14 = 0.0D;
         double var16 = 0.0D;

         for(int var18 = 0; var18 < var3; ++var18) {
            double var19 = var2[var18];
            double var21 = this.P(var1[var18]);
            double var23 = var21 - var19;
            double var25 = var21 - var4;
            double var27 = var19 - var4;
            var30 += var25 * var25;
            var14 += var27 * var27;
            var16 += var23 * var23;
         }

         this.kB = var30 / var14;
         this.kC = Math.sqrt(var16 / (double)(var3 - 2));
      }
   }

   public <E> a(Collection<E> var1, Collection<E> var2) {
      this(b(var1), b(var2));
   }

   public double P(double var1) {
      return this.kz + this.kA * var1;
   }
}
