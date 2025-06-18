package ai.idealistic.vacan.utils.minecraft.d;

public class d implements Comparable {
   public static final d lU = new d(0, 0, 0);
   private final int lV;
   private final int lW;
   private final int lX;

   public d(int var1, int var2, int var3) {
      this.lV = var1;
      this.lW = var2;
      this.lX = var3;
   }

   public d(double var1, double var3, double var5) {
      this(ai.idealistic.vacan.utils.b.c.I(var1), ai.idealistic.vacan.utils.b.c.I(var3), ai.idealistic.vacan.utils.b.c.I(var5));
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof d)) {
         return false;
      } else {
         d var2 = (d)var1;
         return this.fK() != var2.fK() ? false : (this.fL() != var2.fL() ? false : this.fM() == var2.fM());
      }
   }

   public int hashCode() {
      return (this.fL() + this.fM() * 31) * 31 + this.fK();
   }

   public int a(d var1) {
      return this.fL() == var1.fL() ? (this.fM() == var1.fM() ? this.fK() - var1.fK() : this.fM() - var1.fM()) : this.fL() - var1.fL();
   }

   public int fK() {
      return this.lV;
   }

   public int fL() {
      return this.lW;
   }

   public int fM() {
      return this.lX;
   }

   public d b(d var1) {
      return new d(this.fL() * var1.fM() - this.fM() * var1.fL(), this.fM() * var1.fK() - this.fK() * var1.fM(), this.fK() * var1.fL() - this.fL() * var1.fK());
   }

   public double r(double var1, double var3, double var5) {
      double var7 = (double)this.fK() - var1;
      double var9 = (double)this.fL() - var3;
      double var11 = (double)this.fM() - var5;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double s(double var1, double var3, double var5) {
      double var7 = (double)this.fK() + 0.5D - var1;
      double var9 = (double)this.fL() + 0.5D - var3;
      double var11 = (double)this.fM() + 0.5D - var5;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double c(d var1) {
      return this.r((double)var1.fK(), (double)var1.fL(), (double)var1.fM());
   }

   public int compareTo(Object var1) {
      return this.a((d)var1);
   }
}
