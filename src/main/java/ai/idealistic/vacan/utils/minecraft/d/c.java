package ai.idealistic.vacan.utils.minecraft.d;

public class c {
   public final double lR;
   public final double lS;
   public final double lT;

   public c(double var1, double var3, double var5) {
      if (var1 == -0.0D) {
         var1 = 0.0D;
      }

      if (var3 == -0.0D) {
         var3 = 0.0D;
      }

      if (var5 == -0.0D) {
         var5 = 0.0D;
      }

      this.lR = var1;
      this.lS = var3;
      this.lT = var5;
   }

   public c(d var1) {
      this((double)var1.fK(), (double)var1.fL(), (double)var1.fM());
   }

   public c e(c var1) {
      return new c(var1.lR - this.lR, var1.lS - this.lS, var1.lT - this.lT);
   }

   public c fI() {
      double var1 = (double)ai.idealistic.vacan.utils.b.c.G(this.lR * this.lR + this.lS * this.lS + this.lT * this.lT);
      return var1 < 1.0E-4D ? new c(0.0D, 0.0D, 0.0D) : new c(this.lR / var1, this.lS / var1, this.lT / var1);
   }

   public double f(c var1) {
      return this.lR * var1.lR + this.lS * var1.lS + this.lT * var1.lT;
   }

   public c g(c var1) {
      return new c(this.lS * var1.lT - this.lT * var1.lS, this.lT * var1.lR - this.lR * var1.lT, this.lR * var1.lS - this.lS * var1.lR);
   }

   public c h(c var1) {
      return this.p(var1.lR, var1.lS, var1.lT);
   }

   public c p(double var1, double var3, double var5) {
      return this.q(-var1, -var3, -var5);
   }

   public c i(c var1) {
      return this.q(var1.lR, var1.lS, var1.lT);
   }

   public c q(double var1, double var3, double var5) {
      return new c(this.lR + var1, this.lS + var3, this.lT + var5);
   }

   public double j(c var1) {
      double var2 = var1.lR - this.lR;
      double var4 = var1.lS - this.lS;
      double var6 = var1.lT - this.lT;
      return (double)ai.idealistic.vacan.utils.b.c.G(var2 * var2 + var4 * var4 + var6 * var6);
   }

   public double k(c var1) {
      double var2 = var1.lR - this.lR;
      double var4 = var1.lS - this.lS;
      double var6 = var1.lT - this.lT;
      return var2 * var2 + var4 * var4 + var6 * var6;
   }

   public double fJ() {
      return (double)ai.idealistic.vacan.utils.b.c.G(this.lR * this.lR + this.lS * this.lS + this.lT * this.lT);
   }

   public c a(c var1, double var2) {
      double var4 = var1.lR - this.lR;
      double var6 = var1.lS - this.lS;
      double var8 = var1.lT - this.lT;
      if (var4 * var4 < 1.0000000116860974E-7D) {
         return null;
      } else {
         double var10 = (var2 - this.lR) / var4;
         return var10 >= 0.0D && var10 <= 1.0D ? new c(this.lR + var4 * var10, this.lS + var6 * var10, this.lT + var8 * var10) : null;
      }
   }

   public c b(c var1, double var2) {
      double var4 = var1.lR - this.lR;
      double var6 = var1.lS - this.lS;
      double var8 = var1.lT - this.lT;
      if (var6 * var6 < 1.0000000116860974E-7D) {
         return null;
      } else {
         double var10 = (var2 - this.lS) / var6;
         return var10 >= 0.0D && var10 <= 1.0D ? new c(this.lR + var4 * var10, this.lS + var6 * var10, this.lT + var8 * var10) : null;
      }
   }

   public c c(c var1, double var2) {
      double var4 = var1.lR - this.lR;
      double var6 = var1.lS - this.lS;
      double var8 = var1.lT - this.lT;
      if (var8 * var8 < 1.0000000116860974E-7D) {
         return null;
      } else {
         double var10 = (var2 - this.lT) / var8;
         return var10 >= 0.0D && var10 <= 1.0D ? new c(this.lR + var4 * var10, this.lS + var6 * var10, this.lT + var8 * var10) : null;
      }
   }

   public String toString() {
      return "(" + this.lR + ", " + this.lS + ", " + this.lT + ")";
   }

   public c r(float var1) {
      float var2 = ai.idealistic.vacan.utils.b.c.e(var1);
      float var3 = ai.idealistic.vacan.utils.b.c.d(var1);
      double var4 = this.lR;
      double var6 = this.lS * (double)var2 + this.lT * (double)var3;
      double var8 = this.lT * (double)var2 - this.lS * (double)var3;
      return new c(var4, var6, var8);
   }

   public c s(float var1) {
      float var2 = ai.idealistic.vacan.utils.b.c.e(var1);
      float var3 = ai.idealistic.vacan.utils.b.c.d(var1);
      double var4 = this.lR * (double)var2 + this.lT * (double)var3;
      double var6 = this.lS;
      double var8 = this.lT * (double)var2 - this.lR * (double)var3;
      return new c(var4, var6, var8);
   }
}
