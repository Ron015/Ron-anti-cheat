package ai.idealistic.vacan.abstraction.b;

import java.util.Map;

public class a {
   private final Map<String, ai.idealistic.vacan.abstraction.b.a.a> eL;

   public a(Map<String, ai.idealistic.vacan.abstraction.b.a.a> var1) {
      this.eL = var1;
   }

   public double s(String var1) {
      ai.idealistic.vacan.abstraction.b.a.a var2 = (ai.idealistic.vacan.abstraction.b.a.a)this.eL.get(var1);
      return var2 != null ? var2.eM : 0.0D;
   }

   public void b(String var1, int var2) {
      ai.idealistic.vacan.abstraction.b.a.a var3 = (ai.idealistic.vacan.abstraction.b.a.a)this.eL.get(var1);
      if (var3 == null) {
         var3 = new ai.idealistic.vacan.abstraction.b.a.a();
         this.eL.put(var1, var3);
      }

      var3.aO();
      var3.q((double)var2);
   }

   public double c(String var1, int var2) {
      return ((ai.idealistic.vacan.abstraction.b.a.a)this.eL.computeIfAbsent(var1, (var0) -> {
         return new ai.idealistic.vacan.abstraction.b.a.a();
      })).q((double)var2);
   }

   public double d(String var1, int var2) {
      ai.idealistic.vacan.abstraction.b.a.a var3 = (ai.idealistic.vacan.abstraction.b.a.a)this.eL.get(var1);
      return var3 != null ? var3.r((double)var2) : 0.0D;
   }

   public int e(String var1, int var2) {
      ai.idealistic.vacan.abstraction.b.a.a var3 = (ai.idealistic.vacan.abstraction.b.a.a)this.eL.get(var1);
      if (var3 == null) {
         return 0;
      } else {
         long var4 = var3.aN();
         return var4 > (long)var2 ? 0 : (int)((long)var2 - var4);
      }
   }

   public double f(String var1, int var2) {
      return ((ai.idealistic.vacan.abstraction.b.a.a)this.eL.computeIfAbsent(var1, (var0) -> {
         return new ai.idealistic.vacan.abstraction.b.a.a();
      })).a(1.0D, var2);
   }

   public double a(String var1, int var2, int var3) {
      ai.idealistic.vacan.abstraction.b.a.a var4 = (ai.idealistic.vacan.abstraction.b.a.a)this.eL.computeIfAbsent(var1, (var0) -> {
         return new ai.idealistic.vacan.abstraction.b.a.a();
      });
      double var5 = (double)var4.aN();
      if (var5 > (double)var3) {
         var4.aO();
      }

      double var7 = var4.q(1.0D);
      return var7 >= (double)var2 ? var7 / var5 : 0.0D;
   }

   public boolean t(String var1) {
      return this.s(var1) >= 0.0D;
   }

   public void u(String var1) {
      this.eL.remove(var1);
   }

   public void a(String[] var1) {
      String[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         this.eL.remove(var5);
      }

   }

   public static class a {
      private double eM;
      private long eN;

      public a() {
         this.aO();
      }

      public long aN() {
         return (long)ai.idealistic.vacan.utils.b.a.B((double)(System.currentTimeMillis() - this.eN) / 50.0D);
      }

      public long b(int var1) {
         return Math.max(0L, (long)var1 - this.aN());
      }

      public double p(double var1) {
         return this.eM = var1;
      }

      public double q(double var1) {
         this.eM += var1;
         return this.eM;
      }

      public double r(double var1) {
         if (this.eM > var1) {
            this.eM -= var1;
            return this.eM;
         } else {
            this.eM = 0.0D;
            return 0.0D;
         }
      }

      public void aO() {
         this.eM = 0.0D;
         this.eN = System.currentTimeMillis();
      }

      public double a(double var1, int var3) {
         if (this.aN() > (long)var3) {
            this.aO();
         }

         return this.q(var1);
      }
   }

   public static class b {
      public int eO;
   }
}
